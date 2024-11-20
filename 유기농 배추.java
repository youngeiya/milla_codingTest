import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] graph; // 배추밭의 크기
    static boolean[][] visited; // 방문체크 해주기
    static int[] dx = {0,0,-1,1};// x,y축 상하좌우 표시해줘야 함
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        //
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스 개수
        int T = Integer.parseInt(br.readLine());
        // 배추밭 탐색하는 for문
        for (int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            graph = new int[N][M];
            visited = new boolean[N][M];

            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1; // 배추가 있는 곳 표시
            }

            int wormCount = 0; //흰지렁이 수

            // 배추밭 전체 탐색
            for(int i = 0; i<N; i++){
                for(int j=0; j<M;j++){
                    if(graph[i][j] == 1 && !visited[i][j]){
                        bfs(i,j); // 연결요소 발견했을때 BFS 실행함
                        wormCount++; // 흰지렁이 추가
                    }
                }
            }
            bw.write(wormCount + "\n");
        }
        bw.flush();
        bw.close();
    }
    // BFS함수
    public static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y,x});
        visited[y][x] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int curY = current[0];
            int curX = current[1];

            // 상하좌우로 이동
            for(int i = 0; i <4; i++){
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                // 범위 체크 및 방문 여부 확인
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    if(graph[nextY][nextX] == 1 && !visited[nextY][nextX]){
                        queue.offer(new int[] {nextY,nextX});
                        visited[nextY][nextX]=true;
                    }
                }
            }

        }
    }
}
