package com.cf.numbers;

import com.cf.iterators.FractionTermIterator;
import com.cf.iterators.CachingIterable;
import com.cf.utils.DisplayUtil;

import java.math.BigInteger;
import java.util.Iterator;

public class ContinuedFractionNumber implements
	Iterable<BigInteger>,
	Comparable<ContinuedFractionNumber> {
	
	private final CachingIterable<BigInteger> iterable;

	public ContinuedFractionNumber(int l) {
		this(new FractionNumber(l));
	}

	public ContinuedFractionNumber(FractionNumber r) {
		this(new FractionTermIterator(r));
	}

	public ContinuedFractionNumber(Iterator<BigInteger> iter) {
		this.iterable = new CachingIterable<BigInteger>(iter);
	}

	public int compareTo(ContinuedFractionNumber o) {
		Iterator<BigInteger> iter0 = iterator();
		Iterator<BigInteger> iter1 = o.iterator();
		while (true) {
			if (!iter0.hasNext() && !iter1.hasNext()) {
				return 0;
			}
			if (iter0.hasNext() && !iter1.hasNext()) {
				return 1;
			}
			if (!iter0.hasNext() && iter1.hasNext()) {
				return -1;
			}

			final BigInteger i0 = iter0.next();
			final BigInteger i1 = iter1.next();
			final int cmp = i0.compareTo(i1);
			if (cmp != 0) return cmp;
		}
	}

	public Iterator<BigInteger> iterator() {
		return iterable.iterator();
	}

	@Override
	public String toString() {
		return DisplayUtil.writeListNotation(iterator());
	}
}
