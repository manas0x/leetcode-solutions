class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        map = {}

        arrsorted = sorted(arr)
        rank = 1

        for num in arrsorted:
            if num not in map:
                map[num] = rank
                rank+=1
        
        return [map[num] for num in arr]