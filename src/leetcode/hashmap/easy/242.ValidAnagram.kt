package leetcode.hashmap.easy

import kotlin.text.iterator

/**
 * https://leetcode.com/problems/valid-anagram/
 */

private fun main() {
    val s = "anagram"
    val t = "ranagam"

    val output = isAnagram(s, t)

    println("Valid Anagram: $output")
}

private fun isAnagram(s: String, t: String): Boolean =
//    isAnagramBruteForce(s, t)
    isAnagramHashMap(s, t)

/**
 * 1.) Brute-force solution copy characters from `t` into a mutable list.
 * Then go through each character in `s` and remove the matching character from the list.
 */
private fun isAnagramBruteForce(s: String, t: String): Boolean {
    // Check the length, anagram must have same numbers of characters.
    if (s.length != t.length) {
        // If not, return false.
        return false
    }
    // Copy characters from `t` into a mutable list.
    val remainingChars = t.toMutableList()
    // Loop through every character in `s`
    for (char in s) {
        // Check if we can remove current character,
        // return false if the character doesn't exist.
        // And, list insertion/removal requires searching for it, so it can take O(n).
        if (!remainingChars.remove(char)) {
            // If the character doesn't exist, return false
            return false
        }
    }
    // All characters from `s` were found and removed, so they are anagrams.
    return true

    /*
        Time complexity is O(n^2)
            because loop through every character in `s` string take O(n),
            and list removal operation take O(n).

        Space complexity is O(n)
            because the mutable list grows with the input size.
            In the worst case, it stores all characters from `t`.
     */
}

/**
 * 2.) HashMap / Counting solution
 */
private fun isAnagramHashMap(s: String, t: String): Boolean {
    // Anagrams must have the same number of characters.
    if (s.length != t.length) {
        return false
    }
    // HashMap to store character count for `s`
    val charFrequencyS = hashMapOf<Char, Int>()
    // HashMap to store character count for `t`
    val charFrequencyT = hashMapOf<Char, Int>()

    // Loop through each character in `s`
    for (char in s) {
        // Increment the count for the current character.
        charFrequencyS[char] = (charFrequencyS[char] ?: 0) + 1
    }
    // Loop through each character in `t`
    for (char in t) {
        // Increment the count for the current character.
        charFrequencyT[char] = (charFrequencyT[char] ?: 0) + 1
    }
    // Compare character counts
    return charFrequencyS == charFrequencyT

    /*
        Time complexity is O(n)
            because we go through each string once.
            HashMap lookup and update are O(1) on average.

        Space complexity is O(n)
            because we use two HashMaps that can grow with the input size.
     */
}
