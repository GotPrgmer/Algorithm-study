// ==========================================================
// 1291. Sequential Digits
// Difficulty : Medium
// Language   : Java
// Solution   : #2
// Runtime    : 0 ms (Beats 100%)
// Memory     : 42.2 MB (Beats 67%)
// Link       : https://leetcode.com/problems/sequential-digits/
// ==========================================================

import java.util.*;

class Solution {
    static List<Integer> nums;
    public List<Integer> sequentialDigits(int low, int high) {
        // 완전탐색 -> 시간초과 O(N*10) == O(N)
        // 1~9까지, 1~9인데 여기서 하나씩 깎기
        //2~9까지 하나씩 깎기
        //...
        // 89까지 가기
        // 이후 리스트 정렬
        nums = new ArrayList<>();

        for(int i=1; i < 9 ; i++){
            create(i, low, high);
        }
        
        // List<Integer> ans = new ArrayList<>();
        Collections.sort(nums);
        // for(int i=0;i<nums.size();i++){
        //     int cur = nums.get(i);
            
        // }
        return nums;
    }
    // n부터시작하는 숫자를 9까지 진행시키고 10씩 깎으면서 리스트에 추가
    public void create(int base, int low, int high){
        int cur = base;
        int multiply = 10;
        int num = cur;
        while(++cur != 10){
            num *= 10;
            num += cur;
            if(num >= low && num <= high){
                nums.add(num);
            }
        }
        
    }
}