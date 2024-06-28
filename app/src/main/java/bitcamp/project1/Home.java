package bitcamp.project1;

import bitcamp.project1.Util.AccountCommand;
import bitcamp.project1.Util.MenuCommand;
import bitcamp.project1.Util.UserCommand;
import bitcamp.project1.page.Menu;
import bitcamp.project1.vo.Account;
import bitcamp.project1.vo.User;

import java.util.LinkedList;

public class Home extends MenuCommand {
//  [page]
//    |
//    | (*Not implemented)
//    |
//  [MenuCommand]         ->[UserCommand]         ->[UserPage]
//  -subMenuName            -userList
//  -menuSize)
//                        ->[AccountCommand]      ->[AccountPage]
//                          -User
//                          -total
//                                                    |
//                                                    |
//                                                    |
//                                                  [Menu]
//                                                  -(>>new UserList<<)


//  <User Class>
// -accountList   ----------------------------><Account Class>
// -seqNo(prikey)(*Not implemented)            -account
// -ID                                         -description
// -PW





  public static void main(String[] args) {



    Menu m = new Menu();
    m.menu();
    
  }


}// Class Home END
