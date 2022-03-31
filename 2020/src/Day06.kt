fun main() {
    /*
        part 1 comment
    */
    fun part1(input: List<String>): Int {
        var result = 0
        var answers: MutableSet<Char> = mutableSetOf()

        for (line in input) {
            answers.addAll(line.toList())

            // start new group
            if (line.isBlank()) {
                result += answers.size
                answers = mutableSetOf()
            }
        }
        result += answers.size

        return result
    }

    /*
        part 2 comment
    */
    fun part2(input: List<String>): Int {
        var result = 0
        var answers: MutableList<List<Char>> = mutableListOf()

        for (line in input) {
            // start new group
            if (line.isBlank()) {
                result += answers.reduce { acc, chars -> acc.intersect(chars).toList() }.size
                answers = mutableListOf()
            } else {
                answers.add(line.toList())
            }
        }
        result += answers.reduce { acc, chars -> acc.intersect(chars).toList() }.size

        return result
    }

    val dayNum = "06"
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${dayNum}_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 6)

    val input = readInput("Day${dayNum}_input")
    println(part1(input))
    println(part2(input))
}