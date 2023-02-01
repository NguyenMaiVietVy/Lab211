package project01.bookstoremangement;
import java.util.*;

public class ActionPublisher {
    Scanner sc = new Scanner(System.in);
    Validations vali = new Validations();
    
    public int Add(List<Publisher> publishers){
        Publisher publisher = new Publisher();

        System.out.println("Do you want to continue or go back?");
        System.out.println("1. Continue");
        System.out.println("2. Go back");
    
        int option = 0;
        do{
            try{
                System.out.print("Choose option: ");
                option = sc.nextInt();
                break;
            }catch(Exception e){
                System.out.println("Please enter the number");
                sc.nextLine();
            }
        }while(true);      
        
        if(option == 2){
            sc.nextLine();
            return 1;
        } 
        sc.nextLine();
        
//      Enter ID  
        do{        
            System.out.println("Enter Publisher's ID (Pattern “Pxxxxx”, with xxxxx is five digits): ");
            String id = sc.nextLine();
            
            if(vali.checkIDPublisher(id)){
                int check = 0;
                for (Publisher p : publishers) {
                    if(p.getId().equals(id)){
                        System.out.println("This id has duplicated, please enter another id");
                        check = 1;
                        break;
                    }
                }
                if(check == 0){
                    publisher.setId(id);
                    break;
                }
            }
            else
                System.out.println("ID wrong, please re-enter again!");
        }while(true);        
        
//      Enter name
        do{
            System.out.println("Enter Publisher's name: ");
            String name = sc.nextLine();
            
            if(vali.checkName(name)){
                publisher.setName(name);
                break;
            }
            else
                System.out.println("Name wrong, please re-enter again!");
            
        }while(true);
        
//      Enter phone
        do{
            System.out.println("Enter Publisher's phone(the number length 10-12): ");
            String phone = sc.nextLine();
            
            if(vali.checkPhone(phone)){
                publisher.setPhone(phone);
                break;
            }
            else
                System.out.println("phone wrong, please re-enter again!");
            
        }while(true);
        
        publishers.add(publisher);
        return 0;
    }
    public int delete(List<Publisher> publishers){
        System.out.println("Enter ID to delete: ");
        String id = sc.nextLine();
        
        List<Book> books = new ArrayList<>();
        File file = new File();
        file.readFileBook(books);
        
        int check = 0;
        for (Book book : books) {
            if(book.getIdPublisher().equals(id)){
                check = 1;
                books.remove(book);
            }
        }
        if(check == 1)
            file.writeFileBook(books);
        
        for (Publisher publisher : publishers) {
            if(publisher.getId().equals(id)){
                publishers.remove(publisher);
                return 0;
            }
        }
        System.out.println("Publisher’s Id does not exist");
        return 1;
    }
}
