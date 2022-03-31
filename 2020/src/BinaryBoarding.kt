class BinaryBoarding(rows: Int, columns: Int) {
    private val rowRange = (0 until rows).toList()
    private val columnRange = (0 until columns).toList()
    private var seatIds = ArrayList<Int>(rows * columns)

    init {
        var counter = 0
        for (row in rowRange) {
            for (column in columnRange) {
                // Generating a list of seat IDs for the flight
                seatIds.add(row * 8 + column)
                ++counter
            }
        }
    }

    fun findMySeat(boardingPass: String): Int {
        var rowRange = rowRange
        var columnRange = columnRange
        val rowDirections = boardingPass.slice(0 until 7)
        val columnDirections = boardingPass.slice(7 until 10)

        for (segment in rowDirections) {
            // Segments with F front or L right to keep lower half segment
            if (segment.compareTo('F') == 0 || segment.compareTo('L') == 0) {
                rowRange = rowRange.dropLast(rowRange.size/2)
            }
            else {
                rowRange = rowRange.drop(rowRange.size/2)
            }
        }

        for (segment in columnDirections) {
            // Segments with F front or L right have a lower half segment action
            if (segment.compareTo('F') == 0 || segment.compareTo('L') == 0) {
                columnRange = columnRange.dropLast(columnRange.size/2)
            }
            else {
                columnRange = columnRange.drop(columnRange.size/2)
            }
        }
        var mySeatID = rowRange[0] * 8 + columnRange[0]
        seatsTaken(mySeatID)
        return mySeatID
    }

    private fun seatsTaken(seatID: Int): Boolean {
        return seatIds.remove(seatID)
    }

    fun getRows(): Int {
        return rowRange.last() + 1
    }

    fun getAvailableSeats(): ArrayList<Int> {
        return seatIds
    }
}