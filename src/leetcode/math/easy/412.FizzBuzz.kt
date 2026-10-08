package leetcode.math.easy

/**
 * https://leetcode.com/problems/fizz-buzz/
 */
private fun main() {
    val n = 15
    val output = fizzBuzz(n)
    println("Input: $n, Output: $output")
}

private fun fizzBuzz(n: Int): List<String> {
    val result = mutableListOf<String>()

    for (i in 1..n) {
        result += if (i % 15 == 0) {
            "FizzBuzz"
        } else if (i % 3 == 0) {
            "Fizz"
        } else if (i % 5 == 0) {
            "Buzz"
        } else {
            i.toString()
        }
    }

    return result

    /*
        Time complexity is O(n)
            because we check every number from 1 to n.

        Space complexity is O(n)
            because we store the result for every number.
     */
}
