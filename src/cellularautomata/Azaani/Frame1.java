package cellularautomata.Azaani;

import static cellularautomata.Azaani.MyTester.pl;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.math.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
//import com.borland.jbcl.layout.*;
//import com.borland.dbswing.*;
//import com.borland.internetbeans.*;
import java.lang.Math;
import java.io.FileFilter;
import java.lang.Object;
import java.beans.*;

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
public class Frame1 extends JFrame {

    public static int n1 = 5, n2 = 5, pop = n1 * n1 * n2, r = 1, generation = 5, state = 256, time_gene = 4096, Max_t = 300;
    public static double alpha = 0.01, Mut_Prob = 0.001, pi = 22 / 7;
    public static int n = 60, times = 10, no_rule = 5;

    public int[] AA = new int[10000];
    public Character CFile1, CFile2;
    public static File CFile, Cfile1;
    public static int[][][] CA = new int[n2][n1][n1];
    public static int[][][] CA1 = new int[n2][n1][n1];
    public static int[][][] CA2 = new int[n2][n1][n1];
    public static int[][][] Ini_CA = new int[n2][n1][n1];
    public static Record[] Aprob = new Record[pop];
    public static Record[] Bprob = new Record[pop];
    public static Record[] Cprob = new Record[pop];
    public static byte[][] seq_result = new byte[pop][time_gene];
    public static byte[] stream_bit = new byte[time_gene + 2];//+2
    public static byte[] Test_bit = new byte[pop + 2];//+2
    public static byte[] hj = new byte[4];
    public static byte[][] h = {{0, 0, 0, 0},
    {0, 0, 0, 1}, {0, 0, 1, 0}, {0, 0, 1, 1}, {0, 1, 0, 0}, {0, 1, 0, 1},
    {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 0, 1, 0}, {1, 0, 1, 1},
    {1, 1, 0, 0}, {1, 1, 0, 1}, {1, 1, 1, 0}, {1, 1, 1, 1}};
    public static byte[] vect = new byte[27];
    public static byte[] vect_perm = new byte[27];
    public static byte[][] rule = new byte[pop][27];
    public static byte[][] per_matrix, Pmat = new byte[150][150];

    public static File File1, File2, File4096;
    public static long prob, sum_prob, fitness, ave_fit, P_value, sum1, sum_prop, faym, faym1,
            ApEn, Chi_Square, P_value1, P_value2;
    public static double y[] = new double[n];
    public static double series, Even_y, Odd_y, hsimp, ai, bi;
    public char flag;
    public static String oai;
    public static int z = n1, Y = n1, x = n2;
    JPanel contentPane;
    XYLayout xYLayout1 = new XYLayout();
//    GridBagLayout xYLayout1=new GridBagLayout();
    JButton jButton2 = new JButton();
    JButton jButton1 = new JButton();
    Border border1;
    public static TextArea ta = new TextArea();
    public static TextArea txa = new TextArea();
    public static JTextArea tx3 = new JTextArea();
    TitledBorder titledBorder1;
    TitledBorder titledBorder2;
    TitledBorder titledBorder3;
    TitledBorder titledBorder4;
    private transient Vector documentListeners;
    ImageIcon img1, img2, img3, img4, img5;
//Construct the frame

    public Frame1() {
        pl("ok");
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);

