package com.codecool.tinkertailor;

import java.util.ArrayList;
import java.util.List;

class TinkerTailor {

    int n, k;

    public TinkerTailor(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public List execute() {
        List<Integer> outcome = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            start.add(i);
        }
        int position = 0;
        for (int j=0; j<n-1; j++) {
            position = calculateNewPosition(position, k, start.size());
            System.out.println(start.get(position));
            outcome.add(start.get(position));
            start.remove(position);
        }
        outcome.add(start.get(0));

//        outcome.add(3);
//        outcome.add(1);
//        outcome.add(5);
//        outcome.add(2);
//        outcome.add(4);

        // Works for n = 5 and k = 3
        // Well, you should come up with a more general algorithm :)

        return outcome;
    }

    private int calculateNewPosition(int position, int k, int size) {
        int remainder;
        remainder = size - position;
        if (remainder >= k) return position + k - 1;
        else if (remainder == 0) return 0;
        else return k%remainder-1;
    }
}