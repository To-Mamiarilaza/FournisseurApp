/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Fy Botas
 * Created: 24 nov. 2023
 */

CREATE DATABASE gestion_fournisseurs;

\c gestion_fournisseurs

CREATE SEQUENCE seq_category;
CREATE TABLE category (
    id_category int PRIMARY KEY DEFAULT nextval('seq_category') NOT NULL,
    code VARCHAR(30),
    designation VARCHAR(100),
    description VARCHAR(1000),
    status INTEGER
);

CREATE SEQUENCE seq_unity;
CREATE TABLE unity (
    id_unity int PRIMARY KEY DEFAULT nextval('seq_unity') NOT NULL,
    name VARCHAR(50)
);

CREATE SEQUENCE seq_article;
CREATE TABLE article (
    id_article int PRIMARY KEY DEFAULT nextval('seq_article') NOT NULL,
    code VARCHAR(30),
    description VARCHAR(1000),
    designation VARCHAR(100),
    id_category INTEGER,
    tva DECIMAL(10, 2),
    id_unity int,
    status INTEGER,
    FOREIGN KEY(id_category) REFERENCES category(id_category),
    FOREIGN KEY(id_unity) REFERENCES unity(id_unity)
);


-- Insertion des donnees de test dans la table unity
INSERT INTO unity(name) VALUES 
    ('Kg'),
    ('Litres'),
    ('Piece');

-- Insertion des données de test dans la table 'category'
ALTER SEQUENCE seq_category RESTART WITH 1;
INSERT INTO category (code, designation, description, status) VALUES
    ('CAT001', 'Fournitures de bureau', 'Les fournitures necessaire aux bureaux', 1),
    ('CAT002', 'Matiere premiere', 'Matiere premiere pour la production', 1),
    ('CAT003', 'Fournitures menagere', 'Fournitures pour le menage', 1),
    ('CAT004', 'Automobile', 'Piece, Entretien, carburant des voitures', 1);



-- Insertion des données de test dans la table 'article'
ALTER SEQUENCE seq_article RESTART WITH 1;
-- Fournitures de bureau
INSERT INTO article (code, description, designation, id_category, tva, id_unity, status) VALUES
    ('ART001', 'Stylos a encre noire de qualite professionnelle', 'Stylos a encre', 1, 20.0, 3, 1),
    ('ART002', 'Cahiers a spirale avec couverture rigide', 'Cahiers a spirale', 1, 20.0, 3, 1),
    ('ART003', 'Classeurs de bureau pour l''organisation des documents', 'Classeurs de bureau', 1, 20.0, 3, 1);

-- Matiere premiere
INSERT INTO article (code, description, designation, id_category, tva, id_unity, status) VALUES
    ('ART004', 'Bobine de fil d''acier inoxydable pour la production', 'Fil d''acier inoxydable', 2, 20.0, 3, 1),
    ('ART005', 'Tissu en coton de haute qualite', 'Tissu en coton', 2, 20.0, 1, 1),
    ('ART006', 'Blocs de bois pour la sculpture et la production', 'Blocs de bois', 2, 20.0, 1, 1);

-- Fournitures menagere
INSERT INTO article (code, description, designation, id_category, tva, id_unity, status) VALUES
    ('ART007', 'Ensemble de couverts en acier inoxydable', 'Couverts en acier inoxydable', 3, 20.0, 3, 1),
    ('ART008', 'Serviettes en papier de haute qualite', 'Serviettes en papier', 3, 20.0, 3, 1),
    ('ART009', 'Produits de nettoyage ecologiques', 'Produits de nettoyage ecologiques', 3, 20.0, 3, 1);

-- Automobile
INSERT INTO article (code, description, designation, id_category, tva, id_unity, status) VALUES
    ('ART010', 'Filtre a huile de rechange pour voitures', 'Filtre a huile', 4, 20.0, 3, 1),
    ('ART011', 'Essuie-glace de remplacement haute performance', 'Essuie-glace', 4, 20.0, 3, 1),
    ('ART012', 'Huile moteur synthetique de qualite superieure', 'Huile moteur synthetique', 4, 20.0, 2, 1);

CREATE SEQUENCE seq_mouvement;
CREATE TABLE mouvement(
    id_mouvement integer primary key DEFAULT nextval('seq_mouvement') not null,
    date_mouvement date,
    id_article integer references article(id_article),
    type_mouvement integer, -- 1 entree , 2 sortie
    quantite double precision,
    prix_unitaire double precision,
    status integer -- mouvement cree : 1 , valider : 11, refuser : 0
);
ALTER SEQUENCE seq_mouvement RESTART WITH 1;
INSERT INTO mouvement (date_mouvement, id_article, type_mouvement, quantite, prix_unitaire, status) values 
       ('2023-11-22', 1, 1, 50, 700, 11),
       ('2023-11-22', 2, 1, 20, 2000, 11),
       ('2023-11-22', 3, 1, 10, 5000, 11),
       ('2023-11-22', 1, 1, 30, 900, 11);
       
