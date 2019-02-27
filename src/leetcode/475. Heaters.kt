package leetcode


fun main(args: Array<String>) {
    findRadius(intArrayOf(1, 5), intArrayOf(2)).print()
}

fun findRadius(houses: IntArray, heaters: IntArray): Int {
    houses.sort()
    heaters.sort()

    var hid = 0
    var tid = 0
    var radius = 0
    while (hid < houses.size) {
        while (tid < heaters.lastIndex &&
                Math.abs(houses[hid] - heaters[tid + 1]) <= Math.abs(houses[hid] - heaters[tid])) {
            tid++
        }
        val minRadius = Math.abs(houses[hid] - heaters[tid])
        radius = maxOf(radius, minRadius)
        hid++
    }

    return radius
}