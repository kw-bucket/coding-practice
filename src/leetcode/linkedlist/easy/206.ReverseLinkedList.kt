package leetcode.linkedlist.easy

import leetcode.linkedlist.ListNode

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Given:
 *   1 → 2 → 3 → 4 → 5 → null
 * Reverse it to:
 *   5 → 4 → 3 → 2 → 1 → null
 */
fun main() {
    val head = ListNode(1)
        .apply { next = ListNode(2)
            .apply { next = ListNode(3)
                .apply { next = ListNode(4)
                    .apply { next = ListNode(5) }
                }
            }
        }

    val output = reverseList(head)

    println("Reversed List: $output")
}

private fun reverseList(head: ListNode?): ListNode? {
    // Start with no previous node
    var previous: ListNode? = null
    // Start from the head of the list
    var current = head

    while (current != null) {
        // Save the next nodes so we don't lose the rest of the list.
        val next = current.next
        // Reverse the current link to point to the previous node.
        current.next = previous
        // Make previous to the current node.
        previous = current
        // Move current to the next nod.
        current = next
    }

    return previous

    /*
        Time complexity is O(n)
            because we visit each node once.

        Space complexity is O(1)
            because we only use a few node references.
     */
}
