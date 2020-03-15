package leetcode.contest.cur.c180

class CustomStack(maxSize: Int) {

    val max = maxSize
    val list = ArrayList<Int>()
    var cur = 0

    fun push(x: Int) {
        if (cur == max) {
            return
        }
        list.add(x)
        cur++
    }

    fun pop(): Int {
        if (cur == 0) {
            return -1
        }
        val ans = list.last()
        list.removeAt(list.lastIndex)
        cur--
        return ans
    }

    fun increment(k: Int, `val`: Int) {
        for (i in 0 until k) {
            if (i in list.indices) {
                list[i] = list[i] + `val`
            }
        }
    }

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * var obj = CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,`val`)
 */