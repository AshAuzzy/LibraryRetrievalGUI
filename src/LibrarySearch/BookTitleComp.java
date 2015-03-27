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

public class BookTitleComp implements Comparator<Book> {
    
    private TreeMap <String, Book> bookIndexMap;
    Book aBook = new Book();
    
    public BookTitleComp() {
    }
    
    public void add(Book a) {
        bookIndexMap.put(a.getTitle(), a);
    }
    
    public Book searchBookTitle(String aTitle) {
        
        if(bookIndexMap.containsKey(aTitle)) {
            aBook = (Book) bookIndexMap.get(aTitle);
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

        return book1.getTitle().compareTo(book2.getTitle());
    }
}