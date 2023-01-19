SET search_path TO projet;


-- Supprime toutes les données
DELETE FROM role;
DELETE FROM compte;


-- Insère les données

-- Compte

INSERT INTO compte (idcompte, pseudo, motdepasse, email ) VALUES 
( 1, 'geek', 'geek', 'geek@jfox.fr' ),
( 2, 'chef', 'chef', 'chef@jfox.fr' ),
( 3, 'job', 'job', 'job@jfox.fr' );

ALTER TABLE compte ALTER COLUMN idcompte RESTART WITH 4;


-- Role

INSERT INTO role (idcompte, role) VALUES 
( 1, 'ADMINISTRATEUR' ),
( 1, 'UTILISATEUR' ),
( 2, 'UTILISATEUR' ),
( 3, 'UTILISATEUR' );


-- Utilisateur

INSERT INTO utilisateur (idutilisateur, nom, prenom, email, motdepasse, role, paiement ) VALUES 
( 1, 'TCHITAKE', 'Alain', 'atchitak@hotmail.com', 'atchitak', 'GESTIONNAIRE', 0),
( 2, 'DURAND', 'Pierre', 'pdurand@3il.fr', 'pdurand', 'PARENT', 780),
( 3, 'NOUBIELI', 'Benjamin', 'bnoubiel@yahoo.fr', 'bnoubiel', 'GESTIONNAIRE', 0);

ALTER TABLE utilisateur ALTER COLUMN idutilisateur RESTART WITH 4;

-- Enfant 

INSERT INTO enfant (idenfant, idutilisateur, nom, prenom, datedenaissance, etabfrequente, niveauetude, creneauchoisi, modedepaiement) VALUES
( 1,2, 'Durand', 'Pierre', '2000-05-13', 'Lycée Renoir', 'PREMIERE', '10:00:00', 'ESPECES');
ALTER TABLE enfant ALTER COLUMN idenfant RESTART WITH 2;
 
