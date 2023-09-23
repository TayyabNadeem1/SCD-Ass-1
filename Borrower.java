import java.util.ArrayList;
import java.util.List;

public class Borrower {
    public String name;
      private ArrayList<Borrower> BitemList_name;
    
    public Borrower(String name){
        this.name=name;
        BitemList_name = new ArrayList<>();         
        
    }
    
    public void addItem(Borrower bor){
        
    }
    

    public void removeItem(Item item) {
        BitemList_name.remove(item);
    }

    public String get_borrower(){
        return this.name;
    }

   
}
