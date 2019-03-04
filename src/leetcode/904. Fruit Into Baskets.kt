package leetcode

class Solution904 {
    fun totalFruit(tree: IntArray): Int {
        var max = 0
        var start = 0
        val types = hashMapOf<Int, Int>()

        tree.forEachIndexed { index, type ->
            types[type] = types.getOrDefault(type, 0) + 1

            var temp = calTypes(types, 0)
            while (temp > 2) {
                types[tree[start]] = types[tree[start]]!! - 1
                temp = calTypes(types, tree[start])
                start++
            }

            println("$index $start")
            max = maxOf(index - start + 1, max)
        }
        return max
    }

    fun calTypes(map: HashMap<Int, Int>, key: Int): Int {
        var ans = 0
        map.forEach { t, u ->
            if (u != 0) {
                ans++
            }
        }
        if (map[key] != null && map[key] == 0) {
            map.remove(key)
        }
        return ans
    }
}