/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;

import java.util.List;

/**
 *
 * @author franc
 */
public interface ProjetDao {
    
    List<Projet> findAllProjet();
    
}
