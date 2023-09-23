import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.Scanner;


public class Library {
    private List<Item> itemList;
    private List<Item> BitemList;
    private int nextId;
    private int nextBookId;
    private int nextMagazineId;
    private int nextNewspaperId;
    private List<Borrower> borrowers;

    public Library() {
        itemList = new ArrayList<>();
        BitemList = new ArrayList<>();
        borrowers = new ArrayList<>();
        nextId=1;
        nextBookId = 1;
        nextMagazineId = 1;
        nextNewspaperId = 1;
    }


    public void borrow(Library lib){
        Scanner type_value= new Scanner(System.in);
        System.out.print("What type of item yo want to borrow? (1 for Book, 2 for Magazine, 3 for Newspaper): ");
        int itemType = type_value.nextInt();
        
                Scanner pb_company = new Scanner(System.in);
                System.out.println("Enter your name");
                String borrower_name = pb_company.nextLine();
                Scanner author_name = new Scanner(System.in);

                
            switch(itemType){
            case 1: 
                int count=0;
                System.out.println("Enter Title name for Book");
                String title = author_name.nextLine();
                
                
                    for (Item item : BitemList) {
                    if(item instanceof Book){
                        if(item.getTitle().equalsIgnoreCase(title)){
                            count=1;
                            System.out.println(title+" is already borrowed by ");
                            break;
                            
                        }
                    }
                
                    }
                        for (Item item : itemList) {
                        if(item instanceof Book){
                            if(item.getTitle().equalsIgnoreCase(title) && count==0){
                                int cost=item.calculateCost();
                                System.out.println("Borrow Cost: "+cost);
                                Scanner scan = new Scanner(System.in);
                                System.out.println("Yo want to Borrw?(press 1 for yes and 0 for no)");   
                                int choice = scan.nextInt();             
                                
                                if(choice==0){
                                    break;
                                }
                                item.setName(borrower_name);
                                BitemList.add(item);
                                Borrower bor = new Borrower(borrower_name);
                                bor.addItem(bor);
                                item.setBorrowed(true);
                                borrowers.add(bor);
                                
                                item.incre_PopCount();
                                break;
                            }
                        }
                    }

                
                
                break;
            
            case 2:
                int count1=0;
                System.out.println("Enter Title name for Magazine");
                String title_mag = author_name.nextLine();
                
                for (Item item : BitemList) {
                    if(item instanceof Magazine){
                        if(item.getTitle().equalsIgnoreCase(title_mag)){
                            // Borrower bor =new Borrower(borrower_name);
                            // bor.addItem(bor);
                            count1=1;
                            System.out.println(title_mag+" is already borrowed by ");
                            break;
                            
                        }
                    }
                    }
                        for (Item item : itemList) {
                        if(item instanceof Magazine){
                            if(item.getTitle().equalsIgnoreCase(title_mag) && count1==0){
                                int cost=item.calculateCost();
                                System.out.println("Borrow Cost: "+cost);
                                Scanner scan = new Scanner(System.in);
                                System.out.println("Yo want to Borrw?(press 1 for yes and 0 for no)");   
                                int choice = scan.nextInt();             
                                
                                if(choice==0){
                                    break;
                                }
                                item.setName(borrower_name);
                                BitemList.add(item);
                                Borrower bor = new Borrower(borrower_name);
                                bor.addItem(bor);
                                borrowers.add(bor);
                                item.setBorrowed(true);
                                item.incre_PopCount();
                                break;
                            }
                        }
                    }
                break;

            case 3:
                int count2=0;
                System.out.println("Enter Title name for Newspaper");
                String title_news = author_name.nextLine();
                
                for (Item item : BitemList) {
                    if(item instanceof Newspaper){
                        if(item.getTitle().equalsIgnoreCase(title_news)){
                            // Borrower bor =new Borrower(borrower_name);
                            // bor.addItem(bor);
                            count2=1;
                            System.out.println(title_news+" is already borrowed by ");
                            break;
                            
                        }
                    }
                
                    }
                    
                        for (Item item : itemList) {
                        if(item instanceof Newspaper){
                            if(item.getTitle().equalsIgnoreCase(title_news) && count2 ==0){
                                int cost=item.calculateCost();
                                System.out.println("Borrow Cost: "+cost);
                                Scanner scan = new Scanner(System.in);
                                System.out.println("Yo want to Borrw?(press 1 for yes and 0 for no)");   
                                int choice = scan.nextInt();             
                                
                                if(choice==0){
                                    break;
                                }
                                item.setName(borrower_name);
                                BitemList.add(item);
                                Borrower bor = new Borrower(borrower_name);
                                bor.addItem(bor);
                                borrowers.add(bor);
                                item.setBorrowed(true);
                                item.incre_PopCount();
                                break;
                            }
                        }
                    }
                    break;
            
            // default:
            //     System.out.println("Invalid item type.");
        }
    }

