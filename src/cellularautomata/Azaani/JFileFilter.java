package fina;

import javax.swing.filechooser.*;
import java.io.*;
import java.io.File;
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class JFileFilter extends javax.swing.filechooser.FileFilter{
  protected String description;
 protected ArrayList exts = new ArrayList(  );

     public void addType(String s) {
         exts.add(s);
     }

     /** Return true if the given file is accepted by this filter. */
     public boolean accept(File f) {
         // Little trick: if you don't do this, only directory names
         // ending in one of the extensions appear in the window.
         if (f.isDirectory(  )) {
             return true;

         } else if (f.isFile(  )) {
             Iterator it = exts.iterator(  );
             while (it.hasNext(  )) {
                 if (f.getName().endsWith((String)it.next(  )))
                    return true;
             }
    }

   // / A file that didn't match, or a weirdo (e.g. UNIX device
//file?).
    return false;
    }
    public void setDescription(String s) {
        description = s;
    }
    /** Return the printable description of this filter. */
    public String getDescription(  ) {
        return description;
    }



  public JFileFilter() {
  }


}