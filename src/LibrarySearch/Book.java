
package LibrarySearch;
import java.util.*;


public class Book {
    String line, author_name, title, genre;
    double price; 
    Author author;
    int book_index, author_index;
    static int TOTAL_FIELDS = 6;
    public Book() {        
    }    

    public Book(Author a, int book_index, String author_name, String title, 
                                 String genre, double price, int author_index) {
        this.author = a;
        this.book_index = book_index;
        this.author_name = author_name;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.author_index = author_index;        
    }
    
    public Book(int book_index, String author_name, String title, 
                                 String genre, double price, int author_index) {
        
        this.book_index = book_index;
        this.author_name = author_name;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.author_index = author_index;        
    }    
    
    public Author getAuthor() {
        return author;
    }
    
    public int getBookIndex() {
        return book_index;
    }
    
    public String getAuthor_name() {
        return author_name;
    }
    
    public int getAuthor_index() {
        return author_index;
    }
    
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }   

    public void setAuthor(Author a) {
        author = a;
    }
    
    public void setAuthor_name(String n) {
        author_name = n;
    }  
    
    public void setAuthor_index(int index_of_author) {
        author_index = index_of_author;
    }
    
    public void setTitle(String book_title) {
        title = book_title;
    }

    public void getGenre(String book_genre) {
        genre = book_genre;
    }

    public void setPrice(double book_price) {
        price = book_price;
    }     
    
    public String toString() {
        return author + " : " + book_index + " : " + author_name + " : " + title + " : " + genre 
                    + " : " + price + " : " + author_index;
    } 
    
}