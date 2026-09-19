class Solution {

    public boolean isPossible(double a, double b, double m, double c, int r) {
        double dist = Math.abs(m * a - b + c) / Math.sqrt(m * m + 1);
        return dist <= r;
    }

    public double[] getLine(int x1, int y1, int x2, int y2) {
        double m = (double)(y2 - y1) / (x2 - x1);
        double c = y1 - m * x1;

        return new double[]{m, c};
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if(xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2){
            return true;
        }

        if(yCenter >= y1 && yCenter <= y2){
            if(xCenter >= x1 && xCenter <= x2) return true;
        }

        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        double dx = xCenter - closestX;
        double dy = yCenter - closestY;

        return dx * dx + dy * dy <= (double) radius * radius;
    }
}