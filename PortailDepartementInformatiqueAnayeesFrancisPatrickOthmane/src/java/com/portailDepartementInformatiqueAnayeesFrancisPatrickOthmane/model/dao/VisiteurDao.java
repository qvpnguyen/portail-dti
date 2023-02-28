/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Visiteur;
import java.util.List;

/**
 *
 * @author franc
 */
public interface VisiteurDao {
    
    List<Visiteur> findAll();
    
    Visiteur findById(int id);
    
    Visiteur findByName(String nom);
    
    Visiteur findByEmail(String email);    
    
    Visiteur existsByEmailAndPassword(String email);
    
    boolean delete(int id);
    
    boolean create(Visiteur visiteur);
    
    boolean update(Visiteur visiteur);
    
}
