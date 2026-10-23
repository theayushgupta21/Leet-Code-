class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) return 0;

        boolean[][] visited = new boolean[m][n];
        // min-heap of {height, row, col}, ordered by height
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // start from the border: water can't be held above the border's height
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int water = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0], r = cur[1], c = cur[2];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                // the neighbor's water level is bounded by the lowest wall around it, which is h
                water += Math.max(0, h - heightMap[nr][nc]);
                pq.offer(new int[]{Math.max(h, heightMap[nr][nc]), nr, nc});
            }
        }

        return water;
    }
}