
# App Ref. Card 01
Standalone Spring Boot Application

---
title: App Ref. Card 01
author: Rinaldo Lanza, BBW
date: 12. Februar 2023
---


Link zur Übersicht:<br/>
https://gitlab.com/bbwrl/m347-ref-card-overview


## Installation der benötigten Werkzeuge

Maven Tutorial for Beginners<br/>
https://www.simplilearn.com/tutorials/maven-tutorial



### Projekt bauen und starten
Die Ausführung der Befehle erfolgt im Projektordner
Builden mit Maven<br/>
```$ mvn package```

Das Projekt wird gebaut und die entsprechende Jar-Datei im Ordner Target erstellt (Artefakt).
Die erstellte Datei kann nun direkt mit Java gestartet werden.<br/>
```$ java -jar target/app-refcard-01-0.0.1-SNAPSHOT.jar```

Die App kann im Browser unter der URL http://localhost:8080 betrachtet werden.


### Tests ausführen
```$ mvn verify```

- Unit-Tests (`*Test.java`, Surefire): `HomeControllerTest`, `RestAPIControllerTest`, `MessageTest`
- Integrationstest (`*IT.java`, Failsafe): `ArchitectureRefCard01ApplicationIT` startet die App auf einem zufälligen Port

In VS Code: Testing-Panel (Kolben-Symbol) oder `Terminal > Run Task > Tests: mvn verify`.

### Inbetriebnahme mit Docker Container
```
$ docker build -t refcard01 .
$ docker run --rm -p 8080:8080 refcard01
```
Danach im Browser http://localhost:8080 öffnen.

### CI/CD (GitHub Actions)
Workflow: `.github/workflows/ci-cd.yml`

1. **build-and-test**: `mvn verify` (Unit + Integrationstests), Testberichte und JAR als Artefakte
2. **docker**: Image bauen, Container starten und mit `curl` prüfen (Smoke-Test), danach Push zu Docker Hub und ghcr.io

Benötigte Repository-Secrets (Settings > Secrets and variables > Actions):

| Secret | Inhalt |
|---|---|
| `DOCKERHUB_USERNAME` | Docker-Hub-Benutzername |
| `DOCKERHUB_TOKEN` | Docker-Hub Personal Access Token (Read & Write) |

Für ghcr.io braucht es kein Secret, der Workflow nutzt das automatische `GITHUB_TOKEN`.





