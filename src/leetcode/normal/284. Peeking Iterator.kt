package leetcode.normal

class PeekingIterator(var iterator: Iterator<Int>) : Iterator<Int> {

    val l = arrayListOf<Int>()
    var cur = 0

    init {
        while (iterator.hasNext()) {
            l.add(iterator.next())
        }
    }

    fun peek(): Int {
        return l[cur]
    }

    override fun next(): Int {
        return l[cur++]
    }

    override fun hasNext(): Boolean {
        return cur != l.size
    }
}