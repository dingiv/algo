/**
 * @param {string[]} strs
 * @return {string[][]}
 */
export var groupAnagrams = function (strs: string[]) {
   const tmp = strs.map(x => ({
      nv: x.split('').sort().join(''),
      ov: x
   })).sort((a, b) => Number(a.nv < b.nv) * -1)

   const result = [[tmp[0].ov]]
   let prev = tmp[0].nv
   for (let i = 1, j = 0, len = tmp.length; i < len; ++i) {
      const el = tmp[i]
      if (el.nv === prev) {
         result[j].push(el.ov)
      } else {
         result[++j] = [el.ov]
         prev = el.nv
      }
   }

   return result
};