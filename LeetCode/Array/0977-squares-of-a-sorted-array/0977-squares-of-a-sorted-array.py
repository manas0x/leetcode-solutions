class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        
        for sp in range(len(nums)):
            if nums[sp] >= 0:
                break
        
        neg = nums[:sp][::-1]
        pos = nums[sp:]
        result = []
        
        neg = [x * x for x in neg]
        pos = [y * y for y in pos]

        print(neg,pos)
        i , j = 0,0

        while(i < len(neg) and j < len(pos)):
            if neg[i] < pos[j]:
                result.append(neg[i])
                i+=1
            else:
                result.append(pos[j])
                j+=1
        
        while(i < len(neg)):
            result.append(neg[i])
            i+=1
        
        while(j < len(pos)):
            result.append(pos[j])
            j+=1
        
        return result