package CasasMurosMCO2Package;
/**
 * Represents the main class of the program which holds the main method responsible for starting the program
 */
public class Driver {
  public static void main(String[] args) {
    GUI gui = new GUI();
    Model model = new Model();
    new Controller(gui, model);
  }
}
