package leetcode.normal

import leetcode.contest.utils.TreeNode

//fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
//    if (s == null || t == null) {
//        return false
//    }
//
//    return if (s.`val` != t.`val`) {
//        isSubtree(s.left, t) || isSubtree(s.right, t)
//    } else {
//        isSameTree(s.left, t.left) && isSameTree(s.right, t.right) ||
//                isSubtree(s.left, t) || isSubtree(s.right, t)
//    }
//}

//fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
//    return if (p == null && q == null) {
//        true
//    } else if (p != null && q != null && p.`val` == q.`val`) {
//        (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
//    } else {
//        false
//    }
//}