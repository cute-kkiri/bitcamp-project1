package page;


import java.util.LinkedList;
import Util.MenuCommand;
import vo.User;

public class AccountPage extends MenuCommand {



  /************************************************/

  private void setSelectMenu() {
    addSelect("Create");
    addSelect("Info");
    addSelect("Edit");
    addSelect("Delete");
  }

  /************************************************/

  // set default
  AccountPage() {
    select = new LinkedList<String>();
    setSelectMenu();
  }

  // Test: User1(OREO) //////////////////////////////////////
  static User user = new User();


  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////
  // Run Default Menu
  public void menu() {
    // Test: Input DummyData ////////////////////////////////
    user.ac.addAccountDummy();
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
    str += user.ac.printAccount();
    str += setMenuSelect();

    return str;
  }// Method printMenu END


  // Run Menu by MenuNo(1,2...0)
  private void selectMenu(int ans) {

    switch (ans) {
      case 1:// Create
        user.ac.addAccount();
        return;
      case 2:// Info
        System.out.print(user.ac.printInfo());
        return;
      case 3:// Edit
        System.out.printf("num?");
        user.ac.editAccount(getUserScannerInt());
        return;
      case 4:// Delete
        System.out.printf("num?");
        user.ac.deleteAccount(getUserScannerInt());
        return;
      case 0:// Exit
        System.out.printf("Exit\n");
        return;
      default:
        printNumberLimitException();
    }

  }// Method menu END

}// Class MainPage END

