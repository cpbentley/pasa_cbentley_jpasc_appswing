package pasa.cbentley.jpasc.appswing.frame;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.swing.imytab.FrameReference;
import pasa.cbentley.swing.imytab.FrameReferenceTabAbstract;

public abstract class FramesApp {

   protected final PascAppCtx         pec;

   private FrameReferenceAboutAbstract        frameReferenceAbout;

   private FrameReferenceNoConnection frameReferenceCon;

   private FrameReferenceDaemonHelp   frameReferenceDaemon;

   private FrameReferenceTabAbstract  frameMainWindow;

   private FrameReferenceAgreement    frameReferenceAgreement;

   private FrameReferenceConnecting   frameReferenceConnecting;

   public FramesApp(PascAppCtx pec) {
      this.pec = pec;
   }

   public void cmdShowAboutTab() {
      getFrameAbout().showFrame();
   }

   public FrameReferenceConnecting getFrameConnecting() {
      //add the about tab in a frame
      if (frameReferenceConnecting == null) {
         frameReferenceConnecting = new FrameReferenceConnecting(pec);
      }
      return frameReferenceConnecting;
   }

   public FrameReferenceAgreement getFrameAgreement() {
      //add the about tab in a frame
      if (frameReferenceAgreement == null) {
         frameReferenceAgreement = new FrameReferenceAgreement(pec);
      }
      return frameReferenceAgreement;
   }

   public FrameReferenceAboutAbstract getFrameAbout() {
      //add the about tab in a frame
      if (frameReferenceAbout == null) {
         frameReferenceAbout = createFrameReferenceAbout(pec);
      }
      return frameReferenceAbout;
   }

   protected abstract FrameReferenceAboutAbstract createFrameReferenceAbout(PascAppCtx pac);

   public void cmdShowDaemonHelp() {
      //add the about tab in a frame
      getFrameDaemon().showFrame();
   }

   public FrameReferenceDaemonHelp getFrameDaemon() {
      if (frameReferenceDaemon == null) {
         frameReferenceDaemon = new FrameReferenceDaemonHelp(pec);
      }
      return frameReferenceDaemon;
   }

   public FrameReferenceTabAbstract getFrameMain() {
      if (frameMainWindow == null) {
         frameMainWindow = createFrameMainWindow();
      }
      return frameMainWindow;
   }

   public abstract FrameReferenceTabAbstract createFrameMainWindow();

   public void cmdShowMainWindow() {
      getFrameMain().showFrame();
   }

   public FrameReferenceNoConnection getFrameNoConnection() {
      //add the about tab in a frame
      if (frameReferenceCon == null) {
         frameReferenceCon = new FrameReferenceNoConnection(pec);
      }
      return frameReferenceCon;
   }

   public void cmdShowNoConnection() {
      getFrameNoConnection().showFrame();
   }
}
