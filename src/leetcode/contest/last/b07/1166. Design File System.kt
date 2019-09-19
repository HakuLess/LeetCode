package leetcode.contest.last.b07

class FileSystem() {

    val map = hashMapOf<String, Int>()

    fun create(path: String, value: Int): Boolean {
        if (path.isEmpty()) {
            return false
        }
        if (path.count { it == '/' } == 1) {
            map[path] = value
            return true
        } else {
            val sub = path.substring(IntRange(0, path.lastIndexOf('/') - 1))
            println(sub)
            if (map.containsKey(sub)) {
                map[path] = value
                return true
            }
        }
        return false
    }

    fun get(path: String): Int {
        return map[path] ?: -1
    }

}

/**
 * Your FileSystem object will be instantiated and called as such:
 * var obj = FileSystem()
 * var param_1 = obj.create(path,value)
 * var param_2 = obj.get(path)
 */