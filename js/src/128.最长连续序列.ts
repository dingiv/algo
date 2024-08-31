

function longestConsecutive(nums: number[]): number {
   if (!(nums.length > 0)) return 0
   const tmp = [...nums].sort((a, b) => a - b)

   let length = 1, max = 1
   for (let i = 1, len = tmp.length; i < len; ++i) {
      if (tmp[i] === tmp[i - 1] + 1) length++
      else if (tmp[i] === tmp[i - 1]) continue
      else max = Math.max(max, length), length = 1
   }

   max = Math.max(max, length)
   return max
};

export default longestConsecutive