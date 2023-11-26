CREATE DATABASE fournisseur_datas;

\c fournisseur_datas;

CREATE SEQUENCE seq_client_info;
CREATE TABLE client_info (
    id_client_info int PRIMARY KEY DEFAULT nextval('seq_client_info') NOT NULL,
    client_address VARCHAR(100),
    responsable_contrat VARCHAR(100),
    mail VARCHAR(100)
);
    
CREATE SEQUENCE seq_supplier_info;
CREATE TABLE supplier_info (
    id_supplier_info int PRIMARY KEY DEFAULT nextval('seq_supplier_info') NOT NULL,
    supplier_name VARCHAR(50),
    supplier_address VARCHAR(50),
    responsable_contact VARCHAR(50),
    mail VARCHAR(50)
);

CREATE SEQUENCE seq_proforma_request_dto;
CREATE TABLE proforma_request_dto (
    id_proforma_request_supplier int PRIMARY KEY DEFAULT nextval('seq_proforma_request_dto') NOT NULL,
    id_proforma_request_client int,
    sending_date DATE,
    id_supplier_info int,
    id_client int,
    responsable_date DATE,
    amount double precision,
    pdf_representation double precision,
    etat int,
    FOREIGN KEY(id_supplier_info) REFERENCES supplier_info(id_supplier_info),
    FOREIGN KEY(id_client) REFERENCES client_info(id_client_info)
);

CREATE TABLE article_request_dto (
    id_proforma_request_supplier int,
    id_article int,
    article_name VARCHAR(50),
    quantity DOUBLE PRECISION,
    FOREIGN KEY(id_proforma_request_supplier) REFERENCES proforma_request_dto(id_proforma_request_supplier)
);

-- Données pour la table client_info
INSERT INTO client_info (client_address, responsable_contrat, mail) VALUES
('123 Rue de la Republique, Paris', 'Jean Dupont', 'jean.dupont@example.com'),
('456 Avenue des Champs-Elysees, Lyon', 'Marie Martin', 'marie.martin@example.com'),
('789 Boulevard Saint-Michel, Marseille', 'Pierre Leclerc', 'pierre.leclerc@example.com');

-- Données pour la table supplier_info
INSERT INTO supplier_info (supplier_name, supplier_address, responsable_contact, mail) VALUES
('ABC Electronics', '456 Rue de la Technologie, Paris', 'Sophie Dubois', 'sophie.dubois@abc-electronics.com'),
('XYZ Supplies', '789 Avenue de l''Industrie, Lyon', 'Paul Durand', 'paul.durand@xyz-supplies.com'),
('LMN Manufacturing', '101 Boulevard de la Production, Marseille', 'Isabelle Leroux', 'isabelle.leroux@lmn-manufacturing.com');

-- Données pour la table proforma_request_dto
INSERT INTO proforma_request_dto (id_proforma_request_client, sending_date, id_supplier_info, id_client, responsable_date, amount, pdf_representation, etat) VALUES
(1, '2023-01-15', 1, 1, '2023-01-20', 1500.00, 0.75, 1),
(2, '2023-02-10', 2, 2, '2023-02-15', 2000.00, 0.80, 2),
(3, '2023-03-05', 3, 3, '2023-03-10', 1200.00, 0.70, 1);

-- Données pour la table article_request_dto
INSERT INTO article_request_dto (id_proforma_request_supplier, id_article, article_name, quantity) VALUES
(1, 101, 'Laptop', 5),
(1, 102, 'Monitor', 10),
(2, 201, 'Printer', 3),
(3, 301, 'Desk', 2),
(3, 302, 'Chair', 4);