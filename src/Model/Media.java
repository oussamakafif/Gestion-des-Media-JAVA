package Model;

public class Media {
        private String title, director, genre;
        private int releaseYear;
        private double rating;
        private boolean isWatched;

        public Media(String title, String director, int releaseYear) {
                this.title = title;
                this.director = director;
                this.releaseYear = releaseYear;
        }

        public Media(String title, String director, int releaseYear, String genre) {
                this(title, director, releaseYear);
                this.genre = genre;
        }

        public void setGenre(String genre) {
                this.genre = genre;
        }

        public void setRating(double rating) {
                this.rating = rating;
        }

        public void setdirector(String director) {
                this.director = director;
        }

        public void setReleaseYear(int releaseYear) {
                this.releaseYear = releaseYear;
        }

        public void setWatched(boolean isWatched) {
                this.isWatched = isWatched;
        }

        public String getTitle() {
                return title;
        }

        public String getDirector() {
                return director;
        }

        public String getGenre() {
                return genre;
        }

        public int getReleaseYear() {
                return releaseYear;
        }

        public double getRating() {
                return rating;
        }

        public boolean getIsWatched() {
                return isWatched;
        }

        public boolean markAswatched() {
                return this.isWatched = true;
        }

        public String getMediatype() {
                return "Generic Media";
        }

        public void displayInfo() {
                System.out.println("Title: " + title);
                System.out.println("Director: " + director);
                System.out.println("Release Year: " + releaseYear);
                System.out.println("Genre: " + genre);
                System.out.println("Rating: " + rating);
                System.out.println("Watched: " + (isWatched ? "Yes" : "No"));
        }

        void displayInfo(double rating) {
                System.out.println("Title: " + title);
                System.out.println("Director: " + director);
                System.out.println("Release Year: " + releaseYear);
                System.out.println("Genre: " + genre);
                System.out.println("Rating: " + rating);
                System.out.println("Watched: " + (isWatched ? "Yes" : "No"));
        }
}
