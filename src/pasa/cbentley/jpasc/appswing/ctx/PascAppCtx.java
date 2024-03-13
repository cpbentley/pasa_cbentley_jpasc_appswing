package pasa.cbentley.jpasc.appswing.ctx;

import java.awt.Image;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.jpasc.appswing.cmd.PascAppCmd;
import pasa.cbentley.jpasc.appswing.frame.FramesApp;
import pasa.cbentley.jpasc.appswing.menu.MenuBarFactoryPascApp;
import pasa.cbentley.jpasc.appswing.panel.helper.PanelHelperWaitDaemon;
import pasa.cbentley.jpasc.appswing.panel.tab.TabMainAbstract;
import pasa.cbentley.jpasc.pcore.ctx.PCoreCtx;
import pasa.cbentley.jpasc.pcore.network.RPCConnection;
import pasa.cbentley.jpasc.swing.cmds.ICommandableConnect;
import pasa.cbentley.jpasc.swing.ctx.PascalSwingCtx;
import pasa.cbentley.jpasc.swing.others.CentralLogger;
import pasa.cbentley.jpasc.swing.panels.core.PanelCtxHelperAbstract;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabConsoleAlone;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.imytab.FrameReference;

public abstract class PascAppCtx extends ACtx implements ICommandableConnect {

   protected PascAppCmd            cmds;

   protected FramesApp             frames;

   private CentralLogger           logger;

   protected MenuBarFactoryPascApp menuFactory;

   protected PanelTabConsoleAlone  panelConsole;

   protected final PascalSwingCtx  psc;

   protected final SwingCtx        sc;

   private TabMainAbstract         tabMain;

   private String                  version;

   public PascAppCtx(PascalSwingCtx psc) {
      super(psc.getUC());
      this.psc = psc;
      this.sc = psc.getSwingCtx();
   }

   /**
    * Try to connect
    * @param panelWaitDaemon
    */
   public boolean cmdDaemonConnection(PanelHelperWaitDaemon panelWaitDaemon) {
      PCoreCtx pc = this.getPCtx();
      RPCConnection rpc = new RPCConnection(pc);
      boolean isConnected = rpc.connectLocalhost();
      if (isConnected) {
         pc.setRPCConnection(rpc);
         //bring visible the main frame

         return true;
      }

      return false;
   }

   /**
    * 
    * @return {@link PascAppCmd}
    */
   protected abstract PascAppCmd createCmds();

   /**
    * The {@link FrameReference} that can be created in this application
    * @return {@link FramesApp}
    */
   protected abstract FramesApp createFrames();

   /**
    * 
    * @return {@link MenuBarFactoryPascApp}
    */
   protected abstract MenuBarFactoryPascApp createMenuFactory();

   /**
    * The small panel in the login button for deal with contextual 
    * @return
    */
   public abstract PanelCtxHelperAbstract createPanelCtxHelper();

   /**
    * The main {@link TabMainAbstract} 
    * @return
    */
   protected abstract TabMainAbstract createTabMain();

   public PascAppCmd getCmds() {
      if (cmds == null) {
         cmds = createCmds();
      }
      return cmds;
   }

   public FramesApp getFrames() {
      if (frames == null) {
         frames = createFrames();
      }
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

   public MenuBarFactoryPascApp getMenuBarFactory() {
      if (menuFactory == null) {
         menuFactory = createMenuFactory();
      }
      return menuFactory;
   }

   public PanelTabConsoleAlone getPanelConsole() {
      if (panelConsole == null) {
         //setup the gui logger so that we log the user log to be active
         this.panelConsole = new PanelTabConsoleAlone(psc);
      }
      return panelConsole;
   }

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

   /**
    * Shows the No Connection Frame
    */
   public void showUIFailure() {
      getFrames().cmdShowNoConnection();
   }

   /**
    * Shows the Main Window after a daemon connection success.
    */
   public void showUISuccess() {
      getFrames().cmdShowMainWindow();
   }

}
