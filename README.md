# bitcamp-project1
-팀명: 미래의 부자들
-팀원: 장혜정 이선아


##Home
메인
##DummyData
더미데이터


#page

##Page
<<interface>>
+void setSelectMenu()
+void menu()
+public void getScanner()
+int setSubMenuNum(int)
+String printTUI()
+void selectMenu(int)

##AccountPage
가계부 CRUD 페이지

##MenuPage
Main Menu 페이지
--------------------------------------
+String printKing()
+String printKingTUI()
+String printLine()
+String printBlock()
+void printListUserLiset()
--------------------------------------

##MoneyKingPage
거지왕 선별 페이지
--------------------------------------
--------------------------------------
+void printKing()
+void printResult()
+String printKingTUI(int)
+void loading(long)
--------------------------------------

##UserPage
거지 CRUD 페이지

#util

##AccountCommand
가계부 동작
--------------------------------------
-User user
--------------------------------------
+String printAccount()
+String printAccountOpp(int)
+void addAccount()
+String printInfo()
+void editAccount(int)
+void deleteAccount(int)
+isValidateAccount(int)
--------------------------------------

##MenuCommand
Main Menu 동작
--------------------------------------
-LinkedList<String> subMenuList
-int subMenuSize
-final int LINEWIDTH
--------------------------------------
+String printMenu(String)
+String setMenuTitle(String)
+String setMenuSelect()
+void printNumberFormatException()
+void printNumberLimitException()
+String setMenuSpaceTitle()
+String setMenuSpace()
+String setMenuLine()
+void printUserList()
+boolean isValidateScanner(int)
+int getUserScannerInt()
+String getUserScannerStr()
+String scanner()
--------------------------------------

##MoneyKingCommnad
거지왕 동작
--------------------------------------
--------------------------------------
+int getMaxUserNo()
+boolean checkDuplicateKing(int)
--------------------------------------

##UserCommand
거지 동작
--------------------------------------
-LinkedList<User> userList
--------------------------------------
+void addUser()
+String printUser()
+String printUserDetail()
+void editUser(int)
+void deleteUser(int)
+boolean isValidateUser(int)
--------------------------------------


#vo

##AccountCommand
가계부 Class
--------------------------------------
-int AccountCommand
-String description
--------------------------------------
--------------------------------------

##MenuCommand
Menu Class(color, bold ...)

##User
거지 Class
--------------------------------------
-LinkedList<Account> accountList
-static int seqNo
-String ID
-String PW
-int total
--------------------------------------
+void setTotal()
--------------------------------------