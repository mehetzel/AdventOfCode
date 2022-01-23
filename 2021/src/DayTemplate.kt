fun main() {
    /*
        part 1 comment
    */
    fun part1(input: List<String>): Int {
        return 0
    }

    /*
        part 2 comment
    */
    fun part2(input: List<String>): Int {
        return 0
    }

    val dayNum = "0"
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day0${dayNum}_test")
    check(part1(testInput) == 0)
    check(part2(testInput) == 0)

    val input = readInput("Day0${dayNum}_input")
    println(part1(input))
    println(part2(input))
}