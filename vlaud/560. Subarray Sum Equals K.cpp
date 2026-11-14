#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
		unordered_map<int, int> mp; // key: 누적합, value: 누적합이 나온 횟수
		mp[0] = 1; // 공배열의 누적합은 0이므로, 0을 미리 넣어준다.

		// 누적합을 구하면서, (누적합 - k)가 나온 적이 있는지 확인한다.
        int t = 0, res = 0;
        for (int& i : nums)
        {
			t += i; // 누적합
			if (mp.find(t - k) != mp.end()) res += mp[t - k]; // (누적합 - k)가 나온 적이 있다면, 그 횟수만큼 결과에 더해준다.
			mp[t]++; // 현재 누적합을 map에 넣어준다.
        }

        return res;
    }
};