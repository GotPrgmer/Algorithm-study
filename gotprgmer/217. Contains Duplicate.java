
class Solution {
    public boolean containsDuplicate(int[] nums) {

        // 숫자별 등장 횟수를 저장하기 위한 HashMap 생성
        // Key: 숫자, Value: 해당 숫자가 등장한 횟수
        Map<Integer, Integer> map = new HashMap<>();

        // 배열을 순회하며 각 숫자의 등장 횟수를 기록
        for (int i = 0; i < nums.length; i++) {

            // 이미 등장한 숫자라면 기존 등장 횟수를 1 증가
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            // 처음 등장한 숫자라면 등장 횟수를 1로 초기화
            else {
                map.put(nums[i], 1);
            }
        }

        // HashMap에 저장된 모든 숫자를 순회
        for (int num : map.keySet()) {

            // 동일한 숫자가 2번 이상 등장했다면 중복이 존재
            if (map.get(num) >= 2) {
                return true;
            }
        }

        // 모든 숫자의 등장 횟수가 1이라면 중복이 없음
        return false;
    }
}
