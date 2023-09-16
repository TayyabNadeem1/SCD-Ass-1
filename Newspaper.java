import java.sql.Date;

public class Newspaper extends Item{

    private String publisherCompany;
    private String PublicationDate;
    private final int type=3;

    public Newspaper(String title,boolean isBorrowed, int cost, String pbCompany, String pbDate){
        super(title, isBorrowed, cost);
        this.PublicationDate=pbDate;
        this.publisherCompany=pbCompany;

    }

    public int getType(){
        return type;
    }

    public String getpbCompany(){
        return this.publisherCompany;
    }

    public String getpbDate(){
        return this.PublicationDate;
    }
    
    public void displayInfo(){
        System.out.println("Type: Newspaper");
        System.out.println("Title: " + getTitle());
        System.out.println("Publishing Company: " + getpbCompany());
        System.out.println("Publishing Date: " + getpbDate());
        
    }
}