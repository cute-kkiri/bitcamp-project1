package bitcamp.project1.page;

import bitcamp.project1.Util.MoneyKingCommand;
import bitcamp.project1.Util.UserCommand;
import bitcamp.project1.vo.User;

import static bitcamp.project1.page.UserPage.userList;
import static bitcamp.project1.vo.Menu.*;

public class MoneyKingPage extends MoneyKingCommand implements Page  {

    ///////////////////////////////////////////////////////////
    ///////////////////// private Instance ////////////////////
    ///////////////////////////////////////////////////////////
    private static MoneyKingPage kingpg;

    // setup UserCommand Instance
    public static MoneyKingPage getInstance() {

        if (kingpg == null) {
            kingpg = new MoneyKingPage();
        }

        return kingpg;
    }// Method getInstance END

    // reset UserCommand Instance
    public static void freeInstance() {
        kingpg = null;
    }// Method freeInstance END








    ///////////////////////////////////////////////////////////
    ////////////////////////// Method /////////////////////////
    ///////////////////////////////////////////////////////////

    @Override
    public void setSelectMenu() {

    }

    //main Menu
    @Override
    public void menu(){
        printKing();
    }

    @Override
    public void getScanner() {

    }

    //print King
    private void printKing(){


        System.out.print("이달의 거지왕은");
        loading(2000);
        printResult();
        loading(7000);
        System.out.print(setMenuSpaceTitle());
    }

    //print Result
    private void printResult(){
        UserCommand usercmd = UserCommand.getInstance();
        int maxUserNo = getMaxUserNo();

        // Check isValidateUser && DuplicateKing
        if(usercmd.isValidateUser(maxUserNo+1)&&checkDuplicateKing(maxUserNo)) {
            AccountPage accountpg = AccountPage.getInstance(userList.get(maxUserNo));

            System.out.print(printKingTUI(maxUserNo));
            System.out.print(accountpg.printInfo());
            System.out.print("\n\n");
        }
    }


    //print King TUI
    private String printKingTUI(int maxUserNo) {
        String str = "";
        String space="           ";

        User user = userList.get(maxUserNo);

        str += bold+brown;
        str += space+"      /\\         /\\         /\\\n";
        str += space+"     /  \\       /  \\       /  \\\n";
        str += space+"    /    \\     /    \\     /    \\\n";
        str += space+"   /      \\   /      \\   /      \\\n";
        str += space+"  /        \\ /        \\ /        \\\n";
        str += space+" /                                \\\n";
        str += space+"\\           이달의 거지왕          / \n";
        str += space+" \\            ";
        str += brightCyan;
        str += String.format("%8s",user.getID());
        str += reset;
        str += bold+brown;
        str += "            /\n";
        str += space+"  \\                              / \n";
        str += space+"    =============================\n";
        str += reset;


        str += bold+brightYellow;
        str += "。.。:+* ゜ ゜゜ *+:。.。:+* ゜ ゜゜ *+:。.。.。:+* ゜ ゜゜\n";
        str += reset;


        str += brightCyan;
        str += String.format("\n");
        str += "                ";
        str += String.format("%s", user.getID());
        str += reset;
        str += String.format("님 축하드립니다!!!\n", user.getID());
        str += "    ";
        str += String.format("이번달 총 지출 %d원으로 최우수 거지가 되셨습니다.\n", user.getTotal());
        str += String.format("\n");


        str += bold+brightYellow;
        str += "。.。:+* ゜ ゜゜ *+:。.。:+* ゜ ゜゜ *+:。.。.。:+* ゜ ゜゜\n";
        str += reset;
        str += String.format("\n");


        return str;
    }

    //loading (...)
    private void loading(long time){
        long sz = time/1000;
        try {
            for(int i=0;i<sz;i++) {
                System.out.print(".");
                Thread.sleep(time/sz);
            }
            System.out.print("\n");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
    }

    @Override
    public String printTUI() {
        return "";
    }


    @Override
    public int setSubMenuNum(int ans) {
        return 0;
    }


    @Override
    public void selectMenu(int ans) {

    }

}//Class MoneyKingPage END
