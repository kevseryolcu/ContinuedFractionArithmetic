package com.company;

public class CF {
    private int denominator;
    private int numerator;
    private int quotient;

    public CF(int denominator, int numerator)
    {
        this.denominator = denominator;
        this.numerator = numerator;
        this.quotient = 0;
    }

    public int next()
    {
        if(denominator == 0)
        {
            return -1;
        }
        else if(numerator == 0)
        {
            //System.out.println("Continued Fraction is not valid!");
            return -2;
        }
        int remainder = denominator % numerator;
        quotient = (int)(denominator/numerator);
        denominator = numerator;
        numerator = remainder;
        return quotient;
    }

    public void print()
    {
        int i = this.next();
        while(i >= 0)
        {
            System.out.println(i);
            i = this.next();
        }
    }
}
