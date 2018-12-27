package com.cf.utils;

import com.cf.numbers.FractionNumber;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CFTransformUtil {

    public static FractionNumber toFraction(Iterator<BigInteger> iter) {
        final List<Long> terms = new ArrayList<>();
        while (iter.hasNext()) {
            terms.add(iter.next().longValue());
        }
        Collections.reverse(terms);

        FractionNumber r = null;
        for (Long term : terms) {
            if (r == null) {
                r = new FractionNumber(term);
            } else {
                r = new FractionNumber(term).add(r.reciprocal());
            }
        }
        return r;
    }

    public static double toDouble(Iterator<BigInteger> iter) {
        if (iter == null || toFraction(iter) == null) {
            return 0;
        }
        return toFraction(iter).doubleValue();
    }
}
