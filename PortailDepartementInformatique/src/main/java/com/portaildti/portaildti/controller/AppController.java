package com.portaildti.portaildti.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AppController {
    @GetMapping("")
    public String pageAccueil() {
        return "index";
    }
}
