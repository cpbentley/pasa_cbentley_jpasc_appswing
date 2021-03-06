package pasa.cbentley.jpasc.appswing.menu;

import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_P;
import static java.awt.event.KeyEvent.VK_T;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import pasa.cbentley.core.src4.logging.ITechLvl;
import pasa.cbentley.jpasc.pcore.tools.KeyNameProvider;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.swing.menu.MenuDebug;
import pasa.cbentley.swing.widgets.b.BMenuItem;

public class MenuDebugExplorer extends MenuDebug {

   private BMenuItem              itemToStringPkStore;

   protected final PascalSwingCtx psc;

   private BMenuItem              itemConnectTestNet;

   public MenuDebugExplorer(PascalSwingCtx psc) {
      super(psc.getSwingCtx());
      this.psc = psc;
   }

   public void actionPerformed(ActionEvent e) {
      super.actionPerformed(e);
      Object src = e.getSource();
      if (src == itemToStringPkStore) {
         KeyNameProvider stores = psc.getPCtx().getKeyNameProvider();
         //#debug
         sc.toDLog().pAlways("Debug", stores, MenuDebugExplorer.class, "actionPerformed", ITechLvl.LVL_08_INFO, false);

      } else if (src == itemConnectTestNet) {
         psc.getPCtx().getRPCConnection().connectLocalhostTestNet();
      }
   }

   protected void initMenu() {
      super.initMenu();

      itemToStringPkStore = new BMenuItem(sc, this, "menu.debug.tostring.pkstore");
      itemToStringPkStore.setMnemonic(VK_P);
      itemToStringPkStore.setAccelerator(KeyStroke.getKeyStroke(VK_A, modCtrlAltShift));

      itemConnectTestNet = new BMenuItem(sc, this, "menu.debug.connecttestnet");
      itemConnectTestNet.setToolTipText("If you run a testnet on default port, you can connect to it");
      itemConnectTestNet.setMnemonic(VK_T);
      itemConnectTestNet.setAccelerator(KeyStroke.getKeyStroke(VK_A, modCtrlAltShift));

      this.addSeparator();
      this.add(itemToStringPkStore);
      this.add(itemConnectTestNet);
   }

}
