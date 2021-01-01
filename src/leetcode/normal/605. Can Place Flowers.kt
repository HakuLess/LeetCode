package leetcode.normal

class Solution605 {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var ans = 0
        for (i in flowerbed.indices) {
            if (flowerbed[i] == 0) {
                if ((i - 1 !in flowerbed.indices || flowerbed[i - 1] == 0)
                        && (i + 1 !in flowerbed.indices || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1
                    ans++
                }
            }
        }
        return ans >= n
    }
}