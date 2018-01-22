package textDisplay;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class Show extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static void run(){
		SwingUtilities.invokeLater(new Runnable(){
			Show f= new Show();
			public void run(){
				f.setTitle("text form file");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(450,230);
				f.setVisible(true);
			}
		});
	}
	
	
	JButton startButton = new JButton("text");
	JTextArea text = new JTextArea(10,40);
	
		public Show(){
    	//JPanel jp = new JPanel();
    	setLayout(new FlowLayout());
    	//GridBagConstraints c = new GridBagConstraints();
    	setTextSettings();
		add(text);
		setButtonSettings();
		add(startButton);    	
    }
	
	void setTextSettings(){
		text.setEditable(false);
		text.setBackground(null);
		text.setText("text for you");
	}
	
	void setButtonSettings() {
		startButton.addActionListener(new getTestFromFile());
	}
	
	class getTestFromFile implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	  text.setText(findText());
	    	  
	      }
	   }
	
	String 	findText() {
		try {
			Scanner scan = new Scanner(
					new File("text.txt"));
			String poem = "";
				while(scan.hasNextLine())
					poem+=scan.nextLine()+"<br\\>";
				scan.close();
				return poem;
			
		} catch (FileNotFoundException e) {
			return "no file";
		}
	}
}
