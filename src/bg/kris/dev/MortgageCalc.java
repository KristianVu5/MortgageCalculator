package bg.kris.dev;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalc {
    public static void main(String[] args) {

        double principal;
        double annualInterestRate;
        int period;


        System.out.println("Hello, welcome to \"Mortgage Calculator\"");
        System.out.println("-".repeat(40));
        System.out.println("Write you information bellow:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        principal = Double.parseDouble(scanner.nextLine());
        System.out.print("Annual Interest Rate: ");
        annualInterestRate = Double.parseDouble(scanner.nextLine());
        System.out.print("Period (Years): ");
        period = Integer.parseInt(scanner.nextLine());

        double mortgage = formula(principal,annualInterestRate, period);
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + result);
    }

    private static double formula(double principal, double annualInterestRate, int period) {

        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        int numberOfPayments = period * 12;

        return  principal * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }
}