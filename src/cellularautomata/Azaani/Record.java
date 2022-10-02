package cellularautomata.Azaani;

import java.io.*;
import java.lang.*;

/**
 * <p>
 * Title: </p>
 * <p>
 * Description: </p>
 * <p>
 * Copyright: Copyright (c) 2010</p>
 * <p>
 * Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class Record {

    public static final int n1 = 5, n2 = 5, pop = n1 * n1 * n2, r = 1, generation = 5, state = 256, time_gene = 4096, Max_t = 300;
    public static final double alpha = 0.01, Mut_Prob = 0.001, pi = 22 / 7;
    public static final int n = 60, times = 10, no_rule = 5;
    public static byte[] Arec = new byte[27];
    public static long fit, P_select, ei, P_exp;
    public Record Pop_Record;

    public Record() {
    }
}
