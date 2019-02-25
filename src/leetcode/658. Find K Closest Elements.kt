package leetcode

fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    var ans = arr.sortedWith(Comparator { o1, o2 ->
        if (o1 == o2) {
            0
        } else {
            Math.abs(o1 - x) - Math.abs(o2 - x)
        }
    })
    ans = ans.slice(IntRange(0, k - 1))
    return ans.sorted()
}