/*
the sonar sweep report (your puzzle input) appears:
each line is a measurement of the sea floor depth as the sweep looks further and further away from the submarine.

Purpose: count the number of times a depth measurement increases from the previous measurement.
*/

fun main() {
    fun part1(input: List<String>): Int {
        // Get to infer Int with Kotlin
        var previousDepth = -1
        var totalIncreases = 0

        // Using file directly because this isn't real life
        for (line in input) {
            if (previousDepth != -1 && previousDepth < line.toInt())
                totalIncreases += 1
            previousDepth = ine.toInt()
        }

        return totalIncreases
    }

    fun part2(input: List<String>): Int {
        var previousDepth = -1
        var totalIncreases = 0

        var depthA = 0
        var depthB = 0
        var depthCurrent = -1
        // Using file directly because this isn't real life
        /*
        for (line in File(fileName).readLines()) {
          // statement(s)
        }
         */

        return totalIncreases
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test.txt")
    check(part1(testInput) == 1)

    val input = readInput("Day01_input.xt")
    println(part1(input))
    println(part2(input))
}






