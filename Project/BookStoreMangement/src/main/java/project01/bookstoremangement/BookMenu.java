
package project01.bookstoremangement;
import java.util.*;

public class BookMenu {
    public void Menu(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\n\t\tBooks management");
            System.out.println("1. Create a book");
            System.out.println("2. Search the book");
            System.out.println("3. Update a book");
            System.out.println("4. Delete the Book");
            System.out.println("5. Save the Books list to file");
            System.out.println("6. Print the Books list from the file");
            System.out.println("7. Go back");
            
            int option = 0;

            do{
                try{
                    System.out.print("Enter option: ");
                    option = sc.nextInt();
                    if(option >= 1 && option <= 7)
                        break;
                    else{
                        System.out.println("Please enter selection from 1-5!");
                    }
                }catch(Exception e){
                    System.out.println("Please enter a number!");
                    sc.nextLine();
                }
            }while(true);
            
            if(option != 0){
                List<Book> books = new ArrayList<>();
                File file = new File();
                ActionBook action = new ActionBook();
                file.readFileBook(books);
                
                if(option == 1){
                    int check = action.Add(books);
                    if(check == 0)
                        file.writeFileBook(books);
                }
                else if(option == 2){
                    int check = action.Search(books);
                    if(check == 1){
                        System.out.println("Have no any Book");
                    }
                }
                else if(option == 3){
                    int check = action.Update(books);
                    if(check == 0)
                        System.out.println("Update failed!");
                    else
                        file.writeFileBook(books);
                }
                else if(option == 4){
                    int check = action.Delete(books);
                    if(check == 1)
                        System.out.println("Delete Failed!");
                    else{
                        System.out.println("The Book was deleted.");
                        file.writeFileBook(books);
                    }
                }
                else if(option == 5){
                    if(file.writeFileBook(books) == 0)
                        System.out.println("Saved successfully");
                }
                else if(option == 6){
                    List<Book> tmp = new ArrayList<>();
                    file.readFileBook(tmp);
                    Collections.sort(tmp, new Comparator<Book>(){
                        @Override
                        public int compare(Book o1, Book o2) {
                            if(o1.getQuantity() <= o2.getQuantity()){
                                if(o1.getPrice() < o2.getPrice())
                                    return -1;
                                else
                                    return 1;
                            }
                            return -1;
                        }
                    });
                    for (Book book : tmp) {
                        System.out.println(book.showDisplay());
                    }
                }
                else
                    return;
            }
        }while(true);
    }
}
