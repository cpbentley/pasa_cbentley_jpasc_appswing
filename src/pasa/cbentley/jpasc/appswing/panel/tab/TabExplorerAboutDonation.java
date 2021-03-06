/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.appswing.panel.tab;

import java.awt.Color;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.swing.gif.ui.AbstractGifTab;

public class TabExplorerAboutDonation extends AbstractGifTab {

   public static final String      ID               = "about_donations";

   private static final String     KEY_TITLE        = "about_donations_title";

   /**
    * 
    */
   private static final long       serialVersionUID = 4177675057217095786L;

   protected final PascAppCtx pec;

   public TabExplorerAboutDonation(PascAppCtx pec) {
      super(pec.getPascalSwingCtx().getGifContext(), ID, "/gifs/pascal_exude_black_256.gif", KEY_TITLE);
      this.pec = pec;
      this.setColorBackgroundGif(Color.black);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "TabExplorerAboutBentley");
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "TabExplorerAboutBentley");
      super.toString(dc.sup1Line());
   }
   //#enddebug
}
