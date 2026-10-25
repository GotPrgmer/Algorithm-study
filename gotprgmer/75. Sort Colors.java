class Solution {
    public int[] sortColors(int[] nums) {
        // 버블 정렬을 이용한 오름차순 정렬
        // 매 순회마다 최댓값이 오른쪽 끝에 확정되므로 정렬 범위를 줄여나감
        for (int i = nums.length - 1; i > 0; i--) {

            // 인접한 두 원소를 비교하며 큰 값을 오른쪽으로 이동
            for (int j = 0; j < i; j++) {

                // 왼쪽 원소가 더 크면 두 원소의 위치를 교환
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }
}