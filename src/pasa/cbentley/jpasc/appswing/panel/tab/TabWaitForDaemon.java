package pasa.cbentley.jpasc.appswing.panel.tab;

import java.awt.BorderLayout;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.appswing.panel.helper.PanelHelperWaitDaemon;
import pasa.cbentley.jpasc.appswing.panel.helper.TabsNoConnection;
import pasa.cbentley.swing.imytab.AbstractMyTab;

public class TabWaitForDaemon extends AbstractMyTab {

   protected final PascAppCtx pec;

   private TabsNoConnection        tabsGIF;

   private PanelHelperWaitDaemon   panelWaitMessage;

   public TabWaitForDaemon(PascAppCtx pec) {
      super(pec.getSwingCtx(), "daemon_connection");
      this.pec = pec;

   }

   public void tabLostFocus() {
   }

   public void tabGainFocus() {
   }

   public void disposeTab() {

   }

   protected void initTab() {

      this.setLayout(new BorderLayout());

      panelWaitMessage = new PanelHelperWaitDaemon(pec);
      
      tabsGIF = new TabsNoConnection(pec);
      tabsGIF.initCheck();

      this.add(panelWaitMessage, BorderLayout.NORTH);
      this.add(tabsGIF, BorderLayout.CENTER);
   }
}
