/*
the sonar sweep report (your puzzle input) appears:
each line is a measurement of the sea floor depth as the sweep looks further and further away from the submarine.

Purpose: count the number of times a depth measurement increases from the previous measurement.
*/
import java.io.File

fun part1(filePath: String): Int {
    // Get to infer Int with Kotlin
    var previousDepth = -1
    var totalIncreases = 0

    // Using file directly because this isn't real life
    File(filePath).readLines().forEach {
        if (previousDepth != -1 && previousDepth < it.toInt())
            totalIncreases += 1
        previousDepth = it.toInt()
    }

    return totalIncreases
}

fun part2(filePath: String): Int {
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

fun main(args: Array<String>) {
    // Using val since this will be read-only
    val path = System.getProperty("user.dir")
    val part1Answer = part1("$path/src/main/kotlin/inputpart1.txt")
    println("Part 1 Total Increases: $part1Answer")


}