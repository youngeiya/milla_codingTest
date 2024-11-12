import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 공 1547번
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받을때 BufferedReader를 사용하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 컵이 위치를 바꾼횟수
        int N = Integer.parseInt(br.readLine());
        // 공의 위치
        int num = 1;
        // 컵의 위치를 바꾼방법 X와 Y X와 Y 바꾼것임
        for(int i=0; i<N; i++){
            // 문자열로 입력받은 걸 숫자로 바꿈
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            if(a == num){
                num = b;
            } else if(b == num){
                num = a;
            }
        }
        System.out.println(num);
    }
}
