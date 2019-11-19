INSERT INTO enseignant VALUES(1, 'ENSENS01', 'xxxxxx1','Mathematique', 'Mahmoud', 'Tawachi');
INSERT INTO enseignant VALUES(2, 'ENSENS02', 'xxxxxx2','Informatique', 'Anwar', 'Gaafour');
INSERT INTO enseignant VALUES(3, 'ENSENS03', 'xxxxxx3','Langue', 'Fatma', 'Feki');
INSERT INTO enseignant VALUES(4, 'ENSENS04', 'xxxxxx4','Informatique', 'Mariem', 'Sfax');
INSERT INTO enseignant VALUES(5, 'ENSENS05', 'xxxxxx5','Informatique', 'Mohsen', 'Benzarti');
INSERT INTO enseignant VALUES(6, 'ENSENS06', 'xxxxxx6','Informatique', 'Marwen', 'Ben Yahya');
INSERT INTO enseignant VALUES(7, 'ENSENS07', 'xxxxxx7','Langue', 'Rim', 'Majoud');
INSERT INTO enseignant VALUES(8, 'ENSENS08', 'xxxxxx8','Mathematique', 'Amal', 'Ben Hlima');
INSERT INTO enseignant VALUES(9, 'ENSENS09', 'xxxxxx9','Mathematique', 'Mohamed', 'Yaakoubi');
INSERT INTO enseignant VALUES(10, 'ENSENS10', 'xxxxxx10','Mathematique', 'Samir', 'Ben Dhief');

INSERT INTO ADMINISTRATEUR  VALUES (1,'adminadmin1','passpass1');
INSERT INTO ADMINISTRATEUR  VALUES (2,'adminadmin2','passpass2');
INSERT INTO ADMINISTRATEUR  VALUES (3,'adminadmin3','passpass3');

INSERT INTO AGENT_DE_TIRAGE VALUES (1,'agentagent1','passpass1','Farhat','Guesmi');
INSERT INTO AGENT_DE_TIRAGE VALUES (2,'agentagent2','passpass2','Noura','Makhlouf');
INSERT INTO AGENT_DE_TIRAGE VALUES (3,'agentagent3','passpass3','Fathi','Ben slimen');
INSERT INTO AGENT_DE_TIRAGE VALUES (4,'agentagent4','passpass4','Yassin','Ben Yedder');
INSERT INTO AGENT_DE_TIRAGE VALUES (5,'agentagent5','passpass5','Aymen','Rekik');
INSERT INTO AGENT_DE_TIRAGE VALUES (6,'agentagent6','passpass6','Monsef','Ajmi');
INSERT INTO AGENT_DE_TIRAGE VALUES (7,'agentagent7','passpass7','Samir','Zweri');
INSERT INTO AGENT_DE_TIRAGE VALUES (8,'agentagent8','passpass8','Wassim','Mziouw');
INSERT INTO AGENT_DE_TIRAGE VALUES (9,'agentagent9','passpass9','Seddik','Gharyeni');

INSERT INTO MATIERE VALUES (1,'JEE',35);
INSERT INTO MATIERE VALUES (2,'JAVA',35);
INSERT INTO MATIERE VALUES (3,'C#',35);
INSERT INTO MATIERE VALUES (4,'ANGULAR',35);
INSERT INTO MATIERE VALUES (5,'SYNFONY',35);
INSERT INTO MATIERE VALUES (6,'BASE DE DONNEE',35);
INSERT INTO MATIERE VALUES (7,'XML',35);
INSERT INTO MATIERE VALUES (8,'PROGRAMMATION SYSTEM',35);
INSERT INTO MATIERE VALUES (9,'LUNIX',35);
INSERT INTO MATIERE VALUES (10,'SERVICES WEB',35);
INSERT INTO MATIERE VALUES (11,'FRANCAIS',35);
INSERT INTO MATIERE VALUES (12,'ANGLAIS',35);
INSERT INTO MATIERE VALUES (13,'RECHERCHE OPERATIONNEL',35);
INSERT INTO MATIERE VALUES (14,'PROBABILITE',35);
INSERT INTO MATIERE VALUES (15,'ALGEBRE',35);
INSERT INTO MATIERE VALUES (16,'ELECTRONIQUE',35);
INSERT INTO MATIERE VALUES (17,'RESISTANCE DES MATERIAUX',35);
INSERT INTO MATIERE VALUES (18,'MECANIQUE DES POINTS',35);
INSERT INTO MATIERE VALUES (19,'MECANIQUE DES FLUIDES',35);
INSERT INTO MATIERE VALUES (20,'RESSOURCE HUMAINES',35);

INSERT INTO GROUPE VALUES (1,'GINFO1',30);
INSERT INTO GROUPE VALUES (2,'GINFO2',25);
INSERT INTO GROUPE VALUES (3,'GINFO3',25);
INSERT INTO GROUPE VALUES (4,'GIND1',20);
INSERT INTO GROUPE VALUES (5,'GIND2',15);
INSERT INTO GROUPE VALUES (6,'GIND3',10);
INSERT INTO GROUPE VALUES (7,'GM1',30);
INSERT INTO GROUPE VALUES (8,'GM2',25);
INSERT INTO GROUPE VALUES (9,'GM2',20);

INSERT INTO GROUPE_MATIERE VALUES(1,1);
INSERT INTO GROUPE_MATIERE VALUES(1,2);
INSERT INTO GROUPE_MATIERE VALUES(1,3);
INSERT INTO GROUPE_MATIERE VALUES(1,4);
INSERT INTO GROUPE_MATIERE VALUES(2,1);
INSERT INTO GROUPE_MATIERE VALUES(2,2);
INSERT INTO GROUPE_MATIERE VALUES(2,3);
INSERT INTO GROUPE_MATIERE VALUES(2,4);
INSERT INTO GROUPE_MATIERE VALUES(3,1);
INSERT INTO GROUPE_MATIERE VALUES(3,2);
INSERT INTO GROUPE_MATIERE VALUES(3,3);
INSERT INTO GROUPE_MATIERE VALUES(3,4);

INSERT INTO ENSEIGNER VALUES('18/2019',1,1,1);
INSERT INTO ENSEIGNER VALUES('18/2019',2,2,1);
INSERT INTO ENSEIGNER VALUES('18/2019',3,3,1);
INSERT INTO ENSEIGNER VALUES('18/2019',4,4,1);
INSERT INTO ENSEIGNER VALUES('18/2019',5,1,2);
INSERT INTO ENSEIGNER VALUES('18/2019',6,2,2);
INSERT INTO ENSEIGNER VALUES('18/2019',1,3,2);
INSERT INTO ENSEIGNER VALUES('18/2019',2,4,2);
INSERT INTO ENSEIGNER VALUES('18/2019',3,1,3);
INSERT INTO ENSEIGNER VALUES('18/2019',4,2,3);
INSERT INTO ENSEIGNER VALUES('18/2019',5,3,3);
INSERT INTO ENSEIGNER VALUES('18/2019',6,4,3);