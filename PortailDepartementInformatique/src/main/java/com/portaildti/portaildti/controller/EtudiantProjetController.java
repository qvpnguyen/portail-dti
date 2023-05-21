package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.service.EtudiantProjetService;
import com.portaildti.portaildti.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EtudiantProjetController {

    @Autowired
    EtudiantProjetService etudiantProjetService;

    @Autowired
    EtudiantService etudiantService;


}
