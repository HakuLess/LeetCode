package leetcode

fun main(args: Array<String>) {
    subdomainVisits(arrayOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")).forEach {
        println(it)
    }
}

fun subdomainVisits(cpdomains: Array<String>): List<String> {
    val map = hashMapOf<String, Int>()

    cpdomains.forEach {
        val split = it.split(" ")
        val count = Integer.parseInt(split[0])

        var str = split[1]
        while (str.isNotEmpty()) {
            map[str] = map.getOrDefault(str, 0) + count
//            println("$str $count")

            str = if (str.indexOf('.') == -1) {
                ""
            } else {
                str.substring(str.indexOf('.') + 1)
            }
        }
    }

    val ans = arrayListOf<String>()
    map.forEach { t, u ->
        ans.add("$u $t")
    }
    return ans
}