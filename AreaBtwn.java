package com.company;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.regexp.internal.RE;

import java.security.PublicKey;
import java.util.Scanner;

public class AreaBtwn {

    ABFunctions abFunctions ;
    //i tried this but i mean i didnt know how to use it soo.
    private boolean degrees;
    private double low ;
    private double high;
    private double iteratrions;
    private double m;
    private double b;
    private double a;
    private double k;
    private double d;
    private double h;
    private double c;
    private double Gx;
    //these are all the data types that i will be using


    public void resetData(){
        this.a = 0;
        this.b = 0;
        this.m = 0;
        this.c = 0;
        this.d = 0;
        this.low = 0;
        this.high = 0;
        this.iteratrions = 0;
        this.k = 0;
        this.h = 0;
        this.Gx = 0;

    } //this is to reset all data of all the private data
    public void setDomain(double low, double high){
        this.low = low;
        this.high = high;

    } //this is to calculate the domain

    public void setGx( double b){
        Gx = b;
        //this sets the constant to use for Fx - Gx to find the height
    }


    public void setIteration(int n){
        this.iteratrions = n;
    } //this is to set how manny slices the user desires

    public double CalcAreaBetween(double m, double b){
        return calcAreaLinear(m,b);
        //this returns the private method where all the math is done
    }
    //This method should call the setLineData, and calcAreaLinear methods

    public double CalcAreaBetween(double a, double h, double c){

     return calcAreaQuadratic(a, h, c); //this calls the private method where all the calculations are done.
    }
    //This method should call the setQuadraticData, and calcAreaQuadratic methods

    public double CalcAreaBetween(ABFunctions f, double a, double k, double c, double d, boolean degrees){

        if (f.equals(ABFunctions.Sine)){
            //this if statment checks if the Enum Sine is present and if so it will return the
            //calculate Sine private method where all the math is done.

            return (calcAreaSine(f,a,k,c,d,degrees));
        }else //and if the Enum Cosine is present than it will call the private
        //method that calculates the area under a sine curve graph.

            return calAreaCosine(f,a,k,c,d,degrees);
    }


    private void setLineData(double m, double b){
        this.m = m;
        this.b = b;
    }
    private void setQuadraticData(double a,double h, double c){
        this.a = a;
        this.h = h;
        this.c = c;

    }
    private void setSinusoidalData(ABFunctions f, double a, double k, double c, double d, boolean degrees){
        abFunctions = f;
        this.a = a;
        this.k = k;
        this.c = c;
        this.d = d;
        this.degrees = degrees;
    }
    //i didnt know how to use these but the program still works because i added parameters to all the private methods

    //that return a double value

