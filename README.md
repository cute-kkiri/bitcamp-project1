# bitcamp-project1
SA030: test~~~

public class Main {
    public static void main(String[] args) {
        String king = "ChatGPT"; // 거지왕의 이름 예시

        String bold = "\033[1m"; // 굵은 글꼴
        String brightYellow = "\033[93m"; // 밝은 노란색
        String brightCyan = "\033[96m"; // 밝은 청록색
        String brightMagenta = "\033[95m"; // 밝은 마젠타색
        String reset = "\033[0m"; // 리셋 (색상과 스타일 초기화)

        // 왕관 모양의 ASCII 아트
        String[] crown = {
            "       /\\         /\\         /\\",
            "     /    \\     /    \\     /    \\",
            "   /        \\ /        \\ /        \\",
            " /     " + brightMagenta + "이달의 거지왕" + brightYellow + "       \\          \\",
            "/          " + king + "           \\",
            "\\______________________________/"
        };

        // 그림자 효과를 추가하여 입체감을 표현
        String[] shadow = {
            "       /\\         /\\         /\\",
            "     /    \\     /    \\     /    \\",
            "   /        \\ /        \\ /        \\",
            "/          " + brightMagenta + "이달의 거지왕" + brightYellow + "       \\          \\",
            "\\          " + king + "           /",
            " \\______________________________/"
        };

        // 그림자 효과를 추가하여 입체감을 표현
        String str = "";
        for (int i = 0; i < crown.length; i++) {
            str += bold + brightYellow + crown[i] + "\n";
            if (i < crown.length - 1) {
                str += " ";

                // 그림자 부분을 회색으로 표시
                for (int j = 0; j < i; j++) {
                    str += "\u001B[2m"; // 회색
                    str += shadow[i].charAt(j) == ' ' ? '░' : shadow[i].charAt(j); // 그림자 효과
                }
                str += reset + "\n";
            }
        }

        System.out.println(str);
    }
}
