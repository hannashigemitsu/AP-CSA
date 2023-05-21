import java.util.Arrays;
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
        String[] usernames = new String[MAX_USERS];
        int[] scores = new int[MAX_USERS];
        int userCount = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        int userIndex = findUserIndex(username, usernames, userCount);
        int score = 0;

        if (userIndex != -1) {
            score = scores[userIndex];
            System.out.println("Welcome back, " + username + "! Your previous score is: " + score);
        } else {
            if (userCount == MAX_USERS) {
                System.out.println("Sorry, maximum number of users reached.");
                return;
            }
            userIndex = userCount;
            usernames[userIndex] = username;
            userCount++;
            System.out.println("Hello, " + username + "! Your score is: " + score);
        }

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

        scores[userIndex] = score;
        System.out.println("Game over. Your final score is: " + score);
    }

    public static int findUserIndex(String username, String[] usernames, int userCount) {
        for (int i = 0; i < userCount; i++) {
            if (username.equals(usernames[i])) {
                return i;
            }
        }
        return -1;
    }
}
