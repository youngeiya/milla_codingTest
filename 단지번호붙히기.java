import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N;  // 지도의 크기 입력받는 수
    static int[][] graph; // 지도크기
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1}; // 좌우이동
    static int[] dy = {-1,1,0,0}; // 상하이동
    static int houseCount; //하나단지 속 집의개수 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        Queue<Integer> result = new LinkedList<>();
        // 지도 입력받기
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = line.charAt(j) - '0'; // 지도 입력받고 '0'과 '1'로 나누기
            }
        }
        // 모든 집 탐색하면서 단지 수,집의수 계산
        for(int i = 0; i< N; i++){
            for(int j=0; j<N; j++){
                //집이 있고, 아직 방문하지 않은경우
                if(graph[i][j] == 1 && !visited[i][j]){
                    houseCount = 0;
                    bfs(i,j);
                    result.add(houseCount);
                }
            }
        }
        //결과출력 - 오름차순으로 설정
        Collections.sort((List) result);
        System.out.println(result.size());
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }
    //BFS함수 만들기
    public static void bfs(int y,int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});
        visited[y][x] = true;
        houseCount++;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int curY = current[0];
            int curX = current[1];

            // 상하좌우 탐색
            for(int i = 0; i<4; i++){
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                // 범위 내에 있고, 아직 방문안했을경우, 집이 있으면
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX< N){
                    if(graph[nextY][nextX] == 1 & !visited[nextY][nextX]){
                        visited[nextY][nextX] = true;
                        queue.offer(new int[]{nextY,nextX});
                        houseCount++;
                    }
                }
            }
        }
    }
}
