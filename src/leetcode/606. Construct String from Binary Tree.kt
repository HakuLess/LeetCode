package leetcode

import java.lang.StringBuilder

class Solution606 {

    fun tree2str(t: TreeNode?): String {
        if (t == null) {
            return ""
        }

        val ans = StringBuilder()
        ans.append(t.`val`)
        if (t.left != null || t.right != null) {
            ans.append("(${tree2str(t.left)})")
            if (t.right != null) {
                ans.append("(${tree2str(t.right)})")
            }
        }


        return ans.toString()
    }

}