package bitcamp.project1.page;

import java.util.LinkedList;
import bitcamp.project1.Util.MenuCommand;
import bitcamp.project1.Util.UserCommand;
import bitcamp.project1.vo.User;
import static bitcamp.project1.page.UserPage.userList;

public class Menu extends MenuCommand {




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
    select = new LinkedList<String>();
    setSelectMenu();
  }



  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////
  // Run Default Menu
  public void menu() {
    System.out.print(printKing());
    System.out.print(printTUI());
    getUserScanner();
  }// Method menu END


  public String printKing(){
    String reset = "\033[0m";
    String bold = "\033[1m";
    String yellow = "\033[33m";
    String brightYellow = "\033[93m";
    String backgroundYellow = "\033[103m";
    String brown = "\033[0;33m";

    String str ="";


    str += setLine();
    str += setKing();
    str += setLine();

    return str;
  }

  public String setKing(){
    String str = "";
    String reset = "\033[0m";
    String bold = "\033[1m";
    String brightYellow = "\033[93m";

    String kingColor = bold+brightYellow;

    str += bold+brightYellow;

    str += String.format("  ___  ___ _____  _   _  _____ __   __     _   __ _____  _   _  _____      "           +"\n" );
    str += String.format("  |  \\/  ||  _  || \\ | ||  ___|\\ \\ / /    | | / /|_   _|| \\ | ||  __ \\     "         +"\n" );
    str += String.format("  | .  . || | | ||  \\| || |__   \\ V /     | |/ /   | |  |  \\| || |  \\/     "         +"\n" );
    str += String.format("  | |\\/| || | | || . ` ||  __|   \\ /      |    \\   | |  | . ` || | __      "          +"\n" );
    str += String.format("  | |  | |\\ \\_/ /| |\\  || |___   | |      | |\\  \\ _| |_ | |\\  || |_\\ \\     "      +"\n" );
    str += String.format("  \\_|  |_/ \\___/ \\_| \\_/\\____/   \\_/      \\_| \\_/ \\___/ \\_| \\_/ \\____/     "     +"\n" );

    str += String.format("                                      " + "\n");
    str += reset;

    return str;
  }

  public String setLine(){
    String reset = "\033[0m";
    String backgroundYellow = "\033[103m";
    String brown = "\033[0;33m";
    String str="";

    str += brown+backgroundYellow;
    str += String.format("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    str += reset;

    str += String.format("\n");

    return str;
  }

  public String setBlock(){
    String reset = "\033[0m";
    String backgroundYellow = "\033[103m";
    String brown = "\033[0;33m";
    String str="";

    str += brown+backgroundYellow;
    str += String.format("+");
    str += reset;

    return str;
  }



  // Print TUI
  // +------------------------------------------+
  // | [TITLE ] |
  // +------------------------------------------+
  //
  // [1] LogIn [2] Join [0] Exit
  // +------------------------------------------+
  private String printTUI() {
    String str = "";

//    str += printMenu("이달의 거지");
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
      case 1: // View Account
        printListUserLiset();
        menu();
        break;
      case 2: // View User List
        UserPage mainUser = UserPage.getInstance();
        mainUser.menu();
        menu();
        break;
      case 3: // View get Money King
        MoneyKingPage mainMoneyKing = MoneyKingPage.getInstance();
        mainMoneyKing.menu();




        System.out.print(printKing());
        System.out.print(printTUI());


        break;
      case 0: // Exit
//        System.out.printf("Exit\n");
        break;
      default:
        printNumberLimitException();
    }

  }// Method menu END








  public void printListUserLiset(){
    UserCommand usercmd = UserCommand.getInstance();
    int index = -1;

    for(;;) {
      printUserList();
      System.out.println("0을 입력하면 메인 메뉴로 돌아갑니다.");
      index = getUserScannerInt();

      if(usercmd.isValidateUser(index)){
        AccountPage mainAccount = new AccountPage(userList.get(index - 1));
        mainAccount.menu();
        return;
      }

      if(index == 0){
        return;
      }

      printNumberLimitException();

    }



  }

}// Class LogIn END
