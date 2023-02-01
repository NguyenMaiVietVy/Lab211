/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project01.bookstoremangement;
public class Book {
    private String id, name, status, idPublisher, namePublisher;
    private double price;
    int quantity; 

    public Book() {
    }

    public Book(String id, String name, String status, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(String idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setNamePublisher(String namePublisher) {
        this.namePublisher = namePublisher;
    }
    
    @Override
    public String toString() {
        return id + "|" + name + "|" + price + "|" + quantity + "|" + price * quantity + "|" + namePublisher + "|" + status + "," + idPublisher;
    }

    public String showDisplay(){
        return id + "|" + name + "|" + price + "|" + quantity + "|" + price * quantity + "|" + namePublisher + "|" + status;
    }
}
