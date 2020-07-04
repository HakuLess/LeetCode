package leetcode.contest.last.c192

class BrowserHistory(homepage: String) {

    var l = arrayListOf<String>()
    var cur = 0
    init {
        l.add(homepage)
    }
    fun visit(url: String) {
        l = ArrayList(l.take(cur))
        l.add(url)
        cur = l.lastIndex
    }

    fun back(steps: Int): String {
        cur = maxOf(cur - steps, 0)
        return l[cur]
    }

    fun forward(steps: Int): String {
        cur = minOf(cur + steps, l.lastIndex)
        return l[cur]
    }

}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */