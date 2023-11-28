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

\c gestion_fournisseurs;

CREATE SEQUENCE seq_society;
CREATE TABLE society (
    id_society INTEGER PRIMARY KEY DEFAULT nextval('seq_society'),
    society_name VARCHAR(50),
    society_address VARCHAR(50),
    responsable_contact VARCHAR(20),
    mail VARCHAR(30),
    status INTEGER
);

CREATE SEQUENCE seq_category;
CREATE TABLE category (
    id_category int PRIMARY KEY DEFAULT nextval('seq_category') NOT NULL,
    code VARCHAR(30),
    designation VARCHAR(100),
    description VARCHAR(1000),
    status INTEGER
);

ALTER SEQUENCE seq_society RESTART WITH 1;
INSERT INTO society (society_name, society_address, responsable_contact, mail, status) VALUES
('Jumbo Score', 'Mahamasina', '+261 34 238 14', 'jumboScore@example.com', 1),
('Hazo Vato', 'Ambohidranandriana', '+261 20 120 32', 'hazoVato@example.com', 1),
('Toyota Rasseta', 'Analakely', '+261 33 125 62', 'toyotaRasseta@example.com', 1);

CREATE SEQUENCE seq_society_category_product;
CREATE TABLE society_category_product (
    id_society_category_product INTEGER PRIMARY KEY DEFAULT nextval('seq_society_category_product'),
    id_society INTEGER,
    id_category INTEGER,
    FOREIGN KEY(id_society) REFERENCES society(id_society),
    FOREIGN KEY(id_category) REFERENCES category(id_category)
);

ALTER SEQUENCE seq_society_category_product RESTART WITH 1;
INSERT INTO society_category_product (id_society, id_category) VALUES
(1, 1),
(1, 3),
(1, 2),
(2, 1),
(2, 2),
(3, 4);

CREATE SEQUENCE seq_utilisateur;
CREATE TABLE utilisateur (
    id_utilisateur INTEGER DEFAULT nextval('seq_utilisateur'),
    id_society INTEGER,
    username VARCHAR(50),
    password VARCHAR(20),
    mail VARCHAR(50),
    photo VARCHAR(50),
    status INTEGER,
    PRIMARY KEY(id_utilisateur),
    FOREIGN KEY(id_society) REFERENCES society(id_society)
);

ALTER SEQUENCE seq_utilisateur RESTART WITH 1;
INSERT INTO utilisateur(id_society, username, password, mail, status, photo ) VALUES (1, 'INSSA Chalman', 'chalman', 'inssa.chalman@gmail.com', 1, 'chalman.png');
INSERT INTO utilisateur(id_society, username, password, mail, status, photo ) VALUES (1, 'To MAMIARILAZA', 'to', 'mamiarilaza.to@gmail.com', 1, 'to.png');
INSERT INTO utilisateur(id_society, username, password, mail, status, photo ) VALUES (2, 'Fy Michael', 'fy', 'fy.michael@gmail.com', 1, 'fy.png');
INSERT INTO utilisateur(id_society, username, password, mail, status, photo ) VALUES (2, 'Finoana RAKOTO', 'finoana', 'finoanaRAKOTO@gmail.com', 1, 'finoana.png');
INSERT INTO utilisateur(id_society, username, password, mail, status, photo ) VALUES (3, 'Solo RATSIVAHINY', 'solo', 'soloRATSIVAHINY@gmail.com', 1, 'solo.png');
INSERT INTO utilisateur(id_society, username, password, mail, status, photo ) VALUES (3, 'Mialy RIANTSOA', 'mialy', 'mialy.RIANTSOA@gmail.com', 1, 'mialy.png');


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
    price double precision,
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
INSERT INTO article (code, description, designation, price, id_category, tva, id_unity, status) VALUES
    ('ART001', 'Stylos a encre noire de qualite professionnelle', 'Stylos a encre', 700, 1, 20.0, 3, 1),
    ('ART002', 'Cahiers a spirale avec couverture rigide', 'Cahiers a spirale', 3000, 1, 20.0, 3, 1),
    ('ART003', 'Classeurs de bureau pour l''organisation des documents', 'Classeurs de bureau', 5000, 1, 20.0, 3, 1);

-- Matiere premiere
INSERT INTO article (code, description, designation, price, id_category, tva, id_unity, status) VALUES
    ('ART004', 'Bobine de fil d''acier inoxydable pour la production', 'Fil d''acier inoxydable', 20000, 2, 20.0, 3, 1),
    ('ART005', 'Tissu en coton de haute qualite', 'Tissu en coton', 10000, 2, 20.0, 1, 1),
    ('ART006', 'Blocs de bois pour la sculpture et la production', 'Blocs de bois', 30000, 2, 20.0, 1, 1);

-- Fournitures menagere
INSERT INTO article (code, description, designation, price, id_category, tva, id_unity, status) VALUES
    ('ART007', 'Ensemble de couverts en acier inoxydable', 'Couverts en acier inoxydable', 25000, 3, 20.0, 3, 1),
    ('ART008', 'Serviettes en papier de haute qualite', 'Serviettes en papier', 5000, 3, 20.0, 3, 1),
    ('ART009', 'Produits de nettoyage ecologiques', 'Produits de nettoyage ecologiques', 10000, 3, 20.0, 3, 1);

-- Automobile
INSERT INTO article (code, description, designation, price, id_category, tva, id_unity, status) VALUES
    ('ART010', 'Filtre a huile de rechange pour voitures', 'Filtre a huile', 50000, 4, 20.0, 3, 1),
    ('ART011', 'Essuie-glace de remplacement haute performance', 'Essuie-glace', 20000, 4, 20.0, 3, 1),
    ('ART012', 'Huile moteur synthetique de qualite superieure', 'Huile moteur synthetique', 100000, 4, 20.0, 2, 1);

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
     
CREATE SEQUENCE seq_supplier;
CREATE TABLE supplier (
    id_supplier integer primary key DEFAULT nextval('seq_supplier') not null,
    name VARCHAR(50),
    adress VARCHAR(100),
    contact_responsable VARCHAR(50),
    mail VARCHAR(50)
);

INSERT INTO supplier (name, adress, contact_responsable, mail) VALUES
        ('Jumbo Score', 'Tanjombat', '+261345434598', 'JumboScore@gmail.com'),
        ('Filatex', 'Ankadimbahoaka', '+261323567534', 'filatex@gmail.com');

CREATE SEQUENCE seq_proforma_request;
CREATE TABLE proforma_request (
    id_proforma_request integer primary key DEFAULT nextval('seq_proforma_request') not null,
    id_supplier int,
    mail_client VARCHAR(50),
    status int,
    date_sending DATE,
    FOREIGN KEY (id_supplier) REFERENCES supplier(id_supplier)
);

CREATE SEQUENCE seq_article_quantity;
CREATE TABLE article_quantity (
    id_article_quantity integer primary key DEFAULT nextval('seq_article_quantity') not null,
    id_article int,
    quantity double precision,
    status int,
    id_proforma_request int,
    FOREIGN KEY (id_article) REFERENCES article(id_article),
    FOREIGN KEY (id_proforma_request) REFERENCES proforma_request(id_proforma_request)
);