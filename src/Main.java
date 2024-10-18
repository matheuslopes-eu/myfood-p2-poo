import easyaccept.EasyAccept;

public class Main {
    public static void main(String[] args) {
        args = new String[] {
                "br.ufal.ic.p2.myfood.Facade",
                "testes/us5_1.txt", "testes/us5_2.txt",
                "testes/us6_1.txt", "testes/us6_2.txt",
                "testes/us7_1.txt", "testes/us7_2.txt",
                "testes/us8_1.txt", "testes/us8_2.txt",
        };
        EasyAccept.main(args);
    }
}
