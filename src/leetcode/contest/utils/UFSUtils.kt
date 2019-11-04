package leetcode.contest.utils

/**
 * 并查集 Union-Find Set
 *
 * @link https://hakuless.github.io/post/union-find-set/
 */
class UFS(var n: Int = 0) {
    private val parent = IntArray(n) { i -> i }
    private val rank = IntArray(n)

    fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val px = find(x)
        val py = find(y)
        if (px == py) {
            return false
        }
        when {
            rank[px] > rank[py] -> parent[py] = px
            rank[px] < rank[py] -> parent[px] = py
            else -> {
                parent[px] = py
                rank[px]++
            }
        }
        return true
    }
}

class TypedUFS<T>(var n: Int = 0) {
    private val parent = IntArray(n) { i -> i }
    private val rank = IntArray(n)

    val map = hashMapOf<T, Int>()
    private var total = 0

    fun typedFind(key: T): Int {
        var x = total
        if (map.containsKey(key)) {
            x = map[key]!!
        } else {
            map[key] = total
            total++
        }
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    private fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: T, y: T): Boolean {
        val px = typedFind(x)
        val py = typedFind(y)
        if (px == py) {
            return false
        }
        when {
            rank[px] > rank[py] -> parent[py] = px
            rank[px] < rank[py] -> parent[px] = py
            else -> {
                parent[px] = py
                rank[px]++
            }
        }
        return true
    }

    fun getTypes(): Int {
        return map.keys.count()
    }
}