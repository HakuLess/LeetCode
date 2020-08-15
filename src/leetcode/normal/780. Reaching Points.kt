package leetcode.normal

import leetcode.contest.utils.print

fun main() {
    val s = Solution780()
    s.reachingPoints(3, 3, 12, 9).print()
}

class Solution780 {
    fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
        var tx = tx
        var ty = ty
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break
            if (tx > ty) {
                tx %= if (ty > sy) ty else return (tx - sx) % ty == 0
            } else {
                ty %= if (tx > sx) tx else return (ty - sy) % tx == 0
            }
        }
        return tx == sx && ty == sy
    }
}