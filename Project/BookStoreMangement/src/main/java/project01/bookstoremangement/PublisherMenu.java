
package project01.bookstoremangement;

import java.util.*;

public class PublisherMenu {
    public void Menu(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\n\t\tPublishers’ management");
            System.out.println("1. Create a Publisher");
            System.out.println("2. Delete the Publisher");
            System.out.println("3. Save the Publisher list to file");
            System.out.println("4. Print the Publisher list from the file");
            System.out.println("5. Go back");

            int option = 0;

            do{
                try{
                    System.out.print("Enter option: ");
                    option = sc.nextInt();
                    if(option >= 1 && option <= 5)
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
                List<Publisher> publishers = new ArrayList<>();
                File file = new File();
                ActionPublisher action = new ActionPublisher();
                file.readFilePublisher(publishers);
                
                if(option == 1){
                    int check = action.Add(publishers);
                    if(check == 0)
                        file.writeFilePublisher(publishers);
                }
                else if(option == 2){
                    int check = action.delete(publishers);
                    if(check == 0){
                        System.out.println("The Publisher was deleted.");
                        file.writeFilePublisher(publishers);
                    }  
                }
                else if(option == 3){
                    if(file.writeFilePublisher(publishers) == 0)
                        System.out.println("Saved successfully");
                }
                else if(option == 4){
                    List<Publisher> tmp = new ArrayList<>();
                    file.readFilePublisher(tmp);
                    Collections.sort(tmp, new Comparator<Publisher>(){
                        @Override
                        public int compare(Publisher o1, Publisher o2) {
                            return o2.getName().compareTo(o1.getName());
                        } 
                    });
                    for (Publisher publisher : tmp) {
                        System.out.println(publisher.toString());
                    }
                }
                else
                    return;
            }
        }while(true);
        
        
        
    }
}
