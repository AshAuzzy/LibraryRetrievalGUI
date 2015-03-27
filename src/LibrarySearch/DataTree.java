/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearch;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultTreeModel;

    public class DataTree extends JPanel{ 
              
        private DefaultMutableTreeNode root, roaldDahl, suzanneCollins, 
                                        jkRowling,  author_name, fScottFitzgerald;
        private JScrollPane scrollPane = new JScrollPane();
        //private JTree tree = new JTree();
        DataTable dataTable;
        ArrayList <Book> library;
        
        public DataTree() {
            
            library = Main.library;
            JPanel panel = new JPanel();
            /*
            root = new DefaultMutableTreeNode("Authors' Information");            
            
            author_name = new DefaultMutableTreeNode("Names");
            suzanneCollins = new DefaultMutableTreeNode("Suzanne Collins"); 
            roaldDahl = new DefaultMutableTreeNode("Roald Dahl");
            fScottFitzgerald = new DefaultMutableTreeNode("F. Scott Fitzgerald");            
            suzanneCollins = new DefaultMutableTreeNode("Suzanne Collins");            
            jkRowling = new DefaultMutableTreeNode("J.K. Rowling"); 
            
            author_name.add(suzanneCollins);
            author_name.add(roaldDahl);
            author_name.add(fScottFitzgerald);
            author_name.add(jkRowling);            
            
            suzanneCollins.add(new DefaultMutableTreeNode("Not Availible"));
            suzanneCollins.add(new DefaultMutableTreeNode("Connecticut"));
            suzanneCollins.add(new DefaultMutableTreeNode("NA"));
            suzanneCollins.add(new DefaultMutableTreeNode("06482"));
            suzanneCollins.add(new DefaultMutableTreeNode("000-000-0000"));            

            roaldDahl.add(new DefaultMutableTreeNode("NA"));
            roaldDahl.add(new DefaultMutableTreeNode("Oxford"));
            roaldDahl.add(new DefaultMutableTreeNode("England"));
            roaldDahl.add(new DefaultMutableTreeNode("OK1"));         
            roaldDahl.add(new DefaultMutableTreeNode("NA"));              
            
            fScottFitzgerald.add(new DefaultMutableTreeNode("NA"));
            fScottFitzgerald.add(new DefaultMutableTreeNode("Hollywood"));
            fScottFitzgerald.add(new DefaultMutableTreeNode("California"));
            fScottFitzgerald.add(new DefaultMutableTreeNode("91601"));         
            fScottFitzgerald.add(new DefaultMutableTreeNode("000-000-0000"));     

            jkRowling.add(new DefaultMutableTreeNode("Not Availible"));
            jkRowling.add(new DefaultMutableTreeNode("Edinburgh"));
            jkRowling.add(new DefaultMutableTreeNode("United Kingdom"));
            jkRowling.add(new DefaultMutableTreeNode("EH"));         
            jkRowling.add(new DefaultMutableTreeNode("000-000-0000")); 
            
            root.add(author_name);
            tree = new JTree(root);            
            scrollPane.add(tree);
            tree.setModel(new DefaultTreeModel(root));
            tree.setRootVisible(true);
                                     
            scrollPane.setViewportView(tree);                             
            setPreferredSize(new Dimension(400, 100));             
            
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);  
            tree.addTreeExpansionListener(new TreeExpansionListener() {
                               
                @Override
                public void treeCollapsed(TreeExpansionEvent e) {
                }

                @Override
                public void treeExpanded(TreeExpansionEvent e) {               
                } 
        });
            */
        
        dataTable = new DataTable(library);
        JTable table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);        
        table.setModel(dataTable);
        scrollPane = new JScrollPane(table); 
        setPreferredSize(new Dimension(400, 300));
        //panel.add(tree, BorderLayout.WEST);
        panel.add(scrollPane, BorderLayout.EAST);  
        add(panel);          
        }        
    }

    class DataTable extends AbstractTableModel {

            static String dataFile;
            static ArrayList<Book> libraryData = new ArrayList<>();        
            private String[] headings = {"Book Index","Author Name", 
                                        "Title", "Genre","Price", "Author Index"};

            public DataTable(ArrayList<Book> al) {
            libraryData = al;  
            }

            @Override        
            public int getRowCount() {
                return libraryData.size();
            }

            @Override        
            public String getColumnName(int column) {
                    return headings[column];
            }

            @Override        
            public int getColumnCount() {
                    return headings.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) { 
                    case 0:
                        return libraryData.get(rowIndex).getBookIndex();
                    case 1:
                        return libraryData.get(rowIndex).getAuthor_name();            
                    case 2:
                        return libraryData.get(rowIndex).getTitle();
                    case 3:
                        return libraryData.get(rowIndex).getGenre();                  
                    case 4:
                        return libraryData.get(rowIndex).getPrice();
                    case 5:
                        return libraryData.get(rowIndex).getAuthor_index();  
                    default:
                        return null;
                }
            }
        }