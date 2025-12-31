class Solution {

    public int latestDayToCross(int row, int col, int[][] cells) {

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        int left = 1, right = row * col, ans = 0;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (canCross(mid, row, col, cells, dirs)) {

                ans = mid;

                left = mid + 1;

            } else {

                right = mid - 1;

            }

        }

        return ans;

    }

    private boolean canCross(int day, int row, int col, int[][] cells, int[][] dirs) {

        int[][] grid = new int[row][col];

        for (int i = 0; i < day; i++) {

            int r = cells[i][0] - 1;

            int c = cells[i][1] - 1;

            grid[r][c] = 1;

        }

        boolean[][] vis = new boolean[row][col];

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int c = 0; c < col; c++) {

            if (grid[0][c] == 0) {

                q.offer(new int[]{0, c});

                vis[0][c] = true;

            }

        }

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0], c = cur[1];

            if (r == row - 1) return true;

            for (int[] d : dirs) {

                int nr = r + d[0], nc = c + d[1];

                if (

                    nr >= 0 && nr < row &&

                    nc >= 0 && nc < col &&

                    !vis[nr][nc] &&

                    grid[nr][nc] == 0

                ) {

                    vis[nr][nc] = true;

                    q.offer(new int[]{nr, nc});

                }

            }

        }

        return false;

    }

}
