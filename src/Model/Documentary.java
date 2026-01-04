package Model;
public class Documentary extends Media{
    String topic;
    boolean isEducational;

    public Documentary(String title,String director,int releaseYear,String topic, boolean isEducational) {
        super(title,director,releaseYear);
        this.topic = topic;
        this.isEducational = isEducational;
    }

    @Override
    public String getMediatype() {
        return "Documentaire";
    }

    public void getEducationalValue(){
        if(isEducational){
            System.out.println("Ce documentaire est éducatif et sa topic est: " +this.topic);
        } else {
            System.out.println("Ce documentaire n'est pas éducatif et sa topic est : " +this.topic);
        }
    }
}
