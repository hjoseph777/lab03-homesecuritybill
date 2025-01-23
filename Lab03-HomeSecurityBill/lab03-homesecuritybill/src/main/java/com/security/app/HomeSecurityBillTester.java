// ==========================================
// File: src/main/java/com/security/app/HomeSecurityBillTester.java
// Class: HomeSecurityBillTester - Main application class
// ==========================================
package com.security.app;
import com.security.model.HomeSecurityBill;
import com.security.validation.HomeSecurityInputvalidation;
import java.util.Scanner;

public class HomeSecurityBillTester {
    private static final String HEADER = "=== YFinity Security System Calculator ===";
    private static final String CONFIRMATION_PROMPT = 
        "\nPlease review your order details:\n" +
        "--------------------------------";
    private static final HomeSecurityInputvalidation validator = new HomeSecurityInputvalidation();

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            displayHeader();
            HomeSecurityBill bill = createBill(input);
            
            if (confirmPurchase(input, bill)) {
                displayFinalBill(bill);
            } else {
                System.out.println("\nOrder cancelled. Thank you for considering YFinity Security Systems.");
            }
        } catch (IllegalArgumentException e) {
            displayError(e.getMessage());
        }
    }

    private static HomeSecurityBill createBill(Scanner input) {
        HomeSecurityBill bill = new HomeSecurityBill();
        bill.getUserInput(input);
        return bill;
    }

    private static boolean confirmPurchase(Scanner input, HomeSecurityBill bill) {
        System.out.println(CONFIRMATION_PROMPT);
        System.out.println(bill.getBillSummary());
        return validator.getConfirmation(input);
    }

    private static void displayHeader() {
        System.out.println(HEADER);
        System.out.println();
    }

    private static void displayFinalBill(HomeSecurityBill bill) {
        System.out.println("\n=== Final Order Confirmation ===");
        System.out.println(bill.toString());
        System.out.println("\nThank you for choosing YFinity Security Systems!");
        System.out.println("A confirmation email will be sent shortly.");
    }

    private static void displayError(String message) {
        System.out.println("Error: " + message);
    }
}
