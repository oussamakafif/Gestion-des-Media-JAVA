package Model;
public class Movie extends Media{
    public Movie(String title,String director ,int releaseYear){
        super(title, director, releaseYear);
    } 

    @Override
    public String getMediatype(){
        return "Film";
    }

    @Override
    public void displayInfo() {
        // TODO Auto-generated method stub
        super.displayInfo();
    }

    @Override
    void displayInfo(double rating) {
        // TODO Auto-generated method stub
        super.displayInfo(rating);
    }

}