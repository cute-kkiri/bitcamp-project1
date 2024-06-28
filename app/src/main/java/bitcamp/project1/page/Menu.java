package bitcamp.project1.page;

import java.util.Iterator;
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
    addSelect("️️✌️거지왕✌️");
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
  AccountPage mainAccount;;
  // Run Menu by MenuNo(1,2...0)
  private void selectMenu(int ans) {
    switch (ans) {
      case 1: // View Account(Test: Success)
        //Test: Waffle(seqNo:1)

        AccountPage mainAccount;

        printUser(mainUser);

        while (true) {
          System.out.println("0을 입력하면 메인 메뉴로 돌아갑니다.");
          int index = getUserScannerInt();

          if (index == 0) {
            menu();
            return;
          }

          if (index > 0 && index <= userList.size()) {
            testUser = userList.get(index - 1);
            mainAccount = new AccountPage(testUser);
            mainAccount.menu();
          } else {
            System.out.println("유효한 사용자 번호를 입력하세요.");
          }

          // 사용자 목록 다시 출력
          printUser(mainUser);
        }
      case 2: // User
        mainUser.menu();
            menu();
            return;
      case 3:
//        int max = 0;
        int max = 0;
        int maxUserNo = 0;
        for(int i = 0; i < userList.size(); i++) {
          if (userList.get(i).getTotal() > max) {
            max = userList.get(i).getTotal();
            maxUserNo = i;
          }
        }
        for(int i = 0; i < userList.size(); i++) {
          if (i!=maxUserNo&&(max == userList.get(i).getTotal())) {
            System.out.println("이달의 최우수 거지가 없습니다.");
            return;
          }
        }

        System.out.println("이달의 거지는");
        try {
          System.out.println("... ");
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          // e.printStackTrace();
        }
        String king = userList.get(maxUserNo).getID();
        System.out.println(printKing(king));
//        System.out.println("이달의 ✌\uFE0F거지왕✌\uFE0F은 " + userList.get(maxUserNo).getID() + "입니다~~!");
        System.out.println("");
        System.out.println("max: " + max);
        break;
      case 0: // Exit
        System.out.printf("Exit\n");
        return;
      default:
        printNumberLimitException();
    }

  }// Method menu END

  private String printKing(String king){
    String str = "";
    String reset = "\033[0m";
    String bold = "\033[1m";
    String yellow = "\033[33m";
    String brightYellow = "\033[93m";


    str += bold+brightYellow;
    str += String.format("        /\\     /\\     /\\\n" );
    str += String.format("       /  \\   /  \\   /  \\\n" );
    str += String.format("      /    \\ /    \\ /    \\\n" );
    str += String.format("     /      \\      \\      \\\n" );
    str += String.format("    /                        \\\n" );
    str += String.format("   /      이달의 거지왕       \\\n" );
    str += String.format("  /         %6s          \\\n", king );
    str += String.format(" /______________________________\\\n" );
    str += reset;

    return str;
  }


  private void printUser(UserPage user) {
    System.out.println("---------------");
    System.out.println("[거지 목록]");
    System.out.printf(user.printUser());
    System.out.println("---------------");
  }

}// Class LogIn END
