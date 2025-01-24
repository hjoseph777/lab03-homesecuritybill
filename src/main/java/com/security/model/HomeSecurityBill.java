// ==========================================
// Class: HomeSecurityBill
// Purpose: Stores customer and contract information
// ==========================================
package com.security.model;

import java.util.Scanner;
import com.security.validation.HomeSecurityInputvalidation;

public class HomeSecurityBill {
    private String customerName;
    private int numberOfCameras;
    private int term;

    public HomeSecurityBill() {
        // Default constructor
    }

    public HomeSecurityBill(String nName, int cameras, int year) {
        this.customerName = nName;
        this.numberOfCameras = cameras;
        this.term = year;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumOfCameras() {
        return numberOfCameras;
    }

    public int getTerm() {
        return term;
    }

    public void setCustomerName(String nName) {
        this.customerName = nName;
    }

    public void setNumOfCameras(int newC) {
        this.numberOfCameras = newC;
    }

    public void setTerm(int newTerm) {
        this.term = newTerm;
    }

    public double charges(int camPrice, double packPrice) {
        double cameraCost = (term < 4) ? camPrice + (numberOfCameras - 1) * 3 : 0;
        return cameraCost + packPrice;
    }

    public double packageCost() {
        switch (term) {
            case 1: return 15.99;
            case 2: return 13.99;
            case 3: return 12.99;
            default: return 23.99;
        }
    }

    public String getPackageName() {
        String baseName = term < 4 ? 
            (term == 1 ? "XFinity" : term == 2 ? "YFinity" : "ZFinity") : "UFinity";
        return baseName + " Home Protection";
    }

    public void takeInput(Scanner scan) {
        HomeSecurityInputvalidation validator = new HomeSecurityInputvalidation();
        this.customerName = validator.getValidString(scan, "Enter the name of customer: ");
        this.term = validator.getValidTerm(scan);
        if (this.term < 4) {
            System.out.println("Minimum One camera required");
            this.numberOfCameras = validator.getValidCameraCount(scan);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s has purchased %s on a %d-year term\n",
                customerName, getPackageName(), term));
        
        double monthlyBill = packageCost();
        if (term < 4) {
            sb.append(String.format("$%.2f per month for 24/7 video recording with %d camera(s)\n",
                    monthlyBill + (numberOfCameras > 0 ? 5 + (numberOfCameras - 1) * 3 : 0), 
                    numberOfCameras));
            if (numberOfCameras == 1) {
                sb.append("The cost includes base price and $5 per month for one camera");
            } else {
                sb.append("The cost includes base price, $5 per month for one camera and $3 per additional camera");
            }
        } else {
            sb.append(String.format("$%.2f per month for 24/7 video recording\n", monthlyBill));
            sb.append("It comes with four cameras");
        }
        return sb.toString();
    }
}
