import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        final int MAX_ITEMS = 50;
        String[] items = new String[MAX_ITEMS];
        int itemCount = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter items (type 'stop' to end):");

        while (itemCount < MAX_ITEMS) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            items[itemCount] = input;
            itemCount++;
        }

        System.out.println("Enter your activity (coding/sleeping/running/eating/other):");
        String activity = scanner.nextLine();

        String item = searchItem(items, activity);
        System.out.println(item);
    }

    public static String searchItem(String[] items, String activity) {
        ArrayList<String> itemList = new ArrayList<>(Arrays.asList(items));

        if (activity.equalsIgnoreCase("coding") && itemList.contains("computer")) {
            return "computer";
        } else if (activity.equalsIgnoreCase("running") && itemList.contains("shoe")) {
            return "shoe";
        } else if (activity.equalsIgnoreCase("sleeping") && itemList.contains("bed")) {
            return "bed";
        } else if (activity.equalsIgnoreCase("eating") && (itemList.contains("chicken") || itemList.contains("cow"))) {
            if (itemList.contains("chicken")) {
                return "chicken";
            } else {
                return "cow";
            }
        } else if (activity.equalsIgnoreCase("other")){
            return "sorry dawg";
        } else {
            return "go away you don't have what you need";
        }
    }
}
