package com.infnet.fitcoach_saas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @GetMapping("/area")
    public String areaInstrutor() {
        return "Bem-vindo à área do Instrutor!";
    }
}
