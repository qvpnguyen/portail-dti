package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Notes;
import com.portaildti.portaildti.entities.Projet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProjetRepositoryTest {

    @Autowired
    private ProjetRepository repo;

    @Autowired
    NotesRepository reposNotes ;

    @Autowired
    private CoursRepository repo1;

    @Test
    public void testFindProjetsParNomCours() {

        Cours cours = new Cours();
        cours.setNom("Test Course");
        repo1.save(cours);

        Projet projet1 = new Projet();
        projet1.setNom("Test Project 1");
        projet1.setDescription("This is a test project for Test Course.");
        projet1.setCours(cours);
        repo.save(projet1);

        Projet projet2 = new Projet();
        projet2.setNom("Test Project 2");
        projet2.setDescription("This is another test project for Test Course.");
        projet2.setCours(cours);
        repo.save(projet2);

        List<Projet> result = repo.findProjetsByNomCours("Test Course");

        assertEquals(2, result.size());
        assertTrue(result.contains(projet1));
        assertTrue(result.contains(projet2));
    }
    @Test
    public void testFindProjetsParNom() {


        List<Notes>  notesList = reposNotes.findNotesByProjetName("Projet1");

        System.out.println("la listee est xhcghfjcjdjfn"+notesList);
    }
}
