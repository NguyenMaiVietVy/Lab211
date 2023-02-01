
package project01.bookstoremangement;

import java.awt.Menu;
import java.util.*;

public class BookStoreMangement {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        do{
            System.out.println("\n\t\tBook Store management");
            System.out.println("1. Publishers management");
            System.out.println("2. Books management");
            System.out.println("Other. Quit");
            System.out.print("Choose option: ");
            String option = sc.nextLine();
            
            if(option.equals("1") == false && option.equals("2") == false){
                System.out.println("End program");
                return;
            }
            else if(option.equals("1")){
                PublisherMenu menu = new PublisherMenu();
                menu.Menu();
            }
            else if(option.equals("2")){
                BookMenu menu = new BookMenu();
                menu.Menu();
            }
            
        }while(true);
    }
}
