package fr.humanbooster.jpb.EvalNtiersJp.dao;

public class Requetes {
    public static String AJOUTER_UTILISATEUR = "INSERT INTO Utilisateur (nom,prenom,dateNaissance) VALUES(?,?,?)";
    public static String RECUPERER_UTILISATEUR_PAR_ID = "SELECT * FROM Utilisateur WHERE id = ?";
    public static String RECUPERER_LISTE_UTILISATEUR_PAR_DATENAISSANCE = "SELECT * FROM Utilisateur WHERE `dateNaissance` = ?";
    public static String MOFIER_UTILISATEUR = "UPDATE Utilisateur SET nom = ?, prenom = ?, dateNaissance = ? WHERE id = ?";
    public static String SUPPRIMER_UTILISATEUR = "DELETE FROM Utilisateur WHERE id = ?";

}
