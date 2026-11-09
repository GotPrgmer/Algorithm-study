
import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {

        // 누적합 → 최초 등장 인덱스 저장
        Map<Integer, Integer> map = new HashMap<>();

        // 0과 1의 개수가 같은 최장 부분 배열의 길이
        int ans = 0;

        // 1. 0을 -1로 변환
        // 0과 1의 개수가 같다면 해당 구간의 합은 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        // 2. 누적합을 계산하며 최장 구간 탐색
        for (int i = 0; i < nums.length; i++) {

            // 이전 누적합에 현재 값을 더함
            if (i != 0) {
                nums[i] = nums[i - 1] + nums[i];
            }

            // 누적합이 0인 경우
            // 처음부터 현재 인덱스까지 0과 1의 개수가 같음
            if (nums[i] == 0) {
                ans = Math.max(ans, i + 1);
            }

            else {
                // 현재 누적합이 처음 등장한 경우
                // 최장 구간을 찾기 위해 최초 인덱스만 저장
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], i);
                }

                // 동일한 누적합이 이전에 등장한 경우
                else {
                    // 두 누적합 사이 구간의 합은 0
                    int prev = map.get(nums[i]);

                    // 구간 길이 = 현재 인덱스 - 이전 인덱스
                    ans = Math.max(ans, i - prev);
                }
            }
        }

        // 3. 최장 부분 배열의 길이 반환
        return ans;
    }
}
