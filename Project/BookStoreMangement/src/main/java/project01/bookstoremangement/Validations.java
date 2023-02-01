
package project01.bookstoremangement;

import java.util.regex.Pattern;

public class Validations {
    // Check Id publisher    
    public boolean checkIDPublisher(String id){
        Pattern p = Pattern.compile("^P[0-9]{5}$");
        if(p.matcher(id).find())
            return true;
        return false;
    }
    // Check name    
    public boolean checkName(String name){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]{5,30}$");
        if(pattern.matcher(name).find())
            return true;
        return false;
    }
    // Check phone Publisher's and book
    public boolean checkPhone(String phone){
        Pattern pattern = Pattern.compile("^[0-9]{10,12}$");
        if(pattern.matcher(phone).find())
            return true;
        return false;
    }
    // Check pattern Book's ID    
    public boolean checkBook_ID(String id){
        Pattern pattern = Pattern.compile("^B[0-9]{5}$");
        if(pattern.matcher(id).find())
            return true;
        return false;
    }    
}
