package leetcode.binarysearch.medium

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * You have a sorted array that has been rotated: [4, 5, 6, 7, 0, 1, 2]
 * Given a target, return its index.
 *
 * Example:
 * nums = [4, 5, 6, 7, 0, 1, 2]
 * target = 0
 * output = 4
 */

fun main() {
    val output = search(
        nums = intArrayOf(4, 5, 6, 7, 0, 1, 2),
        target = 0,
    )

    println("Search in rotated sorted array result: $output")
}

private fun search(nums: IntArray, target: Int): Int {
    // Store the left index.
    var left = 0
    // Store the right index.
    var right = nums.size - 1

    // Continue while the search range is valid.
    while (left <= right) {
        // Calculate the middle index between left and right.
        val middle = left + (right - left) / 2

        if (target == nums[middle]) {
            // If the target is found, return its index.
            return middle
        } else if (nums[left] <= nums[middle]) {
            // The left half is sorted.
            if (target >= nums[left] && target < nums[middle]) {
                // If the target is inside the left half, search left.
                right = middle - 1
            } else {
                // Otherwise, search the right half.
                left = middle + 1
            }
        }
        else {
            // Otherwise, the right half is sorted.
            if (target > nums[middle] && target <= nums[right]) {
                // If the target is inside the right half, search right.
                left = middle + 1
            } else {
                // Otherwise, search the left half.
                right = middle - 1
            }
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
