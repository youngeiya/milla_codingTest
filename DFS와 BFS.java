import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] graph; // 그래프 저장할 2차원 배열
    static boolean[] visited1; // DFS 방문 배열
    static boolean[] visited2; // BFS 방문 배열

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // 정점의 개수
        int m = in.nextInt(); // 간선의 개수
        int v = in.nextInt(); // 탐색을 시작할 정점 번호

        // 그래프와 방문 배열 초기화
        graph = new int[n + 1][n + 1];
        visited1 = new boolean[n + 1];
        visited2 = new boolean[n + 1];

        // 간선 입력받기 (무방향 그래프)
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v); // DFS 호출
        System.out.println(); // 줄바꿈

        bfs(v); // BFS 호출
    }

    // DFS 구현 - 재귀 이용
    public static void dfs(int v) {
        visited1[v] = true; // 현재 노드 방문 처리
        System.out.print(v + " "); // 방문한 노드 출력

        for (int i = 1; i < graph.length; i++) {
            if (graph[v][i] == 1 && !visited1[i]) { // 연결된 노드 중 방문하지 않은 노드 탐색
                dfs(i); // 재귀 호출
            }
        }
    }

    // BFS 구현
    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>(); // 큐 초기화

        queue.add(v); // 시작 노드를 큐에 추가
        visited2[v] = true; // 시작 노드 방문 처리

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 노드를 꺼냄
            System.out.print(node + " "); // 방문한 노드 출력

            for (int i = 1; i < graph.length; i++) {
                if (graph[node][i] == 1 && !visited2[i]) { // 연결된 노드 중 방문하지 않은 노드 탐색
                    queue.add(i); // 큐에 추가
                    visited2[i] = true; // 방문 처리
                }
            }
        }
    }
}
