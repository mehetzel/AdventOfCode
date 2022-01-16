import java.io.File
import kotlin.system.measureNanoTime

/*
They offer you a second one if you can find three numbers in your expense report that meet the same criteria.

Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
Multiplying them together produces the answer, 241861950.
 */

fun main(args: Array<String>) {
    fun part1solution1(filePath: String): Int {
        var nums = ArrayList<Int>()

        File(filePath).forEachLine {
            nums.add(it.toInt())
        }

        for (index1 in nums.indices) {
            for (num in nums.slice(index1 until nums.size)) {
                if (nums[index1] + num == 2020) {
                    return (nums[index1] * num)
                }
            }
        }
        return -1
    }

    fun part1solution2(filePath: String): Int {
        var nums = HashMap<Int, Int>()
        var answer = -1

        File(filePath).forEachLine {
            var newNum = it.toInt()
            var toFind = 2020 - newNum
            if (nums[toFind] != null) {
                answer = newNum * nums[toFind]!!
                return@forEachLine
            }
            nums[newNum] = newNum
        }

        return answer
    }

    fun part2solution1(filePath: String): Int {
        var nums = HashMap<Int, Int>()
        var answer = -1

        File(filePath).forEachLine {
            var newNum = it.toInt()
            for ((key, value) in nums) {
                var toFind = 2020 - key - newNum
                if (nums[toFind] != null) {
                    answer = newNum * key * nums[toFind]!!
                    return@forEachLine
                }
            }
            nums[newNum] = newNum
        }

        return answer
    }

    val inputPath = System.getProperty("user.dir") + "/2020/src/Day01_input.txt"

    val timeNaive = measureNanoTime {
        println(part1solution1(inputPath))
    }

    val timeOptimized = measureNanoTime {
        println(part1solution2(inputPath))
    }

    val current = measureNanoTime {
        println(part2solution1(inputPath))
    }
    println("Naive: " + timeNaive + "ns")
    println("Optimized: " + timeOptimized + "ns")
    println("Current: " + current + "ns")
}







