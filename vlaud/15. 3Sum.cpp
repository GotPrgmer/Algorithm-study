#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/*
배열의 모든 원소를 카운팅 후, 요구되는 값에 해당하는 원소가 필요한 개수만큼 있는지 파악한다.
*/
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        const int n = nums.size();

        // 배열 정렬
        sort(begin(nums), end(nums));

        // 최소값에 -1을 곱해 최소 원소가 0번 인덱스에 오도록 설정
        int minn = -nums[0];
        int maxx = nums.back();

        // 원소 카운팅 배열, 크기는 최소값~최대값 범위만큼 생성 
        vector<int> mp(minn + maxx + 1);

        // 원소의 개수를 카운트
        for (int& i : nums) mp[i + minn]++;

        vector<vector<int>> res;

        // 첫번째 인덱스
        int i = 0;
        while (i < n)
        {
            // 첫번째 원소
            int x = nums[i];

            // 두번째 인덱스
            int j = i + 1;
            while (j < n)
            {
                // 두번째 원소
                int y = nums[j];

                // 중복 방지를 위해 두번째 인덱스가 두번쨰 원소와 다를 때까지 옮김
                while (j < n && nums[j] == y) j++;

                // req + x + y = 0이여야 하므로 rq = -x-y
                int req = -x - y;

                if (req < y) break; // x < req < y -> 이미 이전에 검사를 했으므로 (더 이상 검사할 게 없음) 반복문 빠지기
                else if (maxx < req) continue; // req가 최대값보다 크면 배열 안에 없으므로 스킵

                // 중복 원소 개수
                int same = 0;
                if (x == req) same++;
                if (y == req) same++;

                // same == 1이면 x,y 둘 중 하나가 요구값과 같음 -> 2개 이상 필요
                // same == 2이면, 3개 원소 모두 같음 -> 3개 이상 필요

                // req의 개수가 same 초과일 경우에만 배열에 삽입
                if (mp[minn + req] > same) res.emplace_back(vector<int>({ x,y,req }));
            }
            // 중복 방지를 위해 첫번째 인덱스가 첫번째 원소와 다를 때까지 옮김
            while (i < n && nums[i] == x) i++;
        }
        return res;
    }
};