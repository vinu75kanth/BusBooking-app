package com.busBooking;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buses")
public class BusData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busId;
    private String busNo;
    private String busName;
    private String parentCompany;
    private String phoneNumber;
    @OneToMany(mappedBy = "busData")
    private List<BusTravelData> routes = new ArrayList<>();

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(String parentCompany) {
        this.parentCompany = parentCompany;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BusTravelData> getRoutes() {
        return routes;
    }

    public void setRoutes(BusTravelData routes) {
        this.routes.add(routes);
    }

    @Override
    public String toString() {
        return "BusData{" +
                "busId=" + busId +
                ", busNo='" + busNo + '\'' +
                ", busName='" + busName + '\'' +
                ", parentCompany='" + parentCompany + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
