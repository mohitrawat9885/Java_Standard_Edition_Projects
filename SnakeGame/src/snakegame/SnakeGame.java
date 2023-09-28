package snakegame;
import javax.swing.JFrame;

public class SnakeGame extends JFrame{
    SnakeGame(){
        super("Snake Game");
        add(new Board());
        pack();
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
    }
    public static void main(String[] args) {
        new SnakeGame().setVisible(true);;
    }
    
}
