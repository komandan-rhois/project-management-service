package com.projectmanagementservice.dto;

import com.projectmanagementservice.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeResponse implements Serializable {

    private static final long serialVersionUID = -859933613060086861L;

    private Employee employe;

}
