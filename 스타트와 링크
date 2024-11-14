
import java.util.Scanner;

public class Main {
    static int N; //N명
    static int [][] s; //
    static boolean[] selected;// 각 사람 선택되었는지 여부

    static int minDifference = Integer.MAX_VALUE; // 구해야 하는 능력치 차이 최솟값저장
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        s = new int[N][N];
        selected =new boolean[N];
        // N*N 크기 만큼 입력받음
        for(int i=0; i<N; i++){
            for(int j = 0; j<N; j++){
                s[i][j] = sc.nextInt();
            }
        }
        dividedteam(0,0);
        System.out.println(minDifference);
    }
    // 팀 나누기 재귀 함수 만들기
    static void dividedteam (int index, int count){
        // 팀이 N/2명으로 구성 스타트팀과 링크팀 구성
        if (count == N/2){
            calculateDifference();
            return;
        }
        // 모든 사람들을 한 명씩 선택하거나 선택하지 않음
        for(int i = index; i<N; i++){
            if(!selected[i]){
                selected[i] = true;
                dividedteam(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }
    // 선택된 팀들 간의 능력치 계산
    static void calculateDifference(){
        int startTeam = 0, linkTeam = 0;

        for(int i = 0; i< N; i++){
            for(int j = 0; j<N; j++){
                if(selected[i] && selected[j]){ //스타트팀 능력계산
                    startTeam += s[i][j];
                } else if(!selected[i] && !selected[j]){
                    linkTeam += s[i][j];// 링크팀 능력계산
                }
            }
        }
        // 두 팀 능력치 차이 최솟값 갱신
        int difference = Math.abs(startTeam - linkTeam);
        minDifference = Math.min(minDifference, difference);
    }
}
