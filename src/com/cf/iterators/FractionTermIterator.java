package com.cf.iterators;

import com.cf.numbers.FractionNumber;

import java.math.BigInteger;

public class FractionTermIterator extends TermIterator<BigInteger> {
	private FractionNumber r;

	public FractionTermIterator(FractionNumber r) {
		this.r = r;
	}

	protected BigInteger makeNext() {
		if (r.den().bitLength() == 0) return null;
		final BigInteger p = r.num().divide(r.den());
		if (p.bitLength() == 0) {
			r = r.reciprocal();
		} else {
			r = new FractionNumber(r.den(), r.num().subtract(p.multiply(r.den())));
		}
		return p;
	}
}