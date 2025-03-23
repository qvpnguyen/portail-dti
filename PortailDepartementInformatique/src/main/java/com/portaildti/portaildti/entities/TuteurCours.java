package com.portaildti.portaildti.entities;

import javax.persistence.*;

@Entity
public class TuteurCours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tuteurid")
    private Etudiant tuteur;
    @ManyToOne
    @JoinColumn(name = "coursid")
    private Cours cours;
    public TuteurCours() {

    }
    public TuteurCours(Etudiant tuteur, Cours cours) {
        this.tuteur = tuteur;
        this.cours = cours;
    }

    public Etudiant getTuteur() {
        return tuteur;
    }

    public void setTuteur(Etudiant tuteur) {
        this.tuteur = tuteur;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
