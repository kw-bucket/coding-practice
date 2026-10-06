package leetcode.easy

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Given an array of integer,
 * return true if array contains duplicate, otherwise, false
 *
 * Example:
 *   nums = [1,2,3,1]
 * Output:
 *   true
 */

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 1)
    val output = containsDuplicate(nums)

    println("Contains duplicate: $output")
}

private fun containsDuplicate(nums: IntArray): Boolean =
//    containsDuplicateBruteForce(nums)
    containsDuplicateHashSet(nums)

/**
 * 1.) Brute-force solution use 2 nested loop to check every pair of numbers.
 */
private fun containsDuplicateBruteForce(nums: IntArray): Boolean {
    // Loop through each index in array.
    for (i in nums.indices) {
        // Loop to check every number after the current number.
        for (j in i + 1 ..< nums.size) {
            // Check if there's a duplicate numbers.
            if (nums[i] == nums[j]) {
                // If yes, return true.
                return true
            }
        }
    }
    // Return false, if there's no duplicate numbers.
    return false

    /*
        Time complexity is O(n^2)
            because we use two nested loop.
            In the worse case, we check every pair of elements.

        Space complexity is O(1)
            because we don't use any extra data structure
            that grow with the input size.
     */
}

/**
 * 2.) HashSet solution
 */
private fun containsDuplicateHashSet(nums: IntArray): Boolean {
    // A HashSet to store number we have already seen.
    val seen = hashSetOf<Int>()
    // Loop through each index in array.
    for (i in nums.indices) {
        // Try to add the current number.
        // If it is already in the set, add() returns false.
        if (!seen.add(nums[i])) {
            // The number is already in the set, so we found a duplicate.
            return true
        }
    }
    // Return false, if there's no duplicate numbers
    return false

    /*
        Time complexity is O(n)
            because we loop through array only once,
            and HashSet add/search is O(1) on average.

        Space complexity is O(n)
            because we use data structure that grow with the input size.
            In the worst case, we store all n elements.
     */
}
