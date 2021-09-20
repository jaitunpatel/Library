
/**
 * This class will contain information of one book
 * such as author's name and title of book
 * 
 *  Jaitun Patel(7920394)
 * 
 */
public class Book
{
    //instance variables
    private String lastName;
    private String firstName;
    private String title;
    //this boolean value will indicate whether the book is out on loan
    private boolean flag;

    //constructor
    public Book(){}

    public Book(String newlastName, String newfirstName, String newtitle, boolean newflag){
        lastName=newlastName;
        firstName=newfirstName;
        title=newtitle;
        flag=newflag;
    }
    
    // this method will return firstname of author
    public String firstName(){
        return firstName;
    }

    // this method will return lastname of author
    public String lastName(){
        return lastName;
    }

    // this method will return title of book
    public String getTitle(){
        return title;
    }

    // this method will return boolean value for which book is out on loan
    public boolean getFlag(){
        return flag;
    }
    
    public void setFlag(boolean changeValue){
        flag=changeValue;
    }

    public void setReturn(boolean changeValue){
        flag=changeValue;
    }
}
