

var minWindow = function (s, t) {
   const map = {}
   for (let i = 0, len = s.length; i < len; ++i) {
      const tmp = s[i]
      map[tmp] = i
   }

   const result = []
   for (let i = 0, len = t.length; i < len; ++i) {
      const tmp = t[i]
      const index = map[tmp]
      if (index === undefined) return ''
      result.push(map[tmp])
   }
   const _ = result.toSorted((a, b) => a - b)
   const min = _[0], max = _[result.length - 1]
   return s.slice(min, max + 1)
};


console.log(minWindow("ADOBECODEBANC", "ABC"))


