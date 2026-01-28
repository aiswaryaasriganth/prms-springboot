package com.prms.prms.service;

import com.prms.prms.entity.Allocation;
import com.prms.prms.entity.Employee;
import com.prms.prms.entity.Project;
import com.prms.prms.exception.AllocationException;
import com.prms.prms.exception.EmployeeNotFoundException;
import com.prms.prms.exception.ProjectNotFoundException;
import com.prms.prms.repository.AllocationRepository;
import com.prms.prms.repository.EmployeeRepository;
import com.prms.prms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private AllocationRepository allocationRepository;

    // Allocate employee to project
    public Allocation allocate(int employeeId, int projectId) {

        Employee employee = employeeRepository.findById((long) employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

        // Check if employee is already allocated
        if (allocationRepository.existsByEmployeeId(employee.getId())) {
            throw new AllocationException("Employee already allocated to another project");
        }

        // Check employee availability
        if (!employee.isAvailability()) {
            throw new AllocationException("Employee is not available");
        }

        // Check skill match
        if (!employee.getSkill().equalsIgnoreCase(project.getRequiredSkill())) {
            throw new AllocationException("Skill mismatch between employee and project");
        }

        Allocation allocation = new Allocation(employee, project);

        // Mark employee as unavailable after allocation
        employee.setAvailability(false);
        employeeRepository.save(employee);

        return allocationRepository.save(allocation);
    }

    // Fetch all allocations
    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    // Release employee from project
    public void releaseEmployee(int allocationId) {

        Allocation allocation = allocationRepository.findById(allocationId)
                .orElseThrow(() -> new AllocationException("Allocation not found"));

        Employee employee = allocation.getEmployee();

        // Make employee available again
        employee.setAvailability(true);
        employeeRepository.save(employee);

        allocationRepository.delete(allocation);
    }
}
