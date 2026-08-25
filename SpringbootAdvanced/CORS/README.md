Requisiti

Per avviare il progetto sono necessari:

Java 17 o superiore
Node.js
npm

--------------------
Avvio del server Spring Boot

Aprire un terminale nella cartella principale ed eseguire:

cd cors-server
.\mvnw.cmd spring-boot:run

Il server Spring Boot sarà disponibile su:

http://localhost:8080

==========================================
Avvio dell'applicazione React

Aprire un secondo terminale nella cartella principale ed eseguire:

cd react-client
npm install
npm start

L'applicazione React sarà disponibile su:

http://localhost:3000
==========================================
Test della connessione
Avviare prima il server Spring Boot.
Avviare il server React in un secondo terminale.
Aprire http://localhost:3000.
Aprire la console del browser premendo F12.
Premere il pulsante 8080.

Risultato atteso nella console:

You have clicked the button!
Response: Welcome from Spring Boot!

La risposta viene visualizzata anche nella pagina React.

===========================================
il server Spring Boot consente le richieste provenienti dal server React tramite:

@CrossOrigin(origins = "http://localhost:3000")

Questa configurazione è necessaria perché React e Spring Boot utilizzano porte differenti e, quindi, sono considerate due origini diverse.