
fun main() {
    /*
        part 1 comment
    */
    fun part1(input: List<String>): Int {
        var toiletSeat = 0
        var test = BinaryBoarding(128, 8)
        for (line in input) {
            var newSeat = test.findMySeat(line)
            if (newSeat > toiletSeat) {
                toiletSeat = newSeat
            }
        }

        return toiletSeat
    }

    /*
        part 2 comment
    */
    fun part2(input: List<String>): Int {
        var mySeat = 0
        var test = BinaryBoarding(128, 8)
        for (line in input) {
            test.findMySeat(line)
        }
        for (seat in test.getAvailableSeats()) {
            if (seat == mySeat) {
                ++mySeat
            }
            else {
                return seat
            }
        }
        return 0
    }

    val dayNum = "05"
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${dayNum}_test")
    check(part1(testInput) == 820)
    //check(part2(testInput) == 0)

    val input = readInput("Day${dayNum}_input")
    println(part1(input))
    println(part2(input))
}