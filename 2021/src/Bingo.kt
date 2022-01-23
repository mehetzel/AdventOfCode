// Dis for day 4
class Bingo(boardNumbers: List<String>) {
    private val rowGrid = Array(5) { ArrayList<String>() }
    private val columnGrid = Array(5) { ArrayList<String>() }
    private val winningRow = arrayListOf("x","x","x","x","x")
    private var hasWon = false
    private var boardSum = 0
    // init takes in numbers to build out board
    init {
        for (index in boardNumbers.indices) {
            // due to how we did arraylist, we aren't enforcing 5 values in row
            rowGrid[index] = ArrayList(boardNumbers[index].trim().split("\\s+".toRegex()))
            for (valueIndex in 0 until rowGrid[index].size) {
                columnGrid[valueIndex].add(rowGrid[index][valueIndex])
                boardSum += rowGrid[index][valueIndex].toInt()
            }
        }
    }
    // method to mark cell as drawn number
    fun markCell(calledNumber: String) {
        for (x in rowGrid.indices) {
            for (y in columnGrid.indices) {
                if (calledNumber == rowGrid[x][y]) {
                    rowGrid[x][y] = "x"
                    columnGrid[y][x] = "x"
                    boardSum -= calledNumber.toInt()
                    if (rowGrid.contains(winningRow) || columnGrid.contains(winningRow)) {
                        hasWon = true
                    }
                    return
                }
            }
        }
    }
    // method to say if bingo was his name-o
    fun screamBingo(): Boolean {
        return hasWon
    }
    // method getter
    fun getUnmarkedSum(): Int {
        return boardSum
    }

    override fun toString(): String {
        return rowGrid[0].joinToString(separator = " ")
    }

    override fun equals(other: Any?): Boolean {
        return rowGrid.toString() == other.toString()
    }
}