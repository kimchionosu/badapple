package fuckmylife;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class FrameThatFuckMyLife extends JFrame {
	
	private static final int PAIN = 6572;
    private File file = new File("src/badapple.wav");

	private static final long serialVersionUID = 1L;
	public static JTextArea textArea;
    
	public FrameThatFuckMyLife(int x, int y, int width, int height) throws InterruptedException, IndexOutOfBoundsException {
		init(x, y, width, height);
		//loop();
	}
	
	private void init(int x, int y, int width, int height) {
		//setup
		setBounds(x, y, width, height);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(":)");
        setUndecorated(true);
        
        //text
        textArea = new JTextArea();
        this.add(textArea);
        textArea.setBounds(0, 0, width, height);
        textArea.setFont(new Font("Lucida Console", Font.PLAIN, 7));
        //textArea.setFont(new Font("Monospaced", 0, 7));
        setLocationRelativeTo(null);
        
        textArea.setForeground(Color.white);
        textArea.setBackground(Color.BLACK);
        textArea.setDoubleBuffered(true);
        
        //PLAY DAE MUSIC
        Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
		        try {
		        	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
			        Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
			        clip.start();				
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {

				}
		        try {


				} catch (Exception e) { }
			}
		});
        thread.start();
        
        startAnimation();

        //giúp người không mù thấy được window
        setVisible(true);
	}
	
	private void startAnimation() {
        final int delay = 1000 / 30;
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				textArea.setText(Main.packshitinhere.get(0));
				Main.packshitinhere.remove(0);
			}
        }, 0L, delay);
    }
	
}
