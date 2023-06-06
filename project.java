import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class project {
    static final int MAX_USERS = 10;
    static final int NUM_RIDDLES = 3;
    static final String[] riddles = {
            "What are two things you can never eat for breakfast?",
            "The more you take, the more you leave behind, what are they?",
            "What can you put in a bucket to make it weigh less?"
    };
    static final String[] answers = {
            "lunch and dinner",
            "footsteps",
            "a hole"
    };

    public static void main(String[] args) {
        Map<String, Integer> scores = loadScores();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        int score = scores.getOrDefault(username, 0);

        System.out.println("Welcome back, " + username + "! Your previous score is: " + score);

        for (int i = 0; i < NUM_RIDDLES; i++) {
            System.out.println("Riddle " + (i + 1) + ":");
            System.out.println(riddles[i]);

            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(answers[i])) {
                score++;
                System.out.println("Correct! You earned 1 point.");
            } else {
                System.out.println("Wrong answer. Moving on to the next riddle.");
            }
        }

        scores.put(username, score);
        saveScores(scores);

        System.out.println("Game over. Your final score is: " + score);
    }

    public static Map<String, Integer> loadScores() {
        Map<String, Integer> scores = new HashMap<>();

 

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("scores.ser"))) {
            scores = (HashMap<String, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Handle file not found or deserialization error
        }

 

        return scores;
    }
    public static void saveScores(Map<String, Integer> scores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("scores.ser"))) {
            oos.writeObject(scores);
        } catch (IOException e) {
            // Handle file write error
        }
    }
}