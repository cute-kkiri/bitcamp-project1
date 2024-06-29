# bitcamp-project1
SA030: test~~~

public class Main {
    public static void main(String[] args) {
        String king = "ChatGPT"; // 거지왕의 이름 예시

        String bold = "\033[1m"; // 굵은 글꼴
        String brightYellow = "\033[93m"; // 밝은 노란색
        String brightCyan = "\033[96m"; // 밝은 청록색
        String reset = "\033[0m"; // 리셋 (색상과 스타일 초기화)

        String str = "";
        str += bold + brightYellow;
        str += "      /\\         /\\         /\\\n";
        str += "     /  \\       /  \\       /  \\\n";
        str += "    /    \\     /    \\     /    \\\n";
        str += "   /      \\   /      \\   /      \\\n";
        str += "  /        \\ /        \\ /        \\\n";
        str += " /          \\          \\          \\\n";
        str += "/    " + brightCyan + "이달의 거지왕" + brightYellow + "       \\          \\\n";
        str += "\\           " + king + "         / \n";
        str += " \\______________________________/\n";
        str += reset;

        System.out.println(str);
    }
}
