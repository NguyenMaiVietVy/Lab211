package project01.bookstoremangement;

import java.util.*;

public class ActionBook {
    Scanner sc = new Scanner(System.in);
    Validations vali = new Validations();  
    
    public String EnterID(List<Book> books){
        do{ 
            System.out.println("Enter Book's ID (Pattern “Bxxxxx”, with xxxxx is five digits): ");
            String id = sc.nextLine();
            if(vali.checkBook_ID(id)){
                int check = 0;
                for (Book b : books) {
                    if(b.getId().equals(id)){
                        System.out.println("This id has duplicated, please enter another id");
                        check = 1;
                        break;
                    }
                }
                if(check == 0)
                    return id;
            }
            else
                System.out.println("ID wrong, please re-enter again!");
        }while(true);
    }
    
    public String EnterName(){
        do{
            System.out.println("Enter name book: ");
            String name = sc.nextLine();
            
            if(vali.checkName(name))
                return name;
            else
                System.out.println("Name wrong, please re-enter again!");
            
        }while(true);
    }
    
    public double EnterPrice(){
        do{
           try{
               System.out.println("Enter price: ");
               double price = sc.nextDouble();
               
               if(price < 0)
                   System.out.println("Please enter the number greater than 0");
               else
                   return price;
           }catch(Exception e){
               System.out.println("Please enter the number");
               sc.nextLine();
           }       
        }while(true);
    }
    
    public int EnterQuantity(){
        do{
           try{
               System.out.println("Enter quantity: ");
               int quantity = sc.nextInt();
               
               if(quantity < 0)
                   System.out.println("Please enter the number greater than 0");
               else
                   return quantity;
           }catch(Exception e){
               System.out.println("Please enter the number");
               sc.nextLine();
           }
        }while(true);
    }
    
    public String EnterStatus(){
        do{
            System.out.println("Status the book: ");
            System.out.println("1. Available");
            System.out.println("2. Not Available");
            
            try{
                System.out.print("Please option: ");
                int option = sc.nextInt();

                if(option == 1){
                    return "Available";
                }else if(option == 2){
                    return "Not Available";
                }else{
                    System.out.println("Please re-enter option!");
                }
            }catch(Exception e){
                System.out.println("Please re-enter option!");
                sc.nextLine();
            }
        }while(true);
    }
    
    public int publisherBook(Book book){
        File file = new File();
        List<Publisher> publishers = new ArrayList<>();
        file.readFilePublisher(publishers);
        do{
            System.out.println("Enter Id of publisher: ");
            String id = sc.nextLine();
            for (Publisher publisher : publishers) {
                if(publisher.getId().equals(id)){
                    book.setNamePublisher(publisher.getName());
                    book.setIdPublisher(id);
                    return 0;
                }
            }
            System.out.println("The id you entered was not found, continue press 1 exit press 0");
            String option = sc.nextLine();
            option = option.trim();
            if(option.equals("0"))  return 1;  
            
        }while(true);
    }
    
    public int Add(List<Book> books){
        System.out.println("Do you want to continue or go back?");
        System.out.println("1. Continue");
        System.out.println("2. Go back");
        
        int option = 0;
        do{
            try{
                System.out.print("Enter option: ");
                option = sc.nextInt();
                if(option > 2 || option < 1)
                    System.out.println("Please enter number from 1-2!");
                else
                    break;
            }catch(Exception e){
                System.out.println("Please enter the number!");
                sc.nextLine();
            }
        }while(true);
        
        sc.nextLine();
        
        if(option == 1){
            
            String id = EnterID(books);
            String name = EnterName();
            double price = EnterPrice();
            int quantity = EnterQuantity();
            String status = EnterStatus();
            Book book = new Book(id, name, status, price, quantity);
            sc.nextLine();
            if(publisherBook(book) == 0){
                books.add(book);
                return 0;
            }
            else{
                System.out.println("Not found Publisher!");
                return 1;
            }
        }
        else
            return 1;
    }
    
    public int Search(List<Book> books){
        System.out.println("Enter id of Publisher: ");
        String id = sc.nextLine().trim();
        System.out.println("Enter Book's name (a part of Book's name): " );
        String name = sc.nextLine().trim().toLowerCase();
        List<Book> tmp = new ArrayList<>();
        int check = 1;
        
        if(id.isEmpty() == true){
            for (Book book : books) {
                if(book.getName().toLowerCase().contains(name.toLowerCase())){
                    check = 0;
                    tmp.add(book);
                }
                    
            }
        }else{
            for (Book book : books) {
                if(book.getName().toLowerCase().contains(name) && book.getIdPublisher().equals(id)){
                    check = 0;
                    tmp.add(book);
                }
                    
            }
        }
        
        if(check == 0){
            Collections.sort(tmp, new Comparator<Book>(){
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            
            for (Book book : tmp) {
                System.out.println(book.showDisplay());
            }
        }
        
        
        
        
        
        return check;
    }
    
    public int Update(List<Book> books){
        
        System.out.println("Do you want to continue or go back?");
        System.out.println("1. Continue");
        System.out.println("2. Go back");
        
        int t = 0;
        do{
            try{
                System.out.print("Choose option: ");
                t = sc.nextInt();
                break;
            }catch(Exception e){
                System.out.println("Please enter the number");
                sc.nextLine();
            }
        }while(true);
        
        if(t == 2){
            sc.nextLine();
            return 1;
        }
        sc.nextLine();
        
        System.out.println("Enter ID: ");
        String id = sc.nextLine();
        
        int check = 0;
        for (Book book : books) {
            if(book.getId().equals(id)){
                check = 1;
                System.out.println("Which one do you want to change?");
                System.out.println("1. Change id book");
                System.out.println("2. Change name book");
                System.out.println("3. Change price");
                System.out.println("4. Change status");
                System.out.print("Please choose(Ex: Choose 1 and 2 type 12): ");
                String option = sc.nextLine();
                
                int ss = 0;
                for (int i = 0; i < option.length(); ++i) {
                    if(option.charAt(i) == '1'){
                        ss = 1;
                        book.setId(EnterID(books));
                    }
                    if(option.charAt(i) == '2'){
                        ss = 1;
                        book.setName(EnterName());
                    }
                    if(option.charAt(i) == '3'){
                        ss = 1;
                        book.setPrice(EnterPrice());
                    }
                    if(option.charAt(i) == '4'){
                        ss = 1;
                        book.setStatus(EnterStatus());
                    }
                }
                if(ss == 1)
                    System.out.println("Successfully updated");
                else
                    System.out.println("Not update!");
                break;
            }
        }
        if(check == 0){
            System.out.println("Book’s Name does not exist");
            return 0;
        }
        return 1;
    }
    
    public int Delete(List<Book> books){
        System.out.println("Enter ID Book");
        String id = sc.nextLine();
        
        for (Book book : books) {
            if(book.getId().equals(id)){
                books.remove(book);
                return 0;
            }
        }
        System.out.println("Book’s Name does not exist");
        return 1;
    }
    
}
