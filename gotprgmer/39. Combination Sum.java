
class Solution {
    static int target;
    static List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
         * [접근 방법]
         * 1. 재귀 완전탐색으로 target을 만드는 모든 조합을 탐색
         *
         * 2. 중복 조합 제거
         *    - 처음에는 정렬 후 Set으로 중복을 제거하려고 했음
         *    - 하지만 중복 탐색 자체가 발생하므로 비효율적
         *    - 현재 인덱스부터 탐색하도록 제한하여 중복 조합 방지
         *    - 같은 숫자는 여러 번 선택할 수 있음
         *
         * 3. 가지치기 (경우의 수 줄이기)
         *    - 현재 합계가 target을 초과하면 더 이상 탐색하지 않음
         *    - 재귀 호출 전에 유효성을 검사하여 불필요한 호출 방지
         *
         * 4. DP 대신 백트래킹 선택
         *    - DP로 합계별 경우의 수를 계산하는 방법도 고려
         *    - 하지만 이 문제는 경우의 수가 아닌 실제 조합을 반환해야 함
         *    - 중간 조합을 모두 저장하는 DP보다 백트래킹이 적합하다고 판단
         *
         * 5. 백트래킹
         *    - 원소 선택 → 재귀 탐색 → 선택 취소
         *    - 정답 발견 시 현재 조합을 복사하여 저장
         */

        Solution.target = target;
        ans = new ArrayList<>();

        // 인덱스 0, 합계 0, 빈 조합에서 탐색 시작
        comb(0, 0, new ArrayList<>(), candidates);

        return ans;
    }

    public void comb(int idx, int partSum, List<Integer> cur, int[] candidates) {

        // [종료 조건 1] 목표 합계를 초과하면 탐색 종료
        if (partSum > target) {
            return;
        }

        // [종료 조건 2] 목표 합계에 도달하면 정답 저장
        if (partSum == target) {
            // cur는 계속 변경되므로 복사본을 저장해야 함
            ans.add(new ArrayList<>(cur));
            return;
        }

        // [종료 조건 3] 더 이상 선택할 후보가 없으면 종료
        if (idx == candidates.length) {
            return;
        } else {
            // 현재 인덱스부터 탐색하여 순서만 다른 중복 조합 방지
            for (int i = idx; i < candidates.length; i++) {

                // [가지치기] target을 초과하는 재귀 호출 방지
                if (partSum + candidates[i] <= target) {

                    // 1. 현재 원소 선택
                    cur.add(candidates[i]);

                    // 2. 재귀 탐색
                    // i를 그대로 전달하여 동일한 원소 재사용 허용
                    comb(i, partSum + candidates[i], cur, candidates);

                    // 3. 선택 취소: 이전 상태로 복원
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
