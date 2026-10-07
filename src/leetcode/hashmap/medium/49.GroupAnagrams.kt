package leetcode.hashmap.medium

import kotlin.text.iterator

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings, group the anagrams together.
 *
 * Example:
 *
 * Input:  ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output:
 * [
 *     ["eat", "tea", "ate"],
 *     ["tan", "nat"],
 *     ["bat"]
 * ]
 *
 * Input: [""]
 * Output: [[""]]
 */
fun main() {
    val output = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))

    println("Group Anagrams: $output")
}

private fun groupAnagrams(strs: Array<String>): List<List<String>> =
    groupAnagramsHashMap(strs)
//    groupAnagramsBruteForce(strs)

/**
 * 1.) Brute-Force solution
 */
private fun groupAnagramsBruteForce(strs: Array<String>): List<List<String>> {
    // A map to store groups of anagrams.
    val anagramsGroup = mutableMapOf<String, List<String>>()
    // Loop through each string.
    for (str in strs) {
        // Sort the characters to create a key.
        val sortedStr = str.toList().sorted().joinToString("")
        // Add current string to its anagram group.
        anagramsGroup[sortedStr] = (anagramsGroup[sortedStr] ?: listOf()) + str
    }

    return anagramsGroup.values.toList()

    /*
        n = number of strings
        k = average length of each string

        Time complexity is O(n * k log k)
            because we go through each string once,
            and sorting each string takes O(k log k).

        Space complexity is O(n * k)
            because we use map to store all the strings.
     */
}

/**
 *
 */
private fun groupAnagramsHashMap (strs: Array<String>): List<List<String>> {
    // A map to store groups of anagrams by char frequency.
    val anagramsGroup = mutableMapOf<Map<Char, Int>, List<String>>()
    // Loop through each string.
    for (str in strs) {
        // A map to store character count for str.
        val charFrequency = mutableMapOf<Char, Int>()
        // Loop through each character.
        for (char in str) {
            // Increment the count for the current character.
            charFrequency[char] = (charFrequency[char] ?: 0) + 1
        }
        // Create an immutable key from the completed frequency map. Take O(k)
        val key = charFrequency.toMap()

        // Adding current string to its anagram group.
        anagramsGroup[key] = (anagramsGroup[key] ?: listOf()) + str
    }

    return anagramsGroup.values.toList()

    /*
        n = number of strings
        k = average length of each string

        Time complexity is O(n * k)
            because we go through each string and count each character once.

        Space complexity is O(n * k)
            because we store all the strings in the groups,
            and we also create character-frequency maps.
     */
}
