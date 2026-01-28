package com.prms.prms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String skill;
    private boolean availability;
    @Column(unique = true, nullable = false)
    private String email;

	public Employee() {}

    public Employee(String name, String skill, boolean availability) {
        this.name = name;
        this.skill = skill;
        this.availability = availability;
        
    }

    public int getId() { 
    	return id; 
    }
    public void setId(int id) { 
    	this.id = id; 
    }

    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }

    public String getSkill() { 
    	return skill; 
    }
    public void setSkill(String skill) { 
    	this.skill = skill; 
    }

    public boolean isAvailability() { 
    	return availability; 
    }
    public void setAvailability(boolean availability) { 
    	this.availability = availability; 
    }
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
