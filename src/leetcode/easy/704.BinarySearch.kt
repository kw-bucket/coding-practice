package leetcode.easy

/**
 * https://leetcode.com/problems/binary-search/
 *
 * Given a sorted array of integers nums and a target value, return the index of target.
 * If target does not exist, return -1.
 *
 * Example:
 * nums = [1, 3, 5, 7, 9]
 * target = 7
 * output = 3
 *
 * nums = [1, 3, 5, 7, 9]
 * target = 4
 * output = -1
 */
fun main() {
    val output = search(
        nums = intArrayOf(-1, 0, 3, 5, 9, 12),
        target = 9,
    )

    println("Binary search result: $output")
}

private fun search(nums: IntArray, target: Int): Int {
    // Store the left index.
    var left = 0
    // Store the right index.
    var right = nums.size - 1

    // Loop continues as long as the search range is valid
    while (left <= right) {
        // Calculate the middle index between left and right.
        val middle = left + (right - left) / 2
        // If the target is found.
        if (nums[middle] == target) {
            // Return target's index.
            return middle
        } else if (nums[middle] < target) {
            // If the middle value is less than the target.
            // Search the right half.
            left = middle + 1
        } else /*else if (nums[middle] > target)*/ {
            // If the middle value is greater than the target.
            // Search the left half.
            right = middle - 1
        }
    }

    return -1

    /*
        Time complexity is O(log n)
            because we cut the search space in half in each iteration.

        Space complexity is O(1)
            because we only use a constant amount of extra space.
     */
}
