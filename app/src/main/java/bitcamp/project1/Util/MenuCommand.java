package Util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MenuCommand {
  protected static Scanner sc = new Scanner(System.in);

  protected static int size = 0;// select Menu Size
  protected static LinkedList<String> select; // select Menu Name List


  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////
  // print Menu
  protected static String printMenu(String title) {
    String str = "";

    // str += setMenuSpaceTitle();
    str += setMenuTitle(title);

    return str;
  }


  // print title
  // +------------------------------------------+
  // | [TITLE ] |
  // +------------------------------------------+
  protected static String setMenuTitle(String title) {
    String str = "";


    str += String.format(setMenuLine());
    str += String.format("|");
    str += setMenuSpace();
    str += String.format("[%-12s]", title);
    str += setMenuSpace();
    str += String.format("|");
    str += String.format("\n");
    str += String.format(setMenuLine());

    return str;
  }



  protected static String setMenuSelect() {
    String str = "";
    Iterator<String> selectList = select.iterator();

    str += String.format("\n");
    // print select title(title_line_size: 14)
    for (int selectNo = 1; selectList.hasNext(); selectNo++) {
      str += String.format("[%1d] %-5s%5s", selectNo, selectList.next(), " ");
    }
    // print Exit(default key 0)
    str += String.format("[0] %-5s%5s", "Exit", " ");
    str += String.format("\n");
    str += String.format(setMenuLine());

    return str;
  }


  // [ERROR message] if system.in doesn't get Number
  protected static void printNumberFormatException() {
    System.out.println("[ERROR] Please enter the number as a number");
  }


  // [ERROR message] if system.in get over Number
  protected static void printNumberLimitException() {
    System.out.printf("[ERROR] Please enter a valid key\n");
  }


  // Clean Console
  protected static String setMenuSpaceTitle() {
    String str = "";
    int SPACE = 6;

    for (int selectNo = 1; selectNo <= SPACE; selectNo++) {
      str += String.format("\n", " ");
    }

    return str;
  }


  // set Space(default (title_line_size: 14)*cnt/2)
  private static String setMenuSpace() {
    String str = "";
    int width = (14 * size) / 2;

    for (int selectNo = 1; selectNo <= width; selectNo++) {
      str += String.format("%s", " ");
    }

    return str;
  }


  // set Line(default title_line_size: 14)
  private static String setMenuLine() {
    String str = "";

    str += String.format("+");
    for (int selectNo = 0; selectNo <= size; selectNo++) {
      str += String.format("--------------");
    }
    str += String.format("+");
    str += String.format("\n");

    return str;
  }



  ///////////////////////////////////////////////////////////
  //////////////////////// Scanner //////////////////////////
  ///////////////////////////////////////////////////////////

  protected static boolean isValidateScanner(int ans) {
    return (ans >= 0) && (ans < size) ? true : false;
  }

  // (String)nextLine -> Integer
  protected static int getUserScannerInt() {
    System.out.printf("> ");
    return Integer.parseInt(scanner());
  }

  // (String)nextLine -> String
  protected static String getUserScannerStr() {
    System.out.printf("> ");
    return scanner();
  }

  // Scanner
  protected static String scanner() {
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

  public static int getSize() {
    return size;
  }

  public static LinkedList<String> getSelect() {
    return select;
  }

  public static void addSelect(String selectName) {
    select.add(selectName);
    size += 1;
  }

  public static void deleteSelect(int selectNo) {
    select.remove(selectNo);
    size -= 1;
  }


}// Class MenuCommand END
