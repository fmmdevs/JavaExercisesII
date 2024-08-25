package devs.fmm.advancedstringprocessing.decomposestringsintotokens;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class ParseSimpleCSVWithCoordinates {

    public static void main(String[] args) {
        String filePath ="devs/fmm/advancedstringprocessing/decomposestringsintotokens/coordinates.csv";
        StringBuilder sb = new StringBuilder();

        try{
            Scanner sc = new Scanner(Path.of(filePath));
            sc.useLocale(Locale.ENGLISH);
            while(sc.hasNextLine()){
                sb.append(sc.nextLine()).append(" ");
            }
            System.out.println(sb);
            String html = """
                    <svg height="400" width="500" viewBox="-160 -160 320 320">
                        <polygon points="%s" style="fill:lime; stroke:purple;stroke-width:1"/>
                    </svg>""".formatted(sb.toString()).replace('\u2010','\u002D');
            System.out.println(html);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
