## 3. Budget Shopping
A school has provided a teacher with a budget to purchase math notebooks that students need. 
Several stores sell bundles of notebooks at various price. 
The teacher wants to purchase as many notebooks as possible within the budget, but can only purchase full bundles.  

Determine the maximum number of notebooks the teacher can purchase.  

For example, the teacher has n= $50 and there are m = 2 stores. 
The first sells bundles of 20 notebooks for $12 each. 
The second sells bundles of only 1 notebook for $2 each. 
The teacher can buy 4 bundles of 20 for $48 leaving $2.
The teacher can then go to the second store and purchase 1 more notebook for $2, for a total of 81 notebooks.

**Function Description**  
Complete the function _budgetShopping_ in the editor below.

budgetShopping has the following parameter(s):  
int budget: the amount of money in the notebook budget  
int bundleQuantities[n]: the number of notebooks in a bundle at shop[i]  
int bundleCosts[n]: the cost of a bundle of notebooks at shop[i]  

**Return**  
int: the maximum number of notebooks that can be purchased.  

**Constraints**  
- 1 <= budget <= 10^4
- 1 <= n <= 10^2
- 1 <= bundleQuantities[i] <=20
- 1 <= bundleCosts[i] <= 200

**Sample Case 0**  
Sample Input  
- budget = 4
- bundleQuantities[] size n = 1
- bundleQuantities = [10]
- bundleCosts[] size n = 1
- bundleCosts = [2]

Sample Output  
20  
Explanation  
2 bundles of 10 notebooks from shop 0 at a cost of 2 leaves budget = 4 - 4 = 0.  


