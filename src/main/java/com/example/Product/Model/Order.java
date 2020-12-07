package com.example.Product.Model;

public class Order {
    private int id;
    private static int idStatic= 0;
    private String date;
    private String nameUser;
    private String status;
    public String URL;
    public String URLEcommerce;
    
    public Order(){}

    public Order(String date, String nameUser, String status) {
        this.date = date;
        this.nameUser = nameUser;
        this.status = status;
        id=++idStatic;
        URL();
        URLEcommerce();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getIdStatic() {
        return idStatic;
    }

    public static void setIdStatic(int idStatic) {
        Order.idStatic = idStatic;
    }

    

    public void URL(){
        this.URL = "http://localhost:9092/OrderProducts?orderId=" + getId();
    }

    public String getURL() {
        return URL;
    }


    public void setURL(String uRL) {
        URL = uRL;
    }

    public String getURLEcommerce() {
        return URLEcommerce;
    }

    public void setURLEcommerce(String uRLEcommerce) {
        URLEcommerce = uRLEcommerce;
    }
    public void URLEcommerce(){
        this.URLEcommerce = "http://localhost:9092/Ecommerce?orderId="+getId();
    }
   

    
}
