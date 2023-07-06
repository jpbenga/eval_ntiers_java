<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Création d'utilisateur</title>
</head>
<body>
    <h1>Création d'utilisateur</h1>
    <%-- Affichage du message de confirmation --%>
    <p>${message}</p>

    <form action="creation-utilisateur" method="POST">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" required><br>

        <label for="dateNaissance">Date de naissance :</label>
        <input type="text" id="dateNaissance" name="dateNaissance" required><br>

        <input type="submit" value="Créer">
    </form>
</body>
</html>