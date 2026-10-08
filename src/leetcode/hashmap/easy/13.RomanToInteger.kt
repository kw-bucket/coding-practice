package leetcode.hashmap.easy

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 */
private fun main() {
    val s = "LVIII"
    val output = romanToInt(s)
    println("Input: $s, Output: $output")
}

private fun romanToInt(s: String): Int {
    val romanMap = hashMapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )

    return romanToIntWindowed(s, romanMap)
//    return romanToIntForLoop(s, romanMap)
}

private fun romanToIntWindowed(s: String, romanMap: Map<Char, Int>): Int {
    var result = 0
    // Use a window of size 2 to look at two characters at a time.
    s.windowed(2) {
        val current = romanMap.getValue(it[0])
        val next =  romanMap.getValue(it[1])

        if (current < next) {
            // Subtract the current value if it is smaller than the next value.
            result -= current
        } else {
            // Otherwise, add the current value.
            result += current
        }
    }
    // The loop end before the last character.
    // Add the last character to the final result.
    return result + romanMap.getValue(s.last())

    /*
        Time complexity is O(n)
            because we process each character once.

        Space complexity is O(1)
            because the Roman numeral map has a fixed number of entries
            and the window size is always 2.
     */
}

private fun romanToIntForLoop(s: String, romanMap: Map<Char, Int>): Int {
    var result = 0

    for (i in 1 .. s.lastIndex) {
        val current = romanMap.getValue(s[i-1])
        val next = romanMap.getValue(s[i])

        if (current < next) {
            result -= current
        } else {
            result += current
        }
    }

    return result + romanMap.getValue(s.last())
}
