package pasa.cbentley.jpasc.appswing.cmd;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.appswing.frame.FrameReferenceAgreement;
import pasa.cbentley.jpasc.appswing.frame.FrameReferenceConnecting;
import pasa.cbentley.jpasc.appswing.panel.helper.PanelHelperWaitDaemon;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;
import pasa.cbentley.jpasc.pcore.network.RPCConnection;
import pasa.cbentley.jpasc.swing.interfaces.IPrefsPascalSwing;

/**
 * Provides the basic implementation of user commands for JPasc Swing app.
 * 
 * <li> Agree
 * <li> Connect to Daemon Connection
 * 
 * @author Charles Bentley
 *
 */
public abstract class PascAppCmd {

   protected final PascAppCtx pac;

   public PascAppCmd(PascAppCtx pac) {
      this.pac = pac;

   }

   public void cmdAgree() {
      //show
      String keyPrefAgree = IPrefsPascalSwing.PREF_AGREE_PREFIX + pac.getVersion();
      String value = String.valueOf(System.currentTimeMillis());
      pac.getPascalSwingCtx().getPascPrefs().put(keyPrefAgree, value);

      //if not already connected
      if (pac.getFrames().createFrameMainWindow().isInactive()) {
         FrameReferenceConnecting frameConnecting = pac.getFrames().getFrameConnecting();
         frameConnecting.showFrame();
         frameConnecting.getTab().cmdConnect();
      }
      //close frame
      FrameReferenceAgreement frameAgree = pac.getFrames().getFrameAgreement();
      frameAgree.closeFrame();
   }

   public void cmdAgreeNo() {
      // TODO Auto-generated method stub

   }

   public boolean cmdDaemonConnection(PanelHelperWaitDaemon panelHelperWaitDaemon) {
      PCoreCtx pc = pac.getPCtx();
      RPCConnection rpc = new RPCConnection(pc);
      boolean isConnected = rpc.connectLocalhost();
      if (isConnected) {
         pc.setRPCConnection(rpc);
         //bring visible the main frame

         return true;
      }

      return false;
   }

}
