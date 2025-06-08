package com.example.acpt.demo.dto;

public class MedicineDto {

    private int id;
    private String name;
    private int quantity;
    private double unitPrice;

    // Default constructor
    public MedicineDto() {
    }

    // Full constructor with ID
    public MedicineDto(int id, String name, int quantity, double unitPrice) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Constructor without ID (e.g., for creation)
    public MedicineDto(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and setters
    public int getId() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
