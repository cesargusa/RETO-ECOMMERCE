package com.example.Product.Model;

public class OrderProduct {
    private int cantidad;
    private int orderId;
    public  int productId;
    private int orderProductId;
    private static int idStatic=0;

    public OrderProduct() {
    }

    public OrderProduct(int cantidad, int orderId, int productId) {

        this.cantidad = cantidad;
        this.orderId = orderId;
        this.productId = productId;
        orderProductId= ++idStatic;
    }
    


   
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public static int getIdStatic() {
        return idStatic;
    }

    public static void setIdStatic(int idStatic) {
        OrderProduct.idStatic = idStatic;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


}
