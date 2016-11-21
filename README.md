# Epice'Arc

Dans le cadre du cours "Outils de développement intégré" de troisième année d'informatique de gestion, 
il est demandé de réaliser une application web en Java EE sur Glassfish.

Ce travail a pour but de mettre en pratique la théorie enseignée tout au long du semestre. 
Le projet est réalisé par groupe de deux personnes tirées au sort. L’application doit se baser sur un cahier des charges qui nous été fournie.  

L’application web de gestion permet de commander des sapins pour les fêtes de Noël. 
Le but est d'implémenter totalement la couche de présentation. Les fonctionnalités proposées permettent aux 
utilisateurs de commander des sapins. Il est néanmoins nécessaire de respecter les contraintes imposées. 

La donnée du projet nous a été transmise le 3 novembre 2016. 
Le délai pour rendre l'application et la documentation sous forme de rapport expliquant la démarche est fixé au vendredi 18 novembre 2016. 
La documentation doit être rédigée dans le README de notre repository github.

Le projet doit être hébergé sur GitLab.

## Introduction

L’application permet, aux personnes qui le désirent, 
de passer des commandes de sapin pour les fêtes de fin d’année. 
Ils auront le choix entre plusieurs types de sapin, de différentes tailles et devront choisir 
la date livraison du sapin ainsi que la date retour.

## L’application

Ici, se trouve le fonctionnement de l’application qui se déroule en 5 parties :
* Accueil du client : Quand l’utilisateur arrive sur cette page, 
on lui souhaite la bienvenue et un bouton « Commencer » permet à l’utilisateur de passer à la page suivante afin de débuter sa commande.
* Choix du type de sapin : L’utilisateur doit choisir le type de sapin qu’il 
souhaite, sa taille, la date de livraison ainsi que la date de retour du sapin.
* Informations personnelles du client : Cette page demande les informations personnelles au client.
* Récapitulatif de la commande : une fois ses choix effectués et informations personnelles saisies, 
l’utilisateur voit un récapitulatif de la commande passée et doit donc confirmer sa commande.
* Remerciements : Arrivé à la fin, on demande à l’utilisateur s’il souhaite effectuer une autre commande, 
retourner à l’écran d’accueil ou alors de télécharger sa commande au format PDF.

## Technologies

Pour développer notre application, nous avons utilisé différentes technologies :


**Netbeans :** Outils de développement intégré

**JSF 2.2 :** Pour la couche de présentation, il nous était imposé d'utilisé Java Server Faces (JSF). 
Ce choix est naturel, car c'est ce que nous apprenons en cours. Ce framework facilite la gestion de la navigation et des exceptions.

**Git :** Plateforme de travail collaborative

**BootsFaces :** Librairie basée sur Bootstrap et JSF pour l'esthétique de l'application


## Fonctionnalités et configuration

Pour que notre application soit plus dynamique et la rendre multilingue, nous avons mis en place un système d'internationalisation.<br/>
La configuration pour que les fichiers de propriétés, 
ou nous intégrerons les différents textes utilisés dans l'application, nous a été fournis.<br/>
Nous avons deux fichiers de propriété:

* msg_fr.properties : pour les textes français
* msg_en.properties : pour les textes anglais


Afin que nos listes s’adaptent à ce que l’utilisateur choisi, nous avons utilisé AJAX qui permet de raffraichir que des parties de page. Dans 
notre cas, nous l'avons utilisé pour le rafraichissement de nos listes déroulantes.
En effet, quand l'utilisateur choisi un élément dans une liste, la suivante, qui est dépendante de la précédente, doit rafraichir son contenu selon 
l'élément séléctionné.

Nous avons également créé des convertisseurs personnalisées afin de récupérer des objets dans le programme pour les 
convertir en chaine de caractères dans nos listes déroulantes et inversément, quand l'utilisateur sélectionne un élément dans 
la liste, de transformer une chaine de caractère en objet. Ceci afin de permettre la gestion des objets pour les afficher dans nos listes.

