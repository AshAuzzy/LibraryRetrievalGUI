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

public class BookPriceComp implements Comparator<Book> {
    
    private TreeMap <Double, Book> bookIndexMap;
    Book aBook = new Book();
    
    public BookPriceComp() {
    }
    
    public void add(Book b) {
        bookIndexMap.put(b.getPrice(), b);
    }
    
    public void searchBookPrice(double aPrice) {
        
        if(bookIndexMap.containsKey(aPrice)) {
            aBook = (Book) bookIndexMap.get(aPrice);
        }

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
    
    public int compare(Book o1, Book o2) {
        int value = 0;
        
        Book b1 = (Book) o1;
        Book b2 = (Book) o2;
        
        if(b1.price > b2.price)
            value = 1;
        if(b1.price < b2.price)  
            value = -1;  
        else if(b1.price == b2.price)         
            value = 0;
        
        return value;
    }
}