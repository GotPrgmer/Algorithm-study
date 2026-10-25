
class Solution {
    // 병합이 완료되어 탐색 대상에서 제외할 구간의 인덱스
    static Set<Integer> mergedIdx;

    // 병합이 완료된 최종 구간을 저장하는 리스트
    static List<int[]> candidates;

    // 원본 구간 배열
    static int[][] intervals;

    public int[][] merge(int[][] intervals) {
        mergedIdx = new HashSet<>();
        candidates = new ArrayList<>();
        Solution.intervals = intervals;

        // 완전탐색: 각 구간을 기준으로 병합 가능한 구간을 탐색
        for (int i = 0; i < intervals.length; i++) {
            // 이미 다른 구간에 병합된 경우 탐색 제외
            if (mergedIdx.contains(i)) continue;

            merge(i);
        }

        // 병합된 구간을 결과 배열로 변환
        int[][] ans = new int[candidates.size()][2];

        for (int i = 0; i < candidates.size(); i++) {
            int ansS = candidates.get(i)[0];
            int ansE = candidates.get(i)[1];

            ans[i][0] = ansS;
            ans[i][1] = ansE;
        }

        // 구간의 시작점을 기준으로 오름차순 정렬
        Arrays.sort(ans, (a, b) -> a[0] - b[0]);

        return ans;
    }

    // 기준 구간과 겹치는 모든 구간을 병합
    public void merge(int idx) {
        // 기준 구간의 시작점과 끝점
        int st = intervals[idx][0];
        int ed = intervals[idx][1];

        // 기준 구간을 처리 대상으로 등록
        mergedIdx.add(idx);

        boolean flag = true;

        // 병합이 발생하면 확장된 구간으로 처음부터 다시 탐색
        while (flag) {
            flag = false;

            for (int i = 0; i < intervals.length; i++) {
                // 이미 병합된 구간은 비교 대상에서 제외
                if (mergedIdx.contains(i)) continue;

                int compareST = intervals[i][0];
                int compareED = intervals[i][1];

                // 현재 구간과 비교 구간이 겹치는 경우
                if (isMerge(compareST, compareED, st, ed)) {
                    // 두 구간을 하나의 구간으로 병합
                    st = Math.min(st, compareST);
                    ed = Math.max(ed, compareED);

                    // 병합된 원본 구간을 이후 탐색에서 제외
                    mergedIdx.add(i);

                    // 병합으로 범위가 확장되었으므로 재탐색 필요
                    // 이전에 겹치지 않았던 구간도 겹칠 수 있음
                    flag = true;
                    break;
                }
            }
        }

        // 더 이상 병합할 구간이 없으면 최종 결과에 추가
        candidates.add(new int[]{st, ed});
    }

    // 두 구간의 겹침 여부 판단
    public boolean isMerge(int compareST, int compareED, int st, int ed) {
        // 두 구간이 완전히 분리되어 있으면 병합 불가능
        if (ed < compareST || compareED < st) {
            return false;
        } else {
            // 분리된 경우가 아니라면 두 구간은 겹침
            return true;
        }
    }
}
