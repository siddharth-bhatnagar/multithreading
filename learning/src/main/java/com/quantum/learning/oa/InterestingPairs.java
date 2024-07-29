package com.quantum.learning.oa;

import java.util.List;

public class InterestingPairs {

    protected int findInterestingPairs(List<Integer> arr, int sumValue) {

        // |a-b| + |a+b| = sumValue
        // |a-b| + |a+b| is always even
        // a or b can either be equal to sumValue/2 or be less than sumValue/2
        // https://leetcode.com/discuss/interview-question/5084258/DE-SHAW-OA-or-28-APR-2024-or-SMT-or-SOFTWARE-DEVELOPER-(BACKEND)-or/
        if (sumValue % 2 != 0) return 0;

        int same=0, less=0;
        for (int x: arr) {
            int p = Math.abs(x);
            if (p == sumValue/2) same++;
            else if(p < sumValue/2) less++;
        }

        return (same * less) + (same * (same - 1)) / 2;
    }
}
