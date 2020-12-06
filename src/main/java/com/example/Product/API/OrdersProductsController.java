package com.example.Product.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.example.Product.Model.OrderProduct;
import com.example.Product.Model.Product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersProductsController {

    public static ArrayList<OrderProduct> orderproducts = new ArrayList<OrderProduct>(Arrays.asList(

            new OrderProduct(20, 1, 1), new OrderProduct(12, 1, 2), new OrderProduct(4, 2, 3),
            new OrderProduct(5, 3, 4), new OrderProduct(1, 4, 1), new OrderProduct(2, 3, 1), new OrderProduct(1, 1, 5),
            new OrderProduct(1, 3, 5), new OrderProduct(2, 3, 3), new OrderProduct(2, 1, 2), new OrderProduct(3, 2, 1),
            new OrderProduct(13, 1, 1)

    ));

    public static ArrayList<OrderProduct> GetOrderProductbyOrder(int orderId) {
        ArrayList<OrderProduct> orderproductsnew = new ArrayList<>();
        if (orderId == 0) {
            return OrdersProductsController.orderproducts;
        } else {
            for (OrderProduct element : OrdersProductsController.orderproducts) {
                if (element.getOrderId() == orderId) {

                    orderproductsnew.add(element);
                }
            }
            return orderproductsnew;

        }

    }

    public static ArrayList<Product> GetProductsByOrderId(int orderId) {
        ArrayList<Product> productsByOrder = new ArrayList<>();
        for (OrderProduct ord : orderproducts) {
            if (orderId == ord.getOrderId()) {
                for (Product pro : ProductsController.products) {
                    if (pro.getId() == ord.getProductId()) {
                        productsByOrder.add(pro);
                    }
                }
            }

        }

        return productsByOrder;

    }

    @GetMapping("/buscar")
    public ArrayList<OrderProduct> find(@RequestParam(name = "id", required = false, defaultValue = "0") int id) {
        ArrayList<OrderProduct> pros = new ArrayList<OrderProduct>();
        if (id == 0) {
            return orderproducts;
        } else {
            for (OrderProduct ele : orderproducts) {
                if (id == ele.getOrderId()) {
                    pros.add(ele);

                }
               
            } 
           return pros;
        }
    } 
    
    @DeleteMapping("/OrderProducts/{id}")
    public void Delete(@PathVariable("id") int id){
        Iterator<OrderProduct> itOrderProduct = orderproducts.iterator();
        while(itOrderProduct.hasNext()){
            OrderProduct ele = itOrderProduct.next();
            if(ele.getOrderProductId()==id){
                itOrderProduct.remove();
            }
        }
        
    }

}
