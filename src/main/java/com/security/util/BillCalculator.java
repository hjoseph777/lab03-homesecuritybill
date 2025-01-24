// ==========================================
// Class: BillCalculator
// Purpose: Handles all pricing calculations
// ==========================================

package com.security.util;

public class BillCalculator {
    private static final double FIRST_CAMERA_PRICE = 5.00;
    private static final double ADDITIONAL_CAMERA_PRICE = 3.00;
    private static final int MONTHS_IN_YEAR = 12;
    private static final double XFINITY_PRICE = 15.99;
    private static final double YFINITY_PRICE = 13.99;
    private static final double ZFINITY_PRICE = 12.99;
    private static final double UFINITY_PRICE = 23.99;

    public double calculateMonthlyPrice(int cameraCount, int term) {
        double basePrice;
        switch (term) {
            case 1:
                basePrice = XFINITY_PRICE;
                break;
            case 2:
                basePrice = YFINITY_PRICE;
                break;
            case 3:
                basePrice = ZFINITY_PRICE;
                break;
            default:
                basePrice = UFINITY_PRICE;
                cameraCount = 0; // UFinity includes four cameras at no additional cost
                break;
        }
        double camerasCost = (term < 4) ? FIRST_CAMERA_PRICE + (cameraCount - 1) * ADDITIONAL_CAMERA_PRICE : 0;
        return basePrice + camerasCost;
    }

    public static double calculateTotalContractValue(double monthlyPrice, int contractYears) {
        return monthlyPrice * MONTHS_IN_YEAR * contractYears;
    }
}
