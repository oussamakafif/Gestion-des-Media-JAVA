package Service;

import Model.Media;
import java.util.ArrayList;

public class MediaDatabase {
    ArrayList<Media> medialist;

    public MediaDatabase() {
        this.medialist = new ArrayList<>();
    }

    public void addMedia(Media media) {
        if (media == null) return;
        this.medialist.add(media);
    }

    public void addMedia(String title, String director, int year) {
        Media media = new Media(title, director, year);
        this.medialist.add(media);
    }

    // RECHERCHE:

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : medialist) {
            if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title)) {
                media.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("Aucun média trouvé avec le titre : " + title);
    }

    public void searchByDirector(String director) {
        boolean found = false;
        for (Media media : medialist) {
            if (media.getDirector() != null && media.getDirector().equalsIgnoreCase(director)) {
                media.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("Aucun média trouvé avec le réalisateur : " + director);
    }

    public void searchByGenre(String genre) {
        boolean found = false;
        for (Media media : medialist) {
            if (media.getGenre() != null && media.getGenre().equalsIgnoreCase(genre)) {
                media.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("Aucun média trouvé pour le genre : " + genre);
    }

    // GESTION:
    public void markAsWatched(String title) {
        for (Media media : medialist) {
            if (media.getTitle().equals(title)) {
                media.markAswatched();
            }
        }
    }

    public void rateMedia(String title, double rating) {
        for (Media media : medialist) {
            if (media.getTitle().equals(title)) {
                media.setRating(rating);
            }
        }
    }

    public void getUnwatchedMedia() {
        for (Media media : medialist) {
            if (!media.getIsWatched()) {
                media.displayInfo();
            }
        }
    }

    public void getWatchedMedia(){
        for (Media media : medialist) {
            if (media.getIsWatched()) {
                media.displayInfo();
            }
        }
    }

    public void displayAllMedia(){
        for(Media media: medialist){
            media.displayInfo();
        }
    }

    // RECHERCHE:
    public double getAverageRating(){
        if (medialist.isEmpty()) return 0.0;
        double totalRating = 0;
        for(Media media: medialist){
            totalRating += media.getRating();
        }
        return totalRating / medialist.size();
    }

   public int getMediaCount(){
        int count =0;
        for(Media media: medialist){
            count++;
        }
        return count;
    }

    public ArrayList<Media> getMediaByType(String type) {
    ArrayList<Media> medias = new ArrayList<>(); 
    
    for (Media media : medialist) {
        if (media.getMediatype() != null && media.getMediatype().equalsIgnoreCase(type)) {
            medias.add(media);
        }
    }

    if (medias.isEmpty()) {
        System.out.println("Aucun média trouvé pour le type : " + type);
    }

    return medias; 
}
}