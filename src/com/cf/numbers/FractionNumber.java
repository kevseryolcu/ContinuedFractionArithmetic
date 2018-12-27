package com.cf.numbers;

import java.math.BigInteger;


public class FractionNumber {
	private BigInteger numerator;
	private BigInteger denominator;
	
	public FractionNumber(long numerator) {
		this(numerator, 1);
	}

	public FractionNumber(long numerator, long denominator) {
		this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
	}

	public FractionNumber(BigInteger numerator, BigInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		reduce();
	}

	public BigInteger num() {
		return numerator;
	}

	public BigInteger den() {
		return denominator;
	}

	protected void reduce() {
		final BigInteger gcd = numerator.gcd(denominator);
		numerator = numerator.divide(gcd);
		denominator = denominator.divide(gcd);

		if (denominator.signum() == -1) {
			denominator.negate();
			numerator.negate();
		}
	}

	public FractionNumber add(FractionNumber r) {
		return new FractionNumber(
				(numerator.multiply(r.denominator)).add(r.numerator.multiply(denominator)),
				denominator.multiply(r.denominator));
	}

	public FractionNumber reciprocal() {
		return new FractionNumber(denominator, numerator);
	}
	
	public double doubleValue() {
		return (double) numerator.longValue() / denominator.longValue();
	}

	@Override
	public String toString() {
		return String.format("%s/%s", numerator.toString(), denominator.toString());
	}
}
