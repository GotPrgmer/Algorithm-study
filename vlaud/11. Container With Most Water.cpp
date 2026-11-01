#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 투 포인터 방법
class Solution {
public:
    int maxArea(vector<int>& height) {
		// 왼쪽 포인터와 오른쪽 포인터를 초기화
        int l = 0, r = height.size() - 1;

		// 최대 면적을 저장할 변수
        int res = 0;
        while (l < r) {
			// 현재 왼쪽과 오른쪽 포인터의 높이 중 작은 값을 선택
            int h = min(height[l], height[r]);

			// 현재 면적을 계산하고 최대 면적을 갱신
            res = max(res, h * (r - l));

			// 왼쪽 포인터의 높이가 최소라면 왼쪽 포인터를 증가시키고, 그렇지 않으면 오른쪽 포인터를 감소시킴
            if (h == height[l]) l++;
            else r--;
        }

        return res;
    }
};