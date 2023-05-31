import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a frase a ser criptografada: ");
        String frase = sc.nextLine();
        System.out.print("Digite a chave de criptografia: ");
        int chave = sc.nextInt();

        Map<Character, Character> tabelaHash = criarTabelaHash(chave);

        String fraseCriptografada = criptografar(frase, tabelaHash);

        System.out.println("Frase criptografada: " + fraseCriptografada);
    }

    public static Map<Character, Character> criarTabelaHash(int chave) {
        Map<Character, Character> tabelaHash = new HashMap<>();
        char primeiro = ' ';
        char ultimo = '~';

        for (char caractere = primeiro; caractere <= ultimo; caractere++) {
            char caractereCriptografado = (char) ((caractere - primeiro + chave) % (ultimo - primeiro + 1) + primeiro);
            tabelaHash.put(caractere, caractereCriptografado);
        }

        return tabelaHash;
    }

    public static String criptografar(String frase, Map<Character, Character> tabelaHash) {
        StringBuilder fraseCriptografada = new StringBuilder();

        for (char caractere : frase.toCharArray()) {
            char caractereCriptografado = tabelaHash.get(caractere);
            fraseCriptografada.append(caractereCriptografado);
        }

        return fraseCriptografada.toString();
    }
}