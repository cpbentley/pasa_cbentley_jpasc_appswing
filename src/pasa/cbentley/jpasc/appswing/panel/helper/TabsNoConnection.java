/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.appswing.panel.helper;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.appswing.panel.NoobGifDaemon;
import pasa.cbentley.jpasc.appswing.panel.NoobGifDaemonKeys;
import pasa.cbentley.jpasc.appswing.panel.tab.TabInstallDesktopWallet;
import pasa.cbentley.swing.imytab.TabbedBentleyPanel;

/**
 * Tabs showing information on how to make everything run
 * 
 * @author Charles Bentley
 *
 */
public class TabsNoConnection extends TabbedBentleyPanel {
   /**
    * 
    */
   private static final long        serialVersionUID = -3523191063614218767L;

   public static final String       ID               = "root_gifs_explorer";

   protected final PascAppCtx  pec;

   private NoobGifDaemon       tabDaemonRPC;

   private NoobGifDaemonKeys       tabDaemonKeys;

   private TabInstallDesktopWallet tabInstall;


   public TabsNoConnection(PascAppCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;
   }

   public void disposeTab() {
      tabDaemonRPC = null;
   }

   public void initTabs() {
      tabDaemonRPC = new NoobGifDaemon(pec.getPascalSwingCtx());
      tabInstall = new TabInstallDesktopWallet(pec.getPascalSwingCtx());
      
      addMyTab(tabDaemonRPC);
      addMyTab(tabInstall);

   }

}