     public void displayHotPicks() {
        
        Collections.sort(itemList, Comparator.comparingInt(Item::getPopCount).reversed());

        System.out.println("-------------------------------Hot Picks------------------------");
        for (Item item : itemList) {
            System.out.println("Title: " + item.getTitle());
            System.out.println("Popularity Count: " + item.getPopCount());
            System.out.println("-----------------------");
        }
    }


    // public void borrowBook() {
    //     System.out.println("Available Books:");
    //     int availableBookCount = 0;

    //     for (Item item : itemList) {
    //         if (item instanceof Book && !item.isBorrowed()) {
    //             System.out.println("ID: " + item.getId() + ", Title: " + item.getTitle());
    //             availableBookCount++;
    //         }
    //     }

    //     if (availableBookCount == 0) {
    //         System.out.println("No available books to borrow.");
    //         return;
    //     }

    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("Enter the ID of the book you want to borrow: ");
    //     int bookId = scanner.nextInt();

    //     Item bookToBorrow = findItemById(bookId);

    //     if (bookToBorrow != null && bookToBorrow instanceof Book && !bookToBorrow.getisBorrowed()) {
    //         bookToBorrow.setBorrowed(true);
    //         System.out.println("You have successfully borrowed the book: " + bookToBorrow.getTitle());
    //         updatePopularityCount(bookId);
    //     } else {
    //         System.out.println("Invalid book ID or the book is already borrowed.");
    //     }
    // }


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
            
                Book book = new Book(title, false, cost, 0,author, year);
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

                Magazine magazine = new Magazine(title, false, cost, 0,pb, authors);
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

                Newspaper newp = new Newspaper(title, false, cost, 0,pb_comp, date);
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

