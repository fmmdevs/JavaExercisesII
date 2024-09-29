package devs.fmm.datastructuresandalgorithms.sets;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class GetAllWordsInAWord {

    private static final String WORD_LIST_URL = "https://raw.githubusercontent.com/ullenboom/english-words/master/words_alpha.txt";

    private static Collection<String> readWordsFromUrl() throws IOException {
        // Creating object URL from String with the URL
        URL url = URI.create(WORD_LIST_URL).toURL(); // 370.000 words

        // Creating a HashSet of 400000 elements
        Collection<String> words = HashSet.newHashSet(400_000);

        try (InputStream is = url.openStream()) {
            new Scanner(is).forEachRemaining(s -> words.add(s.toLowerCase()));
        }

        return words;
    }

    private static Collection<String> readWordsFromLocalTxt() throws IOException {
        // Creating object URL from String with the URL
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("englishWords.txt")));
        String currentLine;

        // Creating a HashSet of 400000 elements
        Collection<String> words = HashSet.newHashSet(400_000);

        while ((currentLine = reader.readLine()) != null) {
            words.add(currentLine);
        }

        return words;
    }


    private static void urlTxtToFile(String fileName, String urlTxt) throws IOException {
        File englishWordsFile = new File(fileName);

        if (englishWordsFile.exists()) {
            System.out.println("The file %s already exists, do you want to overwrite it? y/n".formatted(fileName));
            if (!new Scanner(System.in).nextLine().equalsIgnoreCase("y")) return;
        }
        // Crear BufferedWriter con codificación por defecto (en mi caso UTF-8)
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(englishWordsFile)))) {

            // Escribir BOM para UTF-16 Big-Endian (opcional si OutputStreamWriter ya lo maneja)
            //writer.write(0xFEFF);

            // Crear objeto URL desde String con la URL
            URL url = URI.create(urlTxt).toURL(); // 370,000 palabras

            // Leer desde la URL
            try (InputStream is = url.openStream();
                 Scanner scanner = new Scanner(is)) {

                // Leer cada palabra, convertir a minúsculas y escribir en el archivo
                while (scanner.hasNextLine()) {
                    String word = scanner.nextLine().toLowerCase();
                    writer.write(word);
                    writer.newLine(); // Añadir nueva línea
                }
            }
        }
    }

    private static Collection<String> wordList(String string, Collection<String> words) {
        Collection<String> wordList = new HashSet<>();
        // Generate all substring contained in a string
        String substring;
        //Collection<String> substrings = new HashSet<>();

        Collection<String> wordsInString = new HashSet<>();
        System.out.println("string %s length=%d".formatted(string, string.length()));
        for (int i = 0; i < string.length(); i++) {
            // we only take in account words of 3 or more length of this list of words
            for (int j = i+3; j <= string.length(); j++) {
                //if(j==i) continue;
                substring = string.substring(i, j);
                //substrings.add(substring);
                if (words.contains(substring)) wordsInString.add(substring);
            }
        }

        //System.out.println(substrings.stream().filter(s -> s.length() == 2).toList());

        //System.out.println("substrings length=1 total=%d".formatted(substrings.size()));


        return wordsInString;
    }

    public static void main(String[] args) {

        // Obtener y mostrar la codificación predeterminada de la JVM
        String defaultCharset = Charset.defaultCharset().name();
        System.out.println("La codificación predeterminada de la JVM es: " + defaultCharset);

        Collection<String> words = null;
        try {
            //urlTxtToFile("englishWords.txt", WORD_LIST_URL);
            words = readWordsFromLocalTxt();
            //System.out.println(words);
            Collection<String> wordList = wordList("wristwatches", words);
            System.out.println(wordList);

            System.out.println(wordList("abibliophobia",words));
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
