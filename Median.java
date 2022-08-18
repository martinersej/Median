// Version: 20200917
// Handin done by:
//   202108331 Martin Pugdal Pedersen
// Contributions:
//   Martin Everything

import java.io.*;
import java.util.*;

public class Median {
    private PriorityQueue<Integer> tree = new PriorityQueue<>();
    
    public void add(int x) {
        tree.add(x);
    }
    
    public int median() {
        if (tree.size() == 1) {
            return tree.peek();
        }
        PriorityQueue<Integer> tree1 = new PriorityQueue<>();
        PriorityQueue<Integer> tree2 = new PriorityQueue<>(11, Collections.reverseOrder());
        double sum = 0;
        for (Integer t : tree) {
            tree1.add(t);
            tree2.add(t);
        }
        for (int i = 0; i < (tree1.size()/2); i++) {
            tree1.poll();
            tree2.poll();
            if (tree1.peek() == tree2.peek()) {
                return tree1.peek();
            }
        }
        return tree1.peek();
    }
}