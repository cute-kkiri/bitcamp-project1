package bitcamp.project1.page;

public interface Page {
  void setSelectMenu();

  void menu();
  public void getScanner();

  int getScanner(int ans);

  // Set MenuNo(1,2...0) by UserScanner
  int setSubMenuNum(int ans);// Method getScanner END

  int setSubMenu(int ans);

  String printTUI();

  int setSubMenuNum();

  int setSubMenu();

  void selectMenu(int ans);

}

