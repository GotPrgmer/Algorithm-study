class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        // sort
        intervals.sortWith(
            compareBy<IntArray> { it[0] }.thenByDescending { it[1] }
        )

        // merge overlapping intervals
        var target = intervals[0]
        val result = mutableListOf<IntArray>()
        for(i in 1 until intervals.size){
            val next = intervals[i]
            if (target[1] >= next[0]){
                target = intArrayOf(
                    target[0], max(target[1], next[1])
                )
            } else{
                result.add(target)
                target = next
            }
        }
        result.add(target)
        return result.toTypedArray()
    }
}