    public void displayAllItems(List<Item> itemList2,int choice) {
        if(choice==4){
            System.out.println("-----------------------The Library has Following---------------------------");
        }else if(choice==7){
            System.out.println("-----------------------The Borrower has Following---------------------------");
        }
        for (Item item : itemList2) {
            if (item instanceof Book) {
                Book book = (Book) item;
                System.out.println("Type: Book");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Year: " + book.getpbYear());
                System.out.println("Popularity: " + book.getPopCount());
            } else if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                System.out.println("Type: Magazine");
                System.out.println("Title: " + magazine.getTitle());
                System.out.println("Publishing Company: " + magazine.getpbCompany());
                System.out.println("Authors:");
                
                for (String author : magazine.getAuthorsMag()) {
                    System.out.println("  " + author);
                }
                System.out.println("Popularity: " + magazine.getPopCount());
            } else if (item instanceof Newspaper) {
                Newspaper newspaper = (Newspaper) item;
                System.out.println("Type: Newspaper");
                System.out.println("Title: " + newspaper.getTitle());
                System.out.println("Publishing Company: " + newspaper.getpbCompany());
                System.out.println("Publishing Date: " + newspaper.getpbDate());
                System.out.println("Popularity: " + newspaper.getPopCount());
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

    public Item findItemByIdInBorrow(int id) {
        for (Item item : BitemList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }



    public void loadDataFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
    
                if (parts.length < 6) {
                    System.out.println("Invalid data format in line: " + line);
                    continue;
                }
    
                int itemType;
                try {
                    itemType = Integer.parseInt(parts[0].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid item type in line: " + line);
                    continue; 
                }
    
                String title = parts[1].trim();
                String authorsCompany = parts[2].trim();
                int year = 0;
                if (itemType == 1 || itemType == 3) {

                    try {
                        year = Integer.parseInt(parts[3].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid year in line: " + line);
                        continue; 
                    }
                }
    
                int popularityCount;
                try {
                    popularityCount = Integer.parseInt(parts[4].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid popularity count in line: " + line);
                    continue; 
                }
    
                int price;
                try {
                    price = Integer.parseInt(parts[5].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price in line: " + line);
                    continue; 
                }
    
                switch (itemType) {
                    case 1:
                        
                        Book book = new Book(title, false, price,popularityCount ,authorsCompany, year);
                        addItem(book);
                        break;
                    case 2:
                        // Magazine format: 2, Title, Authors, Publisher, Popularity, Price
                        String[] authorsArray = authorsCompany.split("\\.");
                        ArrayList<String> authorsList = new ArrayList<>(Arrays.asList(authorsArray));
                        Magazine magazine = new Magazine(title, false, price,popularityCount ,parts[3].trim(), authorsList);
                        addItem(magazine);
                        break;
                    case 3:
                        // Newspaper format: 3, Title, Publisher, Date, Popularity, Price
                        Newspaper newspaper = new Newspaper(title, false, price,popularityCount ,authorsCompany, parts[3].trim());
                        addItem(newspaper);
                        break;
                    default:
                        System.out.println("Invalid item type in line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from the file: " + e.getMessage());
        }
    }
    

    public void displayAllBorrowers() {
        System.out.println("Borrowers List:");
                for (Item item : BitemList) {
            if (item instanceof Book) {
                Book book = (Book) item;
                System.out.println("Name of the Borrower:"+item.getName());
                System.out.println("Type: Book");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Year: " + book.getpbYear());
                System.out.println("Popularity: " + book.getPopCount());
            } else if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                System.out.println("Name of the Borrower:"+item.getName());
                System.out.println("Type: Magazine");
                System.out.println("Title: " + magazine.getTitle());
                System.out.println("Publishing Company: " + magazine.getpbCompany());
                System.out.println("Authors:");
                
                for (String author : magazine.getAuthorsMag()) {
                    System.out.println("  " + author);
                }
                System.out.println("Popularity: " + magazine.getPopCount());
            } else if (item instanceof Newspaper) {
                Newspaper newspaper = (Newspaper) item;
                System.out.println("Name of the Borrower:"+item.getName());
                System.out.println("Type: Newspaper");
                System.out.println("Title: " + newspaper.getTitle());
                System.out.println("Publishing Company: " + newspaper.getpbCompany());
                System.out.println("Publishing Date: " + newspaper.getpbDate());
                System.out.println("Popularity: " + newspaper.getPopCount());
            }
            System.out.println("Price: " + item.getCost());
            System.out.println("ID: " + item.getId());
            System.out.println("-------------------------------------------");
        }


    
    }

    public static void main(String[] args) {
        Library lib = new Library();
        Scanner scanner = new Scanner(System.in);
        lib.loadDataFromFile("data.txt"); 
        
        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add an Item");
            System.out.println("2. Edit an Item by ID");
            System.out.println("3. Delete an Item by ID");
            System.out.println("4. View All Items");
            System.out.println("5. View an Item by ID");
            System.out.println("6. Borrow an item");
            System.out.println("7. Display Borrowed item");
            System.out.println("8. Display Borrowers ");
            System.out.println("9. Hot Picks ");
            System.out.println("10. Exit");
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
                     lib.displayAllItems(lib.itemList,choice);
                    break;
                case 5:
                    //viewItemById(scanner);
                    break;
                case 6:
                    lib.borrow(lib);
                    break;
                          
                case 7:
                    lib.displayAllItems(lib.BitemList,choice);
                    break;
                case 8:
                     lib.displayAllBorrowers();
                    //lib.displayBorrowersAndBooks();
                    break;
                case 9:
                    lib.displayHotPicks();
                    break;
                case 10:
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
