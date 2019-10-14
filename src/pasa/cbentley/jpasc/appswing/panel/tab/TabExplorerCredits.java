package pasa.cbentley.jpasc.appswing.panel.tab;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.swing.imytab.TabHTMLAbstract;

public class TabExplorerCredits extends TabHTMLAbstract {

   /**
    * 
    */
   private static final long       serialVersionUID = 8244489697535958652L;

   public static final String      ID               = "credits";

   protected final PascAppCtx pec;

   public TabExplorerCredits(PascAppCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;
   }

   public String getPathHTML() {
      return "/html/credits.html";
   }
}
