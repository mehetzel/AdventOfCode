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
            previousDepth = line.toInt()
        }

        return totalIncreases
    }

    /*
    Instead, consider sums of a three-measurement sliding window. Again considering the above example:

    Start by comparing the first and second three-measurement windows.
    The measurements in the first window are marked A (199, 200, 208); their sum is 199 + 200 + 208 = 607.
    The second window is marked B (200, 208, 210); its sum is 618.
    The sum of measurements in the second window is larger than the sum of the first,
    so this first comparison increased.

    Your goal now is to count the number of times the sum of measurements in this sliding window increases from the previous sum.
    So, compare A with B, then compare B with C, then C with D, and so on. Stop when there aren't enough measurements left to create a new three-measurement sum.
     */
    fun part2(input: List<String>): Int {
        var previousSum = -1
        var totalIncreases = 0

        var depthA = -1
        var depthB = -1

        for (line in input) {
            var currMeasurement = line.toInt()

            if (previousSum != -1 && previousSum < (depthA + depthB + currMeasurement)){
                totalIncreases += 1
            }

            when {
                depthA == -1 -> depthA = currMeasurement
                depthB == -1 -> depthB = currMeasurement
                else -> {
                    previousSum = depthA + depthB + currMeasurement
                    depthA = depthB
                    depthB = currMeasurement
                }
            }
            println(previousSum)
        }

        return totalIncreases
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01_input")
    println(part1(input))
    println(part2(input))
}