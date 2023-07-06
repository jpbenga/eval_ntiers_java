package fr.humanbooster.jpb.EvalNtiersJp.dao.impl;

import fr.humanbooster.jpb.EvalNtiersJp.business.Utilisateur;
import fr.humanbooster.jpb.EvalNtiersJp.dao.ConnexionBdd;
import fr.humanbooster.jpb.EvalNtiersJp.dao.Requetes;
import fr.humanbooster.jpb.EvalNtiersJp.dao.UtilisateurDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDaoImpl implements UtilisateurDao {

    private Connection connection;

    public UtilisateurDaoImpl(){
        try{
          connection = ConnexionBdd.getConnection();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.AJOUTER_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, utilisateur.getNom());
        ps.setString(2, utilisateur.getPrenom());
        ps.setTimestamp(3, Timestamp.valueOf(utilisateur.getDateNaissance()));
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        utilisateur.setId(rs.getLong(1));
        return utilisateur;
    }

    @Override
    public Utilisateur recupererUtilisateurParId(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERER_UTILISATEUR_PAR_ID, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(rs.getLong("id"));
            utilisateur.setNom(rs.getString("nom"));
            utilisateur.setPrenom(rs.getString("prenom"));
            utilisateur.setDateNaissance(rs.getTimestamp("dateNaissance").toLocalDateTime());
            return utilisateur;
        }
        return null;
    }

    @Override
    public List<Utilisateur> recupererListeUtilisateur() throws SQLException {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERER_LISTE_UTILISATEUR_PAR_DATENAISSANCE);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(rs.getLong("id"));
            utilisateur.setNom(rs.getString("nom"));
            utilisateur.setPrenom(rs.getString("prenom"));
            utilisateur.setDateNaissance(rs.getTimestamp("dateNaissance").toLocalDateTime());
            utilisateurs.add(utilisateur);
        }
        return utilisateurs;
    }

    @Override
    public Utilisateur modifierUtilisateur(Utilisateur utilisateur) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.MOFIER_UTILISATEUR);
        ps.setString(1, utilisateur.getNom());
        ps.setString(2, utilisateur.getPrenom());
        ps.setTimestamp(3, Timestamp.valueOf(utilisateur.getDateNaissance()));
        ps.executeUpdate();
        return utilisateur;
    }

    @Override
    public boolean supprimerUtilisateur(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.SUPPRIMER_UTILISATEUR);
        ps.setLong(1,id);
        return ps.execute();
    }
}
