package fr.humanbooster.jpb.EvalNtiersJp.dao;

import fr.humanbooster.jpb.EvalNtiersJp.business.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public interface UtilisateurDao {

    Utilisateur ajouterUtilisateur(Utilisateur utilisateur) throws SQLException;
    Utilisateur recupererUtilisateurParId(Long id) throws SQLException;
    List<Utilisateur> recupererListeUtilisateur() throws SQLException;
    Utilisateur modifierUtilisateur(Utilisateur utilisateur) throws SQLException;
    boolean supprimerUtilisateur(Long id) throws SQLException;
}
