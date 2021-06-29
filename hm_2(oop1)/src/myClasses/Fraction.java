package myClasses;
import java.math.*;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("denominator is zero");
        }
        if(denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction()
    {
        numerator = denominator = 1;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public byte byteValue() {
        return (byte) this.doubleValue();
    }

    public double doubleValue() {
        return ((double) numerator)/((double) denominator);
    }

    public float floatValue() {
        return (float) this.doubleValue();
    }

    public int intValue() {
        return (int) this.doubleValue();
    }

    public long longValue() {
        return (long) this.doubleValue();
    }

    public short shortValue() {
        return (short) this.doubleValue();
    }

    public boolean equals(Fraction frac) {
        return this.compareTo(frac) == 0;
    }

    public Fraction add(Fraction b)
    {
        // check preconditions
        if ((denominator == 0) || (b.denominator == 0))
            throw new IllegalArgumentException("invalid denominator");
        // find lowest common denominator
        int common = lcd(denominator, b.denominator);
        // convert fractions to lcd
        Fraction commonA = new Fraction();
        Fraction commonB = new Fraction();
        commonA = convert(common);
        commonB = b.convert(common);
        // create new fraction to return as sum
        Fraction sum = new Fraction();
        // calculate sum
        sum.numerator = commonA.numerator + commonB.numerator;
        sum.denominator = common;
        // reduce the resulting fraction
        sum = sum.reduce();
        return sum;
    }

    public Fraction subtract(Fraction b)
    {
        // check preconditions
        if ((denominator == 0) || (b.denominator == 0))
            throw new IllegalArgumentException("invalid denominator");
        // find lowest common denominator
        int common = lcd(denominator, b.denominator);
        // convert fractions to lcd
        Fraction commonA = new Fraction();
        Fraction commonB = new Fraction();
        commonA = convert(common);
        commonB = b.convert(common);
        // create new fraction to return as difference
        Fraction diff = new Fraction();
        // calculate difference
        diff.numerator = commonA.numerator - commonB.numerator;
        diff.denominator = common;
        // reduce the resulting fraction
        diff = diff.reduce();
        return diff;
    }

    public Fraction multiply(Fraction b)
    {
        // check preconditions
        if ((denominator == 0) || (b.denominator == 0))
            throw new IllegalArgumentException("invalid denominator");
        // create new fraction to return as product
        Fraction product = new Fraction();
        // calculate product
        product.numerator = numerator * b.numerator;
        product.denominator = denominator * b.denominator;
        // reduce the resulting fraction
        product = product.reduce();
        return product;
    }

    public Fraction divide(Fraction b)
    {
        // check preconditions
        if ((denominator == 0) || (b.numerator == 0))
            throw new IllegalArgumentException("invalid denominator");
        // create new fraction to return as result
        Fraction result = new Fraction();
        // calculate result
        result.numerator = numerator * b.denominator;
        result.denominator = denominator * b.numerator;
        // reduce the resulting fraction
        result = result.reduce();
        return result;
    }

    /* Method: lcd Purpose: find lowest common denominator, used to add and subtract fractions*/
    private int lcd(int denom1, int denom2)
    {
        int factor = denom1;
        while ((denom1 % denom2) != 0)
            denom1 += factor;
        return denom1;
    }

    /**********************************************************
     Method:         gcd
     Purpose:        find greatest common denominator, used to reduce
     fractions */
    private int gcd(int denom1, int denom2)
    {
        int factor = denom2;
        while (denom2 != 0) {
            factor = denom2;
            denom2 = denom1 % denom2;
            denom1 = factor;
        }
        return denom1;
    }

    /**********************************************************
     Method:         convert
     Purpose:        convert a fraction to an equivalent one based on
     a lowest common denominator*/
    private Fraction convert(int common)
    {
        Fraction result = new Fraction();
        int factor = common / denominator;
        result.numerator = numerator * factor;
        result.denominator = common;
        return result;
    }

    /**********************************************************
     Method:         reduce
     Purpose:        convert the "this" fraction to an equivalent one
     based on a greatest common denominator*/
    private Fraction reduce()
    {
        Fraction result = new Fraction();
        int common = 0;
        // get absolute values for numerator and denominator
        int num = Math.abs(numerator);
        int den = Math.abs(denominator);
        // figure out which is less, numerator or denominator
        if (num > den)
            common = gcd(num, den);
        else if (num < den)
            common = gcd(den, num);
        else  // if both are the same, don't need to call gcd
            common = num;

        // set result based on common factor derived from gcd
        result.numerator = numerator / common;
        result.denominator = denominator / common;
        return result;
    }

    @Override
    public boolean equals(Object o){
        Fraction f = (Fraction)o;
        if(o instanceof Fraction){
            if (this.numerator == f.numerator && this.denominator == f.denominator){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    //Check if two object are equal and return as an integer
    public int compareTo(Object o){
        Fraction f = (Fraction)o;
        if(o instanceof Fraction){//check if this object is an instance of Fraction constructor
            //cross multiply
            if(this.numerator*f.denominator > f.numerator*this.denominator){
                return 1;
            }else if(this.numerator*f.denominator < f.numerator*this.denominator){
                return -1;
            }else{
                return 0;
            }
        }else{
            throw new ClassCastException("Wrong type");
        }
    }
    //Convert number to display as a string
    @Override
    public String toString() {
        String idk1 = Integer.toString(this.numerator); //convert fraction to string
        String idk2 = Integer.toString(this.denominator);
        if (idk2 == "1") { //check for whole number
            return idk1;
        } else {
            String wtf = idk1 + "/" + idk2;
            return wtf;
        }
    }
}
