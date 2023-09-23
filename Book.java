public class Book extends Item implements Configuration{
    private String author;
    private int publishingYear;
    private final int type=1;

    public Book(String title,boolean isBorrowed, int cost, int popularityCount,String author, int pbYear){
        super(title, false, cost,popularityCount);
        this.author=author;
        this.publishingYear=pbYear;
    }
    public int getType(){

        return type;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String Author){
        this.author=Author;
    }
    public int getpbYear(){
        return this.publishingYear;
    }
    

    public void displayInfo(){
        System.out.println("Type: Book");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Year: " + this.getpbYear());
    }

    @Override
    public int calculateCost(){
        int percent= (getCost()/20)*100;
        return this.getCost()+percent+200;
    }

    
}