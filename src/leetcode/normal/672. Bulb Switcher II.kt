package leetcode.normal

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution672()
    s.flipLights(2, 1).print()
    s.flipLights(2, 2).print()
}

class Solution672 {
    fun flipLights(n: Int, m: Int): Int {
        val seen = HashSet<Int>()
        val size = minOf(n, 6)
        val shift = maxOf(0, 6 - size)
        for (state in 0..15) {
            val bit = Integer.bitCount(state)
            if (bit % 2 == m % 2 && bit <= m) {
                var lights = 0
                if (state shr 0 and 1 > 0) lights = lights xor (0b111111 shr shift)
                if (state shr 1 and 1 > 0) lights = lights xor (0b010101 shr shift)
                if (state shr 2 and 1 > 0) lights = lights xor (0b101010 shr shift)
                if (state shr 3 and 1 > 0) lights = lights xor (0b100100 shr shift)
                seen.add(lights)
            }
        }
        return seen.size
    }
}