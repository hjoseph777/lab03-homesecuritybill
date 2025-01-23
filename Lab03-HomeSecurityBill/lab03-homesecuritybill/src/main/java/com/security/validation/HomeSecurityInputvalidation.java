// ==========================================
// File: src/main/java/com/security/validation/HomeSecurityInputvalidation.java
// Class: HomeSecurityInputvalidation - Validation utility class
// ==========================================
package com.security.validation;
import java.util.Scanner;
 
public class HomeSecurityInputvalidation {
    private static final int MIN_CAMERAS = 1;
    private static final int MIN_CONTRACT_YEARS = 2;
    private static final String CONFIRMATION_PROMPT = 
        "\nWould you like to proceed with this order? (y/n): ";

    public String getValidString(Scanner input, String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = input.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("Input cannot be empty");
            }
        } while (value.isEmpty());
        return value;
    }

    public int getValidCameraCount(Scanner input) {
        int cameras = 0;
        while (cameras < MIN_CAMERAS) { 
            System.out.print("Number of Cameras (minimum " + MIN_CAMERAS + "): ");
            try {
                cameras = Integer.parseInt(input.nextLine());
                if (cameras < MIN_CAMERAS) {  
                    System.out.println("Must have at least " + MIN_CAMERAS + " camera");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        return cameras;
    }

    public int getValidContractYears(Scanner input) {
        int years = 0;
        while (years < MIN_CONTRACT_YEARS) {  
            System.out.print("Contract Years (minimum " + MIN_CONTRACT_YEARS + "): ");
            try {
                years = Integer.parseInt(input.nextLine());
                if (years < MIN_CONTRACT_YEARS) { 
                    System.out.println("Minimum contract is " + MIN_CONTRACT_YEARS + " years");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        return years;
    }

    public int getValidTerm(Scanner input) {
        int term = 0;
        while (term < 1) {
            System.out.print("Number of Years (minimum 1): ");
            try {
                term = Integer.parseInt(input.nextLine());
                if (term < 1) {
                    System.out.println("Term must be at least 1 year");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        return term;
    }

    public boolean getConfirmation(Scanner input) {
        while (true) {
            System.out.print(CONFIRMATION_PROMPT);
            String response = input.nextLine().trim().toLowerCase();
            
            switch (response) {
                case "y":
                case "yes":
                    return true;
                case "n":
                case "no":
                    return false;
                default:
                    System.out.println("Please enter 'y' for yes or 'n' for no");
            }
        }
    }

    public void validateRange(int value, int min, int max, String fieldName) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(
                String.format("%s must be between %d and %d", fieldName, min, max)
            );
        }
    }
}
