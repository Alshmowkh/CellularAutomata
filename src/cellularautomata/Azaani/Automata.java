package cellularautomata.Azaani;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Automata extends Applet{
  Image img1,img2,img3,img4,img5;
   public   int Automata;
  public Automata() {
  }
  public void init()
      {
           img1 = getImage(getDocumentBase(), "Pic_01.jpg");
           img2 = getImage(getDocumentBase(), "Pic_02_A.jpg");
           img3 = getImage(getDocumentBase(), "Pic_02_B.jpg");
           img4 = getImage(getDocumentBase(), "Pic_03_A.jpg");
           img5 = getImage(getDocumentBase(), "Pic_03_B.jpg");
      }

      public void paint(Graphics g)
      {
           g.drawImage(img1, 10, 10, this);
           g.drawImage(img2, 10, 10, this);
           g.drawImage(img3, 10, 10, this);
           g.drawImage(img4, 10, 10, this);
           g.drawImage(img5, 10, 10, this);
      }

}