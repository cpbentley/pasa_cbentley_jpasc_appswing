/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.appswing.panel;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.appswing.panel.tab.TabExplorerAgreement;
import pasa.cbentley.jpasc.appswing.panel.tab.TabExplorerLicense;
import pasa.cbentley.swing.imytab.TabbedBentleyPanel;

/**
 * Tabs for the agreement
 * 
 * @author Charles Bentley
 *
 */
public class TabsAgreement extends TabbedBentleyPanel {
   /**
    * 
    */
   private static final long       serialVersionUID = -3523191063614218767L;

   public static final String      ID               = "subtabs_agreement";

   protected final PascAppCtx pec;

   private TabExplorerLicense      tabLicense;

   private TabExplorerAgreement    tabAgreement;

   public TabsAgreement(PascAppCtx pec) {
      super(pec.getSwingCtx(), ID);
      this.pec = pec;
   }

   public void disposeTab() {
      tabLicense = null;
      tabAgreement = null;
   }

   public void initTabs() {

      tabAgreement = new TabExplorerAgreement(pec);
      tabLicense = new TabExplorerLicense(pec);

      addMyTab(tabAgreement);
      addMyTab(tabLicense);

   }

}