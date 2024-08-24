package devs.fmm.advancedstringprocessing.regularexpressionspatternrecognition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeterminePopularity {
    public static void main(String[] args) {

        String socialMedia = """
                @User123: Just met @CaptainCiaoCiao today! What an amazing person! 💥
                                
                @Traveler92: Can't believe I missed the live stream with #CaptainCiaoCiao yesterday... 😓
                                
                @AdventureGirl: Heading to the city tomorrow! Anyone knows if @CaptainCiaoCiao is around? 🙌
                                
                @MusicLover: Listening to some great tunes right now, thanks to the recommendations by #CaptainCiaoCiao 🎶
                                
                @GamerDude: Can’t wait for the next gaming session with @CaptainCiaoCiao! You rock! 🎮🔥
                                
                @Foodie_21: Finally tried that restaurant recommended by @CaptainCiaoCiao, and it did not disappoint. 🥘👌
                                
                @FitnessPro: Morning workout done! Feeling strong thanks to #CaptainCiaoCiao's motivation. 💪 #StayFit
                                
                @CaptainCiaoCiao: Thank you all for the love and support! Ready for another adventure? #CaptainCiaoCiao 💫
                                
                @NatureLover: Just saw @CaptainCiaoCiao’s latest post. Such amazing vibes! 🌿🌟""";

        String socialMedia2 = "Make me a baby #CaptainCiaoCiao Hey @CaptainCiaoCiao, where is the recruitment test? What is a hacker's favorite pop group? The Black IP's.";

        // 1. Regex
        String regex = "[#@]CaptainCiaoCiao";
        // 2. Pattern compile regex
        Pattern pattern = Pattern.compile(regex);
        // 3. Declare Matcher and assign pattern matcher text
        Matcher matcher = pattern.matcher(socialMedia);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println("Number of matches: " + counter);

    }
}
