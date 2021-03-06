package com.desafio.desafiospring.dto.products;

import com.desafio.desafiospring.entities.products.Detail;

public class DetailDto {

    private long productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public DetailDto() {
    }

    public DetailDto(Detail detail) {
        this.productId = detail.getProductId();
        this.productName = detail.getProductName();
        this.type = detail.getType();
        this.brand = detail.getBrand();
        this.color = detail.getColor();
        this.notes = detail.getNotes();
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static Detail dtoToClass(DetailDto dto){
        return new Detail(dto);
    }

    public static DetailDto classToDto(Detail detail){
        return new DetailDto(detail);
    }

}
