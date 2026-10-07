package leetcode.graph.medium

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically.
 *
 * You may assume all four edges of the grid are all surrounded by water.
 *
 */
private fun main() {
    val grid = arrayOf(
        charArrayOf('1','1','1','1','0'),
        charArrayOf('1','1','0','1','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','0','0','1'),
    )
    val output = numIslands(grid)

    for (row in grid) {
        println(row.joinToString(""))
    }
    println("---")
    println("Number of Islands: $output")
}

private fun numIslands(grid: Array<CharArray>): Int {
    // If the grid is empty, there are no islands.
    if (grid.isEmpty()) return 0

    var numIslands = 0

    // Visit every cell in the grid.
    for (row in grid.indices) {
        for (col in grid[row].indices) {
            if (grid[row][col] == '1') {
                // We found a new island.
                numIslands++
                // Explore and mark all connected land cells.
                exploreIsland(grid, row, col)
            }
        }
    }

    return numIslands
}

private fun exploreIsland(grid: Array<CharArray>, row: Int, col: Int) {
    // Stop if the position is outside the grid
    // or if this cell is not unvisited land.
    if (row < 0 || row >= grid.size ||
        col < 0 || col >= grid[row].size ||
        grid[row][col] != '1') {
        return
    }
    // Mark the cell as visited.
    grid[row][col] = 'X'

    // Explore the cell above.
    exploreIsland(grid, row - 1 , col)
    // Explore the cell below.
    exploreIsland(grid, row + 1, col)
    // Explore the cell on the left.
    exploreIsland(grid, row, col - 1)
    // Explore the cell on the right.
    exploreIsland(grid, row, col + 1)
}
