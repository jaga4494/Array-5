class Solution {
    // GGLLGG 
    // GL
    // GLRLG
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) {
            return true;
        }

        int i = 0;
        int x = 0;
        int y = 0;
        int[][] dir = new int[][] {{0,1}, {1,0}, {0, -1}, {-1,0}}; // N E S W

        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                i = (i + 3) % 4;
            } else if (c == 'R') {
                i = (i + 1) % 4;
            } else if (c == 'G') {
                x += dir[i][0];
                y += dir[i][1];
            }
        }

        return (x == 0 && y == 0) || i != 0;
        
    }
}