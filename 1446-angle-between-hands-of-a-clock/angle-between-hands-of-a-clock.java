class Solution {
    public double angleClock(int hour, int minutes) {
        hour = hour%12;

        double hrsDegree = (double)(hour)*30.0 + (double)(minutes)*(0.5);
        double minsDegree = (double)(minutes)*6.0;

        double diff = minsDegree - hrsDegree;

        if(diff < 0) diff = diff*(-1.0);

        if(diff > 180) diff = 360.0 - diff;

        return diff;
    }
}