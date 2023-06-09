import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class projecttest {
    static final int MAX_USERS = 20;
    static final int NUM_RIDDLES = 10;
    static final String[] riddles = {
            "What are two things you can never eat for breakfast?",
            "The more you take, the more you leave behind, what are they?",
            "What can you put in a bucket to make it weigh less?",
            "What does a house wear?",
            "Where would you take a sick boat?",
            "What creature is smarter than a talking parrot?",
            "How does a bee get to school?",
            "Why are As like flowers?",
            "What do you call a snail on a ship?",
            "What kind of room has no doors or windows?"
    };
    static final String[] answers = {
            "lunch and dinner",
            "footsteps",
            "a hole",
            "ad-dress",
            "to the dock",
            "a spelling bee",
            "on a buzz",
            "because Bs come after them",
            "a snailor",
            "a mushroom"
    };

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        int score = 0;
        if (scores.containsKey(username)) {
            score = scores.get(username);
            System.out.println("Welcome back, " + username + "! Your previous score is: " + score);
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
                if (score > 0) {
                    score--;
                    System.out.println("Wrong answer. 1 point deducted.");
                } else {
                    System.out.println("Wrong answer. You have zero points.");
                }
            }
        }

        scores.put(username, score);

        if (scores.size() > MAX_USERS) {
            String oldestUser = scores.keySet().iterator().next();
            scores.remove(oldestUser);
        }

        System.out.println("Game over. Your final score is: " + score);

        if (score > 0) {
            drawHeart(score);
        }
    }

    static void drawHeart(int size) {
        switch (size) {
            case 1:
                System.out.println("<3");
                break;
            case 2:
                System.out.println("<3 <3");
                break;
            case 3:
                System.out.println("<3 <3 <3");
                break;
            case 4:
                System.out.println("<3 <3 <3 <3");
                break;
            case 5:
                System.out.println("<3 <3 <3 <3 <3");
                break;
            case 6:
                System.out.println("<3 <3 <3 <3 <3 <3");
                break;
            case 7:
                System.out.println("<3 <3 <3 <3 <3 <3 <3");
                break;
            case 8:
                System.out.println("<3 <3 <3 <3 <3 <3 <3 <3");
                break;
            case 9:
                System.out.println("<3 <3 <3 <3 <3 <3 <3 <3 <3");
                break;
            case 10:
                System.out.println("<3 <3 <3 <3 <3 <3 <3 <3 <3 <3");
                break;
            default:
                System.out.println("</3");
                break;
        }
    }
}
