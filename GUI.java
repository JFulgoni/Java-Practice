package john_test;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI implements KeyListener, Runnable{
	
	private JFrame myFrame;
	private JLabel myText;
	private boolean done;
	private int displayNum;
	
	public GUI(){
		done = false;
		displayNum = 0;
		myFrame = new JFrame("Test GUI");
		initialize();
	}
	
	public void run(){
		while(!done){
			update();
		}
	}
	
	public void update(){
		myText.setText(String.valueOf(displayNum));
		myFrame.getContentPane().add(myText, BorderLayout.CENTER);
	}
	
	public void initialize(){
        myFrame.setVisible(true);
        myFrame.setBounds(300, 200, 700, 400);
        myText = new JLabel("I'm a label in the window",
                SwingConstants.CENTER);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_C){
			done = true;
		}
		else{
			++displayNum;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                GUI frame = new GUI();
//                frame.initialize();
//            }
//        });
		GUI frame = new GUI();
        //frame.initialize();
		frame.run();
	}

}
