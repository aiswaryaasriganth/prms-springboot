package com.prms.prms.controller;

import com.prms.prms.entity.Allocation;
import com.prms.prms.entity.Employee;
import com.prms.prms.entity.Project;
import com.prms.prms.repository.AllocationRepository;
import com.prms.prms.repository.EmployeeRepository;
import com.prms.prms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prms.prms.service.AllocationService;

import java.util.List;

@RestController
@RequestMapping("/allocations")
public class AllocationController {

    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private AllocationService allocationService;

    @PostMapping("/{employeeId}/{projectId}")
    public Allocation allocateEmployee(
            @PathVariable int employeeId,
            @PathVariable int projectId) {

        Employee employee = employeeRepository.findById((long) employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        if (!employee.isAvailability()) {
            throw new RuntimeException("Employee not available");
        }

        if (!employee.getSkill().equalsIgnoreCase(project.getRequiredSkill())) {
            throw new RuntimeException("Skill mismatch");
        }

        Allocation allocation = new Allocation(employee, project);
        employee.setAvailability(false);

        employeeRepository.save(employee);
        return allocationRepository.save(allocation);
    }
    

    @GetMapping
    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }
    
    @DeleteMapping("/{allocationId}")
    public String releaseEmployee(@PathVariable int allocationId) {
        allocationService.releaseEmployee(allocationId);
        return "Employee released from project";
    }

        

        

    

}
