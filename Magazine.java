import java.util.ArrayList;

public class Magazine extends Item implements Configuration{

    private ArrayList<String> Authors = new ArrayList<String>();
    private String publisherCompany;
    private final int type=2;

    public Magazine(String title,boolean isBorrowed, int cost, int popularityCount,String pbComp, ArrayList<String> pbArray){
        super(title, false, cost,popularityCount);
        this.publisherCompany=pbComp;
        for(int i=0;i<pbArray.size();i++){
            Authors.add(pbArray.get(i));
        }
    }
    public int getType(){
        return type;
    }
    public String getpbCompany(){
        return this.publisherCompany;
    }
    public ArrayList<String> getAuthorsMag(){
        return this.Authors;
    }
    public void setAuthorsMag(ArrayList<String> pbArray){
        this.Authors.clear();
        for(int i=0;i<pbArray.size();i++){
            Authors.add(pbArray.get(i));
        }
    }

    public void displayInfo(){
        System.out.println("Type: Magazine");
        System.out.println("Title: " + getTitle());
        System.out.println("Publishing Company: " + getpbCompany());
        System.out.println("Authors:");
        for (String author : getAuthorsMag()) {
            System.out.println("  " + author);
        }
    }
    @Override
    public int calculateCost(){
        
     return this.getCost()*this.getPopCount();
    }
    
}