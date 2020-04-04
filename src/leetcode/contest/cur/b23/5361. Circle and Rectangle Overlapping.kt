package leetcode.contest.cur.b23

import javafx.scene.shape.Circle
import leetcode.contest.utils.print
import kotlin.math.abs


fun main(args: Array<String>) {
    val s = Solution5361()
    s.checkOverlap(1, 0, 0, 1, -1, 3, 1).print()
}

class Solution5361 {
    fun checkOverlap(radius: Int, x_center: Int, y_center: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        val cir = Circle()
        cir.x = x_center.toFloat()
        cir.y = y_center.toFloat()
        cir.radius = radius.toFloat()

        val rec = Rectangle()
        rec.x = x1.toFloat()
        rec.y = y1.toFloat()
        rec.halfHeight = (y2 - y1).toFloat() / 2
        rec.halfWidth = (x2 - x1).toFloat() / 2
        return intersect(rec, cir)
    }

    class Circle {
        var x = 0f
        var y = 0f
        var radius = 0f
    }

    class Rectangle {
        var halfWidth = 0f
        var halfHeight = 0f
        var x = 0f
        var y = 0f
    }

    private fun intersect(r: Rectangle, c: Circle): Boolean {
        val cx: Float = abs(c.x - r.x - r.halfWidth)
        val xDist: Float = r.halfWidth + c.radius
        if (cx > xDist) return false
        val cy: Float = abs(c.y - r.y - r.halfHeight)
        val yDist: Float = r.halfHeight + c.radius
        if (cy > yDist) return false
        if (cx <= r.halfWidth || cy <= r.halfHeight) return true
        val xCornerDist: Float = cx - r.halfWidth
        val yCornerDist: Float = cy - r.halfHeight
        val xCornerDistSq = xCornerDist * xCornerDist
        val yCornerDistSq = yCornerDist * yCornerDist
        val maxCornerDistSq = (c.radius * c.radius.toFloat()).toFloat()
        return xCornerDistSq + yCornerDistSq <= maxCornerDistSq
    }
}