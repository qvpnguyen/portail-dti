package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.EtudiantProjet;
import com.portaildti.portaildti.entities.Projet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EtudiantProjetRepositoryTest {

    @Autowired
    EtudiantProjetRepository repo;

    @Autowired
    ProjetRepository repo1;

    @Autowired
    EtudiantRepository etudiantRepository;

    @Test
    public void testListTousEtudiantsProjet(){

        Iterable<Projet> listeProjets = repo1.findAll();
        Iterable<EtudiantProjet> listeEtudiantProjet = null;
        Iterable<Etudiant> listeEtudiants = null;

        for (Projet projet : listeProjets){

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            listeEtudiants = etudiantRepository.findEtudiantsParProjetNom(projet.getNom());
            for (Etudiant etudiant : listeEtudiants) {
                System.out.println(etudiant.getNom() + " " + etudiant.getPrenom());
            }
        }
    }
}
