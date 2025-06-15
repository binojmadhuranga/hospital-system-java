package com.example.acpt.demo.dto;

import java.util.List;

public class AppoinmentDto {

    private String date;
    private double totalAmount;
    private int doctorId;
    private double docFee;

    private List<AppoinmentDetailDto> appoinmentDetailDtos;


    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
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

    public AppoinmentDto (String date, double totalAmount, int doctorId, double docFee, List<AppoinmentDetailDto> appoinmentDetailDtos) {
        this.date = date;
        this.totalAmount = totalAmount;
        this.doctorId = doctorId;
        this.docFee = docFee;
        this.appoinmentDetailDtos = appoinmentDetailDtos;

    }

}
