// #1
class Solution {
    fun sortColors(nums: IntArray){
        // send 0 to the front
        var target0 = -1
        for(i in 0 until nums.size){
            if(nums[i] != 0 && target0 == -1){
                target0 = i
            } else if(nums[i] == 0 && target0 != -1){
                nums[i] = nums[target0]
                nums[target0] = 0 // move 0 to target
                target0++
            }
        }
        
        if(target0 > -1){
            // send 2 to the back
            var target2 = -1
            for(i in nums.size - 1 downTo target0){
                if(nums[i] !=2 && target2 == -1){
                    target2 = i
                } else if(nums[i] == 2 && target2 != -1){
                    nums[i] = nums[target2]
                    nums[target2] = 2 // move 2 to target
                    target2--
                }
            }
        }
    }
}

// #2
class Solution {
    fun sortColors(nums: IntArray) {
        var l = 0
        var i = 0
        var h = nums.lastIndex

        while (i <= h) {
            when (nums[i]) {
                0 -> {
                    nums[i] = nums[l]
                    nums[l] = 0
                    l++
                    i++
                }
                1 -> i++
                2 -> {
                    nums[i] = nums[h]
                    nums[h] = 2
                    h--
                }
            }
        }
    }
}
