package bitcamp.project1.page;

import java.util.LinkedList;

import bitcamp.project1.DummyData;
import bitcamp.project1.Util.MenuCommand;
import bitcamp.project1.Util.UserCommand;
import bitcamp.project1.vo.Account;
import bitcamp.project1.vo.User;
import org.checkerframework.checker.units.qual.A;

public class Menu extends MenuCommand {

  static LinkedList<User> userList = new LinkedList<User>();



  /************************************************/

  private void setSelectMenu() {
    addSelect("가계부");
    addSelect("거지들");
  }

  /************************************************/
  ///////////////////////////////////////////////////////////
  /////////////////////// Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  // set default
  public Menu() {
    DummyData.addUserDummy(userList);

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

    str += printMenu("이달의 거지");
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

  UserPage mainUser = new UserPage(userList);
  User testUser;
  AccountPage mainAccount;
  // Run Menu by MenuNo(1,2...0)
  private void selectMenu(int ans) {
    switch (ans) {
      case 1: // View Account(Test: Success)
        //Test: Waffle(seqNo:1)
        System.out.println(mainUser.printUser());

        while(true) {
          int index = getUserScannerInt();

          if (index == 0) {
            break;
          }

          testUser = userList.get(index-1);
          mainAccount = new AccountPage(testUser);
          mainAccount.menu();
        }

        return;
      case 2: // User
//        UserPage mainUser = new UserPage(userList);
        mainUser.menu();
        return;
      case 0: // Exit
        System.out.printf("Exit\n");
        return;
      default:
        printNumberLimitException();
    }

  }// Method menu END

}// Class LogIn END
