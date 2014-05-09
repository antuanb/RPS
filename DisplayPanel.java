import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel
{
    private JButton rock;
    private JButton paper;
    private JButton scissors;
    private JLabel computer;
    private JLabel player;
    private JLabel compMove;
    private JLabel playerMove;
    Icon iRock;
    Icon iPaper;
    Icon iScissors;
    
    public DisplayPanel() throws IOException {
    	
    	computer = new JLabel("COMPUTER");
    	player = new JLabel("PLAYER");
    	
    	computer.setName("computer");
    	player.setName("player");
    	
    	player.setLayout(null);
    	computer.setLayout(null);
    	player.setBounds(0, 0, 25, 25);
    	computer.setBounds(100, 100, 100, 100);

    	add(computer);
    	add(player);
    	
    	Icon start = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("Rock_Paper_Scissors__Wallpaper_by_Mattie_P.jpg")));
    	iRock = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("rock.png")));
    	iPaper = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("paper.png")));
    	iScissors = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("scissors.png")));
    	compMove = new JLabel();
    	compMove.setIcon(start);
    	playerMove = new JLabel();
    	playerMove.setIcon(start);
    	
    	add(playerMove);
    	add(compMove);
    	
    	rock = new JButton("ROCK");
    	paper = new JButton("PAPER");
    	scissors = new JButton("SCISSORS");
    	
    	rock.setName("rock");
    	paper.setName("paper");
    	scissors.setName("scissors");
    	
    	rock.addActionListener(new RockListener());
    	paper.addActionListener(new PaperListener());
    	scissors.addActionListener(new ScissorsListener());

    	add(rock);
    	add(paper);
    	add(scissors);
    }
    
    private class RockListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            playerMove.setIcon(iRock);
            repaint();
        }
    }
    
    private class PaperListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            playerMove.setIcon(iPaper);
            repaint();
        }
    }
    
    private class ScissorsListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            playerMove.setIcon(iScissors);
            repaint();
        }
    }
}
