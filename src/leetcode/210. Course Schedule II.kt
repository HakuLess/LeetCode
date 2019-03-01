package leetcode

//todo
class Solution210 {

    private var answer = arrayListOf<Int>()

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val map = hashMapOf<Int, ArrayList<Int>>()
        prerequisites.forEach {
            val array = map.getOrDefault(it[0], arrayListOf())
            array.add(it[1])
            map[it[0]] = array
        }

        val visited = IntArray(numCourses) { 0 }

        for (i in 0 until numCourses) {
            if (!findCircle(i, map, visited, arrayListOf())) {
                return IntArray(0)
            }
        }

        return answer.toIntArray()
    }

    private fun findCircle(key: Int, map: HashMap<Int, ArrayList<Int>>,
                           visited: IntArray, ans: ArrayList<Int>): Boolean {

        val res = ArrayList(ans)
        if (res.size == visited.size) {
            answer = res
        }

        if (!map.containsKey(key) || visited[key] == 1) {
            res.add(key)
            return true
        }

        if (visited[key] == -1) {
            return false
        }

        visited[key] = -1
        for (preKey in map[key]!!) {
            if (!findCircle(preKey, map, visited, res)) {
                return false
            }
        }
        visited[key] = 1
        res.add(key)
        return true
    }
}