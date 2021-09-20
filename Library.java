
/**
 * This class will contain a list of books stored and various methods to perform 
 *
 *  Jaitun Patel(7920394)
 * 
 */
public class Library
{
    // Here it's book array created which contains a list of books
    private Book[] bookStore;
    private int totalBooks;

    // constructor
    public Library(){
        bookStore=new Book[100];
        totalBooks = 0;
    }

    // this method will check whether the book is already in library or not
    public int checkBook(Book br1, Book br2){
        if(br1.lastName().equals(br2.lastName()) 
        && br1.firstName().equals(br2.firstName()) 
        && br1.getTitle().equals(br2.getTitle())){
            System.out.println("This Book is already in library");
            return 0;
        }
        return 1;
    }

    // this method will take the information from the bookand adds new book to library
    public void addBook(Book br){
        int i;
        for(i=0; i<totalBooks ; i++){
            if(checkBook(br,bookStore[i])==0)          
                return;
        }
        if(i < 100){
            bookStore[i]=br;
            totalBooks++;
        }
    } 

    // this method will return list of book written by that author
    public String listByAuthor(){
        String toReturn="";
        for(int i=0; i<totalBooks; i++){
            toReturn+=bookStore[i].firstName()+bookStore[i].lastName();
            toReturn+="\n";
        }
        return toReturn;
    }

    //this method will contain list of book with that title
    public String listByTitle(){
        String toReturn="";
        for(int i=0; i<totalBooks; i++){
            toReturn+=bookStore[i].getTitle();
        }
        return toReturn;
    } 

    //this method will return boolean value stating that if book is available for loan 
    public boolean loanBook(String lastName, String firstName, String title){
        for(int i=0; i<totalBooks; i++){
            if(lastName.equals(bookStore[i].lastName())
            &&firstName.equals(bookStore[i].firstName() )
            && title.equals(bookStore[i].getTitle())){
                bookStore[i].setFlag(true);
                System.out.println("Book loaned:");
                System.out.println(bookStore[i].lastName()+bookStore[i].firstName()+bookStore[i].getTitle()+"\n");
                return true;
            }
        }
        return false;
    }

    //this method will return a boolean indicating whether the book was successfully returned
    public boolean returnBook(String lastName, String firstName, String title){
        for(int i=0; i<totalBooks; i++){
            if(firstName.equals(bookStore[i].firstName())
            && lastName.equals(bookStore[i].lastName())
            && title.equals(bookStore[i].getTitle())){
                bookStore[i].setReturn(false);
                System.out.println("Book returned:");
                System.out.println(bookStore[i].lastName()+bookStore[i].firstName()+bookStore[i].getTitle()+"\n");
                return false;
            }
        }
        return true;
    }

    // this method will result from given author name
    public void SEARCHA(String lastName){
        for(int i=0; i<totalBooks; i++){
            if(lastName.equals(bookStore[i].lastName())){
                System.out.println("Books by "+bookStore[i].lastName());
                System.out.println(bookStore[i].lastName()+bookStore[i].firstName()+bookStore[i].getTitle()+"\n");
            } 
        }
    }

    // this method will result from given title name
    public void SEARCHT(String title){
        for(int i=0; i<totalBooks; i++){
            if(title.equals(bookStore[i].getTitle())){
                System.out.println("Books named "+bookStore[i].getTitle()+":");
                System.out.println(bookStore[i].lastName()+bookStore[i].firstName()+bookStore[i].getTitle()+"\n");
            }
        }
    }
}

