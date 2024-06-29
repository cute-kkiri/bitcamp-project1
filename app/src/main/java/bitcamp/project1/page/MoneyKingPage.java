package bitcamp.project1.page;

import bitcamp.project1.Util.MoneyKingPageCommand;
import bitcamp.project1.Util.UserCommand;
import bitcamp.project1.vo.User;

import static bitcamp.project1.page.UserPage.userList;

public class MoneyKingPage extends MoneyKingPageCommand implements Page  {
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





public void menu(){
        UserCommand usercmd = UserCommand.getInstance();
        int maxUserNo = getMaxUserNo();

        System.out.print("이달의 거지왕은");
        loading(2000);

        if(checkDuplicateKing(maxUserNo)&&usercmd.isValidateUser(maxUserNo+1)) {
            AccountPage accountpg = AccountPage.getInstance(userList.get(maxUserNo));

            System.out.print(printTUI(maxUserNo));
            System.out.print(accountpg.printInfo());
            System.out.print("\n\n");
        }
    loading(7000);
    System.out.print(setMenuSpaceTitle());
}

    public String printTUI(int maxUserNo) {
        String str = "";
        String reset = "\033[0m";
        String bold = "\033[1m";
        String brightYellow = "\033[93m";
        String brightCyan = "\033[96m";
        String brown = "\033[0;33m";

        String space="           ";
        String spaceName="    ";

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
        str += spaceName+spaceName+spaceName+spaceName;
        str += String.format("%s", user.getID());
        str += reset;
        str += String.format("님 축하드립니다!!!\n", user.getID());
        str += spaceName;
        str += String.format("이번달 총 지출 %d원으로 최우수 거지가 되셨습니다.\n", user.getTotal());
        str += String.format("\n");


        str += bold+brightYellow;
        str += "。.。:+* ゜ ゜゜ *+:。.。:+* ゜ ゜゜ *+:。.。.。:+* ゜ ゜゜\n";
        str += reset;
        str += String.format("\n");


        str += String.format("%s님의 이번달 지출 내역입니다. \n", user.getID());



        return str;
    }


    @Override
    public String printTUI() {
        return "";
    }

    public void loading(long time){
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
    public void getUserScanner() {

    }

    @Override
    public int getScanner(int ans) {
        return 0;
    }

    @Override
    public void selectMenu(int ans) {

    }

}
