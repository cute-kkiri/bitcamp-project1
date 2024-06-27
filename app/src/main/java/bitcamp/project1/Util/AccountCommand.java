package bitcamp.project1.Util;

import java.util.Iterator;
import java.util.LinkedList;
import bitcamp.project1.vo.Account;
import bitcamp.project1.vo.User;

public class AccountCommand extends MenuCommand{

  // Test: User1(OREO)'s Account //////////////////////////////////////
  static User user;
  static int total = 0;

  ///////////////////////////////////////////////////////////
  ///////////////////// private Instance ////////////////////
  ///////////////////////////////////////////////////////////
  private static AccountCommand accountCmd;

  // setup AccountCommand Instance
  public static AccountCommand getInstance(User user) {

    if (accountCmd == null) {
      accountCmd = new AccountCommand(user);
    }

    return accountCmd;
  }// Method getInstance END

  // reset AccountCommand Instance
  public static void freeInstance() {
    accountCmd = null;
  }// Method freeInstance END



  ///////////////////////////////////////////////////////////
  /////////////////////// Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  public AccountCommand(){

  }

  // set default
  public AccountCommand(User user) {
    this.user = user;
  }


  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////
  // print Account List
  // 1) -1400
  // 2) -300
  // 3) +1000
  // TOTAL: -700
  public String printAccount() {
    String str = "";
    Iterator<Account> iter = user.getAccountList().iterator();
    Account crntAccount = null;
    int num;


    for (int selectNo = 1; iter.hasNext(); selectNo++) {
      crntAccount = iter.next();
      // No
      str += String.format(" %5d) ", selectNo);
      // account
      num = crntAccount.getAccount();
      str += printAccountOpp(num);
      str += String.format("\n");
    }
    // Total
    str += String.format(" TOTAL: %s\n", printAccountOpp(total));
    return str;
  }

  // count total
  private void setTotal() {
    Iterator<Account> iter = user.getAccountList().iterator();
    Account crntAccount = null;
    total = 0;

    for (; iter.hasNext();) {
      crntAccount = iter.next();
      total += crntAccount.getAccount();
    }
  }

  // print Number operator(+, -)
  private String printAccountOpp(int num) {
    String str = "";

    if (num >= 0) {
      str += String.format("+%-10s ", num);// +
    } else {
      str += String.format("%-10s ", num);// -
    }

    return str;

  }

  ///////////////////////////////////////////////////////////
  //////////////////////// 1. Create ////////////////////////
  ///////////////////////////////////////////////////////////
  public void addAccount() {
    Account newAcc = new Account();

    // set account
    System.out.printf("Account?");
    newAcc.setAccount(MenuCommand.getUserScannerInt());

    // set description
    System.out.printf("Description?");
    newAcc.setDescription(MenuCommand.getUserScannerStr());

    // add list
    user.getAccountList().add(newAcc);

    // set total
    setTotal();
  }



  ///////////////////////////////////////////////////////////
  ///////////////////////// 2. Info /////////////////////////
  ///////////////////////////////////////////////////////////
  public String printInfo() {
    String str = "";
    Iterator<Account> iter = user.getAccountList().iterator();
    Account currentAccount = null;

    for (int selectNo = 1; iter.hasNext(); selectNo++) {
      currentAccount = iter.next();
      // No
      str += String.format("[%d] ", selectNo);
      // account
      str += String.format("%-10s ", currentAccount.getAccount());
      // description
      str += String.format(":%-10s ", currentAccount.getDescription());
      str += String.format("\n");
    }

    return str;
  }



  ///////////////////////////////////////////////////////////
  ///////////////////////// 3. Edit /////////////////////////
  ///////////////////////////////////////////////////////////
  public void editAccount(int accNo) {
    if (isValidateAccount(accNo)) {
      Account acc = user.getAccountList().get(accNo - 1);
      // set account
      System.out.printf("Account?");
      acc.setAccount(MenuCommand.getUserScannerInt());
      // set description
      System.out.printf("Description?");
      acc.setDescription(MenuCommand.getUserScannerStr());
      // set total
      setTotal();
    }
  }


  ///////////////////////////////////////////////////////////
  //////////////////////// 4. delete ////////////////////////
  ///////////////////////////////////////////////////////////
  public void deleteAccount(int accNo) {
    if (isValidateAccount(accNo)) {
      // remove account
      user.getAccountList().remove(accNo - 1);
      // set total
      setTotal();
    }
  }



  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  private boolean isValidateAccount(int accNo) {
    return (accNo > 0) && (accNo <= user.getAccountList().size()) ? true : false;
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


  public static LinkedList<Account> getAccountList() {
    return user.getAccountList();
  }

  public static void setAccountList(LinkedList<Account> accountList) {
    user.setAccountList(accountList);
  }
}// Class AccountCommand END
