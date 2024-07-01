package bitcamp.project1.page;

public interface Page {
  void setSelectMenu();

  void menu();
  public void getScanner();


  // Set MenuNo(1,2...0) by UserScanner
  int setSubMenuNum(int ans);// Method getScanner END

  String printTUI();


  void selectMenu(int ans);

}

