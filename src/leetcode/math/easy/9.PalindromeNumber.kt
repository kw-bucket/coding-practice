package leetcode.math.easy

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Determine whether the number reads the same from left to right and right to left.
 *
 * 121 → palindrome
 * 123 → not palindrome
 * 1221 → palindrome
 *
 */
private fun main() {
    val x = 123
    val output = isPalindrome(x)

    println("Is $x palindrome? $output.")
}

private fun isPalindrome(x: Int): Boolean =
    isPalindromeByMath(x)
//    isPalindromeByString(x)

private fun isPalindromeByMath(x: Int): Boolean {
    // Negative cannot be palindrome, because of negative sign.
    if (x < 0) return false

    var remaining = x
    var reversedNumber = 0
    // Loop to process digit by digit.
    while (remaining > 0) {
        // Get the last digit by modulo ten.
        val lastDigit = remaining % 10
        // Add the digit into variable reversed.
        reversedNumber = reversedNumber * 10 + lastDigit
        // Remove last digit by diving by ten.
        remaining /= 10
    }

    return reversedNumber == x

    /*
        Time complexity is O(log n)
            because we divide the number by 10 in every iteration
            - Logarithm (log) means division.
            - Whenever your code repeatedly divides the input size by a number, the time complexity is logarithmic.

        Space complexity is O(1),
            - `number` takes 4 bytes. `reversed` takes 4 bytes. `digit` takes 4 bytes.
            - Memory used does not change (it remains constant) regardless of how big x is
     */
}

private fun isPalindromeByString(x: Int): Boolean {
    val numString = x.toString()
    var reversed = StringBuilder()

    for (i in numString.length - 1 downTo 0) {
        reversed.append(numString[i])
    }

    return reversed.toString() == numString

    /*
        Time complexity is O(n)
        Space complexity is O(n)
     */
}
