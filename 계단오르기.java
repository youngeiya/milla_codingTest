import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 계단 개수 입력받기
        int[] scores = new int[n + 1];
        for(int i = 1; i <= n; i++){
            scores[i] = sc.nextInt();
        }
        //dp 배열 선언
        int[] dp = new int[n+1];

        // 초기값 설정
        if(n>=1) dp[1] = scores[1];
        if(n>=2) dp[2] = scores[1] + scores[2];
        if(n>=3) dp[3] = Math.max(scores[1]+scores[3], scores[2]+scores[3]);

        for(int i = 4; i <= n; i++){
            dp[i] = Math.max(dp[i - 2] + scores[i],dp[i - 3] + scores[i - 1] + scores[i]);
        }
        System.out.println(dp[n]);

    }
}
