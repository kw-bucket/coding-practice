package challenge.math

/**
 *
 */
private fun main() {
    val transactions = listOf(
        Transaction(id = 1, merchant = "A", amount = 100, time = 0),
        Transaction(id = 2, merchant = "A", amount = 200, time = 0),
        Transaction(id = 3, merchant = "B", amount = 100, time = 0),
        Transaction(id = 4, merchant = "A", amount = 100, time = 3),
        Transaction(id = 5, merchant = "A", amount = 100, time = 63),
        Transaction(id = 6, merchant = "B", amount = 100, time = 20),
        Transaction(id = 7, merchant = "A", amount = 100, time = 50),
    )
    println(
        """
            Original Transaction Ids: ${transactions.map { it.id }}
        """.trimIndent()
    )

    printDuplicateIdsUsingWindow(transactions = transactions)
    printDuplicateIdsUsingGroupBy(transactions = transactions)
}

data class Transaction(
    val id: Int,
    val merchant: String,
    val amount: Int,
    val time: Int,
)

private fun printDuplicateIdsUsingWindow(transactions: List<Transaction>) {
    val sortedTxns = transactions.sortedWith(
        comparator = compareBy<Transaction> { it.merchant }.thenBy { it.amount }.thenBy { it.time }
    )
    println(
        """
            --- --- --- printDuplicateIdsUsingWindow --- --- ---
            Sorted Transaction Ids: ${sortedTxns.map { it.id }}
        """.trimIndent()
    )

    val duplicateIds = mutableSetOf<Int>()

    sortedTxns.windowed(size = 2) {
        val isDuplicate =
            it[0].merchant == it[1].merchant &&
                    it[0].amount == it[1].amount &&
                    it[1].time - it[0].time < 60
        println(
            """
                :- ${it[0]} vs ${it[1]} -> $isDuplicate    
            """.trimIndent()
        )

        if (isDuplicate) {
            duplicateIds.addAll(listOf(it[0].id, it[1].id))
        }
    }

    println(
        """
            Duplicate Ids : $duplicateIds
            --- --- --- printDuplicateIdsUsingWindow --- --- ---
        """.trimIndent()
    )

    /*
        Time complexity is O(n log n),
            - `sortedWith` sorts all transactions → O(n log n).
            - `windowed` goes through the sorted transactions once → O(n).
            - `map` inside println goes through the transactions once → O(n).
            - `toSet` / `mutableSetOf` stores the duplicate IDs → O(n).
            - Sorting takes the most time, so the final complexity is O(n log n).

        Space complexity is O(n),
            - `sortedTxns` stores all sorted transactions → O(n).
            - `duplicateIds` stores duplicate IDs → O(n).
            - `windowed` uses a small window of 2 items → O(1).
            - So the final space complexity is O(n).
     */
}

private fun printDuplicateIdsUsingGroupBy(transactions: List<Transaction>) {
    val duplicateIds = transactions
        .groupBy { it.merchant }
        .mapValues { (_, group) ->
            group
                .asSequence()
                .sortedWith(comparator = compareBy<Transaction> { it.amount }.thenBy { it.time })
                .zipWithNext()
                .filter { (a, b) -> b.amount == a.amount && b.time - a.time < 60 }
                .flatMap { (a, b) -> listOf(a.id, b.id) }
                .toSet()
        }

    println(
        """
            Duplicate Ids : ${duplicateIds.values}
            --- --- --- printDuplicateIdsUsingGroupBy --- --- ---
        """.trimIndent()
    )

    /*
        Time complexity is O(n log n),
            - `groupBy` goes through all transactions → O(n).
            - `sortedWith` sorts the transactions → O(n log n).
            - `zipWithNext`, `filter`, `flatMap`, and `toSet` go through the data once → O(n).
            - Sorting takes the most time, so the final complexity is O(n log n).

        Space complexity is O(n),
            - `groupBy` stores all transactions in groups → O(n).
            - `sortedWith` needs extra memory for sorting → O(n).
            - `toSet` stores the duplicate IDs → O(n).
            - So the final space complexity is O(n).
     */
}
