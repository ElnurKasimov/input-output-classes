import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsFrequency {

    static ArrayList<String> getWordsFromString(String  string) {
        ArrayList<String> wordsList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()) {
            wordsList.add(string.substring(matcher.start(), matcher.end()));
        }
        return wordsList;
    }

    public static Integer countWordsFrequency(ArrayList<String>  wordsList, String word) {
        Integer count =0;
        for (String w : wordsList) {
            if (w.equalsIgnoreCase(word)) {count++;}
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<String> wordsList = new ArrayList<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader("./src/main/resources/test.txt") ) ) {
            String line = reader.readLine();
            while ( line != null) {
                ArrayList<String> wordsFromLine = getWordsFromString(line);
                Iterator<String> iterator = wordsFromLine.iterator();
                while (iterator.hasNext()) {
                    wordsList.add(iterator.next());
                }
                line = reader.readLine();
            }
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }

        HashMap<String , Integer>  wordFrequency = new HashMap<>();
            for ( String w : wordsList) {
                wordFrequency.put(w, countWordsFrequency(wordsList, w));
            }
            System.out.println(wordFrequency.toString());

        ArrayList <Map.Entry<String, Integer >> valuesList = new ArrayList(wordFrequency.entrySet());
        Collections.sort(valuesList, new Comparator<Map.Entry<String, Integer >>() {
            @Override
            public int compare(Map.Entry<String, Integer > o1, Map.Entry<String, Integer > o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer > entry : valuesList) {
            System.out.println(entry);
        }
    }
}