    private double calcAreaLinear(double m, double b){

        double x, width , hieght, n, Gx, ReturnArea, TempArea, TotArea = 0;
        //these are all the local varibles that make it easier to code.

        ReturnArea = 0;
        hieght = 0; //i initilized this varible height so it can be be set during the loop.

        int i = 0; //this is going to be setting the counter soit starts at 0.

        x = (this.high - this.low);
        //this is to loop over how manny times entering the value of g of X
        // System.out.println("X is === "  + x);
        n = this.iteratrions;
        //this is how manny slices they want
        width = x / n;
        //this is to determine the width by dividing the x value by how accurate they want to be.
        Gx = this.Gx;

        // System.out.println("Withd nig  === " + width);
        while(i <= n){

            hieght = Math.abs(((m*low) + (b - Gx) ))  ;
            //this is to find the heigt of each of the values at a certain point of x

            //System.out.println("This is Hieght " +hieght);

            TempArea = Math.abs(hieght * width); // this is to find the Area

            //System.out.println("this is T " +TempArea);

            TotArea += TempArea;

            //System.out.println("This is   Low " + low);

            ReturnArea = TotArea;

            //System.out.println("THis is i ===  " + i);

            low += width;
            //this adds the value of the width of each block to calculate the width.
            i++;
            //since im not using a for loop i manually have to count i +
        }

        return ReturnArea;




    }
    private double calcAreaQuadratic(double a, double h, double c){
        double x, width , hieght, n, Gx, ReturnArea, TempArea, TotArea = 0;
        //all the local varibles i need to use to to calculate the area under a curve.
        ReturnArea = 0;
        hieght = 0;

        int i = 0;

        x = (this.high - this.low); //this is to loop over how manny times entering the value of g of X
        System.out.println("X is === "  + x);
        n = this.iteratrions; //this is how manny slices they want
        width = x / n; //this is to determine the width by dividing the x value by how accurate they want to be.
        Gx = this.Gx;

        while(i <= n){

            hieght = Math.abs(a*((low - h) *(low - h)) + (c -Gx)); //this is to calculate the height
            TempArea = Math.abs(hieght * width);
            TotArea += TempArea;

            i++; //this is for the counter to go up.
            low += width; //this is to add the width from the original X value.

            ReturnArea = TotArea;

        }

        return ReturnArea;
    }
    private double calcAreaSine(ABFunctions f, double a, double k , double c, double d, boolean degrees){

        double x, width , hieght, n, Gx, ReturnArea, TempArea, TotArea = 0;
        //all the local varibles i need to use to to calculate the area under a curve.
        ReturnArea = 0;
        hieght = 0;

        int i = 0;

        x = (this.high - this.low); //this is to loop over how manny times entering the value of g of X
        System.out.println("X is === "  + x);
        n = this.iteratrions; //this is how manny slices they want
        width = x / n; //this is to determine the width by dividing the x value by how accurate they want to be.
        Gx = this.Gx;


        if(degrees){
            while (i < n){

                hieght = Math.abs(a*(Math.sin( k*(low - c   ))) + (d - Gx));
                TempArea = Math.abs(hieght * width);
                TotArea += TempArea;

                low += width;
                i++;

                ReturnArea = TotArea;

            }
            return ReturnArea;
        } else {
            while (i <n){
                hieght = Math.abs(a*(Math.sin( k*(low - c   ))) + (d - Gx));
                TempArea = Math.abs(hieght * width);
                TotArea += TempArea;

                low += width;
                i++;

                ReturnArea = TotArea;
            }
            //Math.toRadians(ReturnArea); this was suppose to be returning the value if wanted to be radians
            ReturnArea = ReturnArea * (3.14159265359 / Math.toDegrees(180));

        }
        return ReturnArea;
    }
    private double calAreaCosine(ABFunctions f, double a, double k , double c, double d, boolean degrees){

        double x, width , hieght, n, Gx, ReturnArea, TempArea, TotArea = 0;
        //all the local varibles i need to use to to calculate the area under a curve.
        ReturnArea = 0;
        hieght = 0;

        int i = 0;

        x = (this.high - this.low); //this is to loop over how manny times entering the value of g of X
        System.out.println("X is === "  + x);
        n = this.iteratrions; //this is how manny slices they want
        width = x / n; //this is to determine the width by dividing the x value by how accurate they want to be.
        Gx = this.Gx;


        if(degrees){
            while (i < n){

                hieght = Math.abs(a*(Math.cos( k*(low - c   ))) + (d - Gx));
                TempArea = Math.abs(hieght * width);
                TotArea += TempArea;

                low += width;
                i++;

                ReturnArea = TotArea;

            }
            return ReturnArea;
        } else {
            while (i <n){
                hieght = Math.abs(a*(Math.cos( k*(low - c   ))) + (d - Gx));
                TempArea = Math.abs(hieght * width);
                TotArea += TempArea;

                low += width;
                i++;

                ReturnArea = TotArea;
            }
            //Math.toRadians(ReturnArea); this was suppose to be returning the value if wanted to be radians
            ReturnArea = ReturnArea * (3.14159265359 / Math.toDegrees(180));

        }
        return ReturnArea;

    }
    private void displayArea(){

    } //had no idea what u wanted me to do with this. 
}
