import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoicePhoneNumber {

    public static boolean isNumberWithoutCode(String  str) {
        return Pattern.matches("\\d{3}-\\d{3}-\\d{4}", str);
    }

    public static boolean isNumberWithCode(String  str) {
        return Pattern.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}", str);
    }

    public static void main(String[] args) throws IOException {
        try ( BufferedReader reader = new BufferedReader(new FileReader("./src/main/resources/ChoicePhoneNumber.txt") ) ) {
            String line = reader.readLine();
            while (line != null) {
                if ( isNumberWithCode(line)  ||  isNumberWithoutCode(line)) {
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        }
    }
}
