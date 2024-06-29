package bitcamp.project1;

import bitcamp.project1.Util.UserCommand;
import bitcamp.project1.vo.Account;
import bitcamp.project1.vo.User;

import java.util.LinkedList;

public class DummyData {


    ///////////////////////////////////////////////////////////
    ////////////////////// Dummy Account //////////////////////
    ///////////////////////////////////////////////////////////
    private static void addAccountDummy(User user) {
        LinkedList<Account> accountList = user.getAccountList();

        Account newAcc0 = new Account();
        newAcc0.setAccount(-1400);
        newAcc0.setDescription("Subway, .,");
        accountList.add(newAcc0);

        Account newAcc1 = new Account();
        newAcc1.setAccount(-300);
        newAcc1.setDescription("Bus/. .");
        accountList.add(newAcc1);


        Account newAcc2 = new Account();
        newAcc2.setAccount(1000);
        newAcc2.setDescription("get. .");
        accountList.add(newAcc2);

        user.setAccountList(accountList);
    }


    ///////////////////////////////////////////////////////////
    ////////////////////// Dummy Account //////////////////////
    ///////////////////////////////////////////////////////////
    public static void addUserDummy(LinkedList<User> userList) {

        User newUser0 = new User();
        newUser0.setID("Cookie");
        newUser0.setPW("1234");
        addAccountDummy(newUser0);

        Account newAcc = new Account();
        newAcc.setAccount(500);
        newAcc.setDescription("Cookie");
        newUser0.addAccount(newAcc);
        newUser0.setTotal();


        userList.add(newUser0);







        User newUser1 = new User();
        newUser1.setID("Waffle");
        newUser1.setPW("5678");
        addAccountDummy(newUser1);
        userList.add(newUser1);


        User newUser2 = new User();
        newUser2.setID("Pudding");
        newUser2.setPW("1234");
        addAccountDummy(newUser2);
        userList.add(newUser2);


        User newUser3 = new User();
        newUser3.setID("Cake");
        newUser3.setPW("5678");
        addAccountDummy(newUser3);
        userList.add(newUser3);


        User newUser4 = new User();
        newUser4.setID("Candy");
        newUser4.setPW("1234");
        addAccountDummy(newUser4);
        userList.add(newUser4);

    }
}
