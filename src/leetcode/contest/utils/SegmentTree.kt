package leetcode.contest.utils


class SegmentTree<T>(val arr: Array<T>, val func: (a: T, b: T) -> T) {

    private val tree = Array<Any?>(arr.size * 4) { null } as Array<T>

    init {
        buildSegmentTree(0, 0, arr.lastIndex)
    }

    private fun buildSegmentTree(treeIndex: Int, treeLeft: Int, treeRight: Int) {
        if (treeLeft == treeRight) {
            tree[treeIndex] = arr[treeLeft]
            return
        }
        val leftIndex = getLeft(treeIndex)
        val rightIndex = getRight(treeIndex)
        val mid = treeLeft + (treeRight - treeLeft) / 2
        buildSegmentTree(leftIndex, treeLeft, mid)
        buildSegmentTree(rightIndex, mid + 1, treeRight)
        tree[treeIndex] = func(tree[leftIndex], tree[rightIndex])
    }

    fun query(start: Int, end: Int): T {
        return query(0, 0, arr.lastIndex, start, end)
    }

    fun update(index: Int, value: T) {
        arr[index] = value
        update(0, 0, arr.lastIndex, index, value)
    }

    fun get(index: Int): T {
        return arr[index]
    }

    private fun query(treeIndex: Int, treeLeft: Int, treeRight: Int, queryL: Int, queryR: Int): T {
        if (treeLeft == queryL && treeRight == queryR) {
            return tree[treeIndex]
        }
        val mid = treeLeft + (treeRight - treeLeft) / 2
        val leftTreeIndex = getLeft(treeIndex)
        val rightTreeIndex = getRight(treeIndex)
        if (queryR <= mid) {
            return query(leftTreeIndex, treeLeft, mid, queryL, queryR)
        }
        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, treeRight, queryL, queryR)
        }
        val ansLeft = query(leftTreeIndex, treeLeft, mid, queryL, mid)
        val ansRight = query(rightTreeIndex, mid + 1, treeRight, mid + 1, queryR)
        return func(ansLeft, ansRight)
    }

    private fun update(treeIndex: Int, treeLeft: Int, treeRight: Int, index: Int, value: T) {
        if (treeLeft == treeRight) {
            tree[treeIndex] = value
            return
        }
        val mid = treeLeft + (treeRight - treeLeft) / 2
        val leftChildIndex = getLeft(treeIndex)
        val rightChildIndex = getRight(treeIndex)
        if (index <= mid) {
            update(leftChildIndex, treeLeft, mid, index, value)
        } else {
            update(rightChildIndex, mid + 1, treeRight, index, value)
        }
        tree[treeIndex] = func(tree[leftChildIndex], tree[rightChildIndex])
    }

    private fun getLeft(cur: Int): Int {
        return cur * 2 + 1
    }

    private fun getRight(cur: Int): Int {
        return cur * 2 + 2
    }
}