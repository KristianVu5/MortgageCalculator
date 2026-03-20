package bg.kris.dev;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalc {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;


        System.out.println("Hello, welcome to \"Mortgage Calculator\"");
        System.out.println("-".repeat(40));
        System.out.println("Write you information below.");

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");

        }

        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + result);
    }
}
