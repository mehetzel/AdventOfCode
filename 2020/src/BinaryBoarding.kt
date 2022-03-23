class BinaryBoarding(rows: Int, columns: Int) {
    private val rowRange = (0 until rows).toList()
    private val columnRange = (0 until columns).toList()

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

        return rowRange[0] * 8 + columnRange[0]
    }

    fun getRows(): Int {
        return rowRange.last() + 1
    }
}