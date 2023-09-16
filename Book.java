public class Book extends Item{
    private String author;
    private int publishingYear;
    private final int type=1;

    public Book(String title,boolean isBorrowed, int cost, String author, int pbYear){
        super(author, false, cost);
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

    // public int calculateCost(){
        
    // }

    
}