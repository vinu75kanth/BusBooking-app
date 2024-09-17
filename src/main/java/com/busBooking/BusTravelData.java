package com.busBooking;

import jakarta.persistence.*;

@Entity
@Table(name = "busData")
public class BusTravelData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sNo;
    private int price;
    private int totalSeats;
    private int avlSeats;
    private String startLoc;
    private String endLoc;
    private String startTime;
    private String endTime;
    private double duration;
    private String busType;
    private String travelType;
    @ManyToOne
    @JoinColumn(name = "busId", nullable = false)
    private BusData busData;

    public String getStartLoc() {
        return startLoc;
    }

    public void setStartLoc(String startLoc) {
        this.startLoc = startLoc;
    }

    public String getEndLoc() {
        return endLoc;
    }

    public void setEndLoc(String endLoc) {
        this.endLoc = endLoc;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public BusData getBusData() {
        return busData;
    }

    public void setBusData(BusData busData) {
        this.busData = busData;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvlSeats() {
        return avlSeats;
    }

    public void setAvlSeats(int avlSeats) {
        this.avlSeats = avlSeats;
    }

    @Override
    public String toString() {
        return "BusTravelData{" +
                "sNo=" + sNo +
                ", price=" + price +
                ", startLoc='" + startLoc + '\'' +
                ", endLoc='" + endLoc + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", duration=" + duration +
                ", busType='" + busType + '\'' +
                ", travelType='" + travelType + '\'' +
                '}';
    }
}
