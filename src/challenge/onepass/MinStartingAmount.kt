package challenge.onepass

/**
 * To find the minimum starting amount.
 *
 * Example:
 *   Input:
 *     senders = "BAA" (First B transfers to A, then A transfers twice to B)
 *     amounts = intArrayOf(10, 15, 5)
 *
 *   Output: [10, 10] (Account A needs 10, Account B needs 10)
 */
fun main() {
//    val output = transfer(
//        senders = "BAA",
//        amounts = intArrayOf(10, 15, 5)
//    )
    val output = transfer(
        senders = "AAA",
        amounts = intArrayOf(5, 10, 5)
    )

    println("Minimum Starting Amounts [A,B]: ${output.contentToString()}")
}

private fun transfer(senders: String, amounts: IntArray): IntArray {
    var balanceA = 0
    var balanceB = 0

    var minStartA = 0
    var minStartB = 0

    for (i in senders.indices) {
        if (senders[i] == 'B') {
            // If money goes to A.
            // A gets the money.
            balanceA += amounts[i]
            // B gives the money.
            balanceB -= amounts[i]

            if (balanceB < minStartB) {
                // If B now has less money than ever before.
                // Update minimum starting amount for B.
                minStartB = balanceB
            }

        } else if (senders[i] == 'A') {
            // If money goes to B.
            // B gets the money.
            balanceB += amounts[i]
            // A gives the money.
            balanceA -= amounts[i]

            if (balanceA < minStartA) {
                // If A now has less money than ever before.
                // Update minimum starting amount for A.
                minStartA = balanceA
            }
        }
    }

    // Turn the lowest negative levels into positive numbers
    return intArrayOf(-minStartA, -minStartB)

    /*
        Time complexity is O(n)
            because there is only one loop looks at each transaction one by one

        Space complexity is O(1)
            because there are only 4 simple variables to count the money
     */
}
