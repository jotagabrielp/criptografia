import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Recebe a frase e a chave criptográfica
        System.out.print("Digite a frase: ");
        String frase = scanner.nextLine();
        System.out.print("Digite a chave criptográfica (um número inteiro): ");
        int chave = scanner.nextInt();

        // Cria a tabela hash com o mapeamento das letras
        Map<Character, Character> tabelaHash = criarTabelaHash(chave);

        // Criptografa a frase
        String fraseCriptografada = criptografar(frase, tabelaHash);

        // Imprime a frase criptografada
        System.out.println("Frase criptografada: " + fraseCriptografada);

        scanner.close();
    }

    public static Map<Character, Character> criarTabelaHash(int chave) {
        Map<Character, Character> tabelaHash = new HashMap<>();
        char primeiro = ' ';
        char ultimo = '~';

        for (char caractere = ' '; caractere <= '~'; caractere++) {
            char caractereCriptografado = (char) ((caractere - primeiro + chave) % (ultimo - primeiro + 1) + primeiro);
            tabelaHash.put(caractere, caractereCriptografado);
        }

        return tabelaHash;
    }

    public static String criptografar(String frase, Map<Character, Character> tabelaHash) {
        StringBuilder fraseCriptografada = new StringBuilder();

        for (char caractere : frase.toCharArray()) {
            char caractereCriptografado = tabelaHash.getOrDefault(caractere, caractere);
            fraseCriptografada.append(caractereCriptografado);
        }

        return fraseCriptografada.toString();
    }
}