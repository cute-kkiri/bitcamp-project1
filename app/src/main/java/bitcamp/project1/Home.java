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

    System.out.print(printPojectName());

    m.menu();
  }


  public static String printPojectName(){
    String str ="";

    str+="\n\n";
    str+="· ··÷¦÷·· ·· ··÷¦÷·· ·· ··÷¦÷·· ·\n";
    str+="     <<<< MONEY KING >>>>\n";
    str+="    💵 팀명: 미래의 부자들\n";
    str+="    💵 팀원: 장혜정 이선아\n";
    str+="· ··÷¦÷·· ·· ··÷¦÷·· ·· ··÷¦÷·· ·\n";
    str+="\n\n";

    return str;
  }
}// Class Home END
