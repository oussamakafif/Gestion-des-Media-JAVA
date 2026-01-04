package InterfaceUtilisateur;

import Service.MediaDatabase;
import Model.Documentary;
import Model.Episode;
import Model.Movie;
import Model.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
   MediaDatabase database;
   Scanner scanner;
   boolean isRunning;

   public Application() {
      this.database = new MediaDatabase();
      this.scanner = new Scanner(System.in);
      this.isRunning = true;
   }



   public void start() {
      while (isRunning) {
         int choix = afficherMenu();

         switch (choix) {
            case 1:
               ajouterunMedia();
               break;
            case 2:
               rechercherunMedia();
               break;
            case 3:
               gérerLesMedias();
               break;
            case 4:
               isRunning = false; // Arrête la boucle
               System.out.println("Fin du programme. Au revoir !");
               break;
         }
      }
   }

   int afficherMenu() {
      System.out.println("=== Menu Principal ===");
      System.out.println("1. Ajouter un media");
      System.out.println("2. Rechercher un média");
      System.out.println("3. Gérer les médias");
      System.out.println("4. Quitter");
      System.out.print("Choisissez une option: ");
      int a = scanner.nextInt();
      scanner.nextLine();
      if (a < 1 || a > 4) {
         System.out.println("Option invalide. Veuillez réessayer.");
         return afficherMenu();
      } else {
         return a;
      }

   }

   public void ajouterunMedia() {
      System.out.println("=== Ajouter un média ===");
      System.out.println("1. Ajouter un film");
      System.out.println("2. Ajouter une série TV");
      System.out.println("3. Ajouter un documentaire");
      System.out.print("Choisissez une option: ");
      int choix = scanner.nextInt();
      scanner.nextLine();

      if (choix == 1) {
         System.out.print("Titre du film: ");
         String title = scanner.nextLine();
         System.out.print("Réalisateur: ");
         String director = scanner.nextLine();
         System.out.print("Année de sortie: ");
         int year = scanner.nextInt();
         Movie movie = new Movie(title, director, year);
         database.addMedia(movie);
         System.out.println("Film ajouté avec succès !");
      } else if (choix == 2) {
         System.out.print("Titre de la série: ");
         String title = scanner.nextLine();
         System.out.print("Réalisateur: ");
         String director = scanner.nextLine();
         System.out.print("Année de sortie: ");
         int year = scanner.nextInt();
         scanner.nextLine();
         System.out.print("Genre: ");
         String genre = scanner.nextLine();
         List<Episode> episodes = new ArrayList<>();
         System.out.print("Nombre de saisons: ");
         int nbOfSeasons = scanner.nextInt();
         Series series = new Series(title, director, year, genre, episodes, nbOfSeasons);
         database.addMedia(series);
         System.out.println("Série TV ajoutée avec succès !");
      } else if (choix == 3) {
         System.out.print("Titre du documentaire: ");
         String title = scanner.nextLine();
         System.out.print("Réalisateur: ");
         String director = scanner.nextLine();
         System.out.print("Année de sortie: ");
         int year = scanner.nextInt();
         scanner.nextLine();
         System.out.print("Sujet: ");
         String topic = scanner.nextLine();
         System.out.print("Est-ce éducatif ? (true/false): ");
         boolean isEducational = scanner.nextBoolean();
         Documentary documentary = new Documentary(title, director, year, topic, isEducational);
         database.addMedia(documentary);
         System.out.println("Documentaire ajouté avec succès !");
      } else {
         System.out.println("Option invalide. Retour au menu d'ajout.");
         ajouterunMedia();
      }
   }

   public void rechercherunMedia() {
      System.out.println("=== Rechercher un média ===");
      System.out.print("1: par titre, \n2: par réalisateur \n3: par genre \n Choisissez une option: ");
      
      int searchChoice = scanner.nextInt();
            scanner.nextLine();

      switch (searchChoice) {
         case 1:
            System.out.println("Entrez le titre à rechercher: ");
            String title = scanner.nextLine();
            database.searchByTitle(title);
            break;
         case 2:
            System.out.println("Entrez le réalisateur à rechercher: ");
            String director = scanner.nextLine();
            database.searchByDirector(director);
            break;
         case 3:
            System.out.println("Entrez le genre à rechercher: ");
            String genre = scanner.nextLine();
            database.searchByGenre(genre);
            break;
         default:
            System.out.println("Option invalide. Retour au menu principal.");
            rechercherunMedia();
      }

   }

   public void gérerLesMedias() {
      System.out.println("=== Gérer les médias ===");
      System.out.println("1. Marquer un média comme vu");
      System.out.println("2. Noter un média");
      System.out.println("3. Afficher les statistiques et les listes visionnées/non visionnées");
      System.out.print("Choisissez une option: ");
      int gestionChoice = scanner.nextInt();
      switch (gestionChoice) {
         case 1:
            System.out.print("Entrez le titre du média à marquer comme vu: ");
            scanner.nextLine();
            String titleToMark = scanner.nextLine();
            database.markAsWatched(titleToMark);
            System.out.println("Média marqué comme vu.");
            break;
         case 2:
            System.out.print("Entrez le titre du média à noter: ");
            scanner.nextLine();
            String titleToRate = scanner.nextLine();
            System.out.print("Entrez la note (0.0 - 5.0): ");
            double rating = scanner.nextDouble();
            database.rateMedia(titleToRate, rating);
            System.out.println("Média noté avec succès.");
            break;
         case 3:
            System.out.println("Médias non vus:");
            database.getUnwatchedMedia();
            System.out.println("Médias vus:");
            database.getWatchedMedia();
            System.out.println("Statistiques: \n Average Rating: " + database.getAverageRating() +
                  "\n Total Médias: " + database.getMediaCount() + "\n Les medias de type film sont: "
                  + database.getMediaByType("film") + "\n Les medias de type série TV sont: "
                  + database.getMediaByType("Série TV") + "\n Les medias de type documentaire sont: "
                  + database.getMediaByType("Documentaire"));

            break;
         default:
            System.out.println("Option invalide. Retour au menu principal.");
            gérerLesMedias();
      }

   }




}
