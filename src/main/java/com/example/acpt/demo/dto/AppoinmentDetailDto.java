package com.example.acpt.demo.dto;

public class AppoinmentDetailDto {


    private  double id;
    private  String name;
    private  int qty;
    private  double price;
    private  double totalPrice;





    public AppoinmentDetailDto(double id, String name, int qty, double price,double total) {
        this.id = id;
        this.name = name ;
        this.qty = qty;
        this.price = price;
        this.totalPrice = total;
    }


    public AppoinmentDetailDto() {

    }


    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
