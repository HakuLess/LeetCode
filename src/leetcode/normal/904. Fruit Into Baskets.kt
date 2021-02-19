package leetcode.normal

class Solution904 {
    fun totalFruit(tree: IntArray): Int {
        var max = 0
        var start = 0
        val types = hashMapOf<Int, Int>()
        tree.forEachIndexed { index, type ->
            types[type] = types.getOrDefault(type, 0) + 1
            while (types.size > 2) {
                types[tree[start]] = types[tree[start]]!! - 1
                if (types[tree[start]] == 0) {
                    types.remove(tree[start])
                }
                start++
            }
            max = maxOf(index - start + 1, max)
        }
        return max
    }
}