package leetcode.array.easy

/**
 * https://leetcode.com/problems/remove-element/
 *
 * You need to remove every occurrence of val in-place.
 *
 * Example:
 * nums = [3, 2, 2, 3]
 * val = 3
 *
 * After function: nums = [2, 2, _, _]
 * Output: 2
 */
private fun main() {
    val nums = intArrayOf(3, 2, 2, 3)
    val `val` = 3

    println("Input: ${nums.contentToString()}, val = $`val`")

    val output = removeElement(nums, `val`)

    println("Output: $output, nums = ${nums.take(output)}")
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
    // Keep the position for the next element we want to keep.
    var writeIndex = 0
    // Read every element in the array.
    for (readIndex in nums.indices) {
        if (nums[readIndex] != `val`) {
            // If the current number is NOT the target we want to remove.
            // Copy it to the write position.
            nums[writeIndex] = nums[readIndex]
            // Move write position one step forward.
            writeIndex++
        }

        println("- read: $readIndex, write: $writeIndex, nums: ${nums.contentToString()}")
    }
    // Return the total count of number we keep.
    return writeIndex

    /*
        Time complexity is O(n)
            because we scan the array once.

        Space complexity is O(1)
            because we only use a fixed number of variables.
     */
}
