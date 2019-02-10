import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {

    private ArrayList<LineSegment> lineSegments = new ArrayList<>();

    /**
     * finds all line segments containing 4 points
     *
     * @param points
     */
    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }

        Point[] jCopy = points.clone();
        Arrays.sort(jCopy);

        if (hasDuplicate(jCopy)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < jCopy.length - 3; i++) {
            Arrays.sort(jCopy);

            // Sort the points according to the slopes they makes with p.
            // Check if any 3 (or more) adjacent points in the sorted order
            // have equal slopes with respect to p. If so, these points,
            // together with p, are collinear.

            Arrays.sort(jCopy, jCopy[i].slopeOrder());

            for (int p = 0, first = 1, last = 2; last < jCopy.length; last++) {
                // find last collinear to p point
                while (last < jCopy.length
                        && Double.compare(jCopy[p].slopeTo(jCopy[first]), jCopy[p].slopeTo(jCopy[last])) == 0) {
                    last++;
                }
                // if found at least 3 elements, make segment if it's unique
                if (last - first >= 3 && jCopy[p].compareTo(jCopy[first]) < 0) {
                    lineSegments.add(new LineSegment(jCopy[p], jCopy[last - 1]));
                }
                // Try to find next
                first = last;
            }
        }
        // finds all line segments containing 4 or more points
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

}
