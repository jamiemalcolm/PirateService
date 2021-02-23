package com.codeclan.example.pirateservice;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.models.Raid;
import com.codeclan.example.pirateservice.models.Ship;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import com.codeclan.example.pirateservice.repositories.RaidRepository;
import com.codeclan.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}


	@Test
	public void createPirateAndShipAndRaid(){
		Raid raid = new Raid("Tortuga", "Gold");
		raidRepository.save(raid);

		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate jack = new Pirate("Jack", "Sparra", 32, ship);
		pirateRepository.save(jack);
		jack.addRaid(raid);
	}

}
