
fun main() {
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
        It's a completely full flight, so your seat should be the only missing boarding pass in your list.
        However, there's a catch: some seats at the very front and back of the plane don't exist on this aircraft,
        so they'll be missing from your list as well.
    */
    fun part2(input: List<String>): Int {
        var mySeat = 0
        var test = BinaryBoarding(128, 8)
        for (line in input) {
            // This will find the seat and track that it is taken
            test.findMySeat(line)
        }
        /*
            Now I gots to find the one that is available
            Weird info:
            Your seat wasn't at the very front or back, though; the seats with IDs +1 and -1 from yours will be in your list.
            I think this means that my seat won't fall in line with sequential seat blocking for the dead rows
            So I can assume that the first non-sequential number means I found where I can park my rear
        */
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
    // Can't really check part 2 since the test data was limited to only 4 seats
    //check(part2(testInput) == 0)

    val input = readInput("Day${dayNum}_input")
    println(part1(input))
    println(part2(input))
}