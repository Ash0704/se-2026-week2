import java.util.*;

public class bfs {
    // 그래프를 표현하기 위한 인접 리스트
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    // 정점(Node) 추가
    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    // 간선(Edge) 추가 (무방향 그래프 기준)
    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    // BFS 메소드 구현
    public void bfs(int startVertex) {
        // 방문 여부를 체크할 Set (또는 boolean 배열)
        Set<Integer> visited = new HashSet<>();
        // 탐색 순서를 관리할 Queue
        Queue<Integer> queue = new LinkedList<>();

        // 시작 정점 세팅
        visited.add(startVertex);
        queue.add(startVertex);

        System.out.print("BFS 탐색 순서: ");

        while (!queue.isEmpty()) {
            // 큐에서 하나를 꺼냄
            int current = queue.poll();
            System.out.print(current + " ");

            // 현재 정점과 연결된 인접 정점들을 확인
            for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        bfs graph = new bfs();

        // 그래프 데이터 예시 입력
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);

        // 1번 노드부터 BFS 탐색 시작
        graph.bfs(1);
    }
}