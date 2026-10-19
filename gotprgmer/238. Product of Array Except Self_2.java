
class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
         * [1. 완전탐색 분석]
         * - 각 원소를 제외한 나머지 원소들의 곱을 계산해야 함.
         * - 완전탐색의 시간복잡도는 O(N^2).
         *
         * [2. 최적화 방향]
         * - 경우의 수를 줄이는 방법과 중복 연산을 줄이는 방법을 고려.
         * - 각 원소의 정답을 계산할 때 동일한 구간의 곱이 반복됨.
         * - 따라서 중복되는 곱셈 연산을 재사용하는 방향으로 접근.
         *
         * [3. 규칙 발견]
         * - i = 0 : 1 ~ (N-1) 구간의 곱
         * - i = 1 : 0 ~ 0, 2 ~ (N-1) 구간의 곱
         * - i = 2 : 0 ~ 1, 3 ~ (N-1) 구간의 곱
         *
         * 일반화하면 다음과 같음.
         * - 왼쪽 구간 : 0 ~ (i-1)
         * - 오른쪽 구간 : (i+1) ~ (N-1)
         *
         * [4. 최적화 방법]
         * - 왼쪽 누적곱과 오른쪽 누적곱을 미리 계산.
         * - 각 원소의 정답은 두 누적곱을 곱하여 계산.
         * - 구간별 곱을 반복 계산하지 않으므로 O(N)에 해결 가능.
         *
         * 시간복잡도 : O(N)
         * 공간복잡도 : O(N)
         */

        int[] dp = new int[nums.length];

        // 왼쪽 누적곱과 오른쪽 누적곱을 저장할 배열
        int[] left = new int[nums.length];
        left[0] = nums[0];

        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];

        // 왼쪽 누적곱 계산 (0부터 오른쪽 방향)
        for (int i = 2; i < nums.length; i++) {
            left[i - 1] = left[i - 2] * nums[i - 1];
        }

        // 오른쪽 누적곱 계산 (N-1부터 왼쪽 방향)
        for (int i = nums.length - 3; i > -1; i--) {
            right[i + 1] = right[i + 2] * nums[i + 1];
        }

        // 현재 원소를 제외한 왼쪽과 오른쪽 구간의 곱 계산
        for (int i = 0; i < nums.length; i++) {
            int leftMulti = 1;
            int rightMulti = 1;

            // 첫 번째 원소: 오른쪽 구간만 존재
            if (i == 0) {
                rightMulti = right[i + 1];
            }
            // 마지막 원소: 왼쪽 구간만 존재
            else if (i == nums.length - 1) {
                leftMulti = left[i - 1];
            }
            // 중간 원소: 양쪽 구간의 누적곱 사용
            else {
                leftMulti = left[i - 1];
                rightMulti = right[i + 1];
            }

            dp[i] = leftMulti * rightMulti;
        }

        return dp;
    }
}
