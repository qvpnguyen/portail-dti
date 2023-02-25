/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.sql.Date;
import java.time.LocalTime;

/**
 *
 * @author franc
 */
public class ServiceTutorat {
    
    private int id;
    private Date dateTutorat;
    private LocalTime heure;
    private double duree;
    private String typeDeRencontre;
    private Etudiant tuteur;
    private Etudiant etudiantTutore;
    private Cours cours;
    
}
