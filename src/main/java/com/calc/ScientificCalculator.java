package com.calc;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ScientificCalculator {

    static Logger logger = Logger.getLogger("CalcLog");

    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("calc.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (Exception e) {
            System.out.println("Logger Exception");
        }

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nScientific Calculator");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Log (ln)");
            System.out.println("4. Power");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter number: ");
                    double num = sc.nextDouble();
                    double sqrt = Math.sqrt(num);
                    System.out.println("Square Root: " + sqrt);
                    logger.info("Square root calculated for " + num);
                    break;

                case 2:
                    System.out.print("Enter number: ");
                    int n = sc.nextInt();
                    long fact = factorial(n);
                    System.out.println("Factorial: " + fact);
                    logger.info("Factorial calculated for " + n);
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    double lnNum = sc.nextDouble();
                    double ln = Math.log(lnNum);
                    System.out.println("Natural Log: " + ln);
                    logger.info("Natural log calculated for " + lnNum);
                    break;

                case 4:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exp = sc.nextDouble();
                    double power = Math.pow(base, exp);
                    System.out.println("Power: " + power);
                    logger.info("Power calculated for " + base + " ^ " + exp);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    logger.info("Calculator exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
}