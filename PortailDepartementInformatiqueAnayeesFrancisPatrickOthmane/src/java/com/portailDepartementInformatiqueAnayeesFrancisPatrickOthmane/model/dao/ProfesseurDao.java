/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;


import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import java.util.List;

/**
 *
 * @author franc
 */
public interface ProfesseurDao {
    
    List<Professeur> findAll();
    
    Professeur findById(int id);
    
    Professeur findByName(String nom);
    
    Professeur findByEmail(String email);    
    
    Professeur existsByEmailAndPassword(String email, String motDePasse);
    
    boolean delete(int id);
    
    boolean create(Professeur prof);
    
    boolean update(Professeur prof);
    
    Professeur findAllProfByDispo(boolean acitve);
}
