# TAGEBUCH

### 23.07.2016  ~6 Stunden

- GITHub soll als Code- und Versionsverwaltungstool verwendet werden, da man den Quellcode sehr einfach Serverseitig speichern und überall abrufen kann. 

- Erstellung von GITHub Accounts.

- Als IDE soll Eclipse Neon verwendet werden, Gründe hierfür sind unter anderem die Kompatibilität mit GITHub.

- Als Grafische Oberfläche wird die von Java bereitgestellte Library "Swing" verwendet. 

- Für das Zeichnen von Klassendiagrammen verwenden wir das Tool "Dia".

- Anfängliches Einarbeiten in die Java GUI.

- Anfängliches Klassendiagramm angefertigt.

  
_Aufgetretene Probleme:_
-> Vererbungen der Abstrakten Nahrungsklasse konnten nicht richtig gelöst werden.
-> Abfrage ob ein Objekt eine Instanz einer bestimmten Klasse ist.

----------------

### 15.09.2016 ~1 Stunde

 Erstellung des genannten Zeitplans für die Fertigung des Tamagotchis.

----------------

### 27.09.2016 ~2 Stunden

Gemeinsames Einarbeiten in die Java GUI mit einem Übungstutorial: http://www.programmierenlernenhq.de/java-spiel-programmieren-tutorial/

---------------

### 27.09.2016 ~1.5 Stunden

GITHub Tagebuch und Zeitplanverwaltung angelegt, dazu gehörte das Einlesen in besondere _"Marker"_ in .md Dateien auf GitHub.
Beispielsweise kann mit Hashtags eine Überschrift gestaltet werden, dabei unterscheidet man zwischen h1 bis h6 (Je höher die Zahl hinter dem "h", desto kleiner die Überschrift).

-----------------

### 28.09.2016 ~30 Minuten

Grammatikalische Korrekturen und Ergänzungen zum Tagebuch und zum Zeitplan.

--------------------

### 01.10.2016 ~10 Minuten

Zeitplan wurde aus dem Tagebuch entfernt, da es dort als unpassend empfunden wurde. Stattdessen ist es nun in der Milestones Abteilung, welche von GITHub bereitgestellt wird. Zu finden sind diese unter: _"Issues -> Milestones"_

-----------------

### 04.10.2016 ~2 Stunden

Angefangen den Prototyp des Klassendiagramms zu zeichnen. Einführung in den "ScheduledThreadPoolExecutor" um einen parallelen Task ein oder mehrfach ausführen zu lassen. 
Für das nächste Treffen war die fertigstellung des Klassendiagramms geplant.

---------------

### 06.10.2016 ~30 Minuten 

Fertigstellung des Klassendiagramms für den Prototyps des Tamagotchis.

----------------

### 11.10.2016

#### ~2 Stunden
Struktur der Klassen "Tamagotchi", "Nahrung" und "Bedürfnisse" durchgesprochen und anfänglich Programmiert. Die jeweiligen Klassen wurden aufgeteilt und jeder von uns 3 hat jeweils ein Package bearbeitet. Einführung in GitHub Desktop (Einrichten des lokalen Repositories, Commits, Pull Requests und merging). 

#### ~1 Stunde
Probleme mit dem GitHub Repository behoben, welche darauf zurückzuführen sind, dass ein ganzes Eclipse Workspace im Repository eingeklinkt war (Siehe Issues).
Programmierung der Nahrungsklassen für den Anfänglichen Tamagotchi Milestone.

#### ~30 Minuten
Die Bedürfnisklassen für den Milestone "Anfängliches Tamagotchi" programmiert.

------------

### 12.10.2016 ~1 Stunde

Zusammenführung aller Klassen, die bis jetzt für das Projekt programmiert wurden. Somit ist die Konsolen Version des Anfänglichen Tamagotchis vollendet und somit auch der ***der erste Milestone*** abgeschlossen. Der nächste Schritt wird sein, eine GUI ohne großen Design Aufwand für den jetzigen Stand zu programmieren.

-------------

### 18.10.2016 ~2 Stunden

Überlegung, wie wir die GUI handhaben wollen. Wir einigten uns nun darauf, die Buttons nicht in das Zeichenfenster zu integrieren, sondern eine zweites "Button Fenster" neben der Zeichenfläche zu erstellen.

Anfängliche GUI erstellt, welche die funktionalitäten der Klassen darstellen soll.

---------------

### 25.10.2016 ~2 Stunden

Fertigstellung des Meilensteins "Bedürfniss Balken", welche die Bedürfnisse Grafisch mit Balken anzeigen, je mehr Hunger das Tamagotchi hat, desto kleiner wird der Balken.
Zusätzlich Gespräch mit Maier Andre über Speicherung des Spielstands, in dem man ein komplettes Objekt in ein File schreibt und dies beim Spielstart wieder ausliest. Ausserdem hatte er die XOR-Verschlüsselung angesprochen um das beschriebene File zu verschlüsseln, damit keiner unberechtigten Zugriff darauf haben kann. 
Tipp: Klassendiagramm von einem Eclipse-Plugin erstellen lassen.

-------------

### 08.11.2016 ~4 Stunden

Versucht Speicherung des Spielstandes zu implementieren anhand der Java Objektserialisierung. Mehrere Testversuche an kleineren Programmen, allerdings ~3 Stunden ohne Erfolg. Beim Ausleseversuch gibt es eine EOFException. Wir vermuten einen Fehler bei der Angabe des Dokumentpfades. Siehe Issues "Speichern und Auslesen".
Mit Hilfe von Andre Maier Fehler gefunden. Im File wurde "null" gespeichert, da das Testspiel erst nach dem Listener instanziert wurde (5Byte großes File).
Idee: Für das ganze Tamagotchi einen Debugmode einbinden mit einem Konstanten Interface, den man dann an- und ausschalten kann.

----------

### 26.11.2016 Merkzettel

Aufgabenverteilung:

Marleen: GUI Design (Animationen für Tamagotchi, Hintergrund, etc...)
Joshi / Marius: Aufteilung der Bedürfniss Struktur (4 Bedürfniss Milestones) 


