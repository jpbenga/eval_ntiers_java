package fr.humanbooster.jpb.EvalNtiersJp.service;

import fr.humanbooster.jpb.EvalNtiersJp.business.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public interface UtilisateurService {
    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
    Utilisateur recupererUtilisateurParId(Long id);
    List<Utilisateur> recupererListeUtilisateur();
    Utilisateur modifierUtilisateur(Utilisateur utilisateur);
    boolean supprimerUtilisateur(Long id);
}
