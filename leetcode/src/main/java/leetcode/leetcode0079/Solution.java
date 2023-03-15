package leetcode.leetcode0079;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] cs = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(solution.exist(cs, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,String word,int index,int x,int y){
        if(x<0||x>board.length-1||y<0||y>board[0].length-1||board[x][y]=='.'||board[x][y]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }else{
            char temp=board[x][y];
            board[x][y]='.';
            boolean b=dfs(board,word,index+1,x+1,y)||dfs(board,word,index+1,x-1,y)||
                    dfs(board,word,index+1,x,y+1)||dfs(board,word,index+1,x,y-1);
            board[x][y]=temp;
            return b;
        }

    }
}
