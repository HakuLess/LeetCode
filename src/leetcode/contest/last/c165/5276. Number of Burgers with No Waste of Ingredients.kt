package leetcode.contest.last.c165

class Solution5276 {
    fun numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List<Int> {
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || cheeseSlices * 4 < tomatoSlices)
            return arrayListOf()
        return arrayListOf(tomatoSlices / 2 - cheeseSlices, cheeseSlices * 2 - tomatoSlices / 2)
    }
}