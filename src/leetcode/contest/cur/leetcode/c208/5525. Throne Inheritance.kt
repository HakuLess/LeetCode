package leetcode.contest.cur.leetcode.c208

fun main(args: Array<String>) {
    val t = ThroneInheritance("king") // 继承顺序：king
    t.birth("king", "andy") // 继承顺序：king > andy
    t.birth("king", "bob") // 继承顺序：king > andy > bob
    t.birth("king", "catherine") // 继承顺序：king > andy > bob > catherine
    t.birth("andy", "matthew") // 继承顺序：king > andy > matthew > bob > catherine
    t.birth("bob", "alex") // 继承顺序：king > andy > matthew > bob > alex > catherine
    t.birth("bob", "asha") // 继承顺序：king > andy > matthew > bob > alex > asha > catherine

    // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
    println(t.getInheritanceOrder().joinToString(", "))
    t.death("bob") // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
    t.getInheritanceOrder() // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
}
class ThroneInheritance(kingName: String) {

    class Node(val name: String) {
        val child = ArrayList<Node>()
        var isLive = true
    }

    val root = Node(kingName)

    val map = HashMap<String, Node>()
    init {
        map[kingName] = root
    }

    fun birth(parentName: String, childName: String) {
        val new = Node(childName)
        map[parentName]!!.child.add(new)
        map[childName] = new
    }

    fun death(name: String) {
        map[name]!!.isLive = false
    }

    fun getInheritanceOrder(): List<String> {
        val ans = ArrayList<String>()
        fun dfs(cur: Node) {
            if (cur.isLive) {
                ans.add(cur.name)
            }
            cur.child.forEach {
                dfs(it)
            }
        }
        dfs(root)
        return ans
    }

}