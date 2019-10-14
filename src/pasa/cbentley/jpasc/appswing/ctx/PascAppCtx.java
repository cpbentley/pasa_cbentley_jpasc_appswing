package pasa.cbentley.jpasc.appswing.ctx;

import java.awt.Image;
import java.util.List;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.jpasc.appswing.cmd.PascAppCmd;
import pasa.cbentley.jpasc.appswing.frame.FramesApp;
import pasa.cbentley.jpasc.appswing.menu.MenuBarFactoryPascApp;
import pasa.cbentley.jpasc.appswing.panel.tab.TabMainAbstract;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;
import pasa.cbentley.jpasc.swing.cmds.ICommandableConnect;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.jpasc.swing.others.CentralLogger;
import pasa.cbentley.jpasc.swing.panels.core.PanelCtxHelperAbstract;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabConsoleAlone;
import pasa.cbentley.swing.ctx.SwingCtx;

public abstract class PascAppCtx extends ACtx implements ICommandableConnect {

   protected final PascAppCmd            cmds;

   protected final FramesApp             frames;

   private CentralLogger                 logger;

   protected final MenuBarFactoryPascApp menuFactory;

   protected PanelTabConsoleAlone        panelConsole;

   protected final PascalSwingCtx        psc;

   protected final SwingCtx              sc;

   private TabMainAbstract               tabMain;

   private String                        version;

   public PascAppCtx(PascalSwingCtx psc) {
      super(psc.getUCtx());
      this.psc = psc;
      this.sc = psc.getSwingCtx();
      menuFactory = createMenuFactory();
      sc.setTabMenuBarFactory(menuFactory);
      frames = createFrames();
      cmds = createCmds();
   }

   /**
    * call super to add App specific bundles
    * @param list
    */
   public void addI18NKey(List<String> list) {
      list.add("i18nJPascApp");
   }

   protected abstract PascAppCmd createCmds();

   protected abstract FramesApp createFrames();

   protected abstract MenuBarFactoryPascApp createMenuFactory();

   protected abstract TabMainAbstract createTabMain();

   public PascAppCmd getCmds() {
      return cmds;
   }

   public FramesApp getFrames() {
      return frames;
   }

   public CentralLogger getLoggerUI() {
      if (logger == null) {
         this.logger = new CentralLogger(psc, getPanelConsole());
         uc.setUserLog(logger);
      }
      return logger;
   }

   public abstract Image getLogo64();

   public TabMainAbstract getMainTab() {
      if (tabMain == null) {
         tabMain = createTabMain();
      }
      return tabMain;
   }

   public PanelTabConsoleAlone getPanelConsole() {
      if (panelConsole == null) {
         //setup the gui logger so that we log the user log to be active
         this.panelConsole = new PanelTabConsoleAlone(psc);
      }
      return panelConsole;
   }
   

   /**
    * The small panel in the login button for deal with contextual 
    * @return
    */
   public abstract PanelCtxHelperAbstract createPanelCtxHelper();

   public PascalSwingCtx getPascalSwingCtx() {
      return psc;
   }

   public PCoreCtx getPCtx() {
      return psc.getPCtx();
   }

   public SwingCtx getSwingCtx() {
      return psc.getSwingCtx();
   }

   public String getVersion() {
      return version;
   }

   public void setVersion(String version) {
      this.version = version;
   }

   public void showUIFailure() {
      getFrames().cmdShowNoConnection();
   }

   public void showUISuccess() {
      getFrames().cmdShowMainWindow();
   }

}
