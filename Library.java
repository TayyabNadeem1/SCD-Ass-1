import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class Library {
    private List<Item> itemList;

    private int nextId;
    private int nextBookId;
    private int nextMagazineId;
    private int nextNewspaperId;

    public Library() {
        itemList = new ArrayList<>();
        nextId=1;
        nextBookId = 1;
        nextMagazineId = 1;
        nextNewspaperId = 1;
    }

    public void addItem(Book book){
        book.setId(nextBookId);
        nextBookId++;
        itemList.add(book);
    }
        public void addItem(Magazine mag){
        mag.setId(nextMagazineId);
        nextMagazineId++;
        itemList.add(mag);
    }
        public void addItem(Newspaper newp){
        newp.setId(nextNewspaperId);
        nextNewspaperId++;
        itemList.add(newp);
    } 
    //    public void addItem(Item it){
    //     it.setId(nextId);
    //     nextId++;
    //     itemList.add(it);
    // }

    
    public void addItem(Library lib){
       
        Scanner type_value= new Scanner(System.in);
        System.out.print("Enter the item type (1 for Book, 2 for Magazine, 3 for Newspaper): ");
        int itemType = type_value.nextInt();
       
            Scanner title_book = new Scanner(System.in);  
            System.out.println("Enter title");
            String title = title_book.nextLine();

            Scanner title_cost = new Scanner(System.in);  
            System.out.println("Enter cost ");
            int cost = title_cost.nextInt();

            // Item item = new Item(title, false, cost);
            // lib.addItem(item);
            
           
            switch(itemType){
            case 1: 
                Scanner author_name = new Scanner(System.in);
                System.out.println("Enter Author name for Book");
                String author = author_name.nextLine();
            
                Scanner year_book = new Scanner(System.in);
                System.out.println("Enter Publishing Year of the Book");
                int year = year_book.nextInt();
            
                Book book = new Book(title, false, cost, author, year);
                lib.addItem(book);
                break;
            
            case 2:
                
                ArrayList<String> authors = new ArrayList<>();
                System.out.println("Enter Authors (type 'exit' to stop):"); 
                Scanner sc=new Scanner(System.in); 
                while (true) {
                
                    String input = sc.nextLine();

                    if (input.equals("exit")) {
                        break;
                    }
                    authors.add(input);
                }
                
                Scanner pb_company = new Scanner(System.in);
                System.out.println("Enter Publishing Company of the Magazine");
                String pb = pb_company.nextLine();

                Magazine magazine = new Magazine(title, false, cost, pb, authors);
                lib.addItem(magazine);
                
                break;

            case 3:
                
                Scanner pbr_company = new Scanner(System.in);
                System.out.println("Enter Publishing Company of the Newspaper");
                String pb_comp = pbr_company.nextLine();

                Scanner paper_date= new Scanner(System.in);
                System.out.println("Enter Publishing Year of the Newspaper");
                String date = paper_date.nextLine();
                paper_date.nextLine();

                Newspaper newp = new Newspaper(title, false, cost, pb_comp, date);
                lib.addItem(newp);
                break;
            
            // default:
            //     System.out.println("Invalid item type.");
        }





        
      
    
    }

    public void deleteItem(int id){
        itemList.removeIf(itemList -> itemList.getId() == id);
        
    }
    public void deleteItem(Library lib){
        Scanner type_value = new Scanner(System.in);  
        System.out.print("Enter the item type (1 for Book, 2 for Magazine, 3 for Newspaper): ");
         int itemType = type_value.nextInt();
        System.out.print("Enter the ID of the item to delete: ");
        
        Scanner id = new Scanner(System.in);  
        
        int id_drop = id.nextInt();
        
        
        Item item_delete= lib.findItemById(id_drop);

        for (Item item : itemList) {
            if (item.getId() == id_drop) {
                switch (itemType) {
                    case 1:
                        if (item instanceof Book) {
                            
                            lib.deleteItem(id_drop);
                            System.out.println("Book Deleted successfully."); 
                            break;    
                        } 
                        
                    case 2:
                        if (item instanceof Magazine) { 
         
                            lib.deleteItem(id_drop);
                            System.out.println("Magazine Deleted successfully."); 
                            break;    
                        } 
                        
                    case 3:
                        if(item instanceof Newspaper){
                            lib.deleteItem(id_drop);
                            System.out.println("Newspaper Deleted successfully."); 
                            break;    
                        }
                    default:
                        System.out.println("Invalid item type choice.");
                }
            }
        }
    }
        
    public void editItem(Library lib) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of item you want to edit:");
        System.out.println("1. Book");
        System.out.println("2. Magazine"); 
        System.out.println("3. Newspaper"); 
        int itemTypeChoice = scanner.nextInt();


        System.out.print("Enter the ID of the item to edit: ");
        int idToEdit = scanner.nextInt();
    
    
        boolean found = false;
    
        for (Item item : itemList) {
            if (item.getId() == idToEdit) {
                switch (itemTypeChoice) {
                    case 1:
                        if (item instanceof Book) {
                            Book book = (Book) item;
                            System.out.print("Enter new title for the book: ");
                            String newTitle = scanner.next();
                            System.out.print("Enter new author for the book: ");
                            String newAuthor = scanner.next();
                            book.setTitle(newTitle);
                            book.setAuthor(newAuthor);
                            System.out.println("Book updated successfully.");
                            found = true;
                        } else {
                            System.out.println("Item with ID " + idToEdit + " is not a Book.");
                        }
                        break;
                    case 2:
                        if (item instanceof Magazine) { 
                        ArrayList<String> authors = new ArrayList<>();
                            Magazine magazine = (Magazine) item; 
                            System.out.print("Enter new title for the magazine: "); 
                            String newTitle = scanner.next();
                            System.out.print("Enter new Authors for the magazine: "); 
                            
                                while (true) {
                
                                    String input = scanner.nextLine();

                                    if (input.equals("exit")) {
                                        break;
                                    }
                                    authors.add(input);
                                }
                                magazine.setTitle(newTitle);
                                magazine.setAuthorsMag(authors);
                            System.out.println("Magazine updated successfully."); 
                            found = true;
                        } else {
                            System.out.println("Item with ID " + idToEdit + " is not a Magazine."); 
                        }
                        break;
                    case 3:
                    if (item instanceof Newspaper) {
                        Newspaper news = (Newspaper) item;
                        System.out.print("Enter new title for the Newspaper: ");
                        String newTitle = scanner.next();
                        System.out.print("Enter new cost for the Newspaper: ");
                        int newAuthor = scanner.nextInt();
                        news.setTitle(newTitle);
                        news.setCost(newAuthor);
                        System.out.println("Newspaper updated successfully.");
                        found = true;
                    } else {
                        System.out.println("Item with ID " + idToEdit + " is not a Newspaper.");
                    }
                    break;
                    default:
                        System.out.println("Invalid item type choice.");
                }
            }
        }
    
        if (!found) {
            System.out.println("Item with ID " + idToEdit + " not found.");
        }
    }
    
    // public void displayAllItems(){
    //     System.out.println("-----------------------The Library has Following---------------------------");
    //     for (Item item : itemList){
            
    //         if(!itemList.isEmpty()){
    //             System.out.println("name = "+item.getTitle()+"price : "+item.getCost()+ " id = "+item.getId());
                
    //         }
    //     }
    // }

    public void displayAllItems() {
        System.out.println("-----------------------The Library has Following---------------------------");
        for (Item item : itemList) {
            if (item instanceof Book) {
                Book book = (Book) item;
                System.out.println("Type: Book");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Year: " + book.getpbYear());
            } else if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                System.out.println("Type: Magazine");
                System.out.println("Title: " + magazine.getTitle());
                System.out.println("Publishing Company: " + magazine.getpbCompany());
                System.out.println("Authors:");
                for (String author : magazine.getAuthorsMag()) {
                    System.out.println("  " + author);
                }
            } else if (item instanceof Newspaper) {
                Newspaper newspaper = (Newspaper) item;
                System.out.println("Type: Newspaper");
                System.out.println("Title: " + newspaper.getTitle());
                System.out.println("Publishing Company: " + newspaper.getpbCompany());
                System.out.println("Publishing Date: " + newspaper.getpbDate());
            }
            System.out.println("Price: " + item.getCost());
            System.out.println("ID: " + item.getId());
            System.out.println("-------------------------------------------");
        }
    }
    

    public void displaySingleItem(int id){
         
         for (Item item : itemList){
            
            if(item.getId()==id){
                System.out.println("name = "+item.getTitle()+"price : "+item.getCost());
            }
        }
    }

    public Item findItemById(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    // public void request_values(){
    //     Scanner title_book = new Scanner(System.in);  
    //     System.out.println("Enter title");
    //     String title = title_book.nextLine();

    //     Scanner title_cost = new Scanner(System.in);  // Create a Scanner object
    //     System.out.println("Enter cost ");
    //     int cost = title_cost.nextInt();

    //     title_book.close();
    //     title_cost.close();


    // }

    public static void main(String[] args) {
        Library lib = new Library();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add an Item");
            System.out.println("2. Edit an Item by ID");
            System.out.println("3. Delete an Item by ID");
            System.out.println("4. View All Items");
            System.out.println("5. View an Item by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");


            int choice = scanner.nextInt();                
            switch (choice) {
                case 1:
                    lib.addItem(lib);
                    scanner.nextLine();
                    choice=0;
                    break;
                case 2:
                    lib.editItem(lib);
                    break;
                case 3:
                    lib.deleteItem(lib);
                    break;
                case 4:
                     lib.displayAllItems();
                    break;
                case 5:
                    //viewItemById(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    
                    
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            //scan.close();
        // } else {
        //     System.out.println("Invalid input. Please enter a valid integer.");
        //     scanner.nextLine(); // Consume the invalid input
        // }
        }
    }
}
