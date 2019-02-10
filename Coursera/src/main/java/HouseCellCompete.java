import java.util.ArrayList;
import java.util.List;

public class HouseCellCompete {

    public static List<Integer> cellCompete(int[] states, int days) {
        int prevstate = 0;
        int res = 0;
        while (days > 0) {
            for (int i = 0; i < states.length - 1; i++) {
                if (i == 0) {
                    res = (0 ^ states[i + 1]);
                } else {
                    res = (prevstate ^ states[i + 1]);
                }
                prevstate = states[i];
                states[i] = res;
            }
            states[states.length - 1] = (prevstate ^ 0);
            days--;
        }
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < states.length; i++) {
            l.add(states[i]);
        }

        return l;
    }
}
