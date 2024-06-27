package page;

import java.util.LinkedList;
import Util.MenuCommand;

public class Menu extends MenuCommand {



  /************************************************/

  private void setSelectMenu() {
    addSelect("View Account");
    addSelect("User");
  }

  /************************************************/
  ///////////////////////////////////////////////////////////
  /////////////////////// Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  // set default
  public Menu() {
    select = new LinkedList<String>();
    setSelectMenu();
  }



  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////
  // Run Default Menu
  public void menu() {
    System.out.print(printTUI());
    getUserScanner();
  }// Method menu END


  // Print TUI
  // +------------------------------------------+
  // | [TITLE ] |
  // +------------------------------------------+
  //
  // [1] LogIn [2] Join [0] Exit
  // +------------------------------------------+
  private String printTUI() {
    String str = "";

    str += printMenu("TITLE");
    str += setMenuSelect();

    return str;
  }// Method printTUI END


  // Get User Scanner
  private void getUserScanner() {
    // default ans < 0
    int ans = -1;

    // until right answer
    while (!isValidateScanner(ans)) {
      try {
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


  // Run Menu by MenuNo(1,2...0)
  private void selectMenu(int ans) {

    switch (ans) {
      case 1: // Login(Test: Success)
        AccountPage main = new AccountPage();
        main.menu();
        return;
      case 2: // Join
        return;
      case 0: // Exit
        System.out.printf("Exit\n");
        return;
      default:
        printNumberLimitException();
    }

  }// Method menu END



}// Class LogIn END
