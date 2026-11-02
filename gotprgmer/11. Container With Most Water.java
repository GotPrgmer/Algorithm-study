
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 현재 출발 후보 지점
        int start = 0;

        // 이동 가능 여부를 확인할 주유소 인덱스
        int check = start;

        // 이전 출발 후보들이 실패하면서 누적된 연료 부족분
        int remain = 0;

        // 현재 출발 후보부터 누적된 연료 잔량
        int cur = 0;

        // 주유소가 하나뿐인 경우
        // 해당 주유소의 연료로 이동 비용을 감당할 수 있는지 확인
        if (gas.length == 1) {
            if (gas[0] >= cost[0]) {
                return 0;
            } else {
                return -1;
            }
        }

        // 전체 순환이 가능한지 확인하는 변수
        boolean isPass = false;

        while (true) {

            // 현재 주유소에서 연료를 충전하고
            // 다음 주유소까지 이동하는 비용을 차감
            cur += gas[check] - cost[check];

            // 마지막 주유소까지 검사한 경우
            if (check == gas.length - 1) {

                // 현재 후보의 연료 잔량과 이전 부족분을 합산
                // 전체 연료가 전체 이동 비용 이상인지 확인
                if (cur + remain >= 0) {
                    isPass = true;
                }

                // 모든 주유소를 검사했으므로 종료
                break;
            }

            // 현재 출발 후보로 다음 주유소에 도달할 수 없는 경우
            if (cur < 0) {

                // 실패한 구간의 연료 부족분을 누적
                remain += cur;

                // 새로운 출발 후보를 위해 연료 잔량 초기화
                cur = 0;

                // 실패한 지점의 다음 주유소로 검사 위치 이동
                check = (check + 1) % gas.length;

                // 기존 출발 후보부터 실패 지점까지는
                // 출발점이 될 수 없으므로 다음 지점을 후보로 지정
                start = check;
            }

            // 현재 출발 후보로 다음 주유소까지 이동 가능한 경우
            else {
                // 출발 후보를 유지하고 검사 위치만 이동
                check = (check + 1) % gas.length;
            }
        }

        // 전체 순환이 가능하다면 출발 후보 반환
        if (isPass) {
            return start;
        }

        // 전체 연료가 부족하여 순환이 불가능한 경우
        else {
            return -1;
        }
    }
}
