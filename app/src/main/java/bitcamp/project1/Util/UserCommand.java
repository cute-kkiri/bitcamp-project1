package bitcamp.project1.Util;

import java.util.Iterator;
import java.util.LinkedList;

import bitcamp.project1.vo.User;

import static bitcamp.project1.vo.Menu.*;

public class UserCommand extends MenuCommand{
  public static LinkedList<User> userList = new LinkedList<User>();

  ///////////////////////////////////////////////////////////
  ///////////////////// private Instance ////////////////////
  ///////////////////////////////////////////////////////////
  private static UserCommand userCmd;

  // setup UserCommand Instance
  public static UserCommand getInstance() {

    if (userCmd == null) {
      userCmd = new UserCommand();
    }

    return userCmd;
  }// Method getInstance END

  // reset UserCommand Instance
  public static void freeInstance() {
    userCmd = null;
  }// Method freeInstance END







  ///////////////////////////////////////////////////////////
  /////////////////////// Constructor ///////////////////////
  ///////////////////////////////////////////////////////////
  public UserCommand(){
  }









  ///////////////////////////////////////////////////////////
  ////////////////////////// Method /////////////////////////
  ///////////////////////////////////////////////////////////


  ///////////////////////////////////////////////////////////
  //////////////////////// 1. Create ////////////////////////
  ///////////////////////////////////////////////////////////
  public void addUser(){
    User newUser = new User();

    // set account
    System.out.printf("ID?");
    newUser.setID(getUserScannerStr());

    // set description
    System.out.printf("PW?");
    newUser.setPW(getUserScannerStr());

    newUser.setNextSeqNo();
    // add list
    userList.add(newUser);
  }





  ///////////////////////////////////////////////////////////
  ///////////////////////// 2. Info /////////////////////////
  ///////////////////////////////////////////////////////////
  public String printUser(){
    String str = "";
    Iterator<User> iter = userList.iterator();
    User currentUser = null;

    for (int selectNo = 1; iter.hasNext(); selectNo++) {
      currentUser = iter.next();
      // No
      str += String.format("[%d] ", selectNo);
      // ID
      str += String.format("%-15s ", currentUser.getID());
      str += String.format("\n");
    }

    return str;
  }



  public String printUserDetail(){
    String str = "";
    Iterator<User> iter = userList.iterator();
    User currentUser = null;

    str += "\n\n";
    for (int selectNo = 1; iter.hasNext(); selectNo++) {
      currentUser = iter.next();
      // No
      str += String.format("[%d] ", selectNo);
      // ID
      str += String.format("%-15s ", currentUser.getID());
      //total
      str += brightCyan;
      str += String.format("total: %-15s ", currentUser.getTotal());
      str += String.format("\n");
      str += reset;
    }
    str += "\n\n";

    return str;
  }








  ///////////////////////////////////////////////////////////
  ///////////////////////// 3. Edit /////////////////////////
  ///////////////////////////////////////////////////////////
  public void editUser(int userNo){
    if (isValidateUser(userNo)) {
      User user = this.userList.get(userNo - 1);
      // set account
      System.out.printf("이름?");
      user.setID(getUserScannerStr());
      // set description
      System.out.printf("비밀번호?");
      user.setPW(getUserScannerStr());
    }
  }





  ///////////////////////////////////////////////////////////
  //////////////////////// 4. delete ////////////////////////
  ///////////////////////////////////////////////////////////
  public void deleteUser(int userNo){
    if (isValidateUser(userNo)) {
      // remove account
      this.userList.remove(userNo - 1);
    }
  }


  public boolean isValidateUser(int userNo) {
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
