package com.prms.prms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "allocation", uniqueConstraints = {
        @UniqueConstraint(columnNames = "employee_id")
})
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Allocation() {}

    public Allocation(Employee employee, Project project) {
        this.employee = employee;
        this.project = project;
    }

    public int getId() { 
    	return id; 
    }
    public void setId(int id) { 
    	this.id = id; 
    }

    public Employee getEmployee() { 
    	return employee; 
    }
    public void setEmployee(Employee employee) { 
    	this.employee = employee; 
    }

    public Project getProject() { 
    	return project; 
    }
    public void setProject(Project project) { 
    	this.project = project; 
    }
}
