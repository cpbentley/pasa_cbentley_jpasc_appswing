/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.jpasc.appswing.run;

import java.util.List;

import javax.swing.ImageIcon;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.helpers.StringBBuilder;
import pasa.cbentley.core.src4.interfaces.IPrefs;
import pasa.cbentley.core.src4.logging.BaseDLogger;
import pasa.cbentley.core.src4.logging.IDLogConfig;
import pasa.cbentley.core.src4.logging.ITechTags;
import pasa.cbentley.jpasc.appswing.ctx.PascAppCtx;
import pasa.cbentley.jpasc.appswing.frame.FrameReferenceAgreement;
import pasa.cbentley.jpasc.appswing.frame.FrameReferenceConnecting;
import pasa.cbentley.jpasc.pcore.ctx.ITechPCore;
import pasa.cbentley.jpasc.swing.interfaces.IPrefsPascalSwing;
import pasa.cbentley.jpasc.swing.others.CentralLogger;
import pasa.cbentley.jpasc.swing.panels.core.PanelTabConsoleAlone;
import pasa.cbentley.jpasc.swing.panels.table.abstrakt.TablePanelAbstract;
import pasa.cbentley.jpasc.swing.run.RunPascalSwingAbstract;
import pasa.cbentley.swing.images.anim.AnimRunnerProducer;
import pasa.cbentley.swing.images.anim.ui.JComponentAnim;
import pasa.cbentley.swing.skin.main.SwingSkinManager;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * 
 * @author Charles Bentley
 *
 */
public abstract class RunPascAppAbstract extends RunPascalSwingAbstract {

   protected final PascAppCtx pac;

   private String             skinDefault;

   private String             skinThemeDefault;

   private String             logoDefault;

   public RunPascAppAbstract() {
      super();
      this.pac = createCtx();
   }

   protected abstract PascAppCtx createCtx();

   /**
    * 
    */
   protected void initSkinner() {
      //load the look and feel before any Swing component
      SwingSkinManager pascalSkinManager = new SwingSkinManager(ssc);
   
      if (skinDefault == null) {
         skinDefault = "com.jtattoo.plaf.mint.MintLookAndFeel";
      }
      if (skinThemeDefault == null) {
         skinThemeDefault = "Medium-Font";
      }
      pascalSkinManager.setDefault(skinDefault, skinThemeDefault);

      if(logoDefault != null) {
         ImageIcon icon = psc.createImageIcon(logoDefault, "");
         pascalSkinManager.setIconSelected(icon);
      }
      pascalSkinManager.prefsInit();
      psc.setSwingSkinManager(pascalSkinManager);
   }

   protected final void addI18nPascal(List<String> list) {
      list.add("i18nJPascApp");
      addI18nPascalApp(list);
   }
   
   protected abstract void addI18nPascalApp(List<String> list);


   protected void initForPrefsPascal(IPrefs prefs) {
      sc.setResMissingLog(true);
      //we don't want auto lock
      pc.getPrefs().putBoolean(ITechPCore.PKEY_AUTO_LOCK, false);

      psc.getPascPrefs().putBoolean(IPrefsPascalSwing.PREF_GLOBAL_MANUAL_REFRESH, true);
      //disable built in sounds for this release
      psc.getPascPrefs().putInt(IPrefsPascalSwing.PREF_PLAY_SOUND, IPrefsPascalSwing.PREF_PLAY_SOUND_0_NONE);

   }
   
   

   protected abstract String getWelcomeMessage();
   
   protected CBentleyFrame initUIThreadInsideSwing() {

      psc.applyPrefs(psc.getPascPrefs());

      pac.getLoggerUI().consoleLogDate(getWelcomeMessage());

      String keyPrefAgree = IPrefsPascalSwing.PREF_AGREE_PREFIX + pac.getVersion();
      String agree = psc.getPascPrefs().get(keyPrefAgree, "");

      FrameReferenceConnecting frameConnecting = pac.getFrames().getFrameConnecting();

      if (agree.length() == 0) {
         //show the agreement window
         FrameReferenceAgreement frameAgreement = pac.getFrames().getFrameAgreement();
         //create a chain action
         frameAgreement.showFrame();
      } else {
         frameConnecting.showFrame();
         frameConnecting.getTab().cmdConnect();
      }

      return null;
   }

   public String getSkinDefault() {
      return skinDefault;
   }

   public void setSkinDefault(String skinDefault) {
      this.skinDefault = skinDefault;
   }

   public String getSkinThemeDefault() {
      return skinThemeDefault;
   }

   public void setSkinThemeDefault(String skinThemeDefault) {
      this.skinThemeDefault = skinThemeDefault;
   }

   public String getLogoDefault() {
      return logoDefault;
   }

   public void setLogoDefault(String logoDefault) {
      this.logoDefault = logoDefault;
   }

}
