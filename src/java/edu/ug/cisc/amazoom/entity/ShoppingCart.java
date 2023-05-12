/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ug.cisc.amazoom.entity;

/**
 *
 * @author victo
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
    private ArrayList items = new ArrayList();

    public ShoppingCart() {
    }
    
  public void addItem(Book b) {
    boolean foundBook = false;
    if (items.size() == 0) {
      items.add(b);
    } else {
      for(int i=0;i<items.size();i++) {
        Book book = (Book)items.get(i);
        if (book.getIdLibro()==(b.getIdLibro())) {
          book.setCantidad(book.getCantidad()+1);
          foundBook = true;
          break;
        }
      }
      if (!foundBook) {
        items.add(b);
      }
    }
  }
  
  public void deleteItem(Book b){
    Iterator iterItems = items.iterator();
    
    while(iterItems.hasNext()){
        Book book = (Book)iterItems.next();
        
        if(book.getIdLibro()==(b.getIdLibro())){
            iterItems.remove();
        }
    }
  }
  
  public void updateItem(Book b){
    Iterator iterItems = items.iterator();
    
    while(iterItems.hasNext()){
        Book book = (Book)iterItems.next();
        
        if(book.getIdLibro()==(b.getIdLibro())){
            book.setCantidad(b.getCantidad());
        }
    }
  }
  
  public Iterator getContents() {
    System.out.println(items.size());
    return items.iterator();
  } 

    public void updateItem(com.amazoom.modelo.Book b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

