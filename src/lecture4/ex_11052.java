package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
카드 구매하기.

 */
public class ex_11052 {
    public static int max (int a, int b){
        if(a> b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] p = new int[N+1]; //주어지는 p[i] 값
        int[] dp = new int[N+1];

        //주어진 값 초기화, 최댓값 배열 초기화
        for(int i=1; i<=N; i++){
            p[i] = Integer.parseInt(st.nextToken());
            dp[i] = p[i];
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++) {
                dp[i] = max(dp[i], p[j] + dp[i - j]);
            }
        }

        System.out.println(dp[N]);


    }
}
