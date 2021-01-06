package leetcode.contest.utils

/**
 * 并查集 Union-Find Set
 *
 * @link https://hakuless.github.io/post/union-find-set/
 */
class UFS(var n: Int = 0) {
    private val parent = IntArray(n) { it }
    private val rank = IntArray(n)
    var size = n

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
        size--
        return true
    }
}

class TypedUFS<T>(var n: Int = 0) {
    private val parent = IntArray(n) { i -> i }
    private val rank = IntArray(n)
    private val weight = DoubleArray(n) { 1.0 }
    val count = IntArray(n) { 1 }

    private val map = hashMapOf<T, Int>()
    private val rev = hashMapOf<Int, T>()
    private var total = 0

    fun typedFind(key: T): Int {
        var x = total
        if (map.containsKey(key)) {
            x = map[key]!!
        } else {
            map[key] = total
            rev[total] = key
            total++
        }
        if (x != parent[x]) {
            val origin = parent[x]
            parent[x] = typedFind(rev[parent[x]]!!)
            weight[x] *= weight[origin]
        }
        return parent[x]
    }

    fun union(x: T, y: T, value: Double = 1.0): Boolean {
        val px = typedFind(x)
        val py = typedFind(y)
        if (px == py) {
            return false
        }
        when {
            rank[px] > rank[py] -> {
                parent[py] = px
                weight[py] = weight[map[x]!!] / value / weight[map[y]!!]
                count[px] += count[py]
            }
            rank[px] < rank[py] -> {
                parent[px] = py
                weight[px] = weight[map[y]!!] * value / weight[map[x]!!]
                count[py] += count[px]
            }
            else -> {
                parent[px] = py
                rank[px]++
                weight[px] = weight[map[y]!!] * value / weight[map[x]!!]
                count[py] += count[px]
            }
        }
        return true
    }

    fun isConnected(x: T, y: T): Double {
        if (x !in map.keys || y !in map.keys)
            return -1.0
        val rootX: Int = typedFind(x)
        val rootY: Int = typedFind(y)
        return if (rootX == rootY) {
            weight[map[x]!!] / weight[map[y]!!]
        } else {
            -1.0
        }
    }
}