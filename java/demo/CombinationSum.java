package day04;

import java.util.ArrayList;
import java.util.List;

// 39.组合之和。给定一个无重复数组和一个目标值，求解用这个数组中的数字组合出目标值的所有情况，一个数字可以重复用。

class CombinationSum {
    List<List<Integer>> ans = null;
    List<Integer> combine = null;
    int[] candidates = null;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        combine = new ArrayList<>();
        this.candidates = candidates;

        dfs(target, 0);
        return ans;
    }

    public void dfs(int target, int idx) {
        if (idx == candidates.length) return;
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(target, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(target - candidates[idx], idx);
            combine.remove(combine.size() - 1);
        }
    }
}
