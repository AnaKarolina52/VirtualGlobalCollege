/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.global.college;

/**
 *
 * @author izaakmccarthy
 */
public class Item {

    private int id;
    private String name;
    
    public Item (int id, String name){
        this.id=id;
        this.name=name;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
       return this.id;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
       return this.name;
    }
}
