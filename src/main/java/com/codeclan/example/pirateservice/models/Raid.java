package com.codeclan.example.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name="raids")

public class Raid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="location")
    private String location;

    @Column(name="loot")
    private String loot;

    @ManyToMany
    @JsonIgnoreProperties({"raids"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "pirates_raids", joinColumns = {@JoinColumn(name = "raid_id", nullable = false)}, inverseJoinColumns = { @JoinColumn(name="pirate_id", nullable = false, updatable = false)})
    private List<Pirate> pirates;

    public Raid(String location, String loot) {
        this.location = location;
        this.loot = loot;
        this.pirates = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLoot() {
        return loot;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }

    public void addPirate(Pirate pirate){
        this.pirates.add(pirate);
    }
}
