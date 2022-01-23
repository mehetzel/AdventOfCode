

fun main() {
    /*
        Gamma rate = highest rate of 1s or 0s
        Epsilon rate = lowest rate of 1s or 0s

        Build a binary number with bits determined from above rules
        Convert to an integer and then multiply the two rates
    */
    fun part1(input: List<String>): Int {
        val binLength = input[0].length
        // Thought here is for each position keep track of count totals for 0s and 1s
        val ratesArrays = Array(binLength) { IntArray(2) }
        var gammaBinary = String()
        var epsilonBinary = String()

        for (inputIndex in input.indices) {
            val binNum = input[inputIndex]
            for (index in 0 until binLength) {
                if (binNum[index] == '0') {
                    ++ratesArrays[index][0]
                }
                else {
                    ++ratesArrays[index][1]
                }
            }
        }

        for (rate in ratesArrays) {
            if (rate[0] > rate[1]) {
                gammaBinary += "0"
                epsilonBinary += "1"
            }
            else {
                gammaBinary += "1"
                epsilonBinary += "0"
            }
        }

        return gammaBinary.toInt(2) * epsilonBinary.toInt(2)
    }

    /*
        Compare bits in all numbers for one position in the binary number.

        Keep only numbers selected by the bit criteria for the type of rating value for which you are searching.
        Discard numbers which do not match the bit criteria.
        If you only have one number left, stop; this is the rating value for which you are searching.
        Otherwise, repeat the process, considering the next bit to the right.
        The bit criteria depends on which type of rating value you want to find:

        To find oxygen generator rating, determine the most common value (0 or 1) in the current bit position,
            and keep only numbers with that bit in that position.
            If 0 and 1 are equally common, keep values with a 1 in the position being considered.
        To find CO2 scrubber rating, determine the least common value (0 or 1) in the current bit position,
            and keep only numbers with that bit in that position.
            If 0 and 1 are equally common, keep values with a 0 in the position being considered.
    */
    fun part2EvalRating(input: List<String>, currentPosition: Int, supportType: Char): Int {
        val newList: List<String>
        var evalResult: Int
        var zeroList = ArrayList<String>()
        var oneList = ArrayList<String>()

        if (input.size > 1) {
            for (binNum in input) {
                // Create newly separated list based on new position in binary number across all inputs
                if (binNum[currentPosition] == '0') {
                    zeroList.add(binNum)
                }
                else {
                    oneList.add(binNum)
                }
            }
            when {
                // Larger size always goes to Oxygen which is also support type 1
                zeroList.size > oneList.size -> {
                    if (supportType == '1') {
                        newList = zeroList
                    }
                    else {
                        newList = oneList
                    }
                }
                // Smaller size always goes to CO2 which is also support type 0
                // zeroList.size < oneList.size || zeroList.size == oneList.size
                 else -> {
                    if (supportType == '1') {
                        newList = oneList
                    }
                    else {
                        newList = zeroList
                    }
                }
            }
            evalResult = part2EvalRating(input = newList, currentPosition = currentPosition + 1, supportType = supportType)
        }
        else {
            evalResult = input[0].toInt(2)
        }
        return evalResult
    }
    fun part2(input: List<String>): Int {
        val oxygenNum = part2EvalRating(input = input, currentPosition = 0, supportType = '1')
        val co2Num = part2EvalRating(input = input, currentPosition = 0, supportType = '0')

        return oxygenNum * co2Num
    }

    val dayNum = "3"
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day0${dayNum}_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day0${dayNum}_input")
    println(part1(input))
    println(part2(input))
}