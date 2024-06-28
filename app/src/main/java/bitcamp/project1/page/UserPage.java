package bitcamp.project1.page;

import bitcamp.project1.Util.AccountCommand;
import bitcamp.project1.Util.MenuCommand;
import bitcamp.project1.Util.UserCommand;
import bitcamp.project1.vo.User;

import java.util.LinkedList;

public class UserPage extends UserCommand implements Page {
    static LinkedList<User> userList;
    /************************************************/

    private void setSelectMenu() {
        addSelect("Create");
        addSelect("Info");
        addSelect("Edit");
        addSelect("Delete");
    }

    /************************************************/

    // set default
    public UserPage(LinkedList<User> userList) {
        select = new LinkedList<String>();
        this.userList = userList;
        setSelectMenu();

        UserCommand uc = UserCommand.getInstance(this.userList);
    }
    ///////////////////////////////////////////////////////////
    ////////////////////////// Method /////////////////////////
    ///////////////////////////////////////////////////////////
    // Run Default Menu
    public void menu() {
        getUserScanner();
    }// Method menu END


    // Get User Scanner
    public void getUserScanner() {
        // default ans < 0
        int ans = -1;

        // until right answer
        // while (!isValidateScanner(ans)) {
        while (ans != 0) {
            try {
                // Print Menu List until AccountPage
                System.out.print(printTUI());
                ans = setMenuNum(ans);
                // if ans is not Number
            } catch (NumberFormatException e) {
                printNumberFormatException();
            }
        }

    }// Method getUserScanner END

    @Override
    public int getScanner(int ans) {
        return 0;
    }


    // Set MenuNo(1,2...0) by UserScanner
    private int setMenuNum(int ans) {
        ans = getUserScannerInt();
        selectMenu(ans);

        return ans;
    }// Method getScanner END


// // Print TUI
//    +--------------------------------------------------------------------------------------------------+
//    |                                          [USER        ]                                          |
//    +--------------------------------------------------------------------------------------------------+
//
//     [1] Create     [2] Info      [3] Edit      [4] Delete     [0] Exit
//   +--------------------------------------------------------------------------------------------------+
    public String printTUI() {
        String str = "";

        str += printMenu("USER");
        str += setMenuSelect();

        return str;
    }// Method printMenu END


    // Run Menu by MenuNo(1,2...0)
    public void selectMenu(int ans) {

        switch (ans) {
            case 1:// Create
                addUser();
                return;
            case 2:// Info
                System.out.print(printUser());
                return;
            case 3:// Edit
                System.out.printf("num?");
                editUser(getUserScannerInt());
                return;
            case 4:// Delete
                System.out.printf("num?");
                deleteUser(getUserScannerInt());
                return;
            case 0:// Exit
                System.out.printf("Exit\n");
                return;
            default:
                printNumberLimitException();
        }

    }// Method menu END
}//Class UserPage END
