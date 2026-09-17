class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] arr=new char[n][n];

        for(char[] row:arr)
        Arrays.fill(row,'.');

        solve(n,0,arr,res);
        return res;

    }
    public void solve(int n,int row,char[][] arr,List<List<String>>res)
    {
        if(row==n)
        {
            List<String>temp=new ArrayList<>();

            for(char[] rows:arr)
            {
                temp.add(new String(rows));
            }
            res.add(temp);
            return;
        }

        for(int col=0;col<n;col++)
        {
            if(issafe(n,row,col,arr))
            {
                arr[row][col]='Q';
                solve(n,row+1,arr,res);
                arr[row][col]='.';
            }
        }
    }
    public boolean issafe(int n,int row,int col,char[][] arr)
    {
        for(int i=0;i<row;i++)
        {
            if(arr[i][col]=='Q') return false;
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--)
        {
            if(arr[i][j]=='Q')
            return false;
        }

        for(int i=row,j=col;i>=0&&j<n;i--,j++)
        {
            if(arr[i][j]=='Q')
            return false;
        }
        return true;
    }
}