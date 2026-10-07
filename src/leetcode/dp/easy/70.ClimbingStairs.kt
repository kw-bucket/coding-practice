package leetcode.dp.easy

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
private fun main() {
    val output = climbStairs(3)

    println("Climbing ways: $output")
}

private fun climbStairs(n: Int): Int {
    if (n <= 2) return n

    var previous2 = 1
    var previous1 = 2

    for (step in 3..n) {
        val current = previous1 + previous2

        previous2 = previous1
        previous1 = current
    }

    return previous1
}
