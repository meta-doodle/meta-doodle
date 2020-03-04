Language spécifié : org.xtext.mdl.workflow\src\org\xtext\mdl\workflow\Workflow.xtext

## Installation de Xtext : 

- Ouvrir Eclipse
- Aller dans Help → Install new software
- Coller cet URL pour rechercher les composants et les dépendances d'Xtext :
	- [Liens](http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/)
- Sélectionner le SDK Xtext dans la catégorie Xtext et compléter le wizard
- Redémarrer Eclipse

## Guide d'utilisation (Démo)

Création du Projet.

- Créer un nouveau projet Xtext **File → New → Project → Other → Xtext → Xtext project**
- Entrer comme nom de projet : mdl.sondage
- Pour le bloc language : Name -> mdl.sondage.MySondage  Extensions -> snd
- Vérifier que l'environement est en Java8 ou plus.
- Normalement, 5 nouveaux projets sont créés dans le workspace.

Création du Langage.

- Copier le contenu du fichier **MySondage.xtext** dans le fichier **mdl.sondage -> src -> mdl.sondage -> MySondage.xtext**
- Clic droit sur le fichier **Run as -> Generate Xtext Artifacts**

Création d'un model conforme à la grammaire définie.

- Clic droit sur le dossier **mdl.sondage** et faire **Run As -> Eclipse Application**
- Une seconde instance d'Eclipse s'ouvre, créer un nouveau projet  **File → New → Project… → Java Project**
- Créer un fichier avec l'extension choisie (ici .snd).
- Copier le contenu de sondage.snd (ou créer votre propre model!)

Création d'un générateur de code.

- Retourner sur la première instance d'Eclipse dans le package mdl.sondage.Generator
- Copier le fichier **MySondageGenerator.xtend**
- Clic droit sur mdl.sondage **Run As -> Eclipse Application**
- Normalement le code généré (ici Sondage.java) se trouve dans src-gen
