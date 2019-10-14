package pasa.cbentley.jpasc.appswing.panel.tab;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.swing.imytab.TabHTMLAbstract;

public class TabExplorerChangeLog extends TabHTMLAbstract {

   /**
    * 
    */
   private static final long       serialVersionUID = -1381488953929259385L;

   public static final String      ID               = "changelog";

   protected final PascAppCtx pec;

   public TabExplorerChangeLog(PascAppCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;

   }

   public String getPathHTML() {
      return "/html/changelog.html";
   }

}
