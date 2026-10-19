
class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
         * [접근 방법]
         *
         * 1. 완전탐색 O(N²)
         *    - 각 인덱스 i를 제외한 나머지 원소들의 곱을 계산
         *    - 모든 인덱스마다 나머지 원소를 순회하면 O(N²)
         *
         * 2. 최적화 방향 탐색
         *    - 단순 곱셈 연산이므로 개별 연산 비용을 줄이기 어려움
         *    - 각 인덱스의 결과를 계산하는 과정에서 중복 연산이 발생
         *    - 중복되는 곱셈을 재사용할 수 있는지 고민
         *
         * 3. 구간 분리
         *    - 인덱스 i를 제외한 곱은 두 구간의 곱으로 표현 가능
         *    - 왼쪽 구간: 0 ~ (i-1)
         *    - 오른쪽 구간: (i+1) ~ (n-1)
         *
         *    예시 (n = 4)
         *    i = 0 : 왼쪽 없음, 오른쪽 1~3
         *    i = 1 : 왼쪽 0~0, 오른쪽 2~3
         *    i = 2 : 왼쪽 0~1, 오른쪽 3~3
         *    i = 3 : 왼쪽 0~2, 오른쪽 없음
         *
         * 4. 누적곱 활용
         *    - 왼쪽에서 오른쪽으로 누적곱 계산
         *    - 오른쪽에서 왼쪽으로 누적곱 계산
         *    - 각 인덱스에 필요한 좌우 누적곱을 곱하여 결과 생성
         *    - 양쪽을 동시에 순회하여 O(N)에 해결
         *
         * 시간복잡도: O(N)
         * 공간복잡도: O(1) - 결과 배열
         */

        // 결과 배열 초기화 (곱셈의 항등원 1)
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // 좌우 누적곱
        int leftMulti = 1;
        int rightMulti = 1;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {

            // [첫 번째 인덱스]
            // 왼쪽/오른쪽 끝에는 각각 곱할 원소가 없는 구간이 존재
            // 빈 구간의 곱은 1로 처리
            if (i == 0) {
                dp[0] = leftMulti;
                dp[nums.length - 1] = rightMulti;
            }

            // [마지막 인덱스]
            // 양쪽 끝 원소를 제외한 누적곱을 최종 반영
            else if (i == nums.length - 1) {
                leftMulti *= nums[i - 1];
                rightMulti *= nums[1];

                dp[0] *= rightMulti;
                dp[nums.length - 1] = leftMulti;
            }

            // [중간 인덱스]
            // 왼쪽과 오른쪽에서 누적곱을 각각 갱신
            else {
                leftMulti *= nums[i - 1];
                rightMulti *= nums[nums.length - i];

                // 현재 인덱스에 왼쪽 누적곱 반영
                dp[i] *= leftMulti;

                // 대칭 인덱스에 오른쪽 누적곱 반영
                dp[n - i - 1] *= rightMulti;
            }
        }

        return dp;
    }
}
