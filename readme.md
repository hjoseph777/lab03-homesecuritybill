# Lab02-HomeSecurityBill

## Synopsis
The Home Security Bill Calculator is a Java program designed to help users select a home security package based on the number of years they commit to. The program calculates the monthly bill, displays relevant details, and provides a summary of the selected package. Users can choose from four distinct home security packages: XFinity, YFinity, ZFinity, and UFinity.

## Modules

### 1. HomeSecurityBill
**File:** [HomeSecurityBill.java](src/main/java/com/security/model/HomeSecurityBill.java)

**Description:** 
The `HomeSecurityBill` class stores customer and contract information. It calculates the monthly price and total contract value based on the selected package and the number of cameras. It also provides methods to get user input and display a summary of the bill.

### 2. HomeSecurityBillTester
**File:** [HomeSecurityBillTester.java](src/main/java/com/security/app/HomeSecurityBillTester.java)

**Description:** 
The `HomeSecurityBillTester` class is the main application class. It prompts the user for input, creates a `HomeSecurityBill` object, and displays the final bill summary. It also handles user confirmation and error display.

### 3. HomeSecurityInputvalidation
**File:** [HomeSecurityInputvalidation.java](src/main/java/com/security/validation/HomeSecurityInputvalidation.java)

**Description:** 
The `HomeSecurityInputvalidation` class provides utility methods for validating user input. It ensures that the input values for customer name, address, number of cameras, and contract years are valid. It also handles user confirmation prompts.

### 4. BillCalculator
**File:** [BillCalculator.java](src/main/java/com/security/util/BillCalculator.java)

**Description:** 
The `BillCalculator` class handles all pricing calculations. It calculates the monthly price based on the selected package and the number of cameras. It also calculates the total contract value based on the monthly price and the contract years.

## Usage
1. Run the `HomeSecurityBillTester` class.
2. Follow the prompts to enter customer name, address, number of years, and number of cameras (if applicable).
3. Review the order details and confirm the purchase.
4. The final order confirmation will be displayed.

## Example Output
## Output

![output1](src/main/resources/images/1bill.png)

![output2](src/main/resources/images/3bill.png)
![output3](src/main/resources/images/4bill.png)
![output4](src/main/resources/images/5bill.png)




## Directory and File Structure
<pre>
Lab02-HomeSecurityBill/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── security/
│   │   │   │   │   ├── app/
│   │   │   │   │   │   └── HomeSecurityBillTester.java
│   │   │   │   │   ├── model/
│   │   │   │   │   │   └── HomeSecurityBill.java
│   │   │   │   │   ├── util/
│   │   │   │   │   │   └── BillCalculator.java
│   │   │   │   │   └── validation/
│   │   │   │   │       └── HomeSecurityInputvalidation.java
│   │   ├── resources/
│   │   │   └── images/
│   │   │       └── output.png
├── readme.md
</pre>

### - Author Harry Joseph [Github](https://github.com/hjoseph777)
### - January 19, 2025
