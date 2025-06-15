package com.example.acpt.demo.dto;

import java.util.List;

public class AppoinmentDto {

    private String data;
    private double totalAmount;
    private int doctorId;
    private double docFee;

    private List<AppoinmentDetailDto> appoinmentDetailDtos;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public double getDocFee() {
        return docFee;
    }

    public void setDocFee(double docFee) {
        this.docFee = docFee;
    }

    public List<AppoinmentDetailDto> getAppoinmentDetailDtos() {
        return appoinmentDetailDtos;
    }

    public void setAppoinmentDetailDtos(List<AppoinmentDetailDto> appoinmentDetailDtos) {
        this.appoinmentDetailDtos = appoinmentDetailDtos;
    }
}
