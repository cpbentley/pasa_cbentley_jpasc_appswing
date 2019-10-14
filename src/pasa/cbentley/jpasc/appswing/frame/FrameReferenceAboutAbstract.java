package pasa.cbentley.jpasc.appswing.frame;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.swing.imytab.FrameIMyTab;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;

public abstract class FrameReferenceAboutAbstract extends FrameReferenceTabAbstract {

   protected final PascAppCtx pec;

   public FrameReferenceAboutAbstract(PascAppCtx pec) {
      super(pec.getSwingCtx());
      this.pec = pec;
   }

   protected void customizeLaunch(FrameIMyTab f) {
      sc.showInNewFrame(f, 0.6f, 0.9f);
   }

   protected void customizeFrame(FrameIMyTab f) {
      f.setIconImage(pec.getLogo64());
   }

   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "FrameReferenceAbout");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "FrameReferenceAbout");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   


}
