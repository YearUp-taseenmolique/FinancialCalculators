package com.pluralsight;
import java.util.*;

public class MortgageCalculator {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {



    //Establish KNOWN values, from user.

    System.out.print("What is your Loan Amount? ");
    double principalAmount = s.nextDouble();
    s.nextLine();

    System.out.print("What is your interest rate? ");
    double interestRate = s.nextDouble();
    s.nextLine();

    System.out.print("(in years) What is your loan length? ");
    int loanLength = s.nextInt();
    s.nextLine();


    //Calculate Unknown Values

    double monthlyPayment = calculateMonthlyPayment(principalAmount, interestRate, loanLength);

    double totalInterest = calculateTotalInterest(principalAmount, monthlyPayment, loanLength);


    //Display the results

    System.out.printf("Your monthly interest payment will be: $%.2f", monthlyPayment);

    System.out.println("          ");

    System.out.printf("Your total interest payment will be: $%.2f", totalInterest);

    }

    public static double calculateMonthlyPayment(double principalAmount, double interestRate, int loanLength){
        double monthlyInterestRate = (interestRate / 100 / 12);
        int numberOfPayments = (loanLength * 12);

        return principalAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments )) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }

    public static double calculateTotalInterest (double principalAmount, double monthlyPayment, int loanLength) {
        int numberOfPayments = (loanLength * 12);
        return (monthlyPayment * numberOfPayments) - principalAmount;

    }

}
