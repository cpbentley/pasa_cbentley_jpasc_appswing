package pasa.cbentley.jpasc.appswing.panel.tab;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.SwingConstants;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.swing.cmds.CmdConnectConnect;
import pasa.cbentley.swing.imytab.AbstractMyTab;
import pasa.cbentley.swing.widgets.b.BButton;
import pasa.cbentley.swing.widgets.b.BLabel;

public class TabConnecting extends AbstractMyTab {

   /**
    * 
    */
   private static final long       serialVersionUID = 3397089946479137427L;

   private BButton                 butConnectingLogo;

   private BLabel                  labConnecting;

   protected final PascAppCtx pec;

   public TabConnecting(PascAppCtx pac) {
      super(pac.getSwingCtx(), "connecting");
      this.pec = pac;

   }

   public void cmdConnect() {
      
      //start the call after the setVisible call has been made in the GUI thread
      sc.executeLaterInUIThread(new Runnable() {
         public void run() {
            //the cmd will launc the next Frame by itself
            CmdConnectConnect cmd = pec.getPascalSwingCtx().getCmds().getCmdConnectConnect();
            cmd.executeWith(pec);

            //notify owner that we are done our job. we can be disposed
            //next ui action can take place
            if (owner != null) {
               owner.tabIsFinished(TabConnecting.this);
            }
         }
      });
   }

   public void disposeTab() {

   }

   protected void initTab() {

      this.setLayout(new BorderLayout());

      labConnecting = new BLabel(pec.getSwingCtx(), "text.connectingnode");
      labConnecting.setHorizontalAlignment(SwingConstants.CENTER);

      Icon icon = pec.getSwingCtx().getResIcon("icon.pascal_logo_64");
      butConnectingLogo = new BButton(pec.getSwingCtx(), icon, icon);

      this.add(labConnecting, BorderLayout.NORTH);
      this.add(butConnectingLogo, BorderLayout.CENTER);
      
   }

   public void tabGainFocus() {
   }

   public void tabLostFocus() {
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "TabConnecting");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "TabConnecting");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {
   }

   //#enddebug

}
