package pasa.cbentley.jpasc.appswing.panel.tab;

import java.awt.BorderLayout;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.jpasc.swing.panels.core.PanelCtxHelperAbstract;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabConsoleAbstract;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabLogin;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabLoginConsole;
import pasa.cbentley.jpasc.swing.widgets.PanelPascal;
import pasa.cbentley.swing.imytab.AbstractMyTab;
import pasa.cbentley.swing.imytab.IMyTab;

public abstract class TabMainAbstract extends AbstractMyTab {

   protected final PascAppCtx     pac;

   protected final PascalSwingCtx psc;

   public TabMainAbstract(PascAppCtx pac, String internalID) {
      super(pac.getSwingCtx(), internalID);
      this.pac = pac;
      this.uc = pac.getUC();
      this.psc = pac.getPascalSwingCtx();
   }

   private AbstractMyTab               centerTab;

   private PanelTabLogin        loginPanel;

   protected final UCtx         uc;

   private PanelTabLoginConsole panelTabLoginConsole;

   protected abstract AbstractMyTab createCenterPanel();
   
   protected void initTab() {

      PanelTabConsoleAbstract panelConsole = pac.getPanelConsole();

      PanelCtxHelperAbstract ctxHelper = pac.createPanelCtxHelper();
      loginPanel = new PanelTabLogin(psc);
      loginPanel.setConfigShowBlockInfo(false);
      loginPanel.setPanelCtxHelperAbstract(ctxHelper);

      panelTabLoginConsole = new PanelTabLoginConsole(psc, loginPanel, panelConsole);

      this.setLayout(new BorderLayout());
      this.add(panelTabLoginConsole, BorderLayout.CENTER);
      panelTabLoginConsole.initCheck();
      loginPanel.initCheck();
      panelConsole.initCheck();
      centerTab = createCenterPanel();
      centerTab.initCheck();
      panelTabLoginConsole.setPanelCenter(centerTab);

   }

}
