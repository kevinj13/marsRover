/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsrover1301;

import java.util.*;

/**
 *
 * @author kjsouribio
 */
public class moveRover {

    static int maximumX;

    static int maximumY;

    static int startingPositionX;

    static int startingPositionY;

    static String startingCompassPoint;

    static String startingRoverInstructions;

    static int positionX;

    static int positionY;

    static String compassPoint;

    static String roverInstructions;

    static char[] roverInstructionsArray;

    /**
     *
     * // * @param args the command line arguments
     *
     */
    
    public static void plateauSize() {
        System.out.println("LET'S ESTABLISH THE SIZE OF THE PLATEAU:");

        while (true) {
            Scanner maximumXInput = new Scanner(System.in);
            System.out.println("Enter the maximum X Axis");
            try {

                maximumX = Integer.parseInt(maximumXInput.next());
                if (maximumX == 0) {
                    System.out.println("It cannot be 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("input is not an int value");
            }

            Scanner maximumYInput = new Scanner(System.in);
            System.out.println("Enter the maximum Y Axis");
            try {
                maximumY = Integer.parseInt(maximumYInput.next());
                if (maximumY == 0) {
                    System.out.println("It cannot be 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("input is not an int value");

            }

            if (maximumX == 0 || maximumY == 0) {
                System.out.println("You had wrong inputs. Please try again.");
            } else {
                break;
            }
        }
    }

    
    public void roverInput() {

        // TODO code application logic here
        System.out.println("\n\nWHERE WOULD YOU LIKE THE ROVER TO START?");

        while (true) {
            boolean pass = false;

            Scanner positionXInput = new Scanner(System.in);
            System.out.println("Enter the starting X Position of the Rover");
            try {

                positionX = Integer.parseInt(positionXInput.next());
                if (positionX > maximumX) {
                    System.out.println("It cannot be more than the size of the plateau");
                } else {
                    startingPositionX = positionX;
                    pass = true;

                }
            } catch (NumberFormatException e) {
                System.out.println("input is not an int value");
                pass = false;
            }

            Scanner positionYInput = new Scanner(System.in);
            System.out.println("Enter the starting Y Position of the Rover");
            try {

                positionY = Integer.parseInt(positionYInput.next());
                if (positionY > maximumY) {
                    System.out.println("It cannot be more than the size of the plateau");
                } else {
                    startingPositionY = positionY;
                    pass = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("input is not an int value");
                pass = false;
            }

            if (positionX > maximumX || positionY > maximumY || pass == false) {
                System.out.println("You entered wrong inputs. Please try again.");
            } else {
                break;
            }
        }

        while (true) {
            Scanner compassPointInput = new Scanner(System.in);
            System.out.println("Enter the Direction the Rover is Facing: N for North, E for East, W for West, S for South");
            compassPoint = compassPointInput.next().toUpperCase();

            if (compassPoint.matches("[a-zA-Z]{1}")
                    && (compassPoint.equals("N")
                    || compassPoint.equals("E")
                    || compassPoint.equals("W")
                    || compassPoint.equals("S"))) {
                startingCompassPoint = compassPoint;
                break;
            } else {
                System.out.println("Wrong Input. It cannot be more than 1 character. Please only choose between N,E,W,");

            }
        }

        boolean instructionsCorrect = true;
        while (instructionsCorrect) {
            Scanner roverInstructionsInput = new Scanner(System.in);
            System.out.println("Enter Your Instructions: L for Left, R for Right, M for Move");
            roverInstructions = roverInstructionsInput.next().toUpperCase();

            roverInstructionsArray = roverInstructions.toCharArray();
//            System.out.println("LENGTH" + roverInstructionsArray.length);

            for (int i = 0; i < roverInstructionsArray.length; i++) {

//                System.out.print(roverInstructionsArray[i]);

                if (roverInstructionsArray[i] == 'L' || roverInstructionsArray[i] == 'R' || roverInstructionsArray[i] == 'M') {
//                    System.out.println("Good");
//                    System.out.println(i);
                    if (i == roverInstructionsArray.length - 1) {
//                        System.out.println("Finish");
                        instructionsCorrect = false;
                        startingRoverInstructions = roverInstructions;

                    }
                } else {
                    System.out.println("Wrong Input. Try again.");
                    instructionsCorrect = true;
                    break;
                }
            }

        }
//        move();

    }

    
    public static void move() {

        //Starting X Position
        //Starting Y Position
        //Starting facing Direction
        System.out.println("\n\nPlateau's Size: " + maximumX + ", " + maximumY);
        System.out.println("Rover Current Position: " + positionX + ", " + positionY + ", " + compassPoint);
        System.out.println("Rover Instructions: " + roverInstructions + "\n\n\n");

        roverInstructionsArray = roverInstructions.toCharArray();

        for (int i = 0; i < roverInstructionsArray.length; i++) {
//            System.out.println("INSTRUCTIONS RECEIVED: ");
            if (roverInstructionsArray[i] == 'M') {

                switch (compassPoint) {
                    case "N":
                        System.out.println("Moving Towards North");
                        System.out.println("Current Compass Point: " + compassPoint);
                        positionY += 1;
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    case "E":
                        System.out.println("Moving Towards East");
                        System.out.println("Current Compass Point: " + compassPoint);
                        positionX += 1;
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    case "W":
                        System.out.println("Moving Towards West");
                        System.out.println("Current Compass Point: " + compassPoint);
                        positionX -= 1;
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    case "S":
                        System.out.println("Moving Towards South");
                        System.out.println("Current Compass Point: " + compassPoint);
                        positionY -= 1;
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    default:
                        break;

                }

            }
            if (roverInstructionsArray[i] == 'L') {

                switch (compassPoint) {
                    case "N":
                        System.out.println("Turning Left to West");
                        compassPoint = "W";
                        System.out.println("Current Compass Point: " + compassPoint);
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    case "E":
                        System.out.println("Turning Left to North");
                        compassPoint = "N";
                        System.out.println("Current Compass Point: " + compassPoint);
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    case "S":
                        System.out.println("Turning Left to East");
                        compassPoint = "E";
                        System.out.println("Current Compass Point: " + compassPoint);
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    case "W":
                        System.out.println("Turning Left to South");
                        compassPoint = "S";
                        System.out.println("Current Compass Point: " + compassPoint);
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;

                    default:
                        break;

                }

            }// L END

            if (roverInstructionsArray[i] == 'R') {

                switch (compassPoint) {
                    case "N":
                        System.out.println("Turning Left to East");
                        compassPoint = "E";
                        System.out.println("Current Compass Point: " + compassPoint);
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    case "E":
                        System.out.println("Turning Left to South");
                        compassPoint = "S";
                        System.out.println("Current Compass Point: " + compassPoint);
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    case "S":
                        System.out.println("Turning Left to West");
                        compassPoint = "W";
                        System.out.println("Current Compass Point: " + compassPoint);
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;
                    case "W":
                        System.out.println("Turning Left to North");
                        compassPoint = "N";
                        System.out.println("Current Compass Point: " + compassPoint);
                        System.out.println("Current Position: " + positionX + ", " + positionY + "\n");
                        break;

                    default:
                        break;

                }

            } //R END
        }
    }
    
    
    public String printPlateauSize() {
        String PlateauSize = maximumX + " " + maximumY;
        return PlateauSize;
    }
    
    public String printStartingPosition() {
        String startingPosition = startingPositionX + " " + startingPositionY + " " + startingCompassPoint + "\n\n"
                               + startingRoverInstructions + "\n";
        return startingPosition;
    }

    
    public String printFinalPosition() {
        String finalPosition = positionX + " " + positionY + " " + compassPoint + "\n";
        return finalPosition;
    }

}
