CREATE TABLE Saluti (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        Testo VARCHAR(255) NOT NULL
);

INSERT INTO Saluti (Testo)
VALUES ('Ciao dal database!');