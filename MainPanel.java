import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JFrame{
    
    private static JButton rock;
    private static JButton paper;
    private static JButton scissors;
    private static JLabel computer;
    private static JLabel player;
    private static JLabel compMove;
    private static JLabel playerMove;
    private static Icon iRock;
    private static Icon iPaper;
    private static Icon iScissors;
    private static Icon iCRock;
    private static Icon iCPaper;
    private static Icon iCScissors;
    private static JLabel info;
    
    private static JFrame frame;
	
    public static void main(String[] args) throws IOException {
    	new MainPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(new DisplayPanel());
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setLayout(null);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);       
    }
    
    public MainPanel() throws IOException {
    	frame = new JFrame("Rock-Paper-Scissors");
    	
    	computer = new JLabel("COMPUTER");
    	player = new JLabel("PLAYER");
    	
    	computer.setName("computer");
    	computer.setFont(new Font("serif", Font.PLAIN, 20));
    	player.setName("player");
    	player.setFont(new Font("serif", Font.PLAIN, 20));
    	
    	player.setBounds(215, 25, 150, 150);
    	computer.setBounds(625, 25, 150, 150);

    	frame.add(computer);
    	frame.add(player);
    	
    	Icon start = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("Rock_Paper_Scissors__Wallpaper_by_Mattie_P.jpg")));
    	iRock = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("rock.png")));
    	iPaper = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("paper.png")));
    	iScissors = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("scissors.png")));
    	iCRock = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("Crock.png")));
    	iCPaper = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("Cpaper.png")));
    	iCScissors = new ImageIcon(ImageIO.read(DisplayPanel.class.getResourceAsStream("Cscissors.png")));
    	compMove = new JLabel();
    	compMove.setIcon(start);
    	playerMove = new JLabel();
    	playerMove.setIcon(start);
    	   	
    	playerMove.setBounds(34, 200, 449, 322);
    	compMove.setBounds(483, 200, 449, 322);
    	
    	frame.add(playerMove);
    	frame.add(compMove);
    	
    	rock = new JButton("ROCK");
    	paper = new JButton("PAPER");
    	scissors = new JButton("SCISSORS");
    	
    	rock.setName("rock");
    	paper.setName("paper");
    	scissors.setName("scissors");
    	
    	rock.setBounds(50, 650, 100, 100);
    	paper.setBounds(450, 650, 100, 100);
    	scissors.setBounds(850, 650, 100, 100);
    	  	
    	rock.addActionListener(new RockListener());
    	paper.addActionListener(new PaperListener());
    	scissors.addActionListener(new ScissorsListener());

    	frame.add(rock);
    	frame.add(paper);
    	frame.add(scissors);
    	
    	info = new JLabel("Set this text here");
    	info.setBounds(100, 800, 700, 100);    	
    	info.setName("info");
    	info.setFont(new Font("serif", Font.PLAIN, 20));
    	frame.add(info);
    }
    
    private class RockListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            playerMove.setIcon(iRock);
            compMove.setIcon(iCPaper);
            frame.repaint();
        }
    }
    
    private class PaperListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            playerMove.setIcon(iPaper);
            compMove.setIcon(iCScissors);
            frame.repaint();
        }
    }
    
    private class ScissorsListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            playerMove.setIcon(iScissors);
            compMove.setIcon(iCRock);
            frame.repaint();
        }
    }
}
