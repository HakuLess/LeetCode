package leetcode.contest.last.c182

class UndergroundSystem() {

    private val map = HashMap<Int, Pair<String, Int>>()
    private val time = HashMap<Pair<String, String>, Pair<Int, Int>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        map[id] = Pair(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val key = Pair(map[id]!!.first, stationName)
        if (key !in time) {
            time[key] = Pair(t - map[id]!!.second, 1)
        } else {
            time[key] = Pair(t - map[id]!!.second + time[key]!!.first, 1 + time[key]!!.second)
        }
        map.remove(id)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val v = time[Pair(startStation, endStation)]
        return v!!.first.toDouble() / v.second.toDouble()
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */