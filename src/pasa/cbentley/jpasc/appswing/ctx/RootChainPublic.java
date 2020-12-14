package pasa.cbentley.jpasc.appswing.ctx;

import pasa.cbentley.jpasc.pcore.domain.java.PublicKeyJava;
import pasa.cbentley.jpasc.pcore.interfaces.IAccessPascal;
import pasa.cbentley.jpasc.pcore.rpc.model.Account;
import pasa.cbentley.jpasc.pcore.rpc.model.Block;
import pasa.cbentley.jpasc.pcore.rpc.model.PublicKey;
import pasa.cbentley.jpasc.swing.interfaces.IRootTabPane;

public class RootChainPublic implements IRootTabPane {

   protected final PascAppCtx ptc;

   public RootChainPublic(PascAppCtx ptc) {
      this.ptc = ptc;
   }

   public Integer getAccountNext(Integer account) {
      // TODO Auto-generated method stub
      return null;
   }

   public Integer getAccountPrev(Integer account) {
      // TODO Auto-generated method stub
      return null;
   }

   public IAccessPascal getAccessPascal() {
      // TODO Auto-generated method stub
      return null;
   }

   public void showBlockDetails(Block ac) {
      //here
   }

   public void showAccountDetails(Account ac) {
      // TODO Auto-generated method stub

   }

   public void showAccountDetails(Integer ac) {
      // TODO Auto-generated method stub

   }

   public void showAccountOwner(Account ac) {
      // TODO Auto-generated method stub

   }

   public void showAccountOwner(Integer ac) {
      // TODO Auto-generated method stub

   }

   public void showBlock(Block ac) {
      // TODO Auto-generated method stub

   }

   public void showPublicKeyAccounts(PublicKey pk) {
      // TODO Auto-generated method stub

   }

   public void showPublicKeyJavaAccountNames(PublicKeyJava pk) {
      // TODO Auto-generated method stub

   }

   public void showPublicKeyJavaAccounts(PublicKeyJava pk) {
      // TODO Auto-generated method stub

   }

   public Integer getAccountLast() {
      // TODO Auto-generated method stub
      return null;
   }

   public Integer getBlockNext(Integer block) {
      // TODO Auto-generated method stub
      return null;
   }

   public Integer getBlockPrev(Integer block) {
      // TODO Auto-generated method stub
      return null;
   }

   public Integer getBlockLast() {
      // TODO Auto-generated method stub
      return null;
   }

}
