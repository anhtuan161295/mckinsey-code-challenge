package com.mckinsey.budgetshopping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    // https://makolyte.com/algorithm-explained-get-the-max-items-you-can-purchase-with-a-fixed-budget/
    // buy with the lowest price
    public static int budgetShoppingV2(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
        Map<Integer, Integer> costMap = new TreeMap<>();
        for (int i = 0; i < bundleQuantities.size(); i++) {
            costMap.put(bundleCosts.get(i), bundleQuantities.get(i));
        }

        int maxQuantity = 0;
        for (Map.Entry<Integer, Integer> entry : costMap.entrySet()) {
            int budget = n;
            int quantity = 0;
            int bundleCost = entry.getKey();
            int bundleQuantity = entry.getValue();
            while (budget - bundleCost >= 0) {
                budget -= bundleCost;
                quantity += bundleQuantity;
            }
            maxQuantity = Math.max(maxQuantity, quantity);
        }

        return maxQuantity;
    }

    // this approach will get Time Limit Exceeded
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
        List<Integer> quantities = Arrays.asList(10);
        List<Integer> costs = Arrays.asList(2);

        int i = budgetShoppingV2(4, quantities, costs);
        System.out.println("Max shopping " + i); // 20

        List<Integer> quantities2 = Arrays.asList(20, 19);
        List<Integer> costs2 = Arrays.asList(24, 20);

        int i2 = budgetShoppingV2(50, quantities2, costs2);
        System.out.println("Max shopping " + i2); // 40
    }
}
