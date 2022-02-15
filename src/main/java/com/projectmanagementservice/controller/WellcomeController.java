package com.projectmanagementservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/wellcome")
public class WellcomeController {

    @GetMapping
    public String wellcome() {
        return "Wellcome to Project Management Service";
    }

}
