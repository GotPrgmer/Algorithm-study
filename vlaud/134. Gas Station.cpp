#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
		// 전체 가스의 합이 전체 비용의 합보다 작으면 어떤 시작점에서도 순회할 수 없음
        if (accumulate(begin(gas), end(gas), 0) < accumulate(begin(cost), end(cost), 0)) return -1;

        const int n = gas.size();

		// 현재까지의 가스 잔량을 저장할 변수와 시작점을 저장할 변수
        int sum = 0;
        int l = 0;

        for (int i = 0; i < n; i++)
        {
			// 현재 가스 잔량이 음수가 되면, 이전 시작점에서는 순회할 수 없으므로 현재 지점을 시작점으로 설정
            if (sum < 0)
            {
                sum = 0;
                l = i;
            }

			// 현재 가스 잔량을 업데이트
            sum += gas[i] - cost[i];
        }

        return l;
    }
};
