/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.TreeMap;
import java.util.Set;
import java.util.Comparator;

    
public class BookIndexList {    
       
    private TreeMap <Integer, Book> bookIndexMap;
    Book aBook = new Book();
    
    public BookIndexList() {        
    }
    
    public void add(Book a) {
        bookIndexMap.put(a.getBookIndex(), a);
    }
    
    public void searchBookIndex(int anIndex) {
        
        if(bookIndexMap.containsKey(anIndex)) {
            aBook = (Book) bookIndexMap.get(anIndex);
        
        System.out.println(aBook);
        }
        else
            JOptionPane.showMessageDialog(null, "No entries have been found."); 
    } // add()    
    
    public String toString() {

        StringBuffer returnStrBuffer = new StringBuffer();
        Collection collection = bookIndexMap.values();
        Iterator it = collection.iterator();
        
        while(it.hasNext()) {           
            returnStrBuffer.append(it.next());
        }
        return (returnStrBuffer.toString());
    }   
} 

class BookIndexComp implements Comparator<Book> {

    //private TreeMap <String, Book> bookIndexMap = new TreeMap(new BookIndexComparator());

    public int compare (Book o1, Book o2) {
       // Book b1 = (Book) o1;
       // Book b2 = (Book) o2;
        Integer index = o1.getBookIndex();
       // return b1.getBookIndex() - b2.getBookIndex();         
       return index.compareTo(o2.getBookIndex()); 
    }
}