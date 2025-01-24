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
    private static final int UFINITY_INCLUDED_CAMERAS = 4;
    
    private double getBasePrice(int term) {
        switch (term) {
            case 1: return XFINITY_PRICE;
            case 2: return YFINITY_PRICE;
            case 3: return ZFINITY_PRICE;
            default: return UFINITY_PRICE;
        }
    }

    public double calculateMonthlyPrice(int cameraCount, int term) {
        double basePrice = getBasePrice(term);
        boolean isUFinity = term >= 4;
        
        if (isUFinity) {
            return basePrice + (cameraCount > UFINITY_INCLUDED_CAMERAS ? (cameraCount - UFINITY_INCLUDED_CAMERAS) * ADDITIONAL_CAMERA_PRICE : 0); // UFinity includes up to 4 cameras at no additional cost
        }
        
        return basePrice + FIRST_CAMERA_PRICE + (cameraCount - 1) * ADDITIONAL_CAMERA_PRICE;
    }

    public static double calculateTotalContractValue(double monthlyPrice, int contractYears) {
        return monthlyPrice * MONTHS_IN_YEAR * contractYears;
    }
}
