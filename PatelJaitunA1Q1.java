    /**
 * This class will read the data from user input and output the results
 *
 *  Jaitun Patel(7920394)
 *  Purpose: Implementing use of file reading methods to read file line-by-line
 */
//java import library
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

// this class will contains method for filereading and produce output  accordingly
public class PatelJaitunA1Q1
{
    //instance variables
    private String info;
    public static void main(String[] args){
        // scanner class for user input
        Scanner scan=new Scanner(System.in);
        System.out.println("Please enter the input file name (.txt files only):");
        String str=scan.nextLine();
        System.out.println("\n");
        System.out.println("Processing file " +str+"\n");
        readFile(str);
    }

    // this method will read file through each line of file entered by user and produce output accordingly
    public static void readFile(String theFile){
        // object of library class
        Library lib = new Library();
        try{
            // filereader object 
            FileReader fr=new FileReader(theFile);
            // buffered object to handle filereader
            BufferedReader br=new BufferedReader(fr);
            String line=br.readLine(); 

            while(line!=null){
                String[] arr=line.split(" ",10);
                String str = "";
                for(int i = 3 ; i < arr.length ; i++){
                    str = str + arr[i] + " ";
                }
                if(arr[0].equals("ADD"))
                {  
                    lib.addBook(new Book(arr[1],arr[2],str,false)); 
                } 
                else if(arr[0].equals("SEARCHA")){
                    arr[1] = arr[1] + ",";
                    lib.SEARCHA(arr[1]);
                }
                else if(arr[0].equals("SEARCHT")){ 
                    String string = "";
                    for(int i = 1 ; i < arr.length ; i++){
                        string = string + arr[i] + " ";
                    }
                    lib.SEARCHT(string);
                }
                else if(arr[0].equals("GETBOOK")){
                    lib.loanBook(arr[1],arr[2],str);
                }
                else if(arr[0].equals("RETURNBOOK")){
                    lib.returnBook(arr[1],arr[2],str);
                }
                line = br.readLine();
            }
            System.out.println("Program terminated normally.");
            // closing the file
            fr.close();
            // this will handle an exception 
        }catch(Exception e){
            System.out.println("File Not Found!!");
            e.printStackTrace();
        }       
    }
}

//this class will contain instance variables and constructor
//that has author's name and title in it
class Book
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

//This class will contain a list of books stored and various methods to required to access it
class Library
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

