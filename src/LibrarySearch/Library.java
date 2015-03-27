package LibrarySearch;

import java.util.*;

public class Library {
        static ArrayList<Book> library = new ArrayList<>();
        ArrayList<Author> author = new ArrayList<>();
        ArrayList<Book> book = new ArrayList<>();     
        
    public Library() {        
    }    
    
    public String toString() {
        String result = " ";
        for(Book b: library) {
            result += b.toString() + "\n";
        }
        return result;
    }
}
