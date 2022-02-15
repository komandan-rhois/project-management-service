package com.projectmanagementservice.service;

import com.projectmanagementservice.dto.GetProductByIdReq;
import com.projectmanagementservice.dto.GetEmployeeResponse;
import com.projectmanagementservice.dto.EmployeeResponse;
import com.projectmanagementservice.dto.GetProjectResponse;
import com.projectmanagementservice.exception.DataNotFoundException;
import com.projectmanagementservice.model.Employee;
import com.projectmanagementservice.model.Project;
import com.projectmanagementservice.repository.EmployeeRepository;
import com.projectmanagementservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class ProjectService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    public EmployeeResponse getEmployee() {
        try {
            var leader = employeeRepository.findAll();
            return EmployeeResponse.builder()
                    .employees(leader).build();

        } catch (Exception e) {
            log.info(e.getMessage());
            throw e;
        }
    }

    public GetProjectResponse getLeaderById(GetProductByIdReq request){
        try{
            var data = projectRepository.findById(request.getId());
            if(ObjectUtils.isEmpty(data)) {
                throw new DataNotFoundException("Data not found.");
            }

            return GetProjectResponse.builder().project(data.get()).build();
        } catch (Exception e){
            log.info(e.getMessage());
            throw e;
        }
    }

    public void addProjectMember(Employee employee, Long productId) {
        try{
         Project projectData = projectRepository.findById(productId).get();
         if (projectData == null) {
             throw new DataNotFoundException("Data not found.");
         }

            projectData.getMemberAssign().add(Employee.builder().id(employee.getId()).build());
            projectRepository.save(projectData);

        } catch (Exception e){
            log.info(e.getMessage());
            throw e;
        }
    }

    public void addProjectLeader(Employee employee, Long productId) {
        try{
            Project projectData = projectRepository.findById(productId).get();
            if (projectData == null) {
                throw new DataNotFoundException("Data not found.");
            }

            projectData.getLeaders().add(Employee.builder().id(employee.getId()).build());
            projectRepository.save(projectData);

        } catch (Exception e){
            log.info(e.getMessage());
            throw e;
        }
    }

    // remove project by id
    public void removeProjectById(Long productId) {
        try{
            Project projectData = projectRepository.findById(productId).get();
            if (projectData == null) {
                throw new DataNotFoundException("Data not found.");
            }

            projectRepository.delete(projectData);

        } catch (Exception e){
            log.info(e.getMessage());
            throw e;
        }
    }

    // remove project member by id
    public void removeProjectMemberById(Long productId, Long memberId) {
        try{
            Project projectData = projectRepository.findById(productId).get();
            if (projectData == null) {
                throw new DataNotFoundException("Data not found.");
            }

            projectData.getMemberAssign().removeIf(member -> member.getId().equals(memberId));
            projectRepository.save(projectData);

        } catch (Exception e){
            log.info(e.getMessage());
            throw e;
        }
    }

    // remove project leader by id
    public void removeProjectLeaderById(Long productId, Long leaderId) {
        try{
            Project projectData = projectRepository.findById(productId).get();
            if (projectData == null) {
                throw new DataNotFoundException("Data not found.");
            }

            projectData.getLeaders().removeIf(leader -> leader.getId().equals(leaderId));
            projectRepository.save(projectData);

        } catch (Exception e){
            log.info(e.getMessage());
            throw e;
        }
    }
}


