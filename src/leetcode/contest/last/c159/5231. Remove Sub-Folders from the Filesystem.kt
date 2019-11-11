package leetcode.contest.last.c159

fun main(args: Array<String>) {
    val s = Solution5231()
    s.removeSubfolders(arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")).forEach {
        print("$it, ")
    }
    println()
    s.removeSubfolders(arrayOf("/a", "/a/b/c", "/a/b/d")).forEach {
        print("$it, ")
    }
    println()
    s.removeSubfolders(arrayOf("/a/b/c", "/a/b/d", "/a/b/ca")).forEach {
        print("$it, ")
    }
    println()
}

class Solution5231 {
    fun removeSubfolders(folder: Array<String>): List<String> {
        folder.sort()
        val ans = arrayListOf<String>()
        folder.forEach { item ->
            ans.removeIf {
                it.startsWith("$item/")
            }
            if (!ans.any { item.startsWith("$it/") }) {
                ans.add(item)
            }
        }
        return ans
    }
}