package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    canPlaceFlowers(intArrayOf(1, 0, 0, 0, 0, 1), 2).print()
}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    val intArray = IntArray(flowerbed.size)
    for (i in 0 until flowerbed.size) {
        intArray[i] = if (intArray[i] == 1) {
            1
        } else {
            flowerbed[i]
        }

        if (flowerbed[i] == 1) {
            if (i - 1 >= 0) {
                intArray[i - 1] = 1
            }
            if (i + 1 < flowerbed.size) {
                intArray[i + 1] = 1
            }
        }
    }

    intArray.forEach {
        print("$it, ")
    }
    var count = 0
    var canP = true
    intArray.forEach {
        canP = if (it == 0) {
            if (canP) {
                count++
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    return count >= n
}