package bitcamp.project1.Util;

import java.util.Iterator;
import java.util.LinkedList;

import bitcamp.project1.vo.Account;
import bitcamp.project1.vo.User;

public class UserCommand extends MenuCommand{
  static LinkedList<User> userList;
  ///////////////////////////////////////////////////////////
  ///////////////////// private Instance ////////////////////
  ///////////////////////////////////////////////////////////
  private static UserCommand userCmd;

  // setup UserCommand Instance
  public static UserCommand getInstance(LinkedList<User> userList) {

    if (userCmd == null) {
      userCmd = new UserCommand(userList);
    }

    return userCmd;
  }// Method getInstance END

  // reset UserCommand Instance
  public static void freeInstance() {
    userCmd = null;
  }// Method freeInstance END

  public UserCommand(){

  }


  public UserCommand(LinkedList<User> userList){
    this.userList = userList;
  }


  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////
  public void addUser(){
    User newUser = new User();

    // set account
    System.out.printf("ID?");
    newUser.setID(MenuCommand.getUserScannerStr());

    // set description
    System.out.printf("PW?");
    newUser.setPW(MenuCommand.getUserScannerStr());

    newUser.setNextSeqNo();
    // add list
    this.userList.add(newUser);
  }

  public String printUser(){
    String str = "";
    Iterator<User> iter = this.userList.iterator();
    User currentUser = null;

    for (int selectNo = 1; iter.hasNext(); selectNo++) {
      currentUser = iter.next();
      // No
      str += String.format("[%d] ", selectNo);
      // account
      str += String.format("%-10s ", currentUser.getID());
      str += String.format("\n");
    }

    return str;
  }

  public void editUser(int userNo){
    if (isValidateUser(userNo)) {
      User user = this.userList.get(userNo - 1);
      // set account
      System.out.printf("ID?");
      user.setID(MenuCommand.getUserScannerStr());
      // set description
      System.out.printf("PW?");
      user.setPW(MenuCommand.getUserScannerStr());
    }
  }


  public void deleteUser(int userNo){
    if (isValidateUser(userNo)) {
      // remove account
      this.userList.remove(userNo - 1);
    }
  }


  private boolean isValidateUser(int userNo) {
    return (userNo > 0) && (userNo <= this.userList.size()) ? true : false;
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
  public LinkedList<User> getUserList() {
    return this.userList;
  }

  public void setUserList(LinkedList<User> userList) {
    this.userList = userList;
  }




}// Class UserCommand END
