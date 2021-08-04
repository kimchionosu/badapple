package fuckmylife;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class FrameThatFuckMyLife extends JFrame {
	
	private static final int PAIN = 6572;
    private File file = new File("src/badapple.wav");

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	
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
        textArea.setFont(new Font("Lucida Console", Font.PLAIN, 8));
        
        textArea.setForeground(Color.white);
        textArea.setBackground(Color.BLACK);
        
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
					loop();
				} catch (IndexOutOfBoundsException | InterruptedException e) { }
			}
		});
        thread.start();
        //giúp người không mù thấy được window
        setVisible(true);
	}
	
	private void loop() throws InterruptedException, IndexOutOfBoundsException {
        for (int i = 0; i < PAIN; i++) {
            textArea.setText(Main.packshitinhere.get(0));
            Main.packshitinhere.remove(0);
            Thread.sleep(28);
        }
    }
}
