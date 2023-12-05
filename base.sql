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

CREATE SCHEMA IF NOT EXISTS "public";

CREATE SEQUENCE "public".seq_article START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_article_quantity START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_category START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_mouvement START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_proforma_request START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_society START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_society_category_product START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_unity START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_utilisateur START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".category ( 
	id_category          integer DEFAULT nextval('seq_category'::regclass) NOT NULL  ,
	code                 varchar(30)    ,
	designation          varchar(100)    ,
	description          varchar(1000)    ,
	status               integer    ,
	CONSTRAINT category_pkey PRIMARY KEY ( id_category )
 );

CREATE  TABLE "public".society ( 
	id_society           integer DEFAULT nextval('seq_society'::regclass) NOT NULL  ,
	society_name         varchar(50)    ,
	society_address      varchar(50)    ,
	responsable_contact  varchar(20)    ,
	mail                 varchar(30)    ,
	status               integer    ,
	CONSTRAINT society_pkey PRIMARY KEY ( id_society )
 );

CREATE  TABLE "public".society_category_product ( 
	id_society_category_product integer DEFAULT nextval('seq_society_category_product'::regclass) NOT NULL  ,
	id_society           integer    ,
	id_category          integer    ,
	CONSTRAINT society_category_product_pkey PRIMARY KEY ( id_society_category_product ),
	CONSTRAINT society_category_product_id_society_fkey FOREIGN KEY ( id_society ) REFERENCES "public".society( id_society )   ,
	CONSTRAINT society_category_product_id_category_fkey FOREIGN KEY ( id_category ) REFERENCES "public".category( id_category )   
 );

CREATE  TABLE "public".unity ( 
	id_unity             integer DEFAULT nextval('seq_unity'::regclass) NOT NULL  ,
	name                 varchar(50)    ,
	CONSTRAINT unity_pkey PRIMARY KEY ( id_unity )
 );

CREATE  TABLE "public".utilisateur ( 
	id_utilisateur       integer DEFAULT nextval('seq_utilisateur'::regclass) NOT NULL  ,
	id_society           integer    ,
	username             varchar(50)    ,
	"password"           varchar(20)    ,
	mail                 varchar(50)    ,
	photo                varchar(50)    ,
	status               integer    ,
	CONSTRAINT utilisateur_pkey PRIMARY KEY ( id_utilisateur ),
	CONSTRAINT utilisateur_id_society_fkey FOREIGN KEY ( id_society ) REFERENCES "public".society( id_society )   
 );

CREATE  TABLE "public".article ( 
	id_article           integer DEFAULT nextval('seq_article'::regclass) NOT NULL  ,
	code                 varchar(30)    ,
	description          varchar(1000)    ,
	designation          varchar(100)    ,
	price                double precision    ,
	id_category          integer    ,
	tva                  numeric(10,2)    ,
	id_unity             integer    ,
	status               integer    ,
	CONSTRAINT article_pkey PRIMARY KEY ( id_article ),
	CONSTRAINT article_id_category_fkey FOREIGN KEY ( id_category ) REFERENCES "public".category( id_category )   ,
	CONSTRAINT article_id_unity_fkey FOREIGN KEY ( id_unity ) REFERENCES "public".unity( id_unity )   
 );

CREATE  TABLE "public".mouvement ( 
	id_mouvement         integer DEFAULT nextval('seq_mouvement'::regclass) NOT NULL  ,
	date_mouvement       date    ,
	id_article           integer    ,
	type_mouvement       integer    ,
	quantite             double precision    ,
	prix_unitaire        double precision    ,
	status               integer    ,
	CONSTRAINT mouvement_pkey PRIMARY KEY ( id_mouvement ),
	CONSTRAINT mouvement_id_article_fkey FOREIGN KEY ( id_article ) REFERENCES "public".article( id_article )   
 );

CREATE  TABLE "public".proforma_request ( 
	id_proforma_request  integer DEFAULT nextval('seq_proforma_request'::regclass) NOT NULL  ,
	id_society           integer    ,
	mail_client          varchar(50)    ,
	status               integer    ,
	date_sending         date    ,
	CONSTRAINT proforma_request_pkey PRIMARY KEY ( id_proforma_request ),
	CONSTRAINT proforma_request_id_society_fkey FOREIGN KEY ( id_society ) REFERENCES "public".society( id_society )   
 );

CREATE  TABLE "public".article_quantity ( 
	id_article_quantity  integer DEFAULT nextval('seq_article_quantity'::regclass) NOT NULL  ,
	id_article           integer    ,
	quantity             double precision    ,
	status               integer    ,
	id_proforma_request  integer    ,
	CONSTRAINT article_quantity_pkey PRIMARY KEY ( id_article_quantity ),
	CONSTRAINT article_quantity_id_article_fkey FOREIGN KEY ( id_article ) REFERENCES "public".article( id_article )   ,
	CONSTRAINT article_quantity_id_proforma_request_fkey FOREIGN KEY ( id_proforma_request ) REFERENCES "public".proforma_request( id_proforma_request )   
 );

