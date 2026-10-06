package leetcode.easy

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers and a target,
 * return indices of two numbers that add up to target.
 *
 * Example:
 *   nums = [2, 7, 11, 15]
 *   target = 9
 *
 * Output: [0, 1]
 */

fun main() {
    val nums: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val target = 9

    val result = twoSum(nums, target)

    println(result.asList())
}

private fun twoSum(nums: IntArray, target: Int): IntArray =
//    twoSumBruteForce(nums, target)
    twoSumHashMap(nums, target)

/**
 * 1.) Brute-force solution use 2 nested loop to check every possible pair.
 */
private fun twoSumBruteForce(nums: IntArray, target: Int): IntArray {
    // Loop through each index in array.
    for (i in nums.indices) {
        // Loop to check every number after the current number.
        for (j in i + 1 ..< nums.size) {
            // Check if the two numbers can add up to the target.
            if (nums[i] + nums[j] == target) {
                // If yes, return the indices.
                return intArrayOf(i, j)
            }
        }
    }
    // Return empty array if no pair is found.
    return intArrayOf()

    /*
        Time complexity is O(n^2)
            because we have two nested loops.
            In the worse case, we check every pair of elements.

        Space complexity is O(1)
            because we use array of 2 elements
            that doesn't grow with the input size.
     */
}

/**
 * 2.) HashMap solution
 */
private fun twoSumHashMap(nums: IntArray, target: Int): IntArray {
    // A map to store number and their index we have already seen.
    val seen: HashMap<Int, Int> = hashMapOf()
    // Loop through each index in array.
    for (i in nums.indices) {
        // Calculate complement we need to reach to target.
        val complement = target - nums[i]
        // Check if we have already seen the complement.
        val previousIndex = seen[complement]
        if (previousIndex != null) {
            // If yes, return the indices
            return intArrayOf(i, previousIndex)
        }
        // If not, store the current number and its index in the map and keep going.
        seen[nums[i]] = i
    }
    // Return empty array if no pair is found
    return intArrayOf()

    /*
        Time complexity is O(n)
            because we loop through array only once,
            and HashMap lookup is O(1) on average.

        Space complexity is O(n)
            because, in the worst case, we store all n elements in the map.
     */
}
