import java.util.Scanner;

public class RocketLaunchSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rocket rocket = new Rocket();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "start_checks":
                    rocket.startChecks();
                    break;
                case "launch":
                    rocket.launch();
                    break;
                case "fast_forward":
                    if (parts.length > 1) {
                        try {
                            int seconds = Integer.parseInt(parts[1]);
                            rocket.fastForward(seconds);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format. Usage: fast_forward X");
                        }
                    } else {
                        System.out.println("Invalid command format. Usage: fast_forward X");
                    }
                    break;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }
}
