#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> res;

        // newInterval의 값을 범위가 겹치는 원소들의 총 범위 길이만큼 확장한 후, 삽입
        for (auto& e : intervals)
        {
            // intervals[i]의 두번째 원소가 newInterval의 첫번째 원소보다 작으면 그대로 삽입 
            if (e[1] < newInterval[0]) res.emplace_back(e); 
            else if (e[0] > newInterval[1])
            {
                // intervals[i]의 첫번째 원소가 newInterval의 두번째 원소보다 크면 newInterval 삽입 후 갱신
                res.emplace_back(newInterval);
                newInterval = e;
            }
            else
            {
                // 두 배열이 겹쳐 있으면 newInterval의 첫번째 원소는 가장 작은 값, 두번째 원소는 가장 큰 값으로 갱신
                newInterval[0] = min(newInterval[0], e[0]);
                newInterval[1] = max(newInterval[1], e[1]);
            }
        }

        // 마지막 원소 삽입
        res.emplace_back(newInterval);
        return res;
    }
};

int main()
{
	return 0;
}