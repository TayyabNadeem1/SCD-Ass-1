public class Item {
    private String title;
    private boolean isBorrowed;
    private int popularityCount;
    private int id;
    private int cost;


    public Item(String title,boolean isBorrowed, int cost){

        this.title=title;
        this.isBorrowed=isBorrowed;
        //this.popularityCount=popularityCount;
        
        this.cost=cost;

    }


    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void displayInfo(){

    }

    public int getCost(){
        return cost;
    }

    public String getTitle(){
        return title;
    }

    public int getId(){
        return id;
    }

    public int calculateCost(){

        return cost;
    }
}