        try {
            jbInit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Component initialization
    private void jbInit() throws Exception {

        contentPane = (JPanel) this.getContentPane();
        border1 = new EtchedBorder(EtchedBorder.RAISED, Color.white, new Color(165, 163, 151));
        titledBorder1 = new TitledBorder("");
        titledBorder2 = new TitledBorder("");
        titledBorder3 = new TitledBorder("");
        titledBorder4 = new TitledBorder("");
        titledBorder5 = new TitledBorder("");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                jButton1_mouseClicked(e);
            }
        });
        jButton1.setText("RUN");
        jButton1.setToolTipText("");
        jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton1.setFont(new java.awt.Font("Dialog", 1, 20));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                jButton2_mouseClicked(e);
            }
        });
        jButton2.setText("EXIT");
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 20));

        contentPane.setToolTipText("");
        contentPane.setLayout(xYLayout1);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(597, 568));
        this.setTitle("Main Window");
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                this_windowOpened(e);
            }
        });
        jButton1.setFont(new java.awt.Font("Serif", 1, 20));
        jButton1.setText("RUN");
        jButton2.setFont(new java.awt.Font("Serif", 1, 20));
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton2_actionPerformed(e);
            }
        });
        ta.setComponentOrientation(null);
        ta.setEnabled(false);
        ta.setFont(new java.awt.Font("Serif", 1, 12));
        jButton3.setText("Brwose");
        // jButton3.setVisible(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton3_actionPerformed(e);
            }
        });
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Path File");
        // jLabel1.setVisible(false);
        // path.setVisible(false);
        jRadioButton1.setFont(new java.awt.Font("Monospaced", 1, 14));
        jRadioButton1.setBorder(BorderFactory.createEtchedBorder());
        jRadioButton1.setToolTipText("");
        jRadioButton1.setText("Encrpion File");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jRadioButton1_actionPerformed(e);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Monospaced", 1, 14));
        jRadioButton2.setText("Encrpion input text");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jRadioButton2_actionPerformed(e);
            }
        });

        txa.setLocale(new java.util.Locale("en", "US", ""));
        contentPane.add(jButton1, new XYConstraints(70, 463, 192, 59));
        contentPane.add(jButton2, new XYConstraints(348, 464, 207, 59));
        contentPane.add(ta, new XYConstraints(12, 77, 573, 303));
        contentPane.add(txa, new XYConstraints(11, 78, 569, 301));
        contentPane.add(path, new XYConstraints(111, 44, 267, 25));
        contentPane.add(jButton3, new XYConstraints(381, 43, 72, 29));
        contentPane.add(jLabel1, new XYConstraints(15, 44, 84, 29));
        contentPane.add(jRadioButton2, new XYConstraints(22, 12, 204, -1));
        contentPane.add(jRadioButton1, new XYConstraints(251, 8, 219, 35));
        contentPane.add(tx3, new XYConstraints(5, 379, 570, 62));
        /* img1=new ImageIcon(fina.Frame1.class.getResource("Pic_03_B.gif"));
         img2=new ImageIcon(fina.Frame1.class.getResource("Pic_02_B.gif"));
         img3=new ImageIcon(fina.Frame1.class.getResource("Pic_03_A.gif"));

         jButton3.createImage(135, 68) ;
         jButton3 .setIcon(img1) ;
         jButton4.setIcon(img2);
         jButton5.setIcon(img3);*/

    }

    public static void Initialize_CA(int[][][] CA, int[][][] CA1, int[][][] Ini_CA, int id) {
        int i, j, k;
        double dd;
        {
            try {
                // randomize;
                if (id == 0) {
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                CA[i][j][k] = (int) Math.round(Math.random());
                                CA1[i][j][k] = CA[i][j][k];
                                Ini_CA[i][j][k] = CA[i][j][k];
                            }
                        }
                    }
                } else {
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                CA[i][j][k] = (int) Math.round(Math.random());
                                CA1[i][j][k] = CA[i][j][k];
                                Ini_CA[i][j][k] = CA[i][j][k];
                            }
                        }
                    }
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "wrong found in randomize value :", "alert", JOptionPane.OK_OPTION);

            }
        }
    }

    //{===========================================================================}
    public static void Initialize_Population(Record[] A) {
        int i, j;
        try {
            for (i = 0; i < pop; i++) {
                for (j = 0; j < 27; j++) {
                    A[i].Arec[j] = (byte) Math.round(Math.random());
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "null pointer to array :", "alert", JOptionPane.OK_OPTION);
        }
    }

    //{  Initialization Procedure  }
//     {===========================================================================}
    public static void Write_CA() {
        int i, j, k;
        for (i = 0; i < n2; i++) {
            oai = Integer.toString(i);
            ta.insert("   I  =" + oai + "     \n", ta.getCaretPosition());
            for (j = 0; j < n1; j++) {
                for (k = 0; k < n1; k++) {
                    oai = Integer.toString(CA[i][j][k]);
                    ta.insert(oai + "   \n", ta.getCaretPosition());
                }
            }
        }
    }

    //   {============================================================================}
    public static void write_Population() {
        int i, j;
        // ta.insert("\nPopulation Values...\n",ta.getCaretPosition());
        for (i = 0; i < pop; i++) {
            oai = Integer.toString(i);
            ta.insert("gene_no = " + oai + "   \n", ta.getCaretPosition());
            for (j = 0; j < 27; j++) {
                oai = Integer.toString(Aprob[i].Arec[j]);
                ta.insert(oai + "  \n", ta.getCaretPosition());
            }
        }
    }

    //  {============================================================================}
    public static void UpdatingCA(int[][][] CA3, int[][][] CA11, int[][][] CA22, int l, int m, int n11, byte[] vect, int det) {
        int i1 = 0, j1 = 0, k1 = 0, i2 = 0, sum = 0, iu = 0, ju = 0, ku = 0, x1 = 0, y1 = 0, z1 = 0;
        boolean flag;
        {
            try {
                sum = 0;
                for (i1 = l - r; i1 < l + r; i1++) {
                    for (j1 = m - r; j1 < m + r; j1++) {
                        for (k1 = n11 - r; k1 < n11 + r; k1++) {
                            x1 = (i1 + x) % x;
                            y1 = (j1 + Y) % Y;
                            z1 = (k1 + z) % z;
                            sum = sum + CA11[x1][y1][z1] * vect[i2];
                            i2 = i2 + 1;
                        }
                    }
                }

                if (det == 1) {
                    CA3[x1][y1][z1] = (sum % state) - CA22[x1][y1][z1];
                } else if (det == 0) {
                    CA3[x1][y1][z1] = (sum % 2);
                } else {
                    CA3[x1][y1][z1] = (sum % state);
                }

                //ta.insert("////////////////////////////////////////////////finshed"+" \n",ta.getCaretPosition());
            } catch (ArrayIndexOutOfBoundsException ee) {

                JOptionPane.showMessageDialog(null, "Updating error :" + ee.getMessage(), "ERROR", JOptionPane.OK_OPTION);

            } finally {

            }
        }
    }

    // {============================================================================}
    public static void Creat_RNS(int[][][] CA_RND, int[][][] CA1_RND, byte[] vect1, byte[][] RNS) {
        int i = 0, j = 0, k = 0, no_rec = 0, pj = 0, r1, no_bit, t = 0, bit_test = 0, sum;
        try {
            t = 0;
            do {
                bit_test = 0;
                do {
                    no_rec = 0;
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                for (r1 = 0; r1 < 27; r1++) {
                                    vect1[r1] = Aprob[no_rec].Arec[r1];
                                }
                                UpdatingCA(CA_RND, CA1_RND, CA1, i, j, k, vect1, 0);
                                no_rec = no_rec + 1;
                            }
                        }
                    }
                    pj = 0;
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                CA1_RND[i][j][k] = CA_RND[i][j][k];
                                RNS[pj][bit_test] = (byte) CA_RND[i][j][k];
                                pj = pj + 1;
                            }
                        }
                    }
                    bit_test = bit_test + 1;
                } while (bit_test < time_gene);
                t = t + 1;
                // ta.insert("t="+t+" \n",ta.getCaretPosition());
            } while (t < time_gene);
            // ta.insert("CREATE FUNCTION FINISHED "+" \n",ta.getCaretPosition());
        } catch (ArrayIndexOutOfBoundsException ee) {

            JOptionPane.showMessageDialog(null, "Creating Error:", "ERROR", JOptionPane.OK_OPTION);
        } finally {
            //JOptionPane.showMessageDialog(null,"Creating Null:","NULL VALUE",JOptionPane.OK_OPTION);
        }
    }

    //   {===========================================================================}
    public static void Entropy_Test(byte[] stream_bit, byte[] Streambit, byte[] hj, long Entropy,
            int pj, int m, int flage) {
        int i, j, k, l, p, no_sub, det;
        double sum_En;
        {
            //Entropy=0;
            sum_En = 0.0;
            k = (pj / m);
            if (flage == 1) {
                for (p = 0; p < 15; p++) {
                    for (det = 0; det < m; det++) {
                        hj[det] = h[p][det];
                    }
                    i = 0;
                    j = 0;
                    no_sub = 0;
                    l = 3;
                    sum_En = 0.0;
                    while (l <= pj - 1) {
                        if (i <= 3) {
                            if (hj[i] != Streambit[j]) {
                                i = 0;
                                j = l + 1;
                                l = l + 4;
                            } else if (hj[i] == Streambit[j]) {
                                i = i + 1;
                                j = j + 1;
                                if (i > m - 1) {
                                    i = 0;
                                    j = l + 1;
                                    l = l + 4;
                                    no_sub = no_sub + 1;
                                }
                            }
                        }
                    }
                    if (no_sub == 0) {
                        prob = 0;
                    } else {
                        prob = (int) Math.log(no_sub / k);
                    }
                    sum_En = -(no_sub / k) * (prob / Math.log(2));
                    Entropy = (long) sum_En + Entropy;
                }
            } else {
                for (p = 0; p < 15; p++) {
                    for (det = 0; det < m - 1; det++) {
                        hj[det] = h[p][det];
                    }
                    i = 0;
                    j = 0;
                    no_sub = 0;
                    l = 3;
                    sum_En = 0;
                    while (l <= pj - 1) {
                        if (i <= 3) {
                            if (hj[i] != stream_bit[j]) {
                                i = 0;
                                j = l + 1;
                                l = l + 4;
                            } else if (hj[i] == stream_bit[j]) {
                                i = i + 1;
                                j = j + 1;
                                if (i > m - 1) {
                                    i = 0;
                                    j = l + 1;
                                    l = l + 4;
                                    no_sub = no_sub + 1;
                                }
                            }
                        }
                    }
                    if (no_sub == 0) {
                        prob = 0;
                    } else {
                        prob = (int) Math.log(no_sub / k);
                    }
                    sum_En = -(no_sub / k) * (prob / Math.log(2));
                    Entropy = (long) sum_En + Entropy;
                }
            }
        }
    }
    //{ function of Entropy test }
    // {===========================================================================}

    public static void buble_sort(Record[] C) {
        Record temp;
        int i, j, k, v1;
        byte v[] = new byte[27];//{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};

        {
            try {
                for (j = 0; j < pop; j++) {
                    for (k = 0; k < pop - 2; k++) {
                        if (C[k].fit < C[k + 1].fit) {
                            temp = C[k];
                            C[k] = C[k + 1];
                            C[k + 1] = temp;
                            for (v1 = 0; v1 < 27; v1++) {
                                v[v1] = C[k].Arec[v1];
                                C[k].Arec[v1] = C[k + 1].Arec[v1];
                                C[k + 1].Arec[v1] = v[v1];
                            }
                            temp = C[k];
                            C[k] = C[k + 1];
                            C[k + 1] = temp;
                        }
                    }
                }
            } catch (NullPointerException ee) {
                JOptionPane.showMessageDialog(null, "bouble sort wrong", "alert", JOptionPane.OK_OPTION);
            }
        }
    }

    //{===========================================================================}
    public static void Selection(Record[] B, Record[] A, Record[] C, long ave_fit) {
        int i, j, k, j1, k2, index, bit_test;
        long Max_prob, Min_prob;
        try {
            sum_prob = 0;
            for (i = 0; i < pop; i++) {
                sum_prob = sum_prob + A[i].fit;
            }
            // ta.insert("sum="+sum_prob+"\n",ta.getCaretPosition());
            ave_fit = sum_prob / pop;
            //  ta.insert("ave="+ave_fit+"\n",ta.getCaretPosition());
            k = 0;
            for (i = 0; i < pop; i++) {
                //ta.insert("a="+A[i].fit+"\n",ta.getCaretPosition());
                A[i].P_select = A[i].fit / sum_prob;
                A[i].ei = A[i].P_select * pop;
            }
            i = 0;
            k2 = 0;
            for (j = 0; j < pop; j++) {
                index = BigDecimal.valueOf(A[j].ei).ROUND_DOWN;
                A[j].P_exp = A[j].ei - index;
                for (j1 = 0; j1 < 27; j1++) {
                    C[j].Arec[j1] = A[j].Arec[j1];
                }
                C[j].ei = A[j].ei;
                C[j].fit = A[j].fit;
                if (index >= 1) {
                    for (bit_test = 1; bit_test < index; bit_test++) {
                        for (k = 0; k < 27; k++) {
                            B[i].Arec[k] = A[j].Arec[k];
                        }
                        B[i].fit = A[j].fit;
                        i = i + 1;
                    }
                }
            }
            if (i <= pop) {
                buble_sort(C);
                k = 0;
                j = 0;
                for (j = i; j < pop; j++) {
                    for (j1 = 0; j1 < 27; j1++) {
                        B[j].Arec[j1] = C[k].Arec[j1];
                    }
                    B[j].fit = C[k].fit;
                    k = k + 1;
                }
            }
        } catch (ArithmeticException e) {
            //JOptionPane.showMessageDialog(null,"don't divided by Zero","alert",JOptionPane.OK_OPTION) ;
        }

    }

    // {===========================================================================}
    public static void Crossover(Record[] B, Record[] A) {
        int i, j, k, l, Point_cross;
        {
            i = 0;
            do {
                j = (int) Math.round(Math.random() * pop);
                l = (int) Math.round(Math.random() * pop);
                Point_cross = (int) Math.round(Math.random() * 26);
                if (A[j].fit < 3.90) {
                    for (k = 0; k < Point_cross - 1; k++) {
                        B[i].Arec[k] = A[j].Arec[k];
                        B[i + 1].Arec[k] = A[l].Arec[k];
                    }
                    for (k = Point_cross; k < 27; k++) {
                        B[i].Arec[k] = A[j].Arec[k];
                        B[i + 1].Arec[k] = A[j].Arec[k];
                    }
                    i = i + 1;
                } else {
                    for (k = 0; k < 27; k++) {
                        B[i].Arec[k] = A[j].Arec[k];
                    }
                    i = i + 1;
                }
            } while (i < pop);
        }
    }

    //{===========================================================================}
    public static void Mutation(Record[] A) {
        int k, l;
        {
            k = (int) Math.round(Math.random() * 26);
            l = (int) Math.round(Math.random() * pop);
            prob = (int) Math.round(Math.random() * 0);
            if ((prob <= Mut_Prob) && (A[l].fit < 3.98)) {
                if (A[l].Arec[k] == 0) {
                    A[l].Arec[k] = 1;
                } else {
                    A[l].Arec[k] = 0;
                }
            }
        }
    }

    //{===========================================================================}
    public static void Substitution_Records(Record[] B, Record[] A) {
        int i, j, k;
        {
            for (i = 0; i < pop; i++) {
                for (j = 0; j < 27; j++) {
                    A[i].Arec[j] = B[i].Arec[j];
                }
                A[i].fit = B[i].fit;
            }
        }
    }

    //{===========================================================================}
    public static void Poker_Test(byte[] Streambit, byte[] hj, long Chi_square, int pj, int m) {
        int i, j, k, l, index, det, p1;
        long[] vect = new long[150];
        {
            i = 0;
            j = 0;
            l = 3;
            Chi_square = 0;
            det = BigDecimal.valueOf((long) Math.exp(m * Math.log(2))).ROUND_DOWN;
            index = 0;
            k = pj / 4;
            while (index <= det) {
                for (i = 0; i < m; i++) {
                    hj[i] = h[index][i];
                }
                i = 0;
                j = 0;
                p1 = 0;
                l = 3;
                while (l <= pj - 1) {
                    if (i <= 3) {
                        if (hj[i] != Test_bit[j]) {
                            i = 0;
                            j = l + 1;
                            l = l + 4;
                        } else if (hj[i] == Test_bit[j]) {
                            i = i + 1;
                            j = j + 1;
                            if (i > 3) {
                                i = 0;
                                j = l + 1;
                                l = l + 4;
                                p1 = p1 + 1;
                            }
                        }
                    }
                }
                vect[index] = (long) Math.pow(p1, 2);
                index = index + 1;
            }
            sum_prob = 0;
            for (i = 0; i <= 15; i++) {
                sum_prob = sum_prob + vect[i];
            }
            Chi_Square = (long) ((Math.exp(m * Math.log(2))) / k) * sum_prob - k;
        }
    }
    //{ Procedure of Poker test }
    //{===========================================================================}

    public static void Integration_erfc(long sum) {
        int i;
        {
            sum = 0;
            for (i = 0; i < n; i++) {
                y[i] = Math.exp(-Math.pow(ai + i * hsimp, 2));
            }
            Even_y = 0;
            i = 0;
            do {
                i = i + 2;
                Even_y = Even_y + y[i];
            } while (i < n - 2);
            Odd_y = 0;
            i = 1;
            do {
                Odd_y = Odd_y + y[i];
                i = i + 2;
            } while (i < n - 1);
            sum = (long) ((hsimp / 3) * (y[0] + 2 * Even_y + 4 * Odd_y + y[n - 1]));
        }
    }

    //{===========================================================================}
    public static void Inte_igamc(double sum1, int gama) {
        int i, sum;
        {
            sum = 0;
            y[0] = 0;
            for (i = 1; i < n; i++) {
                y[i] = Math.exp(-(ai + i * hsimp)) * Math.exp((gama - 1) * Math.log(ai + i * hsimp));
            }
            Even_y = 0;
            i = 0;
            do {
                i = i + 2;
                Even_y = Even_y + y[i];
            } while (i <= n - 2);
            Odd_y = 0;
            i = 1;
            do {
                Odd_y = Odd_y + y[i];
                i = i + 2;
            } while (i <= n - 1);
            sum1 = (hsimp / 3.0) * (y[0] + 2 * Even_y + 4 * Odd_y + y[n]);
        }
    }

    //{===========================================================================}
    public static void Factorial(long fac, int i1) {
        int j1, m;
        {
            m = i1;
            fac = 1;
            if ((i1 == 0) || (i1 == 1)) {
                fac = 1;
            } else {
                do {
                    fac = fac * m;
                    m = m - 1;
                } while (m > 1);
            }
        }
    }

    //{===========================================================================}
    public static void Series_Exp(double series, int k, long ai) {
        long a1;
        int j1;
        long fac;
        double[] y1 = new double[n];
        {
            series = 0;
            for (j1 = 0; j1 < k; j1++) {
                fac = 1;
                Factorial(fac, j1);
                y1[j1] = Math.exp((j1) * Math.log(bi)) / (fac);
            }
            Even_y = 0.0;
            j1 = 0;
            do {
                j1 = j1 + 2;
                Even_y = Even_y + y1[j1];
            } while (j1 <= k - 1);
            Odd_y = 0;
            j1 = 1;
            do {
                Odd_y = Odd_y + y1[j1];
                j1 = j1 + 2;
            } while (j1 < k);
            series = (y1[0] + Even_y) - Odd_y;
        }
    }

    //{============================================================================}
    public static void Series_Comp(double series, int k, long ai) {
        long a1;
        int j1;
        long fac;
        double[] y1 = new double[n];
        {
            series = 0;
            for (j1 = 0; j1 < k; j1++) {
                fac = 1;
                Factorial(fac, j1);
                y1[j1] = Math.exp((j1 + 1) * Math.log(ai)) / ((2 * j1 + 1) * fac);
            }
            Even_y = 0.0;
            j1 = 0;
            do {
                j1 = j1 + 2;
                Even_y = Even_y + y1[j1];
            } while (j1 <= k - 1);
            Odd_y = 0;
            j1 = 1;
            do {
                Odd_y = Odd_y + y1[j1];
                j1 = j1 + 2;
            } while (j1 < k);
            series = (y1[0] + Even_y) - Odd_y;
        }
    }

    //{============================================================================}
    public static void Frequency_Test(byte[] string_bit, int ni, long P_value) {
        int Sn, Si, i;
        long Sobs;
        {
            Sn = 0;
            P_value = 0;
            for (i = 0; i <= ni; i++) {
                if (string_bit[i] == 1) {
                    Sn = Sn + 1;
                }
            }
            Si = Math.abs(Sn - ni);
            Sn = Math.abs(Sn - Si);
            Sobs = Sn / (long) Math.sqrt(ni);
            P_value = Sobs / (long) Math.sqrt(2);
        }
    }

    //{===========================================================================}
    public static void Run_Test(byte[] string_bit, int ni, long P_value) {
        int Vn, S, i;
        long Pivalue, tao;
        {
            S = 0;
            Vn = 0;
            tao = 2 / ((long) Math.sqrt(ni));
            P_value = 0;
            for (i = 0; i <= ni; i++) {
                if (string_bit[i] == 1) {
                    S = S + 1;
                }
            }
            Pivalue = (long) S / ni;
            if (Math.abs(Pivalue - 0.5) >= tao) {
                P_value = (long) 0.0;
            } else {
                for (i = 0; i < ni - 2; i++) {
                    if (string_bit[i] == string_bit[i + 1]) {
                        Vn = Vn + 0;
                    } else {
                        Vn = Vn + 1;
                    }
                }
                Vn = Vn + 1;
                prob = Math.abs(Vn - (2 * ni * Pivalue * (1 - Pivalue)));
                sum_prop = 2 * ((long) Math.sqrt(2 * ni)) * Pivalue * (1 - Pivalue);
                P_value = prob / sum_prop;
            }
        }
    }

    //{============================================================================}
    public static void Serial_Test(long Pvalu1, long Pvalu2, byte[] string_bit, byte[] hj1, int m, int n_bit) {
        int i, j, v, gama, r1, pj;
        long ebsaym, ebsaym1, ebsaym2, delta1, delta2;
        {
            Pvalu1 = 0;
            Pvalu2 = 0;
            m = 3;
            ebsaym = 0;
            ebsaym1 = 0;
            ebsaym2 = 0;
            pj = n_bit % m;
            if (pj == 1) {
                Test_bit[n_bit] = 0;
            } else {
                Test_bit[n_bit] = 0;
                Test_bit[n_bit + 1] = 0;
            }
            while (m == 3 || m == 2) {
                if (m == 3) {
                    for (r1 = 0; r1 <= 7; r1++) {
                        v = 0;
                        for (i = 1; i <= m; i++) {
                            hj1[i - 1] = h[r1][i];
                        }
                        for (j = 0; j <= n_bit + pj - 2; j++) {
                            if ((hj1[0] == string_bit[j]) && (hj1[1] == string_bit[j + 1])
                                    && (hj1[2] == string_bit[j + 2])) {
                                v = v + 1;
                            } else {
                                v = v + 0;
                            }
                        }
                        ebsaym = ebsaym + (long) Math.pow(v, 2);
                    }
                } else {
                    for (r1 = 0; r1 <= 3; r1++) {
                        v = 0;
                        for (i = 2; i <= m + 1; i++) {
                            hj1[i - 2] = h[r1][i];
                        }
                        for (j = 0; j < n_bit; j++) {
                            if ((hj1[0] == string_bit[j]) && (hj1[1] == string_bit[j + 1])) {
                                v = v + 1;
                            } else {
                                v = v + 0;
                            }
                        }
                        ebsaym1 = ebsaym1 + (long) Math.pow(v, 2);
                    }
                }
                m = m - 1;
            }
            v = 0;
            for (j = 0; j < n_bit; j++) {
                if (string_bit[j] == 1) {
                    v = v + 1;
                }
            }
            m = 3;
            ebsaym = (long) (Math.exp(3 * Math.log(2)) / n_bit) * (ebsaym) - n_bit;
            ebsaym1 = (long) (Math.exp(2 * Math.log(2))) / n_bit * (ebsaym1) - n_bit;
            ebsaym2 = 2 / n_bit * ((long) Math.pow(v, 2) + (long) Math.pow(n_bit - v, 2)) - n_bit;
            delta1 = ebsaym - ebsaym1;
            delta2 = ebsaym - 2 * ebsaym1 + ebsaym2;
            if (delta1 == 0) {
                P_value1 = 1;
            } else {
                ai = 0;
                bi = delta1;
                hsimp = Math.abs((bi - ai)) / n;
                gama = 2;
                Inte_igamc(series, 2);
                Pvalu1 = 1 - (1 / (2)) * (long) series;
            }
            if (delta2 == 0) {
                P_value2 = (long) 1;
            } else {
                ai = 0;
                bi = delta2;
                hsimp = Math.abs((bi - ai)) / n;
                gama = 1;
                series = 0;
                Inte_igamc(series, 1);
                Pvalu2 = 1 - (long) series;
            }
        }
    }

    //{===========================================================================}
    public static void Approximate_Entropy_Test(byte[] Test_bit, long Fay, int m, int ni) {
        int i, j, k, l, index, p, pj, bit_test;
        long[] vect = new long[15];
        {
            l = BigDecimal.valueOf((long) Math.exp(m * Math.log(2))).ROUND_DOWN;
            k = 0;
            bit_test = ni + m - 2;
            Fay = 0;
            while (k <= l - 1) {
                if (m == 4) {
                    for (j = 0; j < m; j++) {
                        hj[j] = h[k][j];
                    }
                } else if (m == 3) {
                    for (j = 0; j < m; j++) {
                        hj[j] = h[k][j + 1];
                    }
                } else {
                    for (j = 0; j < m; j++) {
                        hj[j] = h[k][j + 2];
                    }
                }
                pj = 0;
                j = 0;
                index = 0;
                while ((index + m - 1) <= bit_test) {
                    p = 0;
                    j = 0;
                    while (j <= m - 1) {
                        if (hj[j] == Test_bit[index + j]) {
                            p = p + 1;
                        } else {
                            j = m;
                        }
                        j = j + 1;
                        if (p == m) {
                            pj = pj + 1;
                        }
                    }
                    index = index + 1;
                }
                if (pj == 0) {
                    vect[k] = 0;
                } else {
                    vect[k] = (pj / ni) * (long) Math.log(pj / ni);
                }
                k = k + 1;
                pj = 0;
            }
            Fay = 0;
            for (k = 0; k <= l - 1; k++) {
                Fay = Fay + vect[k];
            }
        }
    }

    //{============================================================================}
    public static void Pearson_Chi_Square_Test(byte[] Test_bit, long Fay, int m, int ni) {
        int i, j, k, l, p, pj, index, bit_test;
        long[] vect = new long[15];
        {
            l = BigDecimal.valueOf((long) Math.exp(m * Math.log(2))).ROUND_DOWN;
            k = 0;
            bit_test = ni + m - 2;
            Fay = 0;
            while (k <= l - 1) {
                for (j = 0; j <= m - 1; j++) {
                    hj[j] = h[k][j];
                }
                pj = 0;
                j = 0;
                index = 0;
                while ((index + m - 1) <= bit_test) {
                    p = 0;
                    j = 0;
                    while (j <= m - 1) {
                        if (hj[j] == Test_bit[index + j]) {
                            p = p + 1;
                        } else {
                            j = m;
                        }
                        j = j + 1;
                        if (p == m) {
                            pj = pj + 1;
                        }
                    }
                    index = index + 1;
                }
                if (pj == 0) {
                    vect[k] = 0;
                } else {
                    vect[k] = ((long) Math.pow(pj - ni / l, 2)) / (ni / l);
                }
                k = k + 1;
                pj = 0;
            }
            Fay = 0;
            for (k = 0; k <= l - 1; k++) {
                Fay = Fay + vect[k];
            }
        }
    }

    //{============================================================================}
    public static void Genetic(byte[][] Ruleselect, Record[] Aprob) {
        int i, j, k, m, det, gene, p1 = 0;
        byte[][] temp_rule = new byte[pop][27];
        {
            try {
                //JOptionPane.showMessageDialog(null,"genetic :"+Aprob.length,"alert",JOptionPane.OK_OPTION);
                Initialize_Population(Aprob);

                ta.insert("\n ******************( Initial Population )******************\n", ta.getCaretPosition());

                // JOptionPane.showMessageDialog(null,"Population :"+ta.getCaretPosition(),"alert",JOptionPane.OK_OPTION);
                Write_CA();
                write_Population();
                JOptionPane.showMessageDialog(null, "  Please, Press  OK To Continue   )", "Confrim", JOptionPane.OK_OPTION);//{readln;}
                ta.insert("  ****('/////////////////////''Please Wait few   to Complete'''''''''''''''''''''''')****\n", ta.getCaretPosition());
                Creat_RNS(CA, CA1, vect, seq_result);
                ta.insert("  ****('''''''''''''Finsihed Creating'''''''''''''''''''''''')****\n", ta.getCaretPosition());
                for (p1 = 0; p1 < pop; p1++) {
                    sum_prob = 0;

                    for (det = 0; det < time_gene; det++) {
                        // ta.insert("sepresult="+seq_result[p1][det]+"p1="+p1+"det="+det+"\n",ta.getCaretPosition());
                        stream_bit[det] = seq_result[p1][det];
                        //ta.insert("stream_bit[det]="+stream_bit[det]+"p1="+p1+"det="+det+"\n",ta.getCaretPosition());
                    }
                    m = 4;
                    fitness = 0;
                    //ta.insert("p1="+p1+"det="+det+"\n",ta.getCaretPosition());
                    Entropy_Test(stream_bit, Test_bit, hj, fitness, time_gene, m, 0);
                    ////ta.insert("p1="+p1+"\tdetqqqqqqqqq="+det+"\n",ta.getCaretPosition());
                    Aprob[p1].fit = fitness;
                    // ta.insert("p1="+p1+"detaa="+det+"\n",ta.getCaretPosition());
                }
                gene = 0;
                do {
                    gene = gene + 1;
                    // randomize;
                    oai = Integer.toString(gene);
                    ta.insert("\n****(In Now Time, The Generatin " + oai + " is Computing, Please Wait to Complete)****\n", ta.getCaretPosition());
                    Selection(Bprob, Aprob, Cprob, ave_fit);
                    ta.insert("gene=" + gene + "\n", ta.getCaretPosition());
                    Substitution_Records(Bprob, Aprob);
                    Crossover(Bprob, Aprob);
                    Substitution_Records(Bprob, Aprob);
                    Mutation(Aprob);
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                CA[i][j][k] = Ini_CA[i][j][k];
                                CA1[i][j][k] = Ini_CA[i][j][k];
                            }
                        }
                    }
                    Creat_RNS(CA, CA1, vect, seq_result);
                    k = 0;
                    for (p1 = 0; p1 < pop; p1++) {
                        for (det = 0; det < time_gene; det++) {
                            stream_bit[det] = seq_result[p1][det];
                        }
                        m = 4;
                        fitness = 0;
                        Entropy_Test(stream_bit, Test_bit, hj, fitness, time_gene, m, 0);
                        Aprob[p1].fit = fitness;
                    }
                } while (gene < generation);
                buble_sort(Aprob);
                ta.insert("\n ************(  Final of  Genetic Operators Result After Sorting  )************\n", ta.getCaretPosition());
                k = 0;
                for (i = 0; i <= n - 1; i++) {
                    oai = Integer.toString(i);
                    ta.insert("i=" + oai + ":---->\n", ta.getCaretPosition());
                    for (j = 0; j < 27; j++) {
                        oai = Integer.toString(Aprob[i].Arec[j]);
                        ta.insert(oai + "   " + "\n", ta.getCaretPosition());
                        Ruleselect[i][j] = Aprob[i].Arec[j];
                    }
                    oai = Float.toString(Aprob[i].fit);
                    ta.insert("fit=:" + oai + " " + "\n", ta.getCaretPosition());
                }
            } catch (ArrayIndexOutOfBoundsException ee) {

                JOptionPane.showMessageDialog(null, "genetic catch :" + ee.getMessage(), "alert", JOptionPane.OK_OPTION);
            } finally {

                // JOptionPane.showMessageDialog(null,"genetic finally :","alert",JOptionPane.OK_OPTION);
            }
        }
    }

    //{============================================================================}
    public static void Read_files(int[][] rulei) {
        int i, j, p, pi;
        char ti;
        try {
            InputStream File1 = new FileInputStream("file4096_rule.bin");
            ObjectInputStream out = new ObjectInputStream(File1);
// out.writeObject(user);
            //out.flush();
            // out.reset();
            for (i = 0; i <= no_rule; i++) {
                oai = Integer.toString(i);
                ta.insert("Rule= " + oai + ":\n", ta.getCaretPosition());
                for (j = 0; j < 27; j++) {
                    p = out.readInt();
                    rulei[i][j] = (byte) p;
                    oai = Integer.toString(rulei[i][j]);
                    ta.insert(oai + "   " + "\n", ta.getCaretPosition());
                }
            }
            out.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "file not found", "alert", JOptionPane.OK_OPTION);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "wrong in opreation", "alert", JOptionPane.OK_OPTION);
        }

    }

    //{============================================================================}
    public static void Test_Rule(int[][][] CA, int[][][] CA1, Record[] Aprob, byte[] vect, int no_time) {

        int i, j, k, m, p, p1, pj, t, times1, sum;
        long[] vec_fit = new long[time_gene];
        {
            try {
                for (i = 0; i < time_gene; i++) {
                    Aprob[i].fit = 0;
                }
                times1 = 0;
                do {
                    times1 = times1 + 1;
                    ta.insert("          ****(        Please Wait @@@@@ to Complete   @@@@@@@@@@    Computation           )****\n", ta.getCaretPosition());
                    Initialize_CA(CA, CA1, Ini_CA, 0);
                    // JOptionPane.showMessageDialog(null,"size"+CA.length,"initialize",JOptionPane.OK_OPTION);
                    pj = 0;
                    //  System.out.println("          ****(        Please Wait @@@@@ to Complete   @@@@@@@@@@    Computation           )****");
                    do {
                        for (j = 0; j < 27; j++) {
                            vect[j] = Aprob[pj].Arec[j];
                        }
                        t = 0;
                        do {
                            t = t + 1;
                            for (i = 0; i < n2; i++) {
                                for (j = 0; j < n1; j++) {
                                    for (k = 0; k < n1; k++) {
                                        UpdatingCA(CA, CA1, CA2, i, j, k, vect, 0);
                                    }
                                }
                            }
                            for (i = 0; i < n2; i++) {
                                for (j = 0; j < n1; j++) {
                                    for (k = 0; k < n1; k++) {
                                        CA1[i][j][k] = CA[i][j][k];
                                    }
                                }
                            }
                        } while (t <= time_gene);
                        p1 = 0;
                        for (i = 0; i < n2; i++) {
                            for (j = 0; j < n1; j++) {
                                for (k = 0; k < n1; k++) {
                                    Test_bit[p1] = (byte) CA[i][j][k];
                                    CA[i][j][k] = Ini_CA[i][j][k];
                                    CA1[i][j][k] = Ini_CA[i][j][k];
                                    p1 = p1 + 1;
                                }
                            }
                        }
                        m = 4;
                        Entropy_Test(stream_bit, Test_bit, hj, fitness, pop, m, 1);
                        Aprob[pj].fit = Aprob[pj].fit + fitness;
                        pj = pj + 1;
                    } while (pj < pop);
                } while (times1 <= times);
                for (i = 0; i < pop; i++) {
                    Aprob[i].fit = Aprob[i].fit / times;
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "test rule :", "alert", JOptionPane.OK_OPTION);
            }
        }
    }

    //{============================================================================}
    public static void Chose_Rule(byte[][] RulesChose, Record[] Aprob1, int pj) {
        int q, q1;
        {
            try {
                for (q = 0; q < 27; q++) {
                    RulesChose[0][q] = Aprob[0].Arec[q];
                }
                pj = 0;
                q = 1;
                q1 = 0;
                do {
                    ta.insert("****( Please Wait %%%%%%%%%%%%%% to Complete   %%%%%%%%%%%%%    Computation )****\n", ta.getCaretPosition());
                    if (Aprob[q].fit == Aprob[q - 1].fit) {
                        q = q + 1;
                    } else {
                        for (q1 = 0; q1 < 27; q1++) {
                            RulesChose[q][q1] = Aprob[q].Arec[q1];
                        }
                        q = q + 1;
                        pj = pj + 1;
                    }
                } while (q < pop);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "null pointer", "alert", JOptionPane.OK_OPTION);
            }
        }
    }

    //{============================================================================}
    public static void Tests_Result(byte[][] rule) {
        int fac1 = 0, i, j, k, l, m, p, pj1, t, time_no, sum, bit_test;
        {
            time_no = 0;
            do {
                Initialize_CA(CA, CA1, Ini_CA, 0);
                t = 0;
                time_no = time_no + 1;
                ta.insert("\n***************************************************************************************************************\n", ta.getCaretPosition());
                pj1 = 0;
                do {
                    t = t + 1;
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                if (pj1 >= no_rule) {
                                    pj1 = 0;
                                }
                                for (p = 0; p < 27; p++) {
                                    vect[p] = rule[pj1][p];
                                }
                                pj1 = pj1 + 1;
                                sum = 0;
                                UpdatingCA(CA, CA1, CA2, i, j, k, vect, 0);
                            }
                        }
                    }
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                CA1[i][j][k] = CA[i][j][k];
                            }
                        }
                    }
                } while (t <= Max_t);
                p = 0;
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            Test_bit[p] = (byte) CA[i][j][k];
                            p = p + 1;
                        }
                    }
                }
                oai = Integer.toString(time_no);
                ta.insert("            Final Results for Tests Applied at " + oai + " times\n", ta.getCaretPosition());
                ta.insert("     **********************************************************************\n", ta.getCaretPosition());
                m = 4;
                // {1}//
                Entropy_Test(stream_bit, Test_bit, hj, fitness, pop, m, 1);
                oai = Float.toString(fitness);
                ta.insert("            1- Entropy Test Result                            =" + oai + "\n", ta.getCaretPosition());
                // Test_bit[pop]=0;
                Test_bit[pop] = 1;
                Test_bit[pop + 1] = 0;

                m = 3;
                bit_test = BigDecimal.valueOf((long) Math.exp((m - 1) * Math.log(2))).ROUND_DOWN;
                //{2}//
                Approximate_Entropy_Test(Test_bit, fitness, m, pop);
                faym = fitness;
                m = m + 1;
                Approximate_Entropy_Test(Test_bit, fitness, m, pop - 1);
                faym1 = fitness;
                ApEn = faym - faym1;
                Chi_Square = 2 * pop * ((long) Math.log(2) - ApEn);
                if (Chi_Square == 0) {
                    P_value = 1;
                } else {
                    bit_test = 4;
                    Factorial(fac1, bit_test);
                    ai = 0;
                    bi = Chi_Square / 2;
                    hsimp = Math.abs(bi - ai) / n;
                    fac1 = 1;
                    k = 4;
                    Factorial(fac1, k);
                    Inte_igamc(series, bit_test);
                    P_value = 1 - (long) series / fac1;
                }
                oai = Float.toString(P_value);
                if (P_value >= alpha) {
                    ta.insert("            2- Approximate Entropy Test Result     =" + oai + "      Pass Test\n", ta.getCaretPosition());
                } else {
                    ta.insert("           2- Approximate Entropy Test Result     =" + oai + "     Failed Test\n", ta.getCaretPosition());
                }
                //{3}//
                Frequency_Test(Test_bit, pop, fitness);
                ai = 0;
                bi = fitness / Math.sqrt(2);
                hsimp = (bi - ai) / n;
                Integration_erfc(sum1);
                k = 5;
                ai = 0.0001;
                Series_Comp(series, k, (long) ai);
                sum1 = sum1 + (long) series;
                sum1 = (2 / ((long) Math.sqrt(pi))) * sum1;
                oai = Float.toString(sum1);
                if (sum1 >= alpha) {
                    ta.insert("           3- Frequency Test,  P_value                   =" + oai + "      Pass Test\n", ta.getCaretPosition());
                } else {
                    ta.insert("            3- Frequency Test,  P_value                   =" + oai + "      Failed Test\n", ta.getCaretPosition());
                }
                /* {4}*/
                Run_Test(Test_bit, pop, fitness);
                ai = 0;
                bi = fitness;
                hsimp = Math.abs(bi - ai) / n;
                Integration_erfc(sum1);
                k = 5;
                ai = 0.000027;
                Series_Comp(series, k, (long) ai);
                sum1 = sum1 + (long) series;
                sum1 = (2 / ((long) Math.sqrt(pi))) * (sum1);
                oai = Float.toString(sum1);
                if (sum1 >= alpha) {
                    ta.insert("          4- Run Test Result,   P_value                 =" + oai + "      Pass Test\n", ta.getCaretPosition());
                } else {
                    ta.insert("            4- Run Test Result,   P_value                 =" + oai + "      Failed Test\n", ta.getCaretPosition());
                }
                m = 3;
                /* {5}*/

                Serial_Test(P_value1, P_value2, Test_bit, hj, m, pop - 1);
                oai = Float.toString(P_value1);
                ta.insert("            5- Serial Test Result P_value1              =" + oai + "\n", ta.getCaretPosition());
                oai = Long.toString(P_value2);
                if ((P_value1 >= alpha) && (P_value2 >= alpha)) {
                    ta.insert("                               P_value2                                =" + oai + "       Pass Test\n", ta.getCaretPosition());
                } else {
                    ta.insert("     Failed Test\n", ta.getCaretPosition());
                }
                m = 4;
                /*{6}*/
                Poker_Test(Test_bit, hj, fitness, pop, m);
                oai = Float.toString(fitness);
                if (fitness < 30.58) {
                    ta.insert("            6- Poker Test Result                               =" + oai + "       Pass Test\n", ta.getCaretPosition());
                } else {
                    ta.insert("          6- Poker Test Result                               =" + oai + "       Failed Test\n", ta.getCaretPosition());
                }
                m = 4;
                /* {7}*/
                Pearson_Chi_Square_Test(Test_bit, fitness, m, pop - 1);
                oai = Float.toString(fitness);
                if (fitness < 30.58) {
                    ta.insert("            7- Pearson Chi-Square Test Result      =" + oai + "       Pass Test\n", ta.getCaretPosition());
                } else {
                    ta.insert("             7- Pearson Chi-Square Test Result     =" + oai + "        Failed Test\n", ta.getCaretPosition());
                }
            } while (time_no < times);
        }
    }

    // {============================================================================}
    public static void message1(int[][][] CA1, int[][][] CA2) {
        int i, j, k, chrVal, i1, j1, k1, si;
        char ti = ' ';
        int message_size;
        {
            // randomize;
            ta.insert("=============================The Updating CA Forward=========================   \n", ta.getCaretPosition());
            //try{
            //File  File1=new File("zzz2.txt");
            //FileInputStream out=new FileInputStream(File1);
            //  ta.insert("Size of file "+Integer.toString((int)File1.length())+"\n",ta.getCaretPosition());
            message_size = 0;
            si = 0;
            for (i = 0; i < n2; i++) {
                for (j = 0; j < n1; j++) {
                    for (k = 0; k < n1; k++) {
                        if (message_size < 125) {

                            ti = txa.getText().charAt(message_size);

                            CA1[i][j][k] = (int) ti;
                            CA2[i][j][k] = CA1[i][j][k];
                            ta.insert("Abdulwasee File--" + message_size + "= " + (char) CA2[i][j][k] + "\n", ta.getCaretPosition());
                            message_size = message_size + 1;

                        } else {
                            CA1[i][j][k] = (int) Math.round(Math.random() * 255);
                            CA2[i][j][k] = CA1[i][j][k];
                            //}
                        }
                    }
                }
            }
            i = CA2[0][1][3];
            CA2[0][1][3] = CA2[0][2][4];
            CA2[0][2][4] = i;
            //out.close() ;
            // }
            //catch(IOException e)
            //{
            //JOptionPane.showMessageDialog(null,"ioexception","alert",JOptionPane .OK_OPTION);
// }
        }
    }

    //{============================================================================}
    public static void Add_Key(File Cfile, int[][][] CAE3) {
        int[][][] CAE = new int[n2][n1][n1];
        int[][][] CAE1 = new int[n2][n1][n1];
        int[][][] CAE2 = new int[n2][n1][n1];;
        int i, j, k, p1, pj, t, li, lj, lk;
        char ti;
        File CFile1;

        {
            for (i = 0; i < n2; i++) {
                for (j = 0; j < n1; j++) {
                    for (k = 0; k < n1; k++) {
                        CAE[i][j][k] = CAE3[i][j][k];
                        CAE1[i][j][k] = CAE3[i][j][k];
                        CAE2[i][j][k] = CAE3[i][j][k];
                    }
                }
            }
            Initialize_CA(CAE, CAE1, Ini_CA, 1);
            t = 0;
            do {
                t = t + 1;
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            UpdatingCA(CAE, CAE1, CAE2, i, j, k, vect, 2);
                        }
                    }
                }
            } while (t < 15);
            for (i = 0; i < n2; i++) {
                for (j = 0; j < n1; j++) {
                    for (k = 0; k < n1; k++) {

                        CAE1[i][j][k] = Math.abs((CAE[i][j][k] + CAE3[i][j][k]) % state);
                    }
                }
            }
            try {
                CFile1 = new File("file_rule.bin");
                FileOutputStream out = new FileOutputStream(CFile1);
                ta.insert("   The result of updating Forward of CA After Add CAE3\n", ta.getCaretPosition());
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            //  tx3.insert(""+(char)CAE1[i][j][k],tx3.getCaretPosition());
                            ti = (char) CAE1[i][j][k];
                            out.write(ti);
                            ta.insert(" CA= " + ti + "\n", ta.getCaretPosition());
                        }
                    }
                }
                out.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    //{============================================================================}
    public static void Encryption(File Cfile) {
        int[][][] CAE = new int[n2][n1][n1];
        int[][][] CAE1 = new int[n2][n1][n1];
        int[][][] CAE2 = new int[n2][n1][n1];
        int[][][] CAE3 = new int[n2][n1][n1];
        int i, j, k, p1, pj, t, li, lj, lk;
        char ti = ' ';
        File CFile1;
        {

            ta.insert("  Function of read Message \n", ta.getCaretPosition());
            message1(CA1, CA2);
            ta.insert("  The Update CA Forward \n", ta.getCaretPosition());//("The Updating CA Forward");
            pj = 0;
            t = 0;
            do {
                t = t + 1;
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            if (pj > no_rule) {
                                pj = 0;
                            }
                            for (p1 = 0; p1 < 27; p1++) {
                                vect[p1] = rule[pj][p1];
                            }
                            pj = pj + 1;
                            UpdatingCA(CA, CA1, CA2, i, j, k, vect, 1);
                        }
                    }
                }
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            CA2[i][j][k] = Math.abs(CA1[i][j][k]);
                            CA1[i][j][k] = Math.abs(CA[i][j][k]);
                        }
                    }
                }
            } while (t <= 15);
            try {
                CFile1 = new File("file_rule.bin");
                FileOutputStream out = new FileOutputStream(CFile1);
                ta.insert(" Result of Updating CA,s= " + ti + "\n", ta.getCaretPosition());
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            ti = (char) (CA1[i][j][k]);

                            ta.insert("CA1= " + ti + "\n", ta.getCaretPosition());
                            out.write(ti);
                            ti = (char) (CA2[i][j][k]);
                            ta.insert("CA2 =" + ti + "\n", ta.getCaretPosition());
                            out.write(ti);
                        }
                    }
                }
                ta.insert(" The result of updating Forward of CA Before Add CAE3\n", ta.getCaretPosition());
                //JOptionPane.showConfirmDialog(null,"file created :","alert",JOptionPane.YES_NO_OPTION );
                CFile1 = new File("file_rule.bin");
                FileInputStream inf = new FileInputStream(CFile1);
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            ti = (char) inf.read();
                            ta.insert("CFile =" + ti + "\n", ta.getCaretPosition());
                            CAE3[i][j][k] = (int) (ti);
                        }
                    }
                }
                Add_Key(Cfile, CAE3);
                inf.close();
                out.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    //{===========================================================================}
    public static void File_Dec(File Cfile_Aug) {
        int[][][] CAD3 = new int[n2][n1][n1];
        int[][][] CAD = new int[n2][n1][n1];
        int[][][] CAD1 = new int[n2][n1][n1];
        int[][][] CAD2 = new int[n2][n1][n1];

        int i, j, k, p1, pj, t;
        char ti = ' ';
        {
            ta.insert("The Updating CA Backward\n", ta.getCaretPosition());
            for (i = 0; i < n2; i++) {
                for (j = 0; j < n1; j++) {
                    for (k = 0; k < n1; k++) {
                        CA[i][j][k] = 0;
                    }
                }
            }

            try {
                Cfile_Aug = new File("file_rule.bin");
                FileInputStream infi = new FileInputStream(Cfile_Aug);

                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            ti = (char) infi.read();
                            ta.insert("Cipertext  = " + ti + "\n", ta.getCaretPosition());
                            CAD3[i][j][k] = (int) ti;
                        }
                    }
                }

                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            CAD1[i][j][k] = Math.abs(Ini_CA[i][j][k]);
                            CAD2[i][j][k] = Math.abs(CAD[i][j][k]);
                            CAD[i][j][k] = 0;
                        }
                    }
                }

                t = 0;
                do {
                    t = t + 1;
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                UpdatingCA(CAD, CAD1, CAD2, i, j, k, vect, 2);
                            }
                        }
                    }
                } while (t <= 15);

                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            CAD1[i][j][k] = Math.abs(((CAD3[i][j][k] - CAD[i][j][k]) + state) % state);
                        }
                    }
                }
                // ta.insert("Cipertext After Subtract CAD ="+ti+"\n",ta.getCaretPosition());

                Cfile_Aug = new File("file_rule.bin");
                FileOutputStream out = new FileOutputStream(Cfile_Aug);
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            ti = (char) (CAD1[i][j][k]);
                            ta.insert("File_Dec = " + ti + "\n", ta.getCaretPosition());
                            out.write(ti);
                        }
                    }
                }
                out.close();
                infi.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    //{===========================================================================}
    public static void Decryption(File Cfile) {
        int i, j, k, p1, pj, t;
        char ti;
        {
            File_Dec(Cfile);
            ta.insert("The Updating CA Backward\n", ta.getCaretPosition());
            for (i = 0; i < n2; i++) {
                for (j = 0; j < n1; j++) {
                    for (k = 0; k < n1; k++) {
                        CA[i][j][k] = 0;
                    }
                }
            }
            try {
                Cfile = new File("file_rule.bin");
                FileInputStream infi = new FileInputStream(Cfile);
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            ti = (char) Math.abs(infi.read());
                            CA1[i][j][k] = (int) ti;
                            ti = (char) Math.abs(infi.read());
                            CA2[i][j][k] = (int) ti;

                        }
                    }
                }

                t = 0;
                pj = 0;
                do {
                    t = t + 1;
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                if (pj > no_rule) {
                                    pj = 0;
                                }
                                for (p1 = 0; p1 < 27; p1++) {
                                    vect[p1] = rule[pj][p1];
                                }
                                pj = pj + 1;
                                CA[i][j][k] = 0;
                                UpdatingCA(CA, CA2, CA1, i, j, k, vect, 1);
                            }
                        }
                    }
                    for (i = 0; i < n2; i++) {
                        for (j = 0; j < n1; j++) {
                            for (k = 0; k < n1; k++) {
                                CA1[i][j][k] = Math.abs(CA2[i][j][k]);
                                CA2[i][j][k] = Math.abs(CA[i][j][k]);

                            }
                        }
                    }
                } while (t < 15);
                ta.insert("        Final Result\n", ta.getCaretPosition());
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            ta.insert("Result Decryption =" + (char) Math.abs(CA2[i][j][k]) + "\n", ta.getCaretPosition());
                        }
                    }
                }

                infi.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        // *****************************************************************************
        // reset(Cfile);
        try {
            Cfile = new File("file_rule.bin");
            FileInputStream infi = new FileInputStream(Cfile);

            ta.insert(" The Result from File_Dec Procedure\n", ta.getCaretPosition());
            for (i = 0; i < n2; i++) {
                for (j = 0; j < n1; j++) {
                    for (k = 0; k < n1; k++) {
                        ti = (char) Math.abs(infi.read());
                        ta.insert("Cipertext After  Sbtract = " + ti + "\n", ta.getCaretPosition());
                        CA1[i][j][k] = (int) ti;
                        ti = (char) Math.abs(infi.read());
                        ta.insert("Cipertext After   Sbtract= " + ti + "\n", ta.getCaretPosition());
                        CA2[i][j][k] = (int) ti;
                    }
                }
            }
            t = 0;
            pj = 0;
            do {
                t = t + 1;
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            if (pj > no_rule) {
                                pj = 0;
                            }
                            for (p1 = 0; p1 < 27; p1++) {
                                vect[p1] = (byte) rule[pj][p1];
                            }
                            pj = pj + 1;
                            CA[i][j][k] = 0;
                            UpdatingCA(CA, CA2, CA1, i, j, k, vect, 1);
                        }
                    }
                }
                for (i = 0; i < n2; i++) {
                    for (j = 0; j < n1; j++) {
                        for (k = 0; k < n1; k++) {
                            CA1[i][j][k] = Math.abs(CA2[i][j][k]);
                            CA2[i][j][k] = Math.abs(CA[i][j][k]);
                        }
                    }
                }
            } while (t <= 15);
            ta.insert("        Final Result\n", ta.getCaretPosition());
            for (i = 0; i < n2; i++) {
                for (j = 0; j < n1; j++) {
                    for (k = 0; k < n1; k++) {
                        ta.insert("Result Decryption= " + (char) Math.abs(CA2[i][j][k]) + "\n", ta.getCaretPosition());
                    }
                }
            }
            infi.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        ta.insert("Decreption is Finshed\n", ta.getCaretPosition());
    }

    //{======================================================================================================}
    public static void main(String[] args) {
new Frame1().Run();
    }

    public void Run() {
        int i, j, Chex, index = 0, p, pj = 0, rule1;
        File File1 = new File("file4096_rule.bin");

        Initialize_CA(CA, CA1, Ini_CA, 0);
        // {--------------------------------------------------------------------------}
        Chex = JOptionPane.showConfirmDialog(null, "Do you want to Choose Rules Using Genetic Algorithm :", "alert", JOptionPane.YES_NO_OPTION);
        if (Chex == JOptionPane.YES_OPTION) {
            Genetic(rule, Aprob);

            ta.insert("\n********************************************************************************", ta.getCaretPosition());

            Test_Rule(CA, CA1, Aprob, vect, index);
            buble_sort(Aprob);
            Chose_Rule(rule, Aprob, pj);
            Chex = JOptionPane.showConfirmDialog(null, "Do you want to Save get Rules from  Using Genetic Algorithm : ", "alert", JOptionPane.YES_NO_OPTION);
            //JOptionPane.showMessageDialog(null,"wrong found in random :"+Chex,"alert",JOptionPane.OK_OPTION);
            if (Chex == JOptionPane.YES_OPTION) {

                try {

                    FileOutputStream out = new FileOutputStream(File1);

                    for (i = 0; i < pop; i++) {
                        for (j = 0; j < 27; j++) {
                            p = rule[i][j];
                            out.write(p);
                        }
                    }
                    out.close();
                } catch (IOException a) {
                    JOptionPane.showMessageDialog(null, "wrong in file :", "alert", JOptionPane.OK_OPTION);
                }

                // JOptionPane.showMessageDialog(null,"file created :","alert",JOptionPane.OK_OPTION);
            }
        } else {
            // assignfile(file1,'D:\Wase_Alezzani_Final\file4096_rule.bin');
            // reset(file1);
            try {
                FileInputStream infi = new FileInputStream(File1);
                p = 0;
                for (i = 0; i <= no_rule; i++) {
                    for (j = 0; j < 27; j++) {
                        p = infi.read();
                        // System.out .println(p+"  ");
                        rule[i][j] = (byte) p;
                    }
                }
                infi.close();
            } catch (IOException a) {
                JOptionPane.showMessageDialog(null, "file not found", "wrong", JOptionPane.OK_OPTION);
            }

        }

        ta.insert("  $$$$$$$$$$$$$$(  Please Wait to Complete Computation  )$$$$$$$$$$$$$", ta.getCaretPosition());
        do {
            Tests_Result(rule);
            Chex = JOptionPane.showConfirmDialog(null, "Do you Want To Continue", "alert", JOptionPane.YES_NO_OPTION);
        } while (Chex == JOptionPane.NO_OPTION);
        Chex = JOptionPane.showConfirmDialog(null, "Do you Want To Encryption Message?!!!!", "alert", JOptionPane.YES_NO_OPTION);
        if (Chex == JOptionPane.YES_OPTION) {
            //                {-----------------new added--------------------}
            // form2.showmodal;
            Encryption(Cfile1);
            {
                File_Dec(Cfile1);
            }
            Decryption(Cfile1);
            //  {-----------------new added--------------------}
        }
        // form2.Memo1.Lines.Clear;
        // }

    }

    public void readfile(String ap) {
        int aa = 0;
        char ti;
        byte[] buff = new byte[1024];
        try {
            File ff = new File(ap);
            FileInputStream file2 = new FileInputStream(ff);
            int i = file2.read(buff);
            String ss = new String(buff);
            txa.insert(ss, txa.getCaretPosition());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "file not fond", "File", JOptionPane.NO_OPTION);
        }

    }

    //Overridden so we can exit when window is closed
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);

        //ob.image=0;
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    void jButton2_mouseClicked(MouseEvent e) {
        System.exit(1);

    }

    void jButton1_mouseClicked(MouseEvent e) {
        txa.setVisible(false);
        ta.setVisible(true);
        ta.setEnabled(true);
        Run();

    }

    public synchronized void removeDocumentListener(DocumentListener l) {
        if (documentListeners != null && documentListeners.contains(l)) {
            Vector v = (Vector) documentListeners.clone();
            v.removeElement(l);
            documentListeners = v;
        }
    }

    public synchronized void addDocumentListener(DocumentListener l) {
        Vector v = documentListeners == null ? new Vector(2) : (Vector) documentListeners.clone();
        if (!v.contains(l)) {
            v.addElement(l);
            documentListeners = v;
        }
    }

    protected void fireInsertUpdate(DocumentEvent e) {
        if (documentListeners != null) {
            Vector listeners = documentListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((DocumentListener) listeners.elementAt(i)).insertUpdate(e);
            }
        }
    }

    protected void fireRemoveUpdate(DocumentEvent e) {
        if (documentListeners != null) {
            Vector listeners = documentListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((DocumentListener) listeners.elementAt(i)).removeUpdate(e);
            }
        }
    }

    protected void fireChangedUpdate(DocumentEvent e) {
        if (documentListeners != null) {
            Vector listeners = documentListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((DocumentListener) listeners.elementAt(i)).changedUpdate(e);
            }
        }
    }
    private TitledBorder titledBorder5;
    private JButton jButton3 = new JButton();
    private JTextArea path = new JTextArea();
    private JLabel jLabel1 = new JLabel();
    private JRadioButton jRadioButton1 = new JRadioButton();
    private JRadioButton jRadioButton2 = new JRadioButton();
    //private JTextArea tx3 = new JTextArea();

    void jButton3_actionPerformed(ActionEvent e) {
        int aa;
        final JFrame frame = new JFrame();
        final JFileChooser chooser = new JFileChooser();
        JFileFilter filter = new JFileFilter();
        filter.addType("*");
        filter.setDescription("Related files");
        chooser.addChoosableFileFilter(filter);
        int returnVal = chooser.showOpenDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path.insert(" " + chooser.getSelectedFile().getPath(), ta.getCaretPosition());
            readfile(chooser.getSelectedFile().getPath());
        } else {
            JOptionPane.showMessageDialog(null, "You did not choose a file.", "Alert", JOptionPane.OK_OPTION);
        }
        path.setVisible(true);
        jButton3.setVisible(true);
        jLabel1.setVisible(true);
        txa.setVisible(true);
        ta.setVisible(false);

    }

    void jRadioButton1_actionPerformed(ActionEvent e) {
        if (jRadioButton1.isSelected() == true) {
            jRadioButton2.setSelected(false);
            path.setVisible(true);
            jButton3.setVisible(true);
            jLabel1.setVisible(true);
            jButton1.setVisible(true);
            jButton3.setFocusPainted(true);
            txa.setVisible(true);
            ta.setVisible(false);
        }
        if (jRadioButton1.isSelected() == false) {
            jRadioButton1.setSelected(false);
            path.setVisible(false);
            jButton3.setVisible(false);
            jLabel1.setVisible(false);
            jButton3.setFocusPainted(false);
            jButton1.setVisible(false);
            txa.setVisible(false);
            ta.setVisible(false);
        }
    }

    void jRadioButton2_actionPerformed(ActionEvent e) {
        if (jRadioButton2.isSelected() == true) {
            jRadioButton1.setSelected(false);
            path.setVisible(false);
            jButton3.setVisible(false);
            jLabel1.setVisible(false);
            jButton1.setVisible(true);
            txa.setVisible(true);
            ta.setVisible(false);
        }
        if (jRadioButton2.isSelected() == false) {
            jRadioButton2.setSelected(false);
            path.setVisible(false);
            jButton3.setVisible(false);
            jLabel1.setVisible(false);
            jButton3.setFocusPainted(false);
            jButton1.setVisible(false);
            txa.setVisible(false);
            ta.setVisible(false);
        }

    }

    void this_windowOpened(WindowEvent e) {
        jButton1.setVisible(false);
        path.setVisible(false);
        jLabel1.setVisible(false);
        jButton3.setVisible(false);
        txa.setVisible(false);
        ta.setVisible(false);
    }

    void jButton2_actionPerformed(ActionEvent e) {

    }

}
