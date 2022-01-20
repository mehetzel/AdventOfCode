fun main() {
    /*
        It seems like the submarine can take a series of commands like forward 1, down 2, or up 3:

        forward X increases the horizontal position by X units.
        down X increases the depth by X units.
        up X decreases the depth by X units.
    */
    fun part1(input: List<String>): Int {
        var horizontalPos = 0
        var depth = 0

        for (action in input){
            var splitMovement = action.split(" ")
            when (splitMovement[0]) {
                "forward" -> {
                    horizontalPos += splitMovement[1].toInt()
                }
                "down" -> {
                    depth += splitMovement[1].toInt()
                }
                "up" -> {
                    depth -= splitMovement[1].toInt()
                }
            }
        }

        return horizontalPos * depth
    }

    /*
        In addition to horizontal position and depth, you'll also need to track a third value, aim,
        which also starts at 0. The commands also mean something entirely different than you first thought:

        down X increases your aim by X units.
        up X decreases your aim by X units.
        forward X does two things:
            It increases your horizontal position by X units.
            It increases your depth by your aim multiplied by X.
    */
    fun part2(input: List<String>): Int {
        var horizontalPos = 0
        var depth = 0
        var aim = 0

        for (action in input){
            val splitMovement = action.split(" ")
            val direction = splitMovement[0]
            val amount = splitMovement[1].toInt()

            when (direction) {
                "forward" -> {
                    horizontalPos += amount
                    depth += aim * amount
                }
                "down" -> {
                    aim += amount
                }
                "up" -> {
                    aim -= amount
                }
            }
        }

        return horizontalPos * depth
    }

    val dayNum = "2"
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day0${dayNum}_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day0${dayNum}_input")
    println(part1(input))
    println(part2(input))
}