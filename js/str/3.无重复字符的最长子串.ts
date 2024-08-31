function lengthOfLongestSubstring(s: string): number {
   let max = 0
   for (let left = 0, len = s.length; left < len; ++left) {
      const set = new Set([s[left]])
      for (let right = left + 1; right < len; ++right) {
         if (set.has(s[right])) {
            break
         } else {
            set.add(s[right])
         }
      }
      max = Math.max(max, set.size)
   }
   return max
};


export default lengthOfLongestSubstring