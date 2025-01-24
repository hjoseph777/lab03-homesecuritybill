// ==========================================
// File: src/main/java/com/security/validation/HomeSecurityInputvalidation.java
// Class: HomeSecurityInputvalidation - Validation utility class
// ==========================================
package com.security.validation;
import java.util.Scanner;
 
public class HomeSecurityInputvalidation {
    private static final int MIN_CAMERAS = 1;
    private static final int MIN_CONTRACT_YEARS = 2;
    private static final int MIN_TERM_YEARS = 1;
    private static final String CONFIRMATION_PROMPT = "\nWould you like to proceed with this order? (y/n): ";

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

    private int getValidNumber(Scanner input, String prompt, int minValue, String errorMessage) {
        int value = 0;
        while (value < minValue) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(input.nextLine());
                if (value < minValue) {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        return value;
    }

    public int getValidCameraCount(Scanner input) {
        return getValidNumber(
            input,
            String.format("Number of Cameras (minimum %d): ", MIN_CAMERAS),
            MIN_CAMERAS,
            String.format("Must have at least %d camera", MIN_CAMERAS)
        );
    }

    public int getValidContractYears(Scanner input) {
        return getValidNumber(
            input,
            String.format("Contract Years (minimum %d): ", MIN_CONTRACT_YEARS),
            MIN_CONTRACT_YEARS,
            String.format("Minimum contract is %d years", MIN_CONTRACT_YEARS)
        );
    }

    public int getValidTerm(Scanner input) {
        return getValidNumber(
            input,
            String.format("Number of Years (minimum %d): ", MIN_TERM_YEARS),
            MIN_TERM_YEARS,
            "Term must be at least 1 year"
        );
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
