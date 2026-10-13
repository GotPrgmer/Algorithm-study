class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
         * [문제 정의]
         * - 두 원소의 합이 target이 되는 인덱스 쌍을 찾는다.
         *
         * [접근 방식: 완전탐색]
         * - 모든 인덱스 쌍 (i, j)을 탐색한다.
         * - 동일한 원소의 중복 선택을 방지하기 위해 j = i + 1부터 탐색한다.
         * - 조건을 만족하는 쌍을 발견하면 탐색을 종료한다.
         *
         * [시간복잡도]
         * - O(N²)
         * - 최대 N(N-1)/2개의 쌍을 확인한다.
         *
         * [최적화 방향]
         * - target - nums[i]에 해당하는 원소를 빠르게 찾는 방법을 고려한다.
         * - 각 원소의 탐색 비용을 줄이면 O(N)까지 개선할 수 있다.
         */
        boolean isEnd = false;
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    isEnd = true;
                    break;
                }
            }
            if(isEnd) break;
        }
        return ans;
    }
}