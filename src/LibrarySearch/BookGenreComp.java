/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearch;

import java.util.Iterator;
import java.util.Collection;
import java.util.TreeMap;
import java.util.Set;
import java.util.Comparator;

public class BookGenreComp implements Comparator<Book> {
    
    private TreeMap <String, Book> bookIndexMap;
    Book aBook = new Book();
    
    public BookGenreComp() {
    }
    
    public void add(Book a) {
        bookIndexMap.put(a.getGenre(), a);
    }
    
    public Book searchBookGenre(String aGenre) {
        
        if(bookIndexMap.containsKey(aGenre)) {
            aBook = (Book) bookIndexMap.get(aGenre);
        }
        return aBook;
    } 
    
    public String toString() {

        StringBuffer returnStrBuffer = new StringBuffer();
        Collection collection = bookIndexMap.values();
        Iterator it = collection.iterator();
        
        while(it.hasNext()) {           
            returnStrBuffer.append(it.next());
        }
        return (returnStrBuffer.toString());
    }
    
    public int compare(Book book1, Book book2) {

        return book1.getGenre().compareTo(book2.getGenre());
    }
}