
class Solution {
public:
    int minimumRightShifts(std::vector<int>& nums) {
        int j = 0;
        int f = 0;

        for (int i = 0; i < nums.size() - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];

            if (next < current) {
                f++;
            } else if (f == 0) {
                j++;
            }
        }

        if (nums[nums.size() - 1] > nums[0]) {
            f++;
        }

        if (f > 1) {
            return -1;
        }

        if (f == 1) {
            return nums.size() - j - 1;
        }

        return 0;
    }
};
