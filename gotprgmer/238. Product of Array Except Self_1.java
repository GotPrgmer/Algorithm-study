
class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
         * [1. 완전탐색 분석]
         * - 각 원소를 제외한 나머지 원소들의 곱을 계산해야 함.
         * - 완전탐색 시 시간복잡도는 O(N^2).
         *
         * [2. 최적화 방향]
         * - 경우의 수를 줄이거나, 각 경우의 확인 연산을 최적화하는 방법 고려.
         * - 모든 원소의 정답을 구해야 하므로 경우의 수를 줄이기 어려움.
         * - 각 원소의 정답을 계산하는 과정에서 중복되는 곱셈 연산이 존재함.
         * - 따라서 중복 연산을 재사용하는 방향으로 접근.
         *
         * [3. 규칙 발견 및 일반화]
         * - i = 0 : 1 ~ (N-1) 구간의 곱
         * - i = 1 : 0 ~ 0, 2 ~ (N-1) 구간의 곱
         * - i = 2 : 0 ~ 1, 3 ~ (N-1) 구간의 곱
         *
         * 일반화하면 각 원소의 정답은 두 구간의 곱으로 표현 가능.
         * - 왼쪽 구간 : 0 ~ (i-1)
         * - 오른쪽 구간 : (i+1) ~ (N-1)
         *
         * [4. 최적화 방법]
         * - 왼쪽과 오른쪽의 누적곱을 각각 미리 계산.
         * - 각 인덱스에서 현재 원소를 제외한 두 구간의 누적곱을 활용.
         * - 중복되는 곱셈을 제거하여 O(N)으로 최적화.
         *
         * 시간복잡도 : O(N)
         * 공간복잡도 : O(N)
         */

        int[] dp = new int[nums.length];

        // 왼쪽, 오른쪽 누적곱 배열 초기화
        int[] left = new int[nums.length];
        left[0] = nums[0];

        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];

        // 왼쪽 누적곱 계산 (왼쪽 → 오른쪽)
        for (int i = 2; i < nums.length; i++) {
            left[i - 1] = left[i - 2] * nums[i - 1];
        }

        // 오른쪽 누적곱 계산 (오른쪽 → 왼쪽)
        for (int i = nums.length - 3; i > -1; i--) {
            right[i + 1] = right[i + 2] * nums[i + 1];
        }

        // 현재 원소를 제외한 왼쪽, 오른쪽 누적곱을 결합
        for (int i = 0; i < nums.length; i++) {
            int leftMulti = 1;
            int rightMulti = 1;

            // 첫 번째 원소는 오른쪽 구간만 존재
            if (i == 0) {
                rightMulti = right[i + 1];
            }
            // 마지막 원소는 왼쪽 구간만 존재
            else if (i == nums.length - 1) {
                leftMulti = left[i - 1];
            }
            // 중간 원소는 양쪽 구간의 누적곱을 사용
            else {
                leftMulti = left[i - 1];
                rightMulti = right[i + 1];
            }

            dp[i] = leftMulti * rightMulti;
        }

        return dp;
    }
}
