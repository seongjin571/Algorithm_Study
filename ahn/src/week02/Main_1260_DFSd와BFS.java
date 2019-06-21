package week02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

        /*문제
        그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

        입력
        첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

        출력
        첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.*/


public class Main_1260_DFSd와BFS {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        Graph graph = new Graph();
        graph.init(n);

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.map[a][b] = 1;
            graph.map[b][a] = 1;
        }
        graph.DFS(v);
        graph.memset(n);
        graph.BFS(v);
    }
}

class Graph {
    public static int map[][];
    public static int visited[];

    public void init(int n){
        map = new int[n+1][n+1];
        visited = new int[n+1];
    }

    public void memset(int n){
        for(int i=0; i<n+1; i++){
            visited[i] = 0;
        }
    }

    //DFS
    public void DFS(int start){

        visited[start] = 1;

        System.out.print(start + " ");

        for(int i = 1; i<visited.length; i++){
            if(map[start][i] == 1 && visited[i] == 0){
                DFS(i);
            }
        }
    }

    //BFS
    public void BFS(int start){
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[start] = 1;

        queue.add(start);

        System.out.println(start + " ");

        while(!queue.isEmpty()){
            start = queue.poll();

            for(int i=1; i<visited.length; i++){
                if(map[start][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;

                    System.out.print(i + " ");

                    queue.add(i);
                }
            }
        }
    }
}