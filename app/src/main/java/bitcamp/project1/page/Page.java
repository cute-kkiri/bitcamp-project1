package bitcamp.project1.page;

public interface Page {
  void menu();

  String printTUI();

  void getUserScanner();

  int getScanner(int ans);

  void selectMenu(int ans);
}


