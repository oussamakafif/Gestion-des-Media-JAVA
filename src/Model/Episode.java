package Model;
public class Episode  {
   private String title;
   private int duration;
   private int episodeNumber;
   private int seasonNumber;
    public Episode(String eptitle, int duration, int episodeNumber, int seasonNumber) {
         this.title = eptitle;
         this.duration = duration;
         this.episodeNumber = episodeNumber;
         this.seasonNumber = seasonNumber;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getEpisodeNumber() {
        return episodeNumber;
    }
    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
    public int getSeasonNumber() {
        return seasonNumber;
    }
    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    void displayEpisodeInfo(){
        System.out.println("Titre de l'épisode: " + title);
        System.out.println("Numéro de saison: " + seasonNumber);
        System.out.println("Numéro d'épisode: " + episodeNumber);
        System.out.println("Durée: " + duration);
    }

}
