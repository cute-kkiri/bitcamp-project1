##  bitcamp-project1
-팀명: 미래의 부자들<br>
-팀원: 장혜정 이선아


## Home

메인

## DummyData

더미데이터


## page

## Page

\<\<interface\>\><br>
+void setSelectMenu()<br>
+void menu()<br>
+public void getScanner()<br>
+int setSubMenuNum(int)<br>
+String printTUI()<br>
+void selectMenu(int)<br>

## AccountPage

가계부 CRUD 페이지

## MenuPage

**Main Menu 페이지**<br>
--------------------------------------<br>
+String printKing()<br>
+String printKingTUI()<br>
+String printLine()<br>
+String printBlock()<br>
+void printListUserLiset()<br>
--------------------------------------<br>

## MoneyKingPage

**거지왕 선별 페이지**<br>
--------------------------------------<br>
+void printKing()<br>
+void printResult()<br>
+String printKingTUI(int)<br>
+void loading(long)<br>
--------------------------------------<br>

## UserPage

거지 CRUD 페이지

## util

## AccountCommand

**가계부 동작**<br>
--------------------------------------<br>
-User user<br>
<br>
+String printAccount()<br>
+String printAccountOpp(int)<br>
+void addAccount()<br>
+String printInfo()<br>
+void editAccount(int)<br>
+void deleteAccount(int)<br>
+isValidateAccount(int)<br>
--------------------------------------<br>

## MenuCommand

**Main Menu 동작**<br>
--------------------------------------<br>
-LinkedList<String> subMenuList<br>
-int subMenuSize<br>
-final int LINEWIDTH<br>
<br>
+String printMenu(String)<br>
+String setMenuTitle(String)<br>
+String setMenuSelect()<br>
+void printNumberFormatException()<br>
+void printNumberLimitException()<br>
+String setMenuSpaceTitle()<br>
+String setMenuSpace()<br>
+String setMenuLine()<br>
+void printUserList()<br>
+boolean isValidateScanner(int)<br>
+int getUserScannerInt()<br>
+String getUserScannerStr()<br>
+String scanner()<br>
--------------------------------------<br>

## MoneyKingCommnad

**거지왕 동작**<br>
--------------------------------------<br>
+int getMaxUserNo()<br>
+boolean checkDuplicateKing(int)<br>
--------------------------------------<br>

## UserCommand

**거지 동작**<br>
--------------------------------------<br>
-LinkedList<User> userList<br>
<br>
+void addUser()<br>
+String printUser()<br>
+String printUserDetail()<br>
+void editUser(int)<br>
+void deleteUser(int)<br>
+boolean isValidateUser(int)<br>
--------------------------------------<br>


## vo

## AccountCommand

**가계부 Class**<br>
--------------------------------------<br>
-int AccountCommand<br>
-String description<br>
--------------------------------------<br>

## MenuCommand

Menu Class(color, bold ...)

## User

**거지 Class**<br>
--------------------------------------<br>
-LinkedList<Account> accountList<br>
-static int seqNo<br>
-String ID<br>
-String PW<br>
-int total<br>
<br>
+void setTotal()<br>
--------------------------------------<br>
