import javax.swing.*;

public class Main {
    public static void main(String[] args){
        String[] options = {"Game 1", "Game 2", "Game 3"}; //String array of the three game options

        //Creates dialog box that displays the game titles and descriptions and provides buttons that allow the user to select a game
        int response = JOptionPane.showOptionDialog(null,
                "Select Game\nGame 1: Shape Matcher Game\nGame 2: Quiz Controller Game\nGame 3:Shape Shooter",
                "Game Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        switch (response) //switch statement that runs the game selected by the user
        {
            case 0: // Game 1 selection
                SwingUtilities.invokeLater(new Runnable()
                {
                    @Override
                    public void run() {
                        new org.example.ShapeMatcherGame(); // Starts the game by creating an instance of ShapeMatcherGame
                    }
                });
                break;
            case 1: // Game 2 selection
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new QuizController();
                    }
                });
                break;
            case 2: // Game 3 selection
            default:
                System.out.println("Game 3 playing");
                break;
        }
    }
}
