
class Solution {
    public int majorityElement(int[] nums) {
        // 각 숫자의 등장 횟수를 저장하는 HashMap
        // Key: 숫자, Value: 등장 횟수
        Map<Integer, Integer> map = new HashMap<>();

        // 배열을 순회하며 각 숫자의 등장 횟수 계산
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];

            if (map.containsKey(nums[i])) {
                // 이미 등장한 숫자라면 카운트 증가
                map.put(key, map.get(key) + 1);
            } else {
                // 처음 등장한 숫자라면 카운트 1로 초기화
                map.put(key, 1);
            }
        }

        int ans = 0;

        // 전체 원소의 절반을 초과하여 등장한 숫자 탐색
        for (int num : map.keySet()) {
            if (map.get(num) > nums.length / 2) {
                // 과반수 원소를 찾으면 정답으로 저장
                ans = num;
                break;
            }
        }

        return ans;
    }
}
