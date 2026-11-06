#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

// 유니온 파인드(Disjoint Set Union) 자료구조를 이용한 풀이
class dsu
{
public:
	// 생성자: n개의 원소를 가지는 DSU 초기화
    dsu(int n) : size(n, 1), par(n)
    {
        iota(begin(par), end(par), 0);
    }

	// find 함수: 원소 x가 속한 집합의 대표 원소를 찾음
    int find(int x)
    {
        while (x != par[x])
        {
            par[x] = par[par[x]];
            x = par[x];
        }

        return x;
    }

	// merge 함수: 두 집합을 합침
    void merge(int a, int b)
    {
        a = find(a); b = find(b);

        if (a == b) return;
        if (size[a] < size[b]) swap(a, b);

        par[b] = a;
        size[a] += size[b];
    }

	// getsize 함수: 원소 x가 속한 집합의 크기를 반환
    int getsize(int x)
    {
		x = find(x);
        return size[x];
    }
private:
	// 각 원소의 집합 크기와 부모 노드를 저장하는 벡터
    vector<int> size, par;
};
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        const int n = nums.size();
        if (n == 0) return 0;

		dsu ds(n); // Disjoint Set Union 자료구조 초기화
		unordered_map<int, int> mp; // 숫자와 해당 숫자의 인덱스를 매핑하는 해시맵
        int res = 0;
        for (int i = 0; i < n; i++)
        {
			// 이미 처리한 숫자는 건너뜀
            if (mp.contains(nums[i])) continue;

			// 현재 숫자와 연속된 숫자가 존재하면 두 집합을 합침
            if (mp.contains(nums[i] + 1))
            {
                ds.merge(mp[nums[i] + 1], i);
            }
            if (mp.contains(nums[i] - 1))
            {
                ds.merge(mp[nums[i] - 1], i);
            }

			// 현재 숫자를 해시맵에 추가하고, 최대 연속 길이를 갱신
            mp[nums[i]] = i;
            res = max(res, ds.getsize(i));
        }

        return res;
    }
};