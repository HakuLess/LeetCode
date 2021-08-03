package leetcode.normal

class Solution733 {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val target = image[sr][sc]
        if (target == newColor) {
            return image
        }
        fun dfs(sr: Int, sc: Int) {
            if (sr < 0 || sc < 0 || sr >= image.size || sc >= image[0].size) {
                return
            }
            if (image[sr][sc] == target) {
                image[sr][sc] = newColor
            } else {
                return
            }
            dfs(sr - 1, sc)
            dfs(sr + 1, sc)
            dfs(sr, sc - 1)
            dfs(sr, sc + 1)
        }
        dfs(sr, sc)
        return image
    }
}