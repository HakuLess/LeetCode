package leetcode.contest.cur.leetcode.b36

class ParkingSystem(var big: Int, var medium: Int, var small: Int) {

    fun addCar(carType: Int): Boolean {
        var ans = false
        when (carType) {
            1 -> {
                if (big >= 1) ans = true
                big--
            }
            2 -> {
                if (medium >= 1) ans = true
                medium--
            }
            3 -> {
                if (small >= 1) ans = true
                small--
            }
        }
        return ans
    }

}
