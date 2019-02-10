import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private ArrayList<LineSegment> lineSegments = new ArrayList<>();

    /**
     * finds all line segments containing 4 points
     *
     * @param points
     */
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }

        Point[] jCopy = points.clone();
        Arrays.sort(jCopy);

        if (hasDuplicate(jCopy)) {
            throw new IllegalArgumentException();
        }

        for (int first = 0; first < points.length - 3; first++) {
            for (int second = first + 1; second < points.length - 2; second++) {
                double slopeFS = points[first].slopeTo(points[second]);
                for (int third = second + 1; third < points.length - 1; third++) {
                    double slopeFT = points[first].slopeTo(points[third]);
                    if (slopeFS == slopeFT) {
                        for (int fourth = third + 1; fourth < points.length; fourth++) {
                            double slopeFF = points[first].slopeTo(points[fourth]);
                            if (slopeFS == slopeFF) {
                                lineSegments.add(new LineSegment(points[first], points[fourth]));
                            }
                        }
                    }
                }
            }
        }
    }


    private boolean hasDuplicate(Point[] jcopy) {
        for (int i = 0; i < jcopy.length - 1; i++) {
            if (jcopy[i].compareTo(jcopy[i + 1]) == 0) return true;
        }
        return false;
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }


    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}






