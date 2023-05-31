import java.util.HashMap;
import java.util.Map;
public class Cesar {
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