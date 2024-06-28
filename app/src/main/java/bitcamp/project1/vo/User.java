package bitcamp.project1.vo;

import java.util.Iterator;
import java.util.LinkedList;
import bitcamp.project1.Util.AccountCommand;

public class User {
  public AccountCommand ac = AccountCommand.getInstance(this);

  // User-accountList
  LinkedList<Account> accountList;
  // priKey
  static int seqNo = 0;
  // ID (default OREO)
  String ID = "OREO";
  // PW (default 0000)
  String PW = "0000";

  int total = 0;


  ///////////////////////////////////////////////////////////
  /////////////////////// Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  // set default
  public User() {
    accountList = new LinkedList<Account>();
  }



  // count total
  public void setTotal() {
    Iterator<Account> iter = this.getAccountList().iterator();
    Account crntAccount = null;
    int buffTotal = 0;

    for (; iter.hasNext();) {
      crntAccount = iter.next();
      buffTotal += crntAccount.getAccount();
    }

    this.total = buffTotal;
  }
  ///////////////////////////////////////////////////////////
  ///////////////// public getter, setter ///////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////////// -- ///////////////////////////
  //////////////////////// ---------- ///////////////////////
  ////////////////////////// ------ /////////////////////////
  //////////////////////////// -- ///////////////////////////
  ///////////////////////////////////////////////////////////
  public int getSeqNo() {
    return seqNo;
  }

  public int setNextSeqNo() {
    return ++seqNo;
  }

  public String getID() {
    return ID;
  }

  public void setID(String iD) {
    ID = iD;
  }

  public String getPW() {
    return PW;
  }

  public void setPW(String pW) {
    PW = pW;
  }

  public int getTotal() {
    return total;
  }
  public LinkedList<Account> getAccountList() {
    return accountList;
  }

  public void setAccountList(LinkedList<Account> accountList) {
    this.accountList = accountList;
  }
}// Class User END
