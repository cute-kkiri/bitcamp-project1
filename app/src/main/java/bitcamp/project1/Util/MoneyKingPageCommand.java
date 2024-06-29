package bitcamp.project1.Util;

import bitcamp.project1.vo.User;

import java.util.LinkedList;

import static bitcamp.project1.Util.UserCommand.userList;

public class MoneyKingPageCommand extends MenuCommand {

    public int getMaxUserNo(){
        // get userNo(0)'s Total
        int max = userList.getFirst().getTotal();
        int maxUserNo = 0;

        // userNo(0)'s Total vs userNo(1~...)'s Total
        for(int i = 1 ; i < userList.size(); i++) {
            if (userList.get(i).getTotal() > max) {
                max = userList.get(i).getTotal();
                maxUserNo = i;
            }
        }
        return maxUserNo;
    }


    // [Error] Check Duplication King
    public boolean checkDuplicateKing(int maxUserNo){
        int max = userList.get(maxUserNo).getTotal();
        for(int i = 0; i < userList.size(); i++) {
            if (i!=maxUserNo&&(max == userList.get(i).getTotal())) {
                System.out.println("이달의 최우수 거지가 없습니다...");
                return false;
            }
        }
        return true;
    }
}
