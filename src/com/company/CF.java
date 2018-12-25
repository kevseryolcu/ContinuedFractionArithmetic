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
            return 0;
        }
        int remainder = denominator % numerator;
        quotient = (int)(denominator/numerator);
        denominator = numerator;
        numerator = remainder;
        return quotient;
    }
}
