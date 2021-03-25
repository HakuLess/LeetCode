package leetcode.contest.cur.leetcode.b36

class ParkingSystem(var big: Int, var medium: Int, var small: Int) {

    val cur = intArrayOf(0, big, medium, small)

    fun addCar(carType: Int): Boolean {
        if (cur[carType] < 1) {
            return false
        }
        cur[carType]--
        return true
    }

}
