package leetcode.contest.cur.c148

import leetcode.print

fun main(args: Array<String>) {
//    val snapshotArr = SnapshotArray(3) // 初始化一个长度为 3 的快照数组
//    snapshotArr.set(0, 5)  // 令 array[0] = 5
//    snapshotArr.snap()  // 获取快照，返回 snap_id = 0
//    snapshotArr.set(0, 6)
//    snapshotArr.get(0, 0).print()

    val snapshotArr = SnapshotArray(1) // 初始化一个长度为 3 的快照数组
    snapshotArr.set(0, 15)  // 令 array[0] = 5
    snapshotArr.snap()  // 获取快照，返回 snap_id = 0
    snapshotArr.snap()  // 获取快照，返回 snap_id = 0
    snapshotArr.snap()  // 获取快照，返回 snap_id = 0
    snapshotArr.get(0, 2).print()
    snapshotArr.snap()  // 获取快照，返回 snap_id = 0
    snapshotArr.snap()  // 获取快照，返回 snap_id = 0
    snapshotArr.get(0, 0).print()
}

class SnapshotArray(length: Int) {
    //    private val list = ArrayList<IntArray>()
    private var cur = IntArray(length)

    private val map = HashMap<Pair<Int, Int>, Int>()
    private var index = 0
    fun set(index: Int, `val`: Int) {
        cur[index] = `val`
    }

    fun snap(): Int {
        cur.forEachIndexed { ind, i ->
            if (i != 0) {
                map[Pair(index, ind)] = i
            }
        }
//        list.add(cur)
        index++
        return index - 1
    }

    fun get(index: Int, snap_id: Int): Int {
//        return list[snap_id][index]
        return map[Pair(snap_id, index)] ?: 0
    }

}