package leetcode.math.medium

/**
 * https://leetcode.com/problems/reverse-integer/
 */
private fun main() {
    val x = -123456
    val output = reverse(x)

    println("Input x = $x, Output = $output")
}

private fun reverse(x: Int): Int {
    var remaining = x.toLong()
    var reversedNumber = 0L

    while (remaining != 0L) {
        // Get the last digit.
        val lastDigit = remaining % 10
        // Add the digit to the reversed number.
        reversedNumber = reversedNumber * 10 + lastDigit
        // Remove the last digit.
        remaining /= 10
    }
    // Return 0 if the reversed number is outside the Int range.
    if (reversedNumber > Int.MAX_VALUE || reversedNumber < Int.MIN_VALUE) {
        return 0
    }
    return reversedNumber.toInt()

    /*
        Time complexity is O(log n)
        Space complexity is O(1)
     */
}
