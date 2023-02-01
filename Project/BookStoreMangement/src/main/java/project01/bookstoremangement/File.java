package project01.bookstoremangement;

import java.io.*;
import java.util.*;

public class File {
    String nameFilePublisher = "Publisher.dat";
    String nameBook = "Book.dat";
    
    public void splitPublisher(String s, List<Publisher> publishers){
        String[] txt = s.split("\\|");
        publishers.add(new Publisher(txt[0],txt[1],txt[2]));
    }
    
    public void splitBook(String s, List<Book> books){
        String[] world = s.split("\\,");
        String[] txt = world[0].split("\\|");
        Book book = new Book(txt[0], txt[1], txt[6], Double.parseDouble(txt[2]), Integer.parseInt(txt[3]));
        book.setNamePublisher(txt[5]);
        book.setIdPublisher(world[1]);
        books.add(book);
    }
    
    public int writeFilePublisher(List<Publisher> publishers){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(nameFilePublisher);
            oos = new ObjectOutputStream(fos);
            for (Publisher publisher : publishers) {
                oos.writeUTF(publisher.toString());
            }
            oos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("Not saved, check the file again");
            return 1;
        }
        return 0;
    }
    
    public void readFilePublisher(List<Publisher> publishers){
        try{
            FileInputStream fis = new FileInputStream(nameFilePublisher);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int sum = 1;
            while(ois.available() > 0){
                String s = ois.readUTF();
                splitPublisher(s, publishers);
            }
            ois.close();
            fis.close();
        }catch(Exception e){}
    }
    
    public int writeFileBook(List<Book> books){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(nameBook);
            oos = new ObjectOutputStream(fos);
            for (Book book : books) {
                oos.writeUTF(book.toString());
            }
            oos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("Not saved, check the file again");
            return 1;
        }
        return 0;
    }
    
    public void readFileBook(List<Book> books){
        try{
            FileInputStream fis = new FileInputStream(nameBook);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int sum = 1;
            while(ois.available() > 0){
                String s = ois.readUTF();
                splitBook(s, books);
            }
            ois.close();
            fis.close();
        }catch(Exception e){}
    }
}