ALTER  SEQUENCE seq_category RESTART WITH 1;
INSERT INTO "public".category(code, designation, description, status ) VALUES ('CAT001', 'Fournitures de bureau', 'Les fournitures necessaire aux bureaux', 1);
INSERT INTO "public".category(code, designation, description, status ) VALUES ('CAT002', 'Matiere premiere', 'Matiere premiere pour la production', 1);
INSERT INTO "public".category(code, designation, description, status ) VALUES ('CAT003', 'Fournitures menagere', 'Fournitures pour le menage', 1);
INSERT INTO "public".category(code, designation, description, status ) VALUES ('CAT004', 'Automobile', 'Piece, Entretien, carburant des voitures', 1);

ALTER SEQUENCE seq_society RESTART WITH 1;
INSERT INTO "public".society(society_name, society_address, responsable_contact, mail, status ) VALUES ('Jumbo Score', 'Mahamasina', '+261 34 238 14', 'jumboScore@example.com', 1);
INSERT INTO "public".society(society_name, society_address, responsable_contact, mail, status ) VALUES ('Hazo Vato', 'Ambohidranandriana', '+261 20 120 32', 'hazoVato@example.com', 1);
INSERT INTO "public".society(society_name, society_address, responsable_contact, mail, status ) VALUES ('Toyota Rasseta', 'Analakely', '+261 33 125 62', 'toyotaRasseta@example.com', 1);

ALTER SEQUENCE seq_society_category_product RESTART WITH 1;
INSERT INTO "public".society_category_product(id_society, id_category ) VALUES (1, 1);
INSERT INTO "public".society_category_product(id_society, id_category ) VALUES (1, 3);
INSERT INTO "public".society_category_product(id_society, id_category ) VALUES (2, 2);
INSERT INTO "public".society_category_product(id_society, id_category ) VALUES (3, 4);

ALTER SEQUENCE seq_unity RESTART WITH 1;
INSERT INTO "public".unity(name ) VALUES ('Kg');
INSERT INTO "public".unity(name ) VALUES ('Litres');
INSERT INTO "public".unity(name ) VALUES ('Piece');

ALTER SEQUENCE seq_utilisateur RESTART WITH 1;
INSERT INTO "public".utilisateur(id_society, username, "password", mail, photo, status ) VALUES (1, 'Score', 'score', 'score@gmail.com', 'score.png', 1);
INSERT INTO "public".utilisateur(id_society, username, "password", mail, photo, status ) VALUES (2, 'Hazo vato', 'hazovato', 'hazovato.to@gmail.com', 'hazovato.png', 1);
INSERT INTO "public".utilisateur(id_society, username, "password", mail, photo, status ) VALUES (3, 'Toyota', 'toyota', 'toyota.michael@gmail.com', 'toyota.png', 1);

ALTER SEQUENCE seq_article RESTART WITH 1;
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART002', 'Cahiers a spirale avec couverture rigide', 'Cahiers a spirale', 3000.0, 1, 20, 3, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART003', 'Classeurs de bureau pour l''organisation des documents', 'Classeurs de bureau', 5000.0, 1, 20, 3, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART004', 'Bobine de fil d''acier inoxydable pour la production', 'Fil d''acier inoxydable', 20000.0, 2, 20, 3, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART005', 'Tissu en coton de haute qualite', 'Tissu en coton', 10000.0, 2, 20, 1, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART006', 'Blocs de bois pour la sculpture et la production', 'Blocs de bois', 30000.0, 2, 20, 1, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART007', 'Ensemble de couverts en acier inoxydable', 'Couverts en acier inoxydable', 25000.0, 3, 20, 3, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART008', 'Serviettes en papier de haute qualite', 'Serviettes en papier', 5000.0, 3, 20, 3, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART009', 'Produits de nettoyage ecologiques', 'Produits de nettoyage ecologiques', 10000.0, 3, 20, 3, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART010', 'Filtre a huile de rechange pour voitures', 'Filtre a huile', 50000.0, 4, 20, 3, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART011', 'Essuie-glace de remplacement haute performance', 'Essuie-glace', 20000.0, 4, 20, 3, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART012', 'Huile moteur synthetique de qualite superieure', 'Huile moteur synthetique', 100000.0, 4, 20, 2, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ( 'BEU001', 'un bon beurre', 'Beurre', 10000.0, 2, 20, 1, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('ART001', '', 'Stylos a encres', 1000.0, 1, 20, 1, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('PA001', 'impec', 'Impec', 500.0, 2, 20, 1, 1);
INSERT INTO "public".article( code, description, designation, price, id_category, tva, id_unity, status ) VALUES ('STY001', '', ' Stylo Schneider', 1000.0, 1, 20, 1, 1);