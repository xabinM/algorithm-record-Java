package SSAFY.삼성A형;

import java.util.*;

public class StemCellCulture {
    private static final int TEMP_SIZE = 500;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static Cell[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            graph = new Cell[TEMP_SIZE][TEMP_SIZE];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int realX = i + TEMP_SIZE / 2;
                    int realY = j + TEMP_SIZE / 2;
                    int time = sc.nextInt();
                    if (time == 0) continue;
                    graph[realX][realY] = new Cell(realX, realY, time, time);
                }
            }

            for (int k = 0; k <= K; k++) {
                Queue<Cell> queue = new ArrayDeque<>();
                for (int i = 0; i < TEMP_SIZE; i++) {
                    for (int j = 0; j < TEMP_SIZE; j++) {
                        Cell curCell = graph[i][j];

                        if (curCell == null || curCell.status == Status.DEAD) continue;

                        if (curCell.status == null) {
                            curCell.status = Status.INACTIVE;
                        }

                        if (curCell.status == Status.ACTIVE) {
                            curCell.decreaseTime();

                            if (curCell.time == 0) {
                                curCell.status = Status.DEAD;
                                continue;
                            }
                        }

                        if (curCell.status == Status.INACTIVE) {
                            if (curCell.time == 0) {
                                curCell.status = Status.ACTIVE;
                                curCell.initTime();
                                queue.offer(curCell);   // ACTIVE로 바뀌는 순간 번식 시작
                            } else {
                                curCell.decreaseTime();
                            }
                        }
                    }
                }
                deltaSearch(queue);
            }

            int result = 0;
            for (int i = 0; i < TEMP_SIZE; i++) {
                for (int j = 0; j < TEMP_SIZE; j++) {
                    if (graph[i][j] != null && (graph[i][j].status == Status.INACTIVE || graph[i][j].status == Status.ACTIVE)) {
                        result++;
                    }
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }

    private static void deltaSearch(Queue<Cell> queue) {
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (graph[nx][ny] == null) {
                    graph[nx][ny] = new Cell(nx, ny, cur.originTime, cur.originTime);
                } else if (graph[nx][ny].status == null) {
                    graph[nx][ny] = graph[nx][ny].originTime > cur.originTime ? graph[nx][ny] : new Cell(nx, ny, cur.originTime, cur.originTime);
                }
            }
        }
    }

    private static class Cell {
        final int x, y, originTime;
        int time;
        Status status;

        public Cell(int x, int y, int originTime, int time) {
            this.x = x;
            this.y = y;
            this.originTime = originTime;
            this.time = time;
        }

        public void decreaseTime() {
            if (this.time > 0) {
                this.time--;
            }
        }

        public void initTime() {
            this.time = this.originTime;
        }
    }

    private enum Status {
        INACTIVE, ACTIVE, DEAD;
    }
}
