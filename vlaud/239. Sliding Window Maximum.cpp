#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>

using namespace std;

// deque를 이용하여, 내림차순으로 정렬된 인덱스를 저장한다. 현재 윈도우에서 최대값의 인덱스는 deque의 맨 앞에 위치한다.
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        const int n = nums.size();

		// deque를 이용하여, 현재 윈도우에서 최대값의 인덱스를 저장한다.
        deque<int> d;

        vector<int> res;
        for (int i = 0; i < n; i++)
        {
			if (!d.empty() && d.front() == i - k) d.pop_front(); // 현재 윈도우에서 벗어난 인덱스는 제거한다.
			while (!d.empty() && nums[d.back()] <= nums[i]) d.pop_back(); // 현재 원소보다 작은 원소들은 deque에서 제거한다.
			d.emplace_back(i); // 현재 인덱스를 deque에 추가한다.

			if (k - 1 <= i) res.emplace_back(nums[d.front()]); // 현재 윈도우의 최대값(deque의 맨 앞)을 결과에 추가한다.
        }

        return res;
    }
};