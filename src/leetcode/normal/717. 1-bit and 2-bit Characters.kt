package leetcode.normal

class Solution717 {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        var ans = 0
        for (i in bits.lastIndex - 1 downTo 0) {
            if (bits[i] == 1) {
                ans++
            } else {
                break
            }
        }

        return ans % 2 == 0
    }
}