package 백준._3_골드.구현.P14891;

import java.io.*;
import java.util.*;

public class Main {
    static final int GEAR_SIZE = 4;
    static final int TOOTH = 8;
    static int[][] gears = new int[GEAR_SIZE + 1][TOOTH];
    static int[] place = new int[GEAR_SIZE + 1]; // Tracks the 12 o'clock position for each gear

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= GEAR_SIZE; i++) {
            String input = br.readLine();
            for (int j = 0; j < TOOTH; j++) {
                gears[i][j] = input.charAt(j) - '0';
            }
            place[i] = 0; // Initialize 12 o'clock position
        }

        int K = Integer.parseInt(br.readLine());

        // Process each rotation command
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNumber = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            // Determine rotation directions for all gears
            int[] rotations = new int[GEAR_SIZE + 1];
            rotations[gearNumber] = direction;

            // Check to the left of the current gear
            for (int g = gearNumber; g > 1; g--) {
                // Compare current gear's left tooth with the previous gear's right tooth
                int currentGearRight = (place[g] + 6) % TOOTH;
                int prevGearLeft = (place[g - 1] + 2) % TOOTH;
                if (gears[g][currentGearRight] != gears[g - 1][prevGearLeft]) {
                    rotations[g - 1] = -rotations[g];
                } else {
                    break; // No further rotation needed
                }
            }

            // Check to the right of the current gear
            for (int g = gearNumber; g < GEAR_SIZE; g++) {
                // Compare current gear's right tooth with the next gear's left tooth
                int currentGearLeft = (place[g] + 2) % TOOTH;
                int nextGearRight = (place[g + 1] + 6) % TOOTH;
                if (gears[g][currentGearLeft] != gears[g + 1][nextGearRight]) {
                    rotations[g + 1] = -rotations[g];
                } else {
                    break; // No further rotation needed
                }
            }

            // Perform rotations
            for (int g = 1; g <= GEAR_SIZE; g++) {
                if (rotations[g] == 1) {
                    rotateClockwise(g);
                } else if (rotations[g] == -1) {
                    rotateCounterClockwise(g);
                }
            }
        }

        // Calculate the final score
        int score = 0;
        int multiplier = 1;
        for (int i = 1; i <= GEAR_SIZE; i++) {
            if (gears[i][place[i]] == 1) {
                score += multiplier;
            }
            multiplier *= 2;
        }
        System.out.println(score);
    }

    // Rotates the gear clockwise
    private static void rotateClockwise(int gear) {
        place[gear] = (place[gear] - 1 + TOOTH) % TOOTH;
    }

    // Rotates the gear counterclockwise
    private static void rotateCounterClockwise(int gear) {
        place[gear] = (place[gear] + 1) % TOOTH;
    }
}
