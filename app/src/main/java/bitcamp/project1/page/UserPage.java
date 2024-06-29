package bitcamp.project1.page;

import bitcamp.project1.Util.UserCommand;

import java.util.LinkedList;

public class UserPage extends UserCommand implements Page {
    /************************************************/

    private void setSelectMenu() {
        addSelect("추가");
        addSelect("상세");
        addSelect("수정");
        addSelect("삭제");
    }

    /************************************************/
    ///////////////////////////////////////////////////////////
    ///////////////////// private Instance ////////////////////
    ///////////////////////////////////////////////////////////
    private static UserPage userpg;

    // setup UserCommand Instance
    public static UserPage getInstance() {

        if (userpg == null) {
            userpg = new UserPage();
        }

        return userpg;
    }// Method getInstance END

    // reset UserCommand Instance
    public static void freeInstance() {
        userpg = null;
    }// Method freeInstance END



    ///////////////////////////////////////////////////////////
    /////////////////////// Constructor ///////////////////////
    ///////////////////////////////////////////////////////////
    // set default
    public UserPage() {
        select = new LinkedList<String>();
        setSelectMenu();
    }



    ///////////////////////////////////////////////////////////
    ////////////////////////// Method /////////////////////////
    ///////////////////////////////////////////////////////////
    // Run Default Menu
    public void menu() {
        getUserScanner();
        System.out.print(setMenuSpaceTitle());
    }// Method menu END


    // Get User Scanner
    public void getUserScanner() {
        // default ans < 0
        int ans = -1;

        // until right answer
//        while (ans != 0) {
         while (!isValidateScanner(ans)) {
            try {
                if(ans == 0){
                    return;
                }
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

        str += printMenu("The future kings");
        str += printUser();
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
