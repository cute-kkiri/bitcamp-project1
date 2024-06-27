package bitcamp.project1.page;


import java.util.LinkedList;

import bitcamp.project1.Util.AccountCommand;
import bitcamp.project1.vo.User;

public class AccountPage extends AccountCommand {
  static User user;
  /************************************************/

  private void setSelectMenu() {
    addSelect("Create");
    addSelect("Info");
    addSelect("Edit");
    addSelect("Delete");
  }

  /************************************************/

  // set default
  public AccountPage(User user) {
      select = new LinkedList<String>();
      this.user = user;
      setSelectMenu();
  }

  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////
  // Run Default Menu
  public void menu() {
    getUserScanner();
  }// Method menu END


  // Get User Scanner
  private void getUserScanner() {
    // default ans < 0
    int ans = -1;

    // until right answer
    // while (!isValidateScanner(ans)) {
    while (ans != 0) {
      try {
        // Print Menu List until AccountPage
        System.out.print(printTUI());
        ans = setMenuNum(ans);
        // if ans is not Number
      } catch (NumberFormatException e) {
        printNumberFormatException();
      }
    }

  }// Method getUserScanner END


  // Set MenuNo(1,2...0) by UserScanner
  private int setMenuNum(int ans) {
    ans = getUserScannerInt();
    selectMenu(ans);

    return ans;
  }// Method getScanner END


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
  private String printTUI() {
    String str = "";

    str += printMenu(user.getID());
    str += printAccount();
    str += setMenuSelect();

    return str;
  }// Method printMenu END


  // Run Menu by MenuNo(1,2...0)
  private void selectMenu(int ans) {

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
        System.out.printf("Exit\n");
        return;
      default:
        printNumberLimitException();
    }

  }// Method menu END

}// Class MainPage END

