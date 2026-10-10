package challenge.hashmap

private fun main() {
    val events = listOf(
        Event(1, "A"),
        Event(5, "A"),
        Event(12, "B"),
        Event(16, "A"),
    )
    val k = 10

    val lastProcessed = mutableMapOf<String, Int>()
    val result = mutableListOf<Event>()

    for (event in events) {
        val lastTime = lastProcessed[event.name]

        if (lastTime == null || event.timestamp - lastTime > k) {
            result.add(event)
            lastProcessed[event.name] = event.timestamp
        }
    }
}

data class Event(val timestamp: Int, val name: String)
