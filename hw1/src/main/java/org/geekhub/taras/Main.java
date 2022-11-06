package org.geekhub.taras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the mobile phone number in format +380XXXXXXXXX or 0XXXXXXXXX:");
        Scanner scan = new Scanner(System.in);
        String phoneNumberInput;
        String[] operatorCodesZero = {"050", "063", "067", "068", "073", "091", "092", "093", "094", "095",
                "096", "097", "098", "099"};
        String[] operatorCodesPlus = {"+38050", "+38063", "+38067", "+38068", "+38073", "+38091", "+38092",
                "+38093", "+38094", "+38095", "+38096", "+38097", "+38098", "+38099"};
        boolean correct = false;
        char[] phoneNumChar;

        do{
            phoneNumberInput = scan.nextLine();
            phoneNumChar = phoneNumberInput.toCharArray();

            for (String operatorCode : operatorCodesZero){
                if (phoneNumberInput.startsWith(operatorCode)){
                    if (phoneNumChar.length == 10){
                        correct = true;
                        break;
                    }
                }
            }

            for (String operatorCode : operatorCodesPlus){
                if (phoneNumberInput.startsWith(operatorCode)){
                    if (phoneNumChar.length == 13) {
                        correct = true;
                        break;
                    }
                }
            }

            if (correct){
                for (int i = 1; i < phoneNumChar.length; i++)
                    if (!Character.isDigit(phoneNumChar[i])){
                        correct = false;
                        System.out.println("Phone number is incorrect. " +
                                        "Please enter the mobile phone number in format +380XXXXXXXXX or 0XXXXXXXXX:");
                        break;
                    }
            }
            else {
                System.out.println("Phone number is incorrect. " +
                        "Please enter the mobile phone number in format +380XXXXXXXXX or 0XXXXXXXXX:");
            }
        }while (!correct);

        System.out.println("Phone number is correct");

        int[] phoneNumInt = new int[phoneNumChar.length - 1];
        for (int i = 0; i < phoneNumInt.length; i++)
        {
            phoneNumInt[i] = Character.digit(phoneNumChar[i + 1], 10);
        }

        int sumDigits = 0;
        for (int j : phoneNumInt) {
            sumDigits += j;
        }
        System.out.println("1 round of calculation, sum is:" + sumDigits);

        int roundOfcalc = 2;

        while (sumDigits >= 10)
        {
            int cloneSumDigits = sumDigits;
            sumDigits = 0;
            while (cloneSumDigits > 0)
            {
                sumDigits += cloneSumDigits % 10;
                cloneSumDigits /= 10;
            }
            System.out.println(roundOfcalc + " round of calculation, sum is: " + sumDigits);
            roundOfcalc++;
        }

        switch (sumDigits)
        {
            case 1:
                System.out.println("Final result is: One");
                break;
            case 2:
                System.out.println("Final result is: Two");
                break;
            case 3:
                System.out.println("Final result is: Three");
                break;
            case 4:
                System.out.println("Final result is: Four");
                break;
            default:
                System.out.println("Final result is: " + sumDigits);

        }
    }
}