package leetcode.array.easy

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * The array is already sorted, so duplicates are next to each other.
 *
 * Example: [1, 1, 2, 2, 3]
 * You want: [1, 2, 3, _, _]
 * And return: 3
 *
 */
private fun main() {
    val nums = intArrayOf(1, 1, 2, 2, 3)
    println("Input: ${nums.contentToString()}")

    val output = removeDuplicates(nums)
    println("Output: $output, nums = ${nums.take(output)}")
}

private fun removeDuplicates(nums: IntArray): Int {
    // If array is empty, there are unique elements.
    if (nums.isEmpty()) return 0
    // The first element is always unique.
    var writeIndex = 1
    // Start reading from the second elements
    for (readIndex in 1..< nums.size) {
        // Compare with the last unique value.
        if (nums[readIndex] != nums[writeIndex - 1]) {
            // Copy the new unique value to the write position.
            nums[writeIndex] = nums[readIndex]
            // Move the write position forward.
            writeIndex++
        }
    }
    // Return the number of unique elements
    return writeIndex

    /*
        Time complexity is O(n)
            The code use one loop that visit each number exactly one time.

        Space complexity is O(1)
            The code change original list directly. It does not create a new list.

     */
}
