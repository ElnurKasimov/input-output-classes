import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

public class CreatingJsonFile {

    public static void main(String[] args) throws IOException {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String > ages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("F:\\IdeaProjects\\InputOutputStreams\\src\\main\\java\\UsersInformation.txt")) ) {
            String line = reader.readLine();
            while (line != null) {
                String[] user = line.split(" ");
                names.add(user[0]);
                ages.add(user[1]);
                line = reader.readLine();
            }
        }
        User user1 = new User (names.get(1),  Integer.parseInt(ages.get(1)));
        User user2 = new User (names.get(2), Integer.parseInt(ages.get(2)));
        System.out.println(user1);
        System.out.println(user2);

        File jsonFile = new File("F:\\IdeaProjects\\InputOutputStreams\\src\\main\\java\\Users.json");
        jsonFile.createNewFile();
        try (FileWriter writer = new FileWriter("F:\\IdeaProjects\\InputOutputStreams\\src\\main\\java\\Users.json")) {
        Gson gson = new GsonBuilder(). setPrettyPrinting().create();
        writer.write("[\n");
        writer.write(gson.toJson(user1) + ", \n");
        writer.write(gson.toJson(user2) + "\n");
        writer.write("]");
        }


    }

    public static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}