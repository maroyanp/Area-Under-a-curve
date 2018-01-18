package com.company;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please type in the Words as exactly as they are seen ");

        System.out.println("Welcome to maroyans Goldy Calculator to find the area under a curve \n "
                + "please select which fucntion you would want \n "
                + " 1) Linear  \n 2) Quadratic \n 3) Sine \n 4) Cosine");

        AreaBtwn mySub = new AreaBtwn();
        //this is the object to use all the other methods.

        double low ;
        double high;
        int iteratrions;
        double m;
        double b;
        double a;
        double k;
        double d;
        double h;
        double c;
        double Gx;
        boolean degrees;

        Scanner s = new Scanner(System.in);
        //this is a scanner to take all system input


        switch (ABFunctions.valueOf(s.next())) {

            case Linear:
                System.out.println(" Please enter in the lower bound");
                low = s.nextDouble();
                System.out.println("Please enter in the upper bound");
                high = s.nextDouble();
                System.out.println("How accurate do you want to be ");
                iteratrions = s.nextInt();
                System.out.println("Please enter in G of x");
                Gx = s.nextDouble();
                System.out.println("Please enter in m");
                m = s.nextDouble();
                System.out.println("Please enter in b");
                b = s.nextDouble();

                mySub.setDomain(low, high);
                mySub.setIteration(iteratrions);
                mySub.setGx(Gx);

                System.out.println(mySub.CalcAreaBetween(m,b));
                //this gets all the data from the user and sets it without them knowing.

                mySub.resetData();

                break;


            case Quadratic:

                System.out.println(" Please enter in the lower bound");
                low = s.nextDouble();
                System.out.println("Please enter in the upper bound");
                high = s.nextDouble();
                System.out.println("How accurate do you want to be ");
                iteratrions = s.nextInt();
                System.out.println("Please enter in G of x");
                Gx = s.nextDouble();
                System.out.println("Please enter in a");
                a = s.nextDouble();
                System.out.println("Please enter in h");
                h = s.nextDouble();
                System.out.println("Please enter in a value for c ");
                c = s.nextDouble();

                mySub.setDomain(low, high);
                mySub.setIteration(iteratrions);
                mySub.setGx(Gx);

                System.out.println(mySub.CalcAreaBetween(a,h,c));
                //this gets all the data from the user and sets it without them knowing.

                mySub.resetData();

                break;

            case Sine:

                System.out.println(" Please enter in the lower bound");
                low = s.nextDouble();
                System.out.println("Please enter in the upper bound");
                high = s.nextDouble();
                System.out.println("How accurate do you want to be ");
                iteratrions = s.nextInt();
                System.out.println("Please enter in G of x");
                Gx = s.nextDouble();
                System.out.println("Please enter in a");
                a = s.nextDouble();
                System.out.println("Please enter in k");
                k = s.nextDouble();
                System.out.println("Please enter in a value for c ");
                c = s.nextDouble();
                System.out.println("Please enter in a value for d ");
                d = s.nextDouble();
                System.out.println("Please enter in weather true or false for weither to use degrees ");
                degrees = s.nextBoolean();

                mySub.setDomain(low, high);
                mySub.setIteration(iteratrions);
                mySub.setGx(Gx);
                //this gets all the data from the user and sets it without them knowing.

                System.out.println(mySub.CalcAreaBetween(ABFunctions.Sine,a,k,c,d,degrees));

                //System.out.println();
                mySub.resetData();


                break;

            case Cosine:

                System.out.println(" Please enter in the lower bound");
                low = s.nextDouble();
                System.out.println("Please enter in the upper bound");
                high = s.nextDouble();
                System.out.println("How accurate do you want to be ");
                iteratrions = s.nextInt();
                System.out.println("Please enter in G of x");
                Gx = s.nextDouble();
                System.out.println("Please enter in a");
                a = s.nextDouble();
                System.out.println("Please enter in k");
                k = s.nextDouble();
                System.out.println("Please enter in a value for c ");
                c = s.nextDouble();
                System.out.println("Please enter in a value for d ");
                d = s.nextDouble();
                System.out.println("Please enter in weather True or false for weither to use degrees ");
                degrees = s.nextBoolean();

                mySub.setDomain(low, high);
                mySub.setIteration(iteratrions);
                mySub.setGx(Gx);
                //this gets all the data from the user and sets it without them knowing.

                System.out.println(mySub.CalcAreaBetween(ABFunctions.Cosine,a,k,c,d,degrees));
                //this prints to the user the area under a cosine graph

                //System.out.println();
                mySub.resetData();
                break;

            case Invalid:

                System.out.println("Thats invalid Please try again");

                break;

        }
    }
}


