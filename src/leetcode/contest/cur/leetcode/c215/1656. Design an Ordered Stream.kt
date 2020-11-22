package leetcode.contest.cur.leetcode.c215

class OrderedStream(n: Int) {
    var cur = 0
    val arr = Array<String>(n) { "" }

    fun insert(id: Int, value: String): List<String> {
        arr[id - 1] = value
        val ans = arrayListOf<String>()
        while (cur in arr.indices && arr[cur].isNotEmpty()) {
            ans.add(arr[cur])
            cur++
        }
        return ans
    }

}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * var obj = OrderedStream(n)
 * var param_1 = obj.insert(id,value)
 */