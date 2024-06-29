package bitcamp.project1;

import bitcamp.project1.Util.MenuCommand;
import bitcamp.project1.Util.UserCommand;
import bitcamp.project1.page.Menu;
//                                                  [page]
//                                                    |
//                                                    |
//                                                    |
//  [MenuCommand]          ->[UserCommand]         ->[UserPage]
//  -subMenuName             -(static)userList
//  -size
//                        ->[AccountCommand]      ->[AccountPage]
//                          -User
//
//                                                    |
//                                                    |
//                                                    |
//                                                  [Menu]
//
//                                                    |
//                                                    |
//                                                    |
//                                                  [Home]

//  <User Class>
// -accountList   ----------------------------><Account Class>
// -seqNo(prikey)(*Not implemented)            -account
// -ID                                         -description
// -PW
// -total

public class Home {
  public static void main(String[] args) {
    //DummyData
    DummyData.addUserDummy(UserCommand.userList);
    Menu m = new Menu();

    m.menu();
  }
}// Class Home END
