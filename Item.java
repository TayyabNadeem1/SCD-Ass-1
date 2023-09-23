public class Item {
    private String title;
    private boolean isBorrowed;
    private int popularityCount;
    private int id;
    private int cost;
    private String name;

    public Item(String title,boolean isBorrowed, int cost,int popularityCount){

        this.title=title;
        this.isBorrowed=isBorrowed;
        this.popularityCount=popularityCount;
        
        this.cost=cost;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
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
    public int getPopCount(){
        return popularityCount;
    }

    public void setPopCount(int count){
         this.popularityCount=count;
    }
    public void incre_PopCount(){
         this.popularityCount++;
    }
    public void displayInfo(){

    }
    public boolean getisBorrowed(){
        return this.isBorrowed;
    }

    public void setBorrowed(boolean val){
        this.isBorrowed=val;
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
