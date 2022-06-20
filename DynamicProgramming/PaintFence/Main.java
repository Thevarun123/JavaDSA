import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        // these calculation are for the index 2
        int same = k * 1;
        int diff = k * (k - 1);
        int total = same + diff;

        for (int i = 3; i <= n; i++) {
            // starting from 3rd because, the 2 consecutive is allowed, but the three
            // consecutive is not allowed.
            // so, on 2nd, the rule isn't applicable that's why we started from 3.
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }
        System.out.println(total);
    }
}
// brief:
/*
 * at index 1 (fence 1)
 * same-> 3 colors can be applied -> r, g ,b
 * diff-> 3 colors can be applied -> r, g ,b
 * 
 * at index 2 (fence 2)
 * same-> 3 * 1 colors can be applied -> rr, gg, bb } -> 3
 * diff-> 3 * 2 colors can be applied -> rb, gr, br } -> 6
 * rg gb bg }
 * total-> same + diff
 * -> 3 + 6 = 9
 * (applying the color that are different from the initial color so that the
 * rule can be preserved i.e
 * r is supposed to attach with g &&
 * r is supposed to attach with b as well
 * , so, every color is getting attached with some other color two times.
 * therefore, 3 * 2 give us the total number of different combinations possible)
 * 
 * (the program starts form here)
 * at index 3 (fence 3)
 * same-> diff * 1 -> rgg, gbb, brr, } -> 6
 * rbb grr bgg, }
 * 
 * diff-> total * (k -1) -> rrb, ggb, bbg, } -> 6
 * rrg, ggr, bbr, }
 * 
 * rbr, grg, brb, rgr, gbg, bgb } -> 12
 * rbg grb brg rgb gbr bgr }
 * 
 * diff -> 6 + 12 = 18
 * 
 * total-> same + diff
 * -> 18 + 6 = 24
 */