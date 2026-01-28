package com.prms.prms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project", uniqueConstraints = {
        @UniqueConstraint(columnNames = "projectName")
})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String projectName;
    private String requiredSkill;

    public Project() {}

    public Project(String projectName, String requiredSkill) {
        this.projectName = projectName;
        this.requiredSkill = requiredSkill;
    }

    public int getId() { 
    	return id;
    }
    public void setId(int id) { 
    	this.id = id; 
    }

    public String getProjectName() { 
    	return projectName; 
    
    }
    public void setProjectName(String projectName) { 
    	this.projectName = projectName; 
    }

    public String getRequiredSkill() { 
    	return requiredSkill; 
    }
    public void setRequiredSkill(String requiredSkill) { 
    	this.requiredSkill = requiredSkill; 
    }
}
