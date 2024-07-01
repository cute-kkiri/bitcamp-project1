package bitcamp.project1.page;


import java.util.LinkedList;

import bitcamp.project1.Util.AccountCommand;
import bitcamp.project1.vo.User;

public class AccountPage extends AccountCommand implements Page{
  /************************************************/
@Override
public void setSelectMenu() {
    addSelect("기록");
    addSelect("상세");
    addSelect("수정");
    addSelect("삭제");
  }

  /************************************************/

  // set default
  public AccountPage(User user) {
      subMenuList = new LinkedList<String>();
      super.user = user;
      setSelectMenu();
  }
  ///////////////////////////////////////////////////////////
  ///////////////////// private Instance ////////////////////
  ///////////////////////////////////////////////////////////
  private static AccountPage accpg;

  // setup UserCommand Instance
  public static AccountPage getInstance(User user) {

    if (accpg == null) {
      accpg = new AccountPage(user);
    }

    return accpg;
  }// Method getInstance END

  // reset UserCommand Instance
  public static void freeInstance() {
    accpg = null;
  }// Method freeInstance END








  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////
  // Run Default Menu
  @Override
  public void menu() {
    getScanner();
    System.out.print(setMenuSpaceTitle());
  }// Method menu END


  // Get User Scanner
  @Override
  public void getScanner() {
    // default ans < 0
    int ans = -1;

    // until right answer
    // while (!isValidateScanner(ans)) {
    while (ans != 0) {
      try {
        // Print Menu List until AccountPage
        System.out.print(printTUI());
        ans = this.setSubMenuNum(ans);
        // if ans is not Number
      } catch (NumberFormatException e) {
        printNumberFormatException();
      }
    }

  }// Method getUserScanner END

  @Override
  public int getScanner(int ans) {
    return 0;
  }


  // Set MenuNo(1,2...0) by UserScanner
  @Override
  public int setSubMenuNum(int ans) {
    ans = getUserScannerInt();
    selectMenu(ans);

    return ans;
  }// Method getScanner END

  @Override
  public int setSubMenu(int ans) {
    return 0;
  }


  // // Print TUI
  // +--------------------------------------------------+
  // | [OREO ] |
  // +--------------------------------------------------+
  // 1) -1400
  // 2) -300
  // 3) +1000
  // TOTAL: -700
  //
  // [1] Create [2] Info [3] Edit [4] Delete [0] Exit
  // +--------------------------------------------------+
  @Override
  public String printTUI() {
    String str = "";

    str += printMenu(user.getID());
    str += printAccount();
    str += setMenuSelect();

    return str;
  }// Method printMenu END

  @Override
  public int setSubMenuNum() {
    return 0;
  }

  @Override
  public int setSubMenu() {
    return 0;
  }


  // Run Menu by MenuNo(1,2...0)
  @Override
  public void selectMenu(int ans) {
    switch (ans) {
      case 1:// Create
        addAccount();
        return;
      case 2:// Info
        System.out.print(printInfo());
        return;
      case 3:// Edit
        System.out.printf("num?");
        editAccount(getUserScannerInt());
        return;
      case 4:// Delete
        System.out.printf("num?");
        deleteAccount(getUserScannerInt());
        return;
      case 0:// Exit
//        System.out.printf("Exit\n");
        return;
      default:
        printNumberLimitException();
    }

  }// Method menu END

}// Class MainPage END

