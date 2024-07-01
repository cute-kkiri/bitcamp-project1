package bitcamp.project1.Util;

import java.util.Iterator;
import java.util.LinkedList;
import bitcamp.project1.vo.Account;
import bitcamp.project1.vo.User;

import static bitcamp.project1.vo.Menu.brightCyan;
import static bitcamp.project1.vo.Menu.reset;

public class AccountCommand extends MenuCommand{
  // Test: User1(OREO)'s Account //////////////////////////////////////
  protected User user;

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
    user.setTotal();

    String str = "";
    Iterator<Account> iter = user.getAccountList().iterator();
    Account crntAccount = null;
    int num;
    int total = user.getTotal();

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

    str += brightCyan;
    str += String.format(" TOTAL: %s\n", printAccountOpp(total));
    str += reset;
    return str;
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
    System.out.printf("금액?");
    newAcc.setAccount(getUserScannerInt());

    // set description
    System.out.printf("설명?");
    newAcc.setDescription(getUserScannerStr());

    // add list
    user.getAccountList().add(newAcc);
    user.setTotal();
  }



  ///////////////////////////////////////////////////////////
  ///////////////////////// 2. Info /////////////////////////
  ///////////////////////////////////////////////////////////
  public String printInfo() {
    String str = "";
    Iterator<Account> iter = user.getAccountList().iterator();
    Account currentAccount = null;
    
    str += "\n\n";
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
    str += "\n\n";

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
      acc.setAccount(getUserScannerInt());
      // set description
      System.out.printf("Description?");
      acc.setDescription(getUserScannerStr());
      // set total
      user.setTotal();
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
      user.setTotal();
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LinkedList<Account> getAccountList() {
    return user.getAccountList();
  }

  public void setAccountList(LinkedList<Account> accountList) {
    user.setAccountList(accountList);
  }
}// Class AccountCommand END
