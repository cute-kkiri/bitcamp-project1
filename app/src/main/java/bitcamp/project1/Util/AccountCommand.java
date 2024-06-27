package Util;

import java.util.Iterator;
import java.util.LinkedList;
import vo.Account;

public class AccountCommand {

  // Test: User1(OREO)'s Account //////////////////////////////////////
  public static LinkedList<Account> accountList = new LinkedList<Account>(); // User's Account List
  static int total = 0;

  ///////////////////////////////////////////////////////////
  ///////////////////// private Instance ////////////////////
  ///////////////////////////////////////////////////////////
  private static AccountCommand accountCmd;

  // setup AccountCommand Instance
  public static AccountCommand getInstance() {

    if (accountCmd == null) {
      accountCmd = new AccountCommand();
    }

    return accountCmd;
  }// Method getInstance END

  // reset AccountCommand Instance
  public static void freeInstance() {
    accountCmd = null;
  }// Method freeInstance END



  ///////////////////////////////////////////////////////////
  ////////////////////// Dummy Account //////////////////////
  ///////////////////////////////////////////////////////////
  public void addAccountDummy() {
    Account newAcc1 = new Account();
    newAcc1.setAccount(-1400);
    newAcc1.setDescription("Subway, .,");
    accountList.add(newAcc1);

    Account newAcc2 = new Account();
    newAcc2.setAccount(-300);
    newAcc2.setDescription("Bus/. .");
    accountList.add(newAcc2);


    Account newAcc3 = new Account();
    newAcc3.setAccount(1000);
    newAcc3.setDescription("get. .");
    accountList.add(newAcc3);

    setTotal();
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
    Iterator<Account> iter = accountList.iterator();
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
    Iterator<Account> iter = accountList.iterator();
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
    accountList.add(newAcc);

    // set total
    setTotal();
  }



  ///////////////////////////////////////////////////////////
  ///////////////////////// 2. Info /////////////////////////
  ///////////////////////////////////////////////////////////
  public String printInfo() {
    String str = "";
    Iterator<Account> iter = accountList.iterator();
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
      Account acc = accountList.get(accNo - 1);
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
      accountList.remove(accNo - 1);
      // set total
      setTotal();
    }
  }



  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////
  private boolean isValidateAccount(int accNo) {
    return (accNo > 0) && (accNo <= accountList.size()) ? true : false;
  }


}// Class AccountCommand END
