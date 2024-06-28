package bitcamp.project1;

import bitcamp.project1.Util.MenuCommand;
import bitcamp.project1.page.Menu;

//  [page]
//    |
//    | (*Not implemented)
//    |
//  [MenuCommand]          ->[UserCommand]         ->[UserPage]
//  -subMenuName             -userList
//  -size
//                        ->[AccountCommand]      ->[AccountPage]
//                          -User
//                          -total
//                                                    |
//                                                    |
//                                                    |
//                                                  [Menu]
//                                                  -(>>new static UserList<<)
//                                                    |
//                                                    |
//                                                    |
//                                                  [Home]

//  <User Class>
// -accountList   ----------------------------><Account Class>
// -seqNo(prikey)(*Not implemented)            -account
// -ID                                         -description
// -PW

public class Home {
  public static void main(String[] args) {
    Menu m = new Menu();
    m.menu();
  }
}// Class Home END
