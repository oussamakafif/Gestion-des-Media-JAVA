package Model;
import java.util.List;
public class Series extends Media {
    private List<Episode> episodes;
    private int nbOfSeasons;

    public Series(String title, String director, int releaseYear, String genre, List<Episode> episodes, int nbOfSeasons) {
        super(title, director, releaseYear);
        this.nbOfSeasons = nbOfSeasons;
        this.episodes = episodes;
    }
    @Override
    public String getMediatype() {
        // TODO Auto-generated method stub
        return "Série TV";
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public int getNbOfSeasons() {
        return nbOfSeasons;
    }

    public void setNbOfSeasons(int nbOfSeasons) {
        this.nbOfSeasons = nbOfSeasons;
    }

    public void displaySeriesInfo(){
        super.displayInfo();
        System.out.println("Nombre de saisons: " + nbOfSeasons);
    }

    public void displaSeriesInfo(boolean showTotalEpisodes){
        super.displayInfo();
        System.out.println("Nombre de saisons: " + nbOfSeasons);
        if(showTotalEpisodes){
            System.out.println("Nombre total d'épisodes: " + episodes.size());
        }
    }
}
