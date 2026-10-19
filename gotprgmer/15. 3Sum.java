
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
         * [1. 완전탐색 분석]
         * - 서로 다른 인덱스의 원소 3개를 선택하여 합이 0인 조합을 탐색.
         * - 삼중 반복문을 사용하면 시간복잡도는 O(N^3).
         * - 동일한 값의 조합은 결과에 중복으로 포함되면 안 됨.
         *
         * [2. 최적화 방향]
         * - 경우의 수를 줄이거나, 각 경우의 확인 연산을 최적화하는 방법 고려.
         * - 첫 번째 원소를 고정하고 나머지 두 원소를 탐색하는 방식으로 접근.
         * - 정렬된 배열에서는 합의 크기에 따라 탐색 범위를 줄일 수 있음.
         * - 투 포인터를 활용하여 나머지 두 원소를 O(N)에 탐색.
         *
         * [3. 투 포인터 탐색 규칙]
         * - 배열을 오름차순으로 정렬.
         * - leftIdx : 첫 번째 원소를 고정하는 인덱스.
         * - mid     : 고정 원소 다음 위치에서 시작하는 포인터.
         * - right   : 배열의 마지막 위치에서 시작하는 포인터.
         *
         * 세 원소의 합에 따라 포인터 이동.
         * - 합 > 0 : 합을 줄이기 위해 right 감소.
         * - 합 < 0 : 합을 늘리기 위해 mid 증가.
         * - 합 = 0 : 정답을 저장하고 양쪽 포인터 이동.
         *
         * [4. 중복 제거]
         * - 첫 번째 원소가 이전 원소와 같으면 탐색을 건너뜀.
         * - HashSet을 사용하여 동일한 세 원소 조합의 중복 저장 방지.
         *
         * [5. 시간 및 공간복잡도]
         * - 정렬 : O(N log N)
         * - 첫 번째 원소 선택 : O(N)
         * - 각 원소에 대한 투 포인터 탐색 : O(N)
         * - 전체 시간복잡도 : O(N^2)
         * - 추가 공간복잡도 : O(K), K는 저장된 정답 조합의 수
         *   (정렬 과정의 내부 공간은 제외)
         */

        // 정답 저장 및 중복 제거를 위한 자료구조
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> numList = new ArrayList<>();

        // 투 포인터 탐색을 위해 배열 오름차순 정렬
        Arrays.sort(nums);
        System.out.println(nums.toString());

        // 첫 번째 원소를 고정하고 나머지 두 원소 탐색
        for (int leftIdx = 0; leftIdx < nums.length - 2; leftIdx++) {

            // 동일한 첫 번째 원소에 대한 중복 탐색 방지
            if (leftIdx > 0 && nums[leftIdx] == nums[leftIdx - 1]) {
                continue;
            }

            int mid = leftIdx + 1;
            int right = nums.length - 1;
            int leftValue = nums[leftIdx];

            // 나머지 두 원소를 투 포인터로 탐색
            while (mid < right) {
                int midValue = nums[mid];
                int rightValue = nums[right];

                if (midValue + rightValue + leftValue > 0) {
                    // 합이 양수이면 큰 값을 줄임
                    right--;
                } else if (midValue + rightValue + leftValue < 0) {
                    // 합이 음수이면 작은 값을 늘림
                    mid++;
                } else {
                    // 세 원소의 합이 0인 조합 발견
                    System.out.println(String.valueOf(leftValue));

                    // 동일한 값의 조합이 없을 때만 정답 저장
                    if (!set.contains(Arrays.asList(leftValue, midValue, rightValue))) {
                        result.add(Arrays.asList(leftValue, midValue, rightValue));
                        set.add(Arrays.asList(leftValue, midValue, rightValue));
                    }

                    // 다음 조합 탐색
                    mid++;
                    right--;
                }
            }
        }

        return result;
    }
}
