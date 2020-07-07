package leetcode.contest.utils

class SegmentTree<T>(val start: Int = 0,
                     val end: Int = 0,
                     var value: T? = null,
                     var lazy: T? = null,
                     val merge: (a: T, b: T) -> T) {

    var left: SegmentTree<T>? = null
    var right: SegmentTree<T>? = null
    val mid: Int
        get() {
            return (start + end) / 2
        }

    fun build(arr: Array<T>): SegmentTree<T>? {
        return buildHelper(0, arr.lastIndex, arr)
    }

    private fun buildHelper(left: Int, right: Int, arr: Array<T>): SegmentTree<T>? {
        if (left > right) return null
        val root = SegmentTree(left, right, arr[left], null, merge)
        if (left == right) return root
        val mid = (left + right) / 2
        root.left = buildHelper(left, mid, arr)
        root.right = buildHelper(mid + 1, right, arr)
        root.value = safeMerge(root.left?.value, root.right?.value)
        return root
    }

    fun update(root: SegmentTree<T>, l: Int, r: Int, v: T) {
        if (l <= start && r >= end) {
            root.value = v
            root.lazy = v
            return
        }
        if (root.lazy != null) {
            // pushDown
        }
        val mid = root.mid
        if (l <= mid) {
            update(root.left!!, l, r, v)
        }
        if (r > mid) {
            update(root.right!!, l, r, v)
        }
        root.value = merge(root.left!!.value!!, root.right!!.value!!)
    }

    fun update(root: SegmentTree<T>, index: Int, value: T) {
        if (root.start == index && root.end == index) {
            root.value = value
            return
        }
        val mid = root.mid
        if (index <= mid) {
            update(root.left!!, index, value)
            root.value = safeMerge(root.left!!.value, root.right!!.value)
        } else {
            update(root.right!!, index, value)
            root.value = safeMerge(root.left!!.value, root.right!!.value)
        }
    }

    fun query(root: SegmentTree<T>, start: Int, end: Int): T {
        if (start <= root.start && end >= root.end) {
            return root.value!!
        }
        val mid = root.mid
        var ans: T? = null
        if (mid >= start) {
            ans = safeMerge(ans, query(root.left!!, start, end))
        }
        if (mid + 1 <= end) {
            ans = safeMerge(ans, query(root.right!!, start, end))
        }
        return ans!!
    }

    private fun safeMerge(a: T?, b: T?): T? {
        return when {
            a == null -> b
            b == null -> a
            else -> merge(a, b)
        }
    }
}

fun <T> SegmentTree<T>?.print() {
    if (this == null) return
    println("$start ~ $end value is ${this.value}")
    this.left.print()
    this.right.print()
}