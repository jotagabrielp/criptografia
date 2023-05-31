
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a frase a ser criptografada: ");
        String frase = sc.nextLine();
        System.out.print("Digite a chave de criptografia: ");
        int chave = sc.nextInt();

        Map<Character, Character> tabelaHash = Cesar.criarTabelaHash(chave);

        String fraseCriptografada = Cesar.criptografar(frase, tabelaHash);

        System.out.println("Frase criptografada: " + fraseCriptografada);
    }
}