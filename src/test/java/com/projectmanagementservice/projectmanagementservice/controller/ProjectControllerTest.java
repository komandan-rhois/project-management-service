package com.projectmanagementservice.projectmanagementservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectmanagementservice.controller.ProjectController;
import com.projectmanagementservice.dto.EmployeeResponse;
import com.projectmanagementservice.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ContextConfiguration(classes = ProjectController.class)
@WebMvcTest(controllers = ProjectController.class)
@Slf4j
public class ProjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @Autowired
    private ObjectMapper objectMapper;

    private ObjectMapper mapper = new ObjectMapper();

    @Test //tes getAllLeader success
    public void getEmployee_success() throws Exception {

        when(projectService.getEmployee()).thenReturn(EmployeeResponse.builder().build().builder().build());

    }



}