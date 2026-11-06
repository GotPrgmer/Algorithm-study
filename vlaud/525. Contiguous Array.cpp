#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
		// 구간합과 인덱스를 저장하는 해시맵
        unordered_map<int,int> mp;

		// 구간합이 0일 때를 위해 초기값 설정 (0일 때는 인덱스 -1로 설정)
        mp[0] = -1;

        int res = 0, sum = 0;

        for (int i = 0; i<nums.size();i++)
        {
			// 1을 1로, 0을 -1로 변환하여 구간합 계산
            sum += (nums[i] == 1 ? 1 : -1);

			// 구간합이 이전에 나온 적이 있다면, 그 구간의 길이를 계산하여 최대값 갱신
            if (!mp.contains(sum)) mp[sum] = i;
            res = max(res, i-mp[sum]);
        }
        return res;
    }
};