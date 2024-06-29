package bitcamp.project1.Util;

import bitcamp.project1.page.UserPage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MenuCommand {
  protected Scanner sc = new Scanner(System.in);

  protected int size = 0;// select Menu Size
  private final int SIZE = 3;
  protected LinkedList<String> select; // select Menu Name List


  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////
  // print Menu
  protected String printMenu(String title) {
    String str = "";

    // str += setMenuSpaceTitle();
    str += setMenuTitle(title);

    return str;
  }


  // print title
  // +------------------------------------------+
  // | [TITLE ] |
  // +------------------------------------------+
  protected String setMenuTitle(String title) {
    String reset = "\033[0m";
    String bold = "\033[1m";
    String yellow = "\033[33m";
    String brightYellow = "\033[93m";
    String backgroundYellow = "\033[103m";
    String brown = "\033[0;38;2;139;69;19m";
    String str = "";

    str += String.format(setMenuLine());
    str += String.format("|");
    str += setMenuSpace();
    str += String.format("[%-16s]", title);
    str += setMenuSpace();
    str += String.format("|");
    str += String.format("\n");
    str += String.format(setMenuLine());

    return str;
  }



  protected String setMenuSelect() {
    String str = "";
    Iterator<String> selectList = select.iterator();

    str += String.format("\n");
    // print select title(title_line_size: 14)
    for (int selectNo = 1; selectList.hasNext(); selectNo++) {
      str += String.format("[%1d] %-5s%5s", selectNo, selectList.next(), " ");
    }
    // print Exit(default key 0)
    str += String.format("\033[91m[0] %-5s%5s", "종료\033[0m", " ");
    str += String.format("\n");
    str += String.format(setMenuLine());

    return str;
  }


  // [ERROR message] if system.in doesn't get Number
  protected void printNumberFormatException() {
    System.out.println("[ERROR] Please enter the number as a number");
  }


  // [ERROR message] if system.in get over Number
  protected void printNumberLimitException() {
    System.out.printf("[ERROR] Please enter a valid key\n");
  }


  // Clean Console
  protected String setMenuSpaceTitle() {
    String str = "";
    int SPACE = 50;

    for (int selectNo = 1; selectNo <= SPACE; selectNo++) {
      str += String.format("\n", " ");
    }

    return str;
  }


  // set Space(default (title_line_size: 14)*cnt/2)
  private String setMenuSpace() {
    String str = "";
    int width = (18 * SIZE) / 2;

    for (int selectNo = 1; selectNo <= width; selectNo++) {
      str += String.format("%s", " ");
    }

    return str;
  }


  // set Line(default title_line_size: 18)
  private String setMenuLine() {
    String str = "";

    str += String.format("+");
    for (int selectNo = 0; selectNo <= SIZE; selectNo++) {
      str += String.format("------------------");
    }
    str += String.format("+");
    str += String.format("\n");

    return str;
  }


  protected void printUserList() {
    UserPage userpage = (UserPage) UserPage.getInstance();
    System.out.print(setMenuLine());
    System.out.println("[거지 목록]");
    System.out.printf(userpage.printUser());
    System.out.print(setMenuLine());
  }


  ///////////////////////////////////////////////////////////
  //////////////////////// Scanner //////////////////////////
  ///////////////////////////////////////////////////////////

  protected boolean isValidateScanner(int ans) {
    return (ans >= 0) && (ans < size) ? true : false;
  }

  // (String)nextLine -> Integer
  protected int getUserScannerInt() {
    System.out.printf("> ");
    return Integer.parseInt(scanner());
  }

  // (String)nextLine -> String
  protected String getUserScannerStr() {
    System.out.printf("> ");
    return scanner();
  }

  // Scanner
  protected String scanner() {
    return sc.nextLine();
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

  public int getSize() {
    return size;
  }

  public LinkedList<String> getSelect() {
    return select;
  }

  public void addSelect(String selectName) {
    select.add(selectName);
    size += 1;
  }

  public void deleteSelect(int selectNo) {
    select.remove(selectNo);
    size -= 1;
  }


}// Class MenuCommand END
