
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        // 1. 배열을 오름차순으로 정렬
        Arrays.sort(nums);

        // 최장 연속 수열의 길이
        int answer = 0;

        // 현재 탐색 중인 숫자
        int cur = -1_000_000_005;

        // 현재 연속 수열의 길이
        int cnt = 1;

        // 배열이 비어 있다면 0 반환
        if (nums.length == 0) {
            return 0;
        }

        // 2. 정렬된 배열을 순회하며 연속 수열 탐색
        for (int numIdx = 0; numIdx < nums.length; numIdx++) {

            // 첫 번째 원소를 기준으로 탐색 시작
            if (numIdx == 0) {
                cnt = 1;
                cur = nums[numIdx];
            }

            // 이전 숫자와 1 차이 → 연속 수열 길이 증가
            else if ((cur + 1) == nums[numIdx]
                    || (cur - 1) == nums[numIdx]) {
                cnt += 1;
                cur = nums[numIdx];
            }

            // 중복된 숫자는 연속 수열 길이에 포함하지 않음
            else if (cur == nums[numIdx]) {
                continue;
            }

            // 연속성이 끊어진 경우
            else {
                // 지금까지 탐색한 수열의 최대 길이 갱신
                answer = Math.max(answer, cnt);

                // 현재 숫자를 기준으로 새로운 수열 시작
                cur = nums[numIdx];
                cnt = 1;
            }
        }

        // 3. 마지막 연속 수열의 길이까지 반영
        answer = Math.max(answer, cnt);

        return answer;
    }
}
