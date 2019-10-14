package pasa.cbentley.jpasc.appswing.panel.helper;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.swing.panels.core.PanelCtxHelperAbstract;

/**
 * Default ctx helper with about button
 * @author Charles Bentley
 *
 */
public abstract class PanelCtxHelperJPascAbstract extends PanelCtxHelperAbstract {

   private static final long  serialVersionUID = 2137906542927031336L;

   protected final PascAppCtx pec;

   public PanelCtxHelperJPascAbstract(PascAppCtx pec) {
      super(pec.getPascalSwingCtx());
      this.pec = pec;
   }

   protected void initHelper() {
      buttonHelpAbout.setTextKey(getKeyAbout());
      String path = getImagePathAbout();
      if (path != null) {
         Icon icon = pec.getPascalSwingCtx().createImageIcon(path, "");
         buttonHelpAbout.setIconNormal(icon);
         buttonHelpAbout.setIconSelected(icon);
      }
   }
   public abstract String getKeyAbout();

   public abstract String getImagePathAbout();

   public void actionPerformed(ActionEvent e) {
      //depending on the state
      if (e.getSource() == buttonHelpAbout) {
         pec.getFrames().cmdShowAboutTab();
      }
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "PanelCtxHelperJPascAbstract");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "PanelCtxHelperJPascAbstract");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