Afin de permettre la navigation entre les pages de l'application, nous avons défini un ensemble de règles dans le fichier de configuration. 
C'est à dire que l'on défini par exemple quand on clic sur le bouton « Commencer » que l'utilisateur arrive sur la page de sélection 
des sapin.

Nous avons également développer une fonctionnalité qui permet à l'utilisateur de ne pas ressaisir ses informations personnelles lors d'une nouvelle commande si il en 
a déjà passé une auparavant.

Pour avoir un modèle qui se ressemble sur toutes nos pages, nous avons utilisé un fichier de templating que nous avons adapté afin d'integrer les fonctionnalités 
de BootsFaces.

En ce qui concerne le nommage des packages et des classes Java, nous avons employés les standards Java.<br/>
Le terme est toujours au singulier. Les bean porte des noms parlant qui sont presque identiques aux pages pour s’y retrouver facilement.  
Les classe Java commencent par un majuscule et les pages par une minuscule.<br/>
Le titre des pages représentent la fonctionnalité de la page.<br/>
Exemple :

* Page web : orderRecap.xhtml
* Bean : OrderRecapBean.java


## Petit plus

Nous avons ajouté une fonctionnalité supplémentaire qui est de pouvoir télécharger sa commande au format PDF. Ce choix se fait à la dernière étape du processus de commande.
Une fois que l'utilisateur a fini de passer sa commande, il a la possibilité de télécharger sa commande.

Pour cela, nous avons utilisé :


**Primefaces :** Primefaces est un framework de présentation. Il est disponible sous forme de ".jar". 
Il est facilement intégrable à notre projet. Il nous permet essentiellement d'obtenir une palette de composants additionnels avancé qui prend en compte les nouvelles technologies 
du web tels qu'Ajax par exemple. Tous les composants Primefaces sont disponibles à l'adresse suivant :  http://www.primefaces.org/

Nous avons décidé d'intégrer ce framework pour pouvoir exporter un fichier pdf qui servira de récapitulatif de la commande

* Primefaces 5.3
	* Com.lowagie.text-2.1.7 pour la création de PDF, maintenant connu sous le nom de iText

* Primefaces-extensions 4.0.0 
	* pour étendre les fonctionnalités de primefaces notamment sur l'impression de PDF pour tableau personnalisé
	* commons-lang3-3.4 et gson-2.6.2 pour faire fonctionner l'extension




Ce framework est une surcouche de JSF. Au départ, nous aurions aimés nous concentrer sur un framework, 
mais nous avons trouvé sympa de pouvoir intégrer la création d'un PDF pour la récapitulation d'une commande.

## Conclusion

Pour conclure, nous avons su réaliser la couche de présentation de l'application de gestion de commande de sapin. Nous avons rencontrés divers problèmes liés à Glassfish. Comme dans tout projet, une partie de recherche d'information a été nécessaire pour réaliser certains points. La réalisation de l'application nous a permis d'appliquer des éléments vus en cours. Nous avons été contraints à respecter certains points présents dans le cahier des charges. La JavaDoc ainsi que l'internationalisation a été réalisées. Nous avons bien évidement des librairies pour le développement de l'application. L'utilisation de la méthode de collaboration sur gitLab avec la création des issues, les merge request ainsi que les branches, nous a permis de collaborer de façon optimale. 

Ce projet nous permis de mettre en commun nos connaissances acquises tout au long du cours.

En ce qui concerne les améliorations, il faudrait stocker les informations dans une base de données, pour rendre l'application plus réelle. 

## Sources

* Support de cours 625-1.2 Outils de développement intégré, U. Rosselet

**Création de PDF**

* http://developers.itextpdf.com/examples/tables/tables-and-fonts

**Java EE**

* https://docs.oracle.com/javaee/7/api/javax/servlet/Filter.html

**Primefaces**

* http://www.primefaces.org/showcase/ 
* Locale fr : https://code.google.com/archive/p/primefaces/wikis/PrimeFacesLocales.wiki

**Primefaces extensions**

* http://primefaces-extensions.github.io/
