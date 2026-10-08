package leetcode.string.medium

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
private fun main() {
    val num = 3749
    val output = intToRoman(num)
    println("Input: $num, Output: $output")
}

private fun intToRoman(num: Int): String {
    val romanValues = listOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I",
    )
    var remaining = num

    val result = buildString {
        for ((value, symbol) in romanValues) {
            while (remaining >= value) {
                append(symbol)
                remaining -= value
            }
        }
    }

    return result

    /*
        Time complexity is O(1)
            because the number of roman values and the maximum output are both fixed.

        Space complexity is O(1)
            because romanValues list always contains 13 elements, regardless of the input.
     */
}
