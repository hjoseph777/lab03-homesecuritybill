// ==========================================
// Class: HomeSecurityBill
// Purpose: Stores customer and contract information
// ==========================================
package com.security.model;
import com.security.util.BillCalculator;
import com.security.validation.HomeSecurityInputvalidation;
import java.util.Scanner;

public class HomeSecurityBill {
    private String customerName;
    private String address;
    private int cameraCount;
    private int contractYears;
    private double monthlyPrice;
    private double totalContractValue;
    private static final HomeSecurityInputvalidation validator = new HomeSecurityInputvalidation();
    private int numberOfCameras;
    private int term;

    public HomeSecurityBill() {
        // Default constructor
    }

   

    public HomeSecurityBill(String customerName, String address, int cameraCount, int contractYears) {
        
        this.customerName = validator.getValidString(new Scanner(customerName), "");
        this.address = validator.getValidString(new Scanner(address), "");
        
        
        validator.validateRange(cameraCount, 1, Integer.MAX_VALUE, "Camera count");
        validator.validateRange(contractYears, 2, Integer.MAX_VALUE, "Contract years");
        
        this.cameraCount = cameraCount;
        this.contractYears = contractYears;
        calculatePrices();
    }

    private void calculatePrices() {
        BillCalculator calculator = new BillCalculator();
        this.monthlyPrice = calculator.calculateMonthlyPrice(numberOfCameras, term);
        this.totalContractValue = calculator.calculateTotalContractValue(monthlyPrice, term);
    }

    public void getUserInput(Scanner scanner) {
        this.customerName = validator.getValidString(scanner, "Customer Name: ");
        this.address = validator.getValidString(scanner, "Customer Address: ");
        this.term = validator.getValidTerm(scanner);
        if (this.term < 4) {
            this.numberOfCameras = validator.getValidCameraCount(scanner);
        } else {
            this.numberOfCameras = 4; 
        }
        calculatePrices();
    }

    public String getPackageName() {
        switch (term) {
            case 1:
                return "XFinity Home Protection";
            case 2:
                return "YFinity Home Protection";
            case 3:
                return "ZFinity Home Protection";
            default:
                return "UFinity Home Protection";
        }
    }

    public double packageCost() {
        BillCalculator calculator = new BillCalculator();
        return calculator.calculateMonthlyPrice(numberOfCameras, term);
    }

    @Override
    public String toString() {
        
        String packageDetails = (term < 4) ? String.format("$%.2f per month for 24/7 video recording with %d camera(s)\nThe cost includes base price, $5 per month for one camera and $3 per additional camera", packageCost(), numberOfCameras) : "$23.99 per month for 24/7 video recording\nIt comes with four cameras";
        return String.format("%s has purchased %s on a %d-year term\n%s", customerName, getPackageName(), term, packageDetails);
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public int getCameraCount() {
        return cameraCount;
    }

    public int getContractYears() {
        return contractYears;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public double getTotalContractValue() {
        return totalContractValue;
    }

    public void setCustomerName(String customerName) {
        this.customerName = validator.getValidString(new Scanner(customerName), "");
    }

    public void setAddress(String address) {
        this.address = validator.getValidString(new Scanner(address), "");
    }

    public void setCameraCount(int cameraCount) {
        validator.validateRange(cameraCount, 1, Integer.MAX_VALUE, "Camera count");
        this.cameraCount = cameraCount;
        calculatePrices(); // Recalculate prices when camera count changes
    }

    public void setContractYears(int contractYears) {
        validator.validateRange(contractYears, 2, Integer.MAX_VALUE, "Contract years");
        this.contractYears = contractYears;
        calculatePrices(); // Recalculate prices when contract years change
    }

    public String getBillSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append(String.format("Customer: %s\nAddress: %s\n", customerName, address));
        if (term < 3) {
            summary.append(String.format("Number of Cameras: %d\nContract Length: %d years\n", numberOfCameras, term));
        }
        summary.append(String.format("Monthly Cost: $%.2f\nTotal Contract Value: $%.2f\n", monthlyPrice, totalContractValue));
        return summary.toString();
    }
}
