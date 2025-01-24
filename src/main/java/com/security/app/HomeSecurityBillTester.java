// ==========================================
// File: src/main/java/com/security/app/HomeSecurityBillTester.java
// Class: HomeSecurityBillTester - Main application class
// ==========================================
package com.security.app;

import com.security.model.HomeSecurityBill;
import java.util.Scanner;

public class HomeSecurityBillTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HomeSecurityBill bill = new HomeSecurityBill();
        bill.takeInput(input);
        System.out.println();
        System.out.println(bill.toString());
        input.close();
    }
}
