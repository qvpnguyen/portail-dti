package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Etudiant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

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

        Etudiant etudiant = new Etudiant("Anayees", "Sarkes");

        repo.save(etudiant);
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
