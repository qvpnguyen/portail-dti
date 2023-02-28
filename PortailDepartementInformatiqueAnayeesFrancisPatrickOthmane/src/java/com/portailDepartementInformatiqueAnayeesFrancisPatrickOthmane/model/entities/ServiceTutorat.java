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
    private int tuteurId;
    private int etudiantTutoreId;
    private int coursId;

    public ServiceTutorat() {
    }
    
    

    public ServiceTutorat(int id, Date dateTutorat, LocalTime heure, double duree, String typeDeRencontre, int tuteurId, int etudiantTutoreId, int coursId) {
        this.id = id;
        this.dateTutorat = dateTutorat;
        this.heure = heure;
        this.duree = duree;
        this.typeDeRencontre = typeDeRencontre;
        this.tuteurId = tuteurId;
        this.etudiantTutoreId = etudiantTutoreId;
        this.coursId = coursId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTutorat() {
        return dateTutorat;
    }

    public void setDateTutorat(Date dateTutorat) {
        this.dateTutorat = dateTutorat;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String getTypeDeRencontre() {
        return typeDeRencontre;
    }

    public void setTypeDeRencontre(String typeDeRencontre) {
        this.typeDeRencontre = typeDeRencontre;
    }

    public int getTuteurId() {
        return tuteurId;
    }

    public void setTuteurId(int tuteurId) {
        this.tuteurId = tuteurId;
    }

    public int getEtudiantTutoreId() {
        return etudiantTutoreId;
    }

    public void setEtudiantTutoreId(int etudiantTutoreId) {
        this.etudiantTutoreId = etudiantTutoreId;
    }

    public int getCoursId() {
        return coursId;
    }

    public void setCoursId(int coursId) {
        this.coursId = coursId;
    }
    
    
    
    
}
