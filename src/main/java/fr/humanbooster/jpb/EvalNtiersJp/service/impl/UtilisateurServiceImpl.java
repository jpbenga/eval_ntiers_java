package fr.humanbooster.jpb.EvalNtiersJp.service.impl;

import fr.humanbooster.jpb.EvalNtiersJp.business.Utilisateur;
import fr.humanbooster.jpb.EvalNtiersJp.dao.UtilisateurDao;
import fr.humanbooster.jpb.EvalNtiersJp.dao.impl.UtilisateurDaoImpl;
import fr.humanbooster.jpb.EvalNtiersJp.service.UtilisateurService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UtilisateurServiceImpl implements UtilisateurService {

    UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        Utilisateur nouvelUtilisateur = new Utilisateur();
        try{
            nouvelUtilisateur = utilisateurDao.ajouterUtilisateur(utilisateur);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return nouvelUtilisateur;
    }

    @Override
    public Utilisateur recupererUtilisateurParId(Long id) {
        try{
            utilisateurDao.recupererUtilisateurParId(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Utilisateur> recupererListeUtilisateur() {
        try{
            utilisateurDao.recupererListeUtilisateur();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Utilisateur modifierUtilisateur(Utilisateur utilisateur) {
        try{
            utilisateurDao.modifierUtilisateur(utilisateur);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return utilisateur;
    }

    @Override
    public boolean supprimerUtilisateur(Long id) {
        try{
            utilisateurDao.supprimerUtilisateur(id);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
