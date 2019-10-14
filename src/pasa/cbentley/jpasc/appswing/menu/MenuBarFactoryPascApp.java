/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.appswing.menu;

import javax.swing.JMenuBar;

import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.appswing.interfaces.IPascAppAbout;
import pasa.cbentley.jpasc.appswing.panel.TabsNoobGifs;
import pasa.cbentley.jpasc.appswing.panel.tab.TabConnecting;
import pasa.cbentley.jpasc.appswing.panel.tab.TabWaitForDaemon;
import pasa.cbentley.jpasc.swing.menu.MenuBarPascalFactory;
import pasa.cbentley.swing.imytab.ITabMenuBarFactory;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * Create a menu bar.
 * 
 * What if the panel is decided by the brander?
 * 
 * @author Charles Bentley
 *
 */
public class MenuBarFactoryPascApp extends MenuBarPascalFactory implements ITabMenuBarFactory {

   protected final PascAppCtx pec;

   public MenuBarFactoryPascApp(PascAppCtx pec) {
      super(pec.getPascalSwingCtx());
      this.pec = pec;
   }

   public JMenuBar getMenuBar(Object owner, CBentleyFrame frame) {
      if (owner instanceof IPascAppAbout) {
         //we want a menu bar for the about frame
         return new MenuBarPascalAbout(pec, frame);
      } else if (owner instanceof TabConnecting) {
         return null;
      } else if (owner instanceof TabWaitForDaemon) {
         return new MenuBarPascalNoConnection(pec, frame);
      } else if (owner instanceof TabsNoobGifs) {
         return new MenuBarPascalDaemonHelp(pec, frame);
      } else {
         //the default menu
         return new MenuBarPascalAbout(pec, frame);
      }
   }
}
