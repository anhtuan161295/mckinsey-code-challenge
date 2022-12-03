package com.mckinsey.budgetshopping;

import java.util.Arrays;
import java.util.List;

public class Result {

    /*
     * Complete the 'budgetShopping' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY bundleQuantities
     *  3. INTEGER_ARRAY bundleCosts
     */

    public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
        // Write your code here
        return exploreCombinations(n, 0, 0, bundleQuantities, bundleCosts);

    }

    static int exploreCombinations(int budget, int currentQuantity, int currentCost, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
        int maxQuantity = currentQuantity;
        for (int i = 0; i < bundleQuantities.size(); i++) {
            int bundleCost = bundleCosts.get(i);
            int bundleQuantity = bundleQuantities.get(i);
            if (currentCost + bundleCost <= budget) {
                int amount = exploreCombinations(budget, currentQuantity + bundleQuantity, currentCost + bundleCost, bundleQuantities, bundleCosts);
                if (maxQuantity < amount) {
                    maxQuantity = amount;
                }
            }
        }
        return maxQuantity;
    }

    public static void main(String[] args) {
        List<Integer> quantities = Arrays.asList(20, 19);
        List<Integer> costs = Arrays.asList(24, 20);

        int i = budgetShopping(50, quantities, costs);
        System.out.println("Max shopping "+i);
    }
}
