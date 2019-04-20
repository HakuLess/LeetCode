package leetcode.normal

val ans = arrayListOf<ArrayList<Int>>()

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    fillAns(candidates, target, arrayListOf(), 0)
    return ans
}

fun fillAns(candidates: IntArray, target: Int, current: ArrayList<Int>, start: Int) {
    if (target < 0) {
        return
    }

    if (target == 0) {
        ans.add(current)
    }

    candidates.forEachIndexed { index, it ->
        if (index >= start) {
            val next = ArrayList(current)
            next.add(it)
            fillAns(candidates, target - it, next, index)
        }
    }
}