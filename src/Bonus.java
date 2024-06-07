import java.util.*;

public class Bonus {

  public static void main(String[] args) {

    // Onderstaande code is uitgecommentarieerd. Haal de code uit de comment (delete /* en */) om aan de slag te gaan met de bonus
    // In de code staan op verschillende plekken comments tussen "/*...*/" als hint wat je moet doen

    // The first method is being used to create a random number that will saved in a
    Set<Integer> secretnumber = randomnumbergenerator();
    // HastSet collection.
    // This will force the numbers that are being saved to be unique.
    // This is still an array that need to be looped over
    String stringnumber = setToStringConverter(
      secretnumber); // THis method will add all values of the HashSet Collection array to be add to one string

    System.out.println(stringnumber);
    // Now the fun can begin, we can try to gues the number
    feedback(stringnumber);

  }

  public static HashSet<Integer> randomnumbergenerator() {
         /*
        Vul hier de body van de methode in.
        Stappenplan:
        - Maak een nieuwe variabele van type Random. (Tip: Zoek op internet hoe je Random kunt gebruiken)
        - Maak een nieuwe variabele van type HashSet.
        - Schrijf een while-loop om 4 random nummers aan de hashset toe te voegen
        - return de hashset
         */

    Random rand = new Random();
    HashSet<Integer> numbers = new HashSet<>();
    while (numbers.size() < 4) {
      numbers.add(rand.nextInt(10)); // the random number I have set to a limit between 0 and 10
      // this will make sence since the result will only be 4 integers long and every integer needs to be different
    }
    return numbers;
  }

  public static String setToStringConverter(Set<Integer> numbers) {
        /*
        Vul hier de body van de methode in.
        Stappenplan:
        - Maak als eerst een String variabele met als waarde een lege String. (of gebruik een StringBuilder)
        - Schrijf vervolgens een for-loop om de items in de hashset een voor een aan de String variabele toe te voegen.
        - Return de (gevulde) String variabele
         */

    // This will generate a string builder, and keep hold of the value an later eventually convert it to a string
    StringBuilder sb = new StringBuilder();
    for (Integer number : numbers) {
      sb.append(number);
    }
    return sb.toString();
  }

  public static void feedback(String stringnumber) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder feedback = new StringBuilder();
    System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
    System.out.println("Doe een gok, Let op vul 4 getallen in.");

    // I added a while loop that will only break out if are right formatted value has been entered
    // I added a few if statement to check wheter there are only a numeric value is being entered
    // Also a else if statement to prevent the maximum of numbers being entered
    while (true) {
      String guess = scanner.nextLine(); // writes the entry from the scanner to a String variable
      if (!guess.matches("\\d+")) {
        System.out.println("You enterd not a numeric value \n try again!");
      } else if ((guess.length() > 4)) {
        System.out.println("You entered to many numbers \n try again!");
      } else { // From here the lottery will begin.
        if (Objects.equals(guess, stringnumber)) { //  this will compare the 'value' of the two string to check if they are the same
          // when the condition is true. You exactly guessed the right number.
          System.out.println("gefeliciteerd je hebt het goed");
        } else {
          // If not true
          // We run another for loop to compare all 4 characters to certain conditions
          for (int i = 0; i < 4; i++) {
            if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i +
              1))) { // this will thus check if a letter on certain position is the exact same as on the other string on the same
              // position. The reason for the i +_1 is to be able to select one character. Thats how the substring works.
              feedback.append("+");
            } else if (stringnumber.contains(guess.substring(i,
              i + 1))) { // this will just check per character if is available in the string where it is compared to
              // if yes it will append a 0 to 'feedback'  string
              feedback.append("0");
            } else {
              // else it will append a X to the 'feedback' string
              feedback.append("X");
            }
          }
        }
        System.out.println(feedback.toString());
        break; // eventually when the guessing game is done. THe loop will break out.
      }
    }
  }
}
