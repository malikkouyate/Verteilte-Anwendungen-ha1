# Verteilte Anwendungen Übungsaufgabe 1

Mögliche Punktzahl: 20 Punkte

## Deadlines

- 1. Zug 1. Gruppe: 14.11.2022
- 1. Zug 2. Gruppe: 17.11.2022
- 2. Zug 1. Gruppe: 15.11.2022
- 2. Zug 2. Gruppe: 15.11.2022 

## Aufgabestellung

1.  **(4P)** Schreiben Sie ein Dockerfile mit dem Sie das [offizielle Image des NGINX von Docker Hub](https://hub.docker.com/_/nginx) erweitern. Erstellen Sie eine individuelle HTML Seite, die die Matrikelnummern der Gruppenteilnehmer darstellt und die Namen der Gruppenmitglieder als Meta Tag „author“ ausliefert. Starten Sie einen Container mit ihrem eigenen Image mittels ``$ docker run -d -p 8080:80 verteilte-anwendungen-nginx`` und stellen Sie sicher, dass die erstellte HTML Datei unter [http://localhost:8080/verteilte-anwendungen/test.html](http://localhost:8080/verteilte-anwendungen/test.html) von dem Container richtig ausgeliefert wird.
2.  **(4P)** Bauen Sie mit Hilfe von Maven die Quarkus Applikation sowie das entsprechende Docker Image. Starten sie einen Container mit der Quarkus Applikation und testen Sie die RESTful Webservices mit Hilfe eines REST Clients (z.B. curl oder Insomnia).
3.  **(4P)** Schreiben Sie ein Docker Compose file mit dem Sie das angepasste Image aus dem ersten Schritt starten. Der gestartete Container soll über Port 8181 erreichbar sein und die Konfiguration aus einer lokalen Datei des Host Systems (somit nicht im Image enthalten) lesen.
4.  **(8P)** Erweitern sie die Quarkus Applikation, um einen weiteren REST Endpunkt. Dieser soll unter dem Pfad `/aufgaben/1/` eine Ressource namens „zahl“ vom Media Type ``application/example`` bereitstellen. Der REST Endpunkt soll vier Methoden unterstützen: 1. Initiales Anlegen einer Zahl, 2. Abrufen der aktuellen Zahl, 3. Aktualisieren einer Zahl und 4. Löschen einer Zahl. 


# Quarkus Get Started

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
$mvn compile quarkus:dev
```

> **_NOTE:_**  Quarkus ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
$mvn package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `$java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
$mvn package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `$java -jar target/*-runner.jar`.
