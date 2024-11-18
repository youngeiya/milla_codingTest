import java.util.Scanner;

public class Main {

    public static boolean[][] arr; //겹치는 값 boolean으로 확인
    public static int min = 64;

    public static void main(String[] args) {

        // N과 M의 값 입력받기
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        // N과 M boolean방식으로 입력받음
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = in.next();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    // 8*8 크기의 배열을 하나씩 검사하면서 첫칸색이 하얀색일 경우와 검은색일 경우의 수를 비교해서
// 칠한 개수의 최소값을 구함
    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y]; // 첫번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 올바른 색 아닐 경우 count1 증가
                if (arr[i][j] != TF) {
                    count++;
                }
                // 다음 칸 색 바꿔주기 true를 false로 false를 true로
                TF = (!TF);
            }
            TF = !TF;
        }
        count = Math.min(count, 64 - count);

        min = Math.min(min,count);
    }
}
