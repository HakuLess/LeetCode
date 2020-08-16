package leetcode.normal

class Solution733 {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val target = image[sr][sc]
        if (target == newColor) {
            return image
        }
        dfs(image, sr, sc, target, newColor)
        return image
    }

    private fun dfs(image: Array<IntArray>, sr: Int, sc: Int, target: Int, newColor: Int) {
        if (sr < 0 || sc < 0 || sr >= image.size || sc >= image[0].size) {
            return
        }
        if (image[sr][sc] == target) {
            image[sr][sc] = newColor
        } else {
            return
        }
        dfs(image, sr - 1, sc, target, newColor)
        dfs(image, sr + 1, sc, target, newColor)
        dfs(image, sr, sc - 1, target, newColor)
        dfs(image, sr, sc + 1, target, newColor)
    }
}