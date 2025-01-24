// ==========================================
// Class: HomeSecurityBill
// Purpose: Stores customer and contract information
// ==========================================
package com.security.model;

import java.util.Scanner;
import com.security.validation.HomeSecurityInputvalidation;
import com.security.util.BillCalculator;

public class HomeSecurityBill {
    private String customerName;
    private int numberOfCameras;
    private int term;

    public HomeSecurityBill() {
        
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

    public double charges() {
        BillCalculator calculator = new BillCalculator();
        return calculator.calculateMonthlyPrice(numberOfCameras, term);
    }

    public double packageCost() {
        BillCalculator calculator = new BillCalculator();
        return calculator.calculateMonthlyPrice(numberOfCameras, term);
    }

    public String getPackageName() {
        switch (term) {
            case 1:
                return "XFinity Home Protection 24/7 video monitoring";
            case 2:
                return "YFinity Home Protection 24/7 video monitoring";
            case 3:
                return "ZFinity Home Protection 24/7 video monitoring";
            default:
                return "UFinity Home Protection 24/7 video monitoring";
        }
    }

    public void takeInput(Scanner scan) {
        HomeSecurityInputvalidation validator = new HomeSecurityInputvalidation();
        this.customerName = validator.getValidString(scan, "Enter customer name: ");
        this.term = validator.getValidTerm(scan);
        if (this.term < 4) {
            this.numberOfCameras = validator.getValidCameraCount(scan);
        } else {
            this.numberOfCameras = 0; 
        }
    }

    @Override
    public String toString() {
        double monthlyPrice = packageCost();
        StringBuilder sb = new StringBuilder();
        
        
        sb.append(String.format("%s has purchased %s on a %d-year term\n",
                getCustomerName(), getPackageName(), getTerm()));
        
        
        if (term < 4) {
            sb.append(String.format("$%.2f per month for 24/7 video recording with %d camera(s)\n",
                    monthlyPrice, getNumOfCameras()));
         
            if (numberOfCameras == 1) {
                sb.append("The cost includes base price and $5 per month for one camera");
            } else {
                sb.append("The cost includes base price, $5 per month for one camera and $3 per additional camera");
            }
        } else {
            sb.append(String.format("$%.2f per month for 24/7 video recording\n", monthlyPrice));
            sb.append("It comes with four cameras");
        }
        
        return sb.toString();
    }
}
