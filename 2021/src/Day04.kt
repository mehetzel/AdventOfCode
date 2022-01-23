fun main() {
    /*
        part 1 comment
    */
    fun part1(input: List<String>): Int {
        val calledNumbers = input[0].trim().split(",")
        val bingoBoards = ArrayList<Bingo>()

        for (index in 1 until input.size step 6) {
            val newBoard = Bingo(input.subList(index + 1, index + 6))
            bingoBoards.add(newBoard)
        }

        for (number in calledNumbers) {
            for (board in bingoBoards) {
                board.markCell(number)
                if (board.screamBingo()) {
                    return number.toInt() * board.getUnmarkedSum()
                }
            }
        }
        return 0
    }

    /*
        part 2 comment
    */
    fun part2(input: List<String>): Int {
        val calledNumbers = input[0].trim().split(",")
        val bingoBoards = ArrayList<Bingo>()
        val losingBoards = ArrayList<Bingo>()

        for (index in 1 until input.size step 6) {
            val newBoard = Bingo(input.subList(index + 1, index + 6))
            bingoBoards.add(newBoard)
        }
        losingBoards.addAll(bingoBoards)
        for (number in calledNumbers) {
            for (board in bingoBoards) {
                board.markCell(number)
                if (board.screamBingo()) {
                    losingBoards.remove(board)
                    println(losingBoards)
                }
                if (losingBoards.size == 0) {
                    return number.toInt() * board.getUnmarkedSum()
                }
            }
        }
        return 0
    }

    val dayNum = "4"
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day0${dayNum}_test")
    check(part1(testInput) == 4512)
    println(part2(testInput))
    //check(part2(testInput) == 1924)

    val input = readInput("Day0${dayNum}_input")
    //println(part1(input))
    //println(part2(input))
}