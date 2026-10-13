class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
         * [문제 정의]
         * - 정렬된 구간 목록에 새로운 구간을 삽입한다.
         * - 서로 겹치는 구간은 병합한다.
         * - 병합 후에도 구간의 정렬 상태를 유지한다.
         *
         * [접근 방식: 선형 탐색]
         * - 새로운 구간을 기준으로 기존 구간을 순차적으로 확인한다.
         * - 각 구간을 세 가지 경우로 분류한다.
         *
         *   1. 현재 구간이 병합 구간보다 왼쪽에 있는 경우
         *      → 병합 없이 결과에 추가한다.
         *
         *   2. 현재 구간이 병합 구간보다 오른쪽에 있는 경우
         *      → 병합 구간을 결과에 삽입하고 이후 구간을 추가한다.
         *
         *   3. 현재 구간과 병합 구간이 겹치는 경우
         *      → 시작점은 최솟값, 끝점은 최댓값으로 갱신한다.
         *
         * [시간복잡도]
         * - O(N): 기존 구간을 한 번씩 탐색한다.
         * - 공간복잡도 O(N): 결과 구간을 저장한다.
         *
         * [최적화 핵심]
         * - 정렬된 구간이라는 특성을 활용한다.
         * - 겹치는 구간을 탐색과 동시에 병합한다.
         * - 병합 구간의 삽입이 완료되면 추가 병합 검사를 생략한다.
         */

        int mergeSt = newInterval[0];
        int mergeEd = newInterval[1];

        List<int[]> ans = new ArrayList<>();

        if (intervals.length == 0) {
            return new int[][]{{mergeSt, mergeEd}};
        }

        boolean isInserted = false;

        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            // 삽입 완료: 남은 구간을 그대로 추가
            if (isInserted) {
                ans.add(new int[]{s, e});
                continue;
            }

            // Case 1. 현재 구간이 병합 구간보다 왼쪽
            if (e < mergeSt) {
                ans.add(new int[]{s, e});
            }

            // Case 2. 현재 구간이 병합 구간보다 오른쪽
            else if (mergeEd < s) {
                ans.add(new int[]{mergeSt, mergeEd});
                ans.add(new int[]{s, e});

                isInserted = true;
            }

            // Case 3. 현재 구간과 병합 구간이 겹침
            else {
                mergeSt = Math.min(mergeSt, s);
                mergeEd = Math.max(mergeEd, e);
            }
        }

        // 순회 종료 후 아직 삽입하지 않은 병합 구간 추가
        if (!isInserted) {
            ans.add(new int[]{mergeSt, mergeEd});
        }

        return ans.toArray(new int[ans.size()][]);
    }
}