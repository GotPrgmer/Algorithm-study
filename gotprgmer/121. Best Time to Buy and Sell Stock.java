class Solution {
    public int maxProfit(int[] prices) {
        // 완전탐색
        // 10**5에 O(N^2)라서 시간복잡도 초과
        // N^2을 해결해야함
        // 경우의 수를 줄일 수 있는지
        // 각 경우에서 확인하는 비용 최적화

        // 완전탐색 과정
        // 첫번째 for문에서 살 시점을 고르고
        // 두번째 for문에서 팔 시점을 고름

        // -> 굳이 다 봐야할까?
        // 어차피 기존에 확인한 팔 시점을 중복으로 봄
        // dp로 0까지 최대값으로 채움(n-1 idx에서 자기자신+1까지 최대값을 확인하는 것이 관건)
        int[] dp = new int[prices.length];
        dp[dp.length-1] = prices[dp.length-1];
        for(int i=dp.length-2;i>-1;i--){
            dp[i] = Math.max(prices[i],dp[i+1]);
        }
        int diff = Integer.MIN_VALUE;
        for(int i=0;i<prices.length-1;i++){
            diff = Math.max(dp[i+1] - prices[i],diff);
        }
        if(diff < 0){
            return 0;
        }
        return diff;
    }
}