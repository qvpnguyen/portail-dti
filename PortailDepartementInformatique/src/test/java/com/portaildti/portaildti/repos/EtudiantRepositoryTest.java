package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Etudiant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EtudiantRepositoryTest {

    @Autowired
    private EtudiantRepository repo;

    @Test
    public void testSaveEtudiant(){

//        Etudiant etudiant = new Etudiant("Anayees", "Sarkes");
//
//        repo.save(etudiant);

        Etudiant etudiant2 = new Etudiant(false, null, false, "Programmation", "Patrick", "Nguyen", "0855068@crosemont.qc.ca", "Etudiant", true, "pnguyen", "password123", LocalDate.of(1900, 1, 1), "patrick.jpg");
        repo.save(etudiant2);
    }

    @Test
    public void testListTousEtudiants(){

        Iterable<Etudiant> listeEtudiants = repo.findAll();

        for (Etudiant etudiant : listeEtudiants){

            System.out.println(etudiant);
        }
    }

    @Test
    public void testFindEtudianyByEmail(){

        String email = "asarkes@gmail.com";

        Etudiant result = repo.findEtudiantByEmail(email);
        System.out.println("±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±");
        System.out.println(repo.findEtudiantByEmail(email));

        assertNotNull(result);
        assertEquals(email, result.getEmail());
    }
}
