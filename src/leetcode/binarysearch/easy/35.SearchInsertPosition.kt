package leetcode.binarysearch.easy

/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 *
 * If not, return the index where it would be if it were inserted in order.
 */
private fun main() {
    val nums = intArrayOf(1, 3, 5, 6)
    val target = 7

    val output = searchInsert(nums, target)
    println("Input: nums = ${nums.contentToString()}, target = $target, Output: $output")
}

private fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        // Find the middle index.
        val middle = left + (right - left) / 2

        if (target == nums[middle]) {
            // Return index if we find the target.
            return middle
        } else if (target > nums[middle]) {
            // Target is on the right half.
            left = middle + 1
        } else {
            // Target is on the left half.
            right = middle - 1
        }
    }
    // Target was not found.
    // At this point, left is the correct position to insert the target.
    return left

    /*
        Time complexity is O(log n)
            because we remove about half of the search space in each iteration.

        Space complexity is O(1)
            because we only use left, right, and middle; no extra data structure.
     */
}
