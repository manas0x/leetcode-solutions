class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int [][] new_nums = new int[n][2];
        for (int i = 0 ; i < n ; i++){
            new_nums[i][0] = nums[i];
            new_nums[i][1] = i;
        }
        Arrays.sort(new_nums , (a,b) -> Integer.compare(a[0],b[0]));

        HashMap <Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.put(new_nums[i][1],i);
        }
        int LOG = 1;

        while ((1 << LOG) < n) LOG++;

        int [] [] up = new int [n] [LOG];

        int right = 0;

        for(int left =  0 ; left < n ; left++){
            if (right < left) right = left;
            while (right + 1 < n && new_nums[right + 1][0] - new_nums[left][0] <= maxDiff) right++;

            up[left][0] = right;
        }
        
        for (int j = 1; j < LOG; j++) {
            for (int ind = 0; ind < n; ind++) {
                up[ind][j] = up[up[ind][j - 1]][j - 1];
            }
        }


        int ans[] = new int[queries.length];
        for(int ind=0; ind<queries.length; ind++) {
            int src = map.get(queries[ind][0]);
            int dest = map.get(queries[ind][1]);

            if(src > dest) {
                int temp = src;
                src = dest;
                dest = temp; 
            }

            if(src==dest) {
                ans[ind] = 0;
                continue;
            }

            int curr = src;
            int hops = 0;
            
            for (int j = LOG - 1; j >= 0; j--) {
                if (up[curr][j] < dest) {
                    curr = up[curr][j];
                    hops += (1<<j);
                }
            }

        if (up[curr][0] >= dest) {
                ans[ind] = hops + 1;
            } else {
                ans[ind] = -1; 
            }
        }

        return ans;

    }
}