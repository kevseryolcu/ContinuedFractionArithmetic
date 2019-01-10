package com.cf.applications;

import com.cf.iterators.FractionTermIterator;
import com.cf.iterators.GosperTermIterator;
import com.cf.numbers.ContinuedFractionNumber;
import com.cf.numbers.FractionNumber;
import com.cf.utils.DisplayUtil;
import com.cf.utils.CFTransformUtil;

import java.util.Scanner;

public class CFArithmeticsApp {
    public static void main(String[] args) {
        getInputVariables();
    }

    private static void getInputVariables() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first fraction: ");
        String firstNumberString = scanner.nextLine();
        System.out.println("Input second fraction:");
        String secondNumberString = scanner.nextLine();
        controlInputs(firstNumberString, secondNumberString);
        scanner.close();
    }

    private static void controlInputs(String firstNumberString, String secondNumberString) {
        if (firstNumberString == null || secondNumberString == null || !firstNumberString.contains("/") || !secondNumberString.contains("/")) {
            System.out.println("Wrong input. Try again.");
            getInputVariables();
        }
        String[] firstNumber = firstNumberString.split("/");
        long firstNumerator = Long.valueOf(firstNumber[0]);
        long firstDenominator = Long.valueOf(firstNumber[1]);
        String[] secondNumber = secondNumberString.split("/");
        long secondNumerator = Long.valueOf(secondNumber[0]);
        long secondDenominator = Long.valueOf(secondNumber[1]);

        ContinuedFractionNumber cf = getOperationType(firstNumerator, firstDenominator, secondNumerator, secondDenominator);

        System.out.println("Results:");
        System.out.println("continued fraction: " + DisplayUtil.writeListNotation(cf.iterator()));
        System.out.println("fraction: " + CFTransformUtil.toFraction(cf.iterator()));
        //System.out.println("decimal: " + CFTransformUtil.toDouble(cf.iterator()));
    }

    private static ContinuedFractionNumber getOperationType(long firstNumerator, long firstDenominator, long secondNumerator, long secondDenominator) {
        System.out.println("Input arithmetic operation(add, sub, mul, div): ");
        Scanner operationScanner = new Scanner(System.in);
        String operationType =  operationScanner.nextLine();
        ContinuedFractionNumber cf = null;
        FractionTermIterator firstFractionTermIterator = new FractionTermIterator(new FractionNumber(firstNumerator, firstDenominator));
        FractionTermIterator secondFractionTermIterator = new FractionTermIterator(new FractionNumber(secondNumerator, secondDenominator));
        //System.out.println("First CF" + DisplayUtil.writeListNotation(firstFractionTermIterator));
        //System.out.println("Second CF" + DisplayUtil.writeListNotation(secondFractionTermIterator));
        switch (operationType) {
            case "add":
                cf = new ContinuedFractionNumber(GosperTermIterator.add(firstFractionTermIterator, secondFractionTermIterator));
                break;
            case "sub":
                cf = new ContinuedFractionNumber(GosperTermIterator.subtract(firstFractionTermIterator, secondFractionTermIterator));
                break;
            case "mul":
                cf = new ContinuedFractionNumber(GosperTermIterator.multiply(firstFractionTermIterator, secondFractionTermIterator));
                break;
            case "div":
                cf = new ContinuedFractionNumber(GosperTermIterator.divide(firstFractionTermIterator, secondFractionTermIterator));
                break;
            default:
                System.out.println("Wrong operation selection try again; ");
                getOperationType(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
                break;
        }
        return cf;
    }
}
