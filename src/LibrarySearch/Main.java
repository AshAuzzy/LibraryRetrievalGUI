
package LibrarySearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.tree.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class Main extends JPanel {    
    
    static String fileName = "library.txt";   
    char c;
    static JRadioButton[] radioLabels = new JRadioButton[9];
    ButtonGroup group = new ButtonGroup();
    String[] columnNames = {"Author", "book_index", "author name", "title", "genre", "price", "author_index"};
    String[] labels = {"Search by Author", "Search by Author's Index", "Search by Genre", 
                            "Search by Title", "Sort by Author's Index", "Sort by Price", 
                                "Sort by Genre", "Sort by Title", "Exit Program"};
    String[] messageHeaders = {"author's full name", 
                               "author's index (enter an number from 0 to 3):", 
                               "the title of the book", "1 of the following genres: " + 
                               "\nAdult Fiction, Children's Fiction, Science Fiction, " +
                               "Fiction, or Young Adult Fiction"};
    
    JButton jbtOK = new JButton("OK");

    static ArrayList<Book> library = new ArrayList<>();
    
    int intInput, arrayVariable;
    static int author_index;
    static String author_name;
    String input;
    static Author a;
    static Book b;
    Boolean flag = false;
    
    public Main() {
    
        JPanel p1 = new JPanel(new GridLayout(4,0)); 
        
        for (int i = 0; i < radioLabels.length; i++ ) {
            radioLabels[i] = new JRadioButton(labels[i]);
            p1.add(radioLabels[i]);
            group.add(radioLabels[i]);
        } 
        
        add(p1, BorderLayout.CENTER);
        add(jbtOK, BorderLayout.SOUTH); 
        
        OKListenerClass listener1 = new OKListenerClass();
        jbtOK.addActionListener(listener1);
    }

    public static void main(String[] args) throws IOException {
        
        // Read text file
        File file = new File(fileName);    
       
        Scanner input = new Scanner(file);     

        while(input.hasNextLine()) { 

        String line = input.nextLine();
        String[] fields = line.split(":");

            if(fields[0].contentEquals("A")) {
                int index = (new Integer(fields[1]).intValue());
                author_index = index;
                String name = fields[2];
                author_name = name;
                String stAddress = fields[3];
                String city = fields[4];
                String state = fields[5];
                String zipCode = fields[6];
                String phoneNum = fields[7];

                a = new Author(author_index, stAddress, city, state, zipCode, phoneNum); 

            } 
            
            else {                
                int book_index = (new Integer(fields[1]).intValue());
                String title = fields[2]; 
                String genre = fields[3]; 
                double price = (new Double(fields[4]).intValue());                 
                             
                b = new Book(a, book_index, author_name, title, genre, price, author_index);                           
                library.add(b);
                }            
        }           
        input.close();         
        
         EventQueue.invokeLater(new Runnable()
         {             
            @Override
             public void run()
             {
                JFrame frame = new JFrame();
                Main searchPanel = new Main();
                DataTree dataTree = new DataTree();
                frame.setTitle("Library Search"); 
                
                JLabel header = new JLabel("Welcome to the Library Retrieval Database", 
                                        JLabel.CENTER);
                header.setFont(new Font("Serif", Font.BOLD, 14));
                JLabel header2 = new JLabel("Please review the options below:",
                                        JLabel.CENTER);
                JPanel p2 = new JPanel(new GridLayout(2,0));                
                
                p2.add(header, BorderLayout.NORTH);
                p2.add(header2, BorderLayout.SOUTH);        
           
                frame.add(p2, BorderLayout.NORTH);                
                frame.add(dataTree, BorderLayout.CENTER);
                frame.add(searchPanel, BorderLayout.SOUTH);   
                frame.setSize(650, 550);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);              
             }
         });    
    } 
    
    class OKListenerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(radioLabels[0].isSelected()) {
                arrayVariable = 0;
                searchByTitleOrGenreOrAuthor();
            }
            else if(radioLabels[1].isSelected()) {
                arrayVariable = 1;
                searchByIndex();
            }
            else if(radioLabels[2].isSelected()) {
                arrayVariable = 3;
                searchByTitleOrGenreOrAuthor();
            } 
            else if(radioLabels[3].isSelected()) {
                arrayVariable = 2;
                searchByTitleOrGenreOrAuthor();
            }
            else if(radioLabels[4].isSelected()) {
                sortByIndex();
            }
            else if(radioLabels[5].isSelected()) {
                arrayVariable = 5;
                sortByPrice();
            } 
            else if(radioLabels[6].isSelected()) {
                sortByGenre();
            }
            else if(radioLabels[7].isSelected()) {
                sortByTitle();
            }             
            else
                JOptionPane.showMessageDialog(null, "You have exited the program.");
                System.exit(0);                 
        }
    }  
    
    public void searchByTitleOrGenreOrAuthor() {       
        
       input = JOptionPane.showInputDialog(null, "Please enter " + messageHeaders[arrayVariable]);       
       int count = 0;
       for(int i=0; i<library.size(); i++) {
     
           if(input.equalsIgnoreCase(library.get(i).getTitle()) 
                    || input.equalsIgnoreCase(library.get(i).getGenre())
                        || input.equalsIgnoreCase(library.get(i).getAuthor_name())) {
               flag = true;               
               count++;
            }
       }
       if(flag) {
            JOptionPane.showMessageDialog(null, "Your search has retrieved " 
                                            + count + " entry(ies)");
            for(int i=0; i<library.size(); i++) {
                 if(input.equalsIgnoreCase(library.get(i).getTitle()) 
                         || input.equalsIgnoreCase(library.get(i).getGenre())
                            || input.equalsIgnoreCase(library.get(i).getAuthor_name())) {
                     JOptionPane.showMessageDialog(null, "\nAuthor Name: " + 
                                 library.get(i).getAuthor_name() + 
                                 "\nBook Title: " + library.get(i).getTitle() + 
                                 "\nPersonal Information: " + 
                                 library.get(i).getAuthor(), "Results", 
                                 JOptionPane.INFORMATION_MESSAGE);
                 }
            }
       }
       else {
                JOptionPane.showMessageDialog(null, "No entries have been found."); 
       }
    }              
    
    public void searchByIndex() {
        
       int count = 0; 
       input = JOptionPane.showInputDialog(null, "Please enter " + messageHeaders[arrayVariable]);       
       intInput = Integer.parseInt(input);
       
       for(int i=0; i<library.size(); i++) {     
     
           if(intInput == (library.get(i).getAuthor_index()))  {
               flag = true;
               count++;
            }
       }
       if(flag) {
            JOptionPane.showMessageDialog(null, "Your search has retrieved " 
                                            + count + " entry(ies)");           
            for(int i=0; i<library.size(); i++) {
                if(intInput == (library.get(i).getAuthor_index()))  {
                     JOptionPane.showMessageDialog(null, "\nAuthor Name: " + 
                                 library.get(i).getAuthor_name() + 
                                 "\nBook Title: " + library.get(i).getTitle() + 
                                 "\nPersonal Information: " + 
                                 library.get(i).getAuthor(), "Results", 
                                 JOptionPane.INFORMATION_MESSAGE);
                 }
            }
       }
       else {
             JOptionPane.showMessageDialog(null, "No entries have been found."); 
       }
    }     
    
    public void sortByIndex() {
        Collections.sort(library,new BookGenreComp());
        String listOfBooks = "";
        for(int i=0; i<library.size(); i++) {
            listOfBooks = listOfBooks + library.get(i) + "\n";
        } 
        JOptionPane.showMessageDialog(null, listOfBooks); 
    }
    
    public void sortByPrice() {
        Collections.sort(library,new BookPriceComp());
        String listOfBooks = "";
        for(int i=0; i<library.size(); i++) {
            listOfBooks = listOfBooks + library.get(i) + "\n";
        } 
        JOptionPane.showMessageDialog(null, "Sorted books by price:" + "\n" + "\n" + listOfBooks); 
    }

    public void sortByGenre() {
        Collections.sort(library,new BookGenreComp());
        String listOfBooks = "";
        for(int i=0; i<library.size(); i++) {
            listOfBooks = listOfBooks + library.get(i) + "\n";
        } 
        JOptionPane.showMessageDialog(null, "Sorted books by genre:" + "\n" + "\n" + listOfBooks); 
    }

    public void sortByTitle() {
        Collections.sort(library,new BookTitleComp());
        String listOfBooks = "";
        for(int i=0; i<library.size(); i++) {
            listOfBooks = listOfBooks + library.get(i) + "\n";
        } 
        JOptionPane.showMessageDialog(null, "Sorted books by title:" + "\n" + "\n" + listOfBooks); 
    } 
}
