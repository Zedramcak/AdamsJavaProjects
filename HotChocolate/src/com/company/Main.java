package com.company;

import java.util.concurrent.TimeUnit;

public class Main {

    public static final double tooHot = 85;
    public static final double tooCold = 71.1;

    public static void drinkHotChocolate(double cocoaTemp) throws TooHotException, TooColdException{
        if (cocoaTemp>=tooHot)
            throw new TooHotException();
        else if (cocoaTemp<=tooCold)
            throw new TooColdException();

    }

    public static void main(String[] args) throws InterruptedException {

        double currentCocoaTemp = 20.4;
        boolean wrongTemp = true;
        while(wrongTemp) {
            System.out.printf("Temperature of the cocoa is %f\n", currentCocoaTemp);
            try {
                drinkHotChocolate(currentCocoaTemp);
                System.out.println("That cocoa was good");
                wrongTemp = false;
            } catch (TooHotException e1) {
                System.err.println("TOO HOT");
                currentCocoaTemp-=2.5;
            } catch (TooColdException e2) {
                System.err.println("TOO COLD");
                currentCocoaTemp+=2.5;
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("And it's gone");
    }
}
