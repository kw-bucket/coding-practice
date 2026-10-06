package leetcode.easy

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
fun main() {
    val output = maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))

    println("Max profit: $output")
}

private fun maxProfit(prices: IntArray): Int =
//    maxProfitBruteForce(prices)
    maxProfitOptimized(prices)

/**
 * 1.) Brute-Force Solution
 */
private fun maxProfitBruteForce(prices: IntArray): Int {
    var maxProfit = 0
    // `i` represents buy day.
    for (i in 0 ..< prices.size - 1) {
        // `j` represents sell day. Since j starts from i + 1, you always sell after buying.
        for (j in i + 1..< prices.size) {
            val profit = prices[j] - prices[i]
            // Keep the maximum profit
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
    }

    return maxProfit

    /*
        Time complexity is O(n^2)
            because we check every possible buy/sell pair.

        Space complexity is O(1)
            because we don't use any variable that grows with the input size.
     */
}

/**
 * Optimized Solution
 *
 * We will keep track of the lowest price.
 * If we buy at the lowest price I've seen and sell today, what's my profit?
 */
private fun maxProfitOptimized(prices: IntArray): Int {
    // A variable to keep the maximum profit.
    var maxProfit: Int = 0
    // Keep track of the lowest price we've seen so far.
    var lowestPrice: Int = Int.MAX_VALUE
    // Loop through every price
    for (price in prices) {
        // If current price is lower.
        if (price < lowestPrice) {
            // Update the lowest price
            lowestPrice = price
        }
        // If not, and current profit is higher
        else if (price - lowestPrice > maxProfit) {
            // Update the maximum profit
            maxProfit = price - lowestPrice
        }
    }

    return maxProfit

    /*
        Time complexity is O(n)
            because we go through each element only once.

        Space complexity is O(1)
            because we don't use a variable that grows with the input size.
     */
}
