#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        const int n = nums.size();

		// 로무토 partition을 이용하여 0이 아닌 원소들을 앞으로 이동시키고, 0은 뒤로 이동시킨다.
        for (int i = 0, l = 0; i < n; i++) {
			if (nums[i] != 0) { // 0이 아닌 원소를 발견하면, 0이 아닌 원소들을 앞으로 이동시키고, 0은 뒤로 이동시킨다.
                swap(nums[l++], nums[i]);
            }
        }
    }
};
