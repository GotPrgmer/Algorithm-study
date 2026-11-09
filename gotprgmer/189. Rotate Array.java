
import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {

        // 1. 회전한 원소의 기존 값을 임시 저장하기 위한 배열
        int[] temp = new int[nums.length];

        // 이미 값이 이동된 인덱스를 기록
        Set<Integer> set = new HashSet<>();

        // 임시 배열 초기화
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.MAX_VALUE;
        }

        // 2. 각 원소를 k칸 오른쪽으로 이동
        for (int i = 0; i < nums.length; i++) {

            // 현재 이동시킬 값
            int cur = nums[i];

            // 이미 덮어쓴 위치라면 기존 값을 가져옴
            if (set.contains(i)) {
                cur = temp[i];
            }

            // k칸 이동한 목적지 인덱스
            int nxt = (i + k) % nums.length;

            // 아직 이동하지 않은 위치인 경우
            if (!set.contains(nxt)) {

                // 덮어쓰기 전에 기존 값을 보관
                temp[nxt] = nums[nxt];

                // 현재 값을 목적지로 이동
                nums[nxt] = cur;

                // 이동 완료한 인덱스 기록
                set.add(nxt);
            }
        }
    }
}
