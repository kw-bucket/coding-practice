package leetcode.stack.easy

import java.util.Stack
import kotlin.text.iterator

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
fun main() {
    val output = isValid("()()()()()")

    println("Valid Parentheses: $output")
}

private fun isValid(s: String): Boolean {
    // Use mapOf because we don't need to add/remove/update items.
    val bracketsMap = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '[',
    )
    val stack = Stack<Char>() /* ArrayDeque<Char>() */

    for (char in s) {
        // If it's an opening bracket
        if (bracketsMap.containsValue(char)) {
            // Push into stack
            stack.push(char) /* stack.addFirst(char) */
        }
        // If it's a closing bracket
        else if (bracketsMap.containsKey(char)) {
            // Check stack is not empty and this bracket match the expected opening bracket
            if (stack.isEmpty() || stack.pop() != bracketsMap.getValue(char)) {
                return false
            }
            /*
            if (stack.isEmpty() || stack.removeFirst() != bracketsMap.getValue(char)) {
                return false
            }
             */
        }
    }

    return stack.isEmpty()

    /*
        Time complexity is O(n)
            because we loop through each character in string.

        Space complexity is O(n)
            because we need to store elements in stack,
            in the worst case, we need to store all n characters (e.g. "((((((")
     */
    /*
        For Kotlin specifically, recommend ArrayDeque<Char> instead of Java's Stack,
        but for a coding interview, Stack<Char> is completely understandable.
     */
}
