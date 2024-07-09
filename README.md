##  bitcamp-project1

<blockquote>
  <ul>
    <li> 팀명: 미래의 부자들</li>
    <li> 팀원: 장혜정 이선아</li>
  </ul>
</blockquote>

## 주요 기능

- **가계부** : User별 가계부 CRUD 기능.
- **거지들** : User CRUD 기능.
- **거지왕** : 등록된 가계부들 중에서 가장 절약한 User를 이달의 거지왕으로 선정.

## App
<table>
  <tr>
    <th>Home</th>
  </tr>
  <tr>
    <td>메인</td>
  </tr>
</table>

<table>
  <tr>
    <th>DummyData</th>
  </tr>
  <tr>
    <td>더미데이터</td>
  </tr>
</table>

### page

<table>
  <tr>
    <th>
      Page
    </th>
  </tr>
  <tr>
    <td align="center">«interface»</td>
  </tr>
  <tr>
    <td>
        +void setSelectMenu()<br>
        +void menu()<br>
        +public void getScanner()<br>
        +int setSubMenuNum(int)<br>
        +String printTUI()<br>
        +void selectMenu(int)<br>
    </td>
  </tr>
</table>
<br>
<table>
  <tr>
    <th>AccountPage</th>
  </tr>
  <tr>
    <td>가계부 CRUD 페이지</td>
  </tr>
</table>
<br>
<table>
  <tr>
    <th>MenuPage</th>
  </tr>
  <tr>
    <td>
      Main Menu 페이지
    </td>
  </tr>
</table>

```
--------------------------------------
+String printKing()
+String printKingTUI()
+String printLine()
+String printBlock()
+void printListUserLiset()
--------------------------------------
```
<br>
<table>
  <tr>
    <th>MoneyKingPage</th>
  </tr>
  <tr>
    <td>거지왕 선별 페이지</td>
  </tr>
</table>

```
--------------------------------------
+void printKing()
+void printResult()
+String printKingTUI(int)
+void loading(long)
--------------------------------------
```
<br>
<table>
  <tr>
    <th>UserPage</th>
  </tr>
  <tr>
    <td>거지 CRUD 페이지</td>
  </tr>
</table>

### util

<table>
  <tr>
    <th>AccountCommand</th>
  </tr>
  <tr>
    <td>
      가계부 동작<br>
    </td>
  </tr>
</table>

```
--------------------------------------
-User user

+String printAccount()
+String printAccountOpp(int)
+void addAccount()
+String printInfo()
+void editAccount(int)
+void deleteAccount(int)
+isValidateAccount(int)
--------------------------------------
```
<br>
<table>
  <tr>
    <th>MenuCommand</th>
  </tr>
  <tr>
    <td>Main Menu 동작</td>
  </tr>
</table>

```
--------------------------------------
-LinkedList<String> subMenuList
-int subMenuSize
-final int LINEWIDTH

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
```
<br>
<table>
  <tr>
    <th>MoneyKingCommnad</th>
  </tr>
  <tr>
    <td>거지왕 동작</td>
  </tr>
</table>

```
--------------------------------------
+int getMaxUserNo()
+boolean checkDuplicateKing(int)
--------------------------------------
```
<br>
<table>
  <tr>
    <th>UserCommand</th>
  </tr>
  <tr>
    <td>거지 동작</td>
  </tr>
</table>

```
--------------------------------------
-LinkedList<User> userList

+void addUser()
+String printUser()
+String printUserDetail()
+void editUser(int)
+void deleteUser(int)
+boolean isValidateUser(int)
--------------------------------------
```
<br>

### vo

<table>
  <tr>
    <th>AccountCommand</th>
  </tr>
  <tr>
    <td>가계부 Class</td>
  </tr>
</table>

```
--------------------------------------
-int AccountCommand
-String description
--------------------------------------
```
<br>
<table>
  <tr>
    <th>MenuCommand</th>
  </tr>
  <tr>
    <td>Menu Class(color, bold ...)</td>
  </tr>
</table>
<br>
<table>
  <tr>
    <th>User</th>
  </tr>
  <tr>
    <td>거지 Class</td>
  </tr>
</table>

```
--------------------------------------<br>
-LinkedList<Account> accountList<br>
-static int seqNo<br>
-String ID<br>
-String PW<br>
-int total<br>
<br>
+void setTotal()<br>
--------------------------------------<br>
```
