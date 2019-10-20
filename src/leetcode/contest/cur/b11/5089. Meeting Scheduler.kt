package leetcode.contest.cur.b11

fun main(args: Array<String>) {
    val s = Solution5089()
    s.minAvailableDuration(arrayOf(intArrayOf(10, 50), intArrayOf(60, 120), intArrayOf(140, 210)),
            arrayOf(intArrayOf(0, 15), intArrayOf(60, 70)), 12).forEach {
        print("$it, ")
    }
    s.minAvailableDuration(
            arrayOf(intArrayOf(216397070, 363167701),
                    intArrayOf(98730764, 158208909),
                    intArrayOf(441003187, 466254040),
                    intArrayOf(558239978, 678368334),
                    intArrayOf(683942980, 717766451)),
            arrayOf(intArrayOf(50490609, 222653186),
                    intArrayOf(512711631, 670791418),
                    intArrayOf(730229023, 802410205),
                    intArrayOf(812553104, 891266775),
                    intArrayOf(230032010, 399152578)),
            456085
    ).forEach {
        print("$it, ")
    }
}

class Solution5089 {
    fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {
        slots1.sortBy { it[0] }
        slots2.sortBy { it[0] }
        var i = 0
        var j = 0
        while (i < slots1.size && j < slots2.size) {
            println("$i, $j")
            when {
                slots1[i][0] >= slots2[j][0] && slots1[i][1] <= slots2[j][1] -> {
                    if (slots1[i][1] - slots1[i][0] >= duration) {
                        return listOf(slots1[i][0], slots1[i][0] + duration)
                    }
                    j++
                }
                slots1[i][0] >= slots2[j][0] && slots1[i][1] >= slots2[j][1] && slots1[i][0] < slots2[j][1] -> {
                    if (slots2[j][1] - slots1[i][0] >= duration) {
                        return listOf(slots1[i][0], slots1[i][0] + duration)
                    }
                    j++
                }
                slots1[i][0] >= slots2[j][1] -> {
                    j++
                }

                slots2[j][0] >= slots1[i][0] && slots2[j][1] <= slots1[i][1] -> {
                    if (slots2[j][1] - slots2[j][0] >= duration) {
                        return listOf(slots2[j][0], slots2[j][0] + duration)
                    }
                    i++
                }
                slots2[j][0] >= slots1[i][0] && slots2[j][1] >= slots1[i][1] && slots2[j][0] < slots1[i][1] -> {
                    if (slots1[i][1] - slots2[j][0] >= duration) {
                        return listOf(slots2[j][0], slots2[j][0] + duration)
                    }
                    i++
                }
                slots2[j][0] >= slots1[i][1] -> {
                    i++
                }
            }
        }
        return emptyList()
    }
}