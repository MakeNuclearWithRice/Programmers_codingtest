package bruteforce;

import java.util.*;

public class ElectronicNetwork {
    public int solution(int n, int[][] wires) {
        // 1. 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        int minDifference = Integer.MAX_VALUE;

        // 2. 모든 간선을 제거하며 탐색
        for (int[] wire : wires) {
            // 현재 간선을 제거
            int node1 = wire[0];
            int node2 = wire[1];
            graph.get(node1).remove((Integer) node2);
            graph.get(node2).remove((Integer) node1);

            // 3. 두 서브 그래프의 노드 개수를 계산
            boolean[] visited = new boolean[n + 1];
            int nodesInSubGraph = countNodes(graph, node1, visited);
            int difference = Math.abs(nodesInSubGraph - (n - nodesInSubGraph));

            // 4. 최소 차이 갱신
            minDifference = Math.min(minDifference, difference);

            // 간선을 다시 복구
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return minDifference;
    }

    // 그래프 탐색 (DFS로 서브 그래프의 노드 개수 세기)
    private int countNodes(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        int count = 1; // 현재 노드 포함
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += countNodes(graph, neighbor, visited);
            }
        }
        return count;
    }
}