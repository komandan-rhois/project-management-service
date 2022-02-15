package com.projectmanagementservice.dto;

import com.projectmanagementservice.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse implements Serializable {

    private static final long serialVersionUID = -859933613060086861L;
    private List<Employee> employees;

}
