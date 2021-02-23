package com.codeclan.example.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// this tells hibernate what to use its funcitonallity on.
@Entity

// create a table of this name
@Table(name = "pirates")

public class Pirate {

    // the id will be generated as an identity and will have a column called "Id"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // first name column
    @Column(name = "first_name")
    private String firstName;

    // last name column
    @Column(name = "last_name")
    private String lastName;

    // age column

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "ship_id", nullable = false)
    @JsonIgnoreProperties({"pirates"})
    private Ship ship;

    @ManyToMany
    @JsonIgnoreProperties({"pirates"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "pirates_raids",
            joinColumns = {@JoinColumn(
                    name = "pirate_id", nullable = false)}
                    , inverseJoinColumns = {@JoinColumn
            (name = "raid_id", nullable = false, updatable = false)})
    private List<Raid> raids;

    public Pirate(String firstName, String lastName, int age, Ship ship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ship = ship;
        this.raids = new ArrayList<>();
    }

    public Pirate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addRaid(Raid raid){
        this.raids.add(raid);
    }
}
