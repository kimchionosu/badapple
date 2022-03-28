package fuckmylife;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.Format;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;

public class ThreadOne extends Thread {
	
	public static ThreadOne t = new ThreadOne();
	private static final String white = ".";
	private static final String black = "#";
	private static final String huh = " ";
	public static boolean iscalled;
	public boolean fuckmylife;
	static int i = 0;
	public void run() {
		startGet();
	}
	
	private static void startGet() {
		try {
			iscalled = true;
			AAAAA("D:\\dddd\\game\\badapple.mp4");
		} catch (IOException | JCodecException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int aAAaaAa(String aaa) throws IOException {
		Format aAa = JCodecUtil.detectFormat(new File(aaa));
		Demuxer aaAaA = JCodecUtil.createDemuxer(aAa, new File(aaa));
		DemuxerTrack aaAa = aaAaA.getVideoTracks().get(0);
		DemuxerTrackMeta aaaa = aaAa.getMeta();

		int aAaAA = aaaa.getTotalFrames();
		//System.out.println("video_frame: " + aAaAA);
		return aAaAA;
	}

	//BufferedImage
	public static void AAAAA(String Aaaa) throws IOException, JCodecException, InterruptedException {
		int AaAA = aAAaaAa(Aaaa);
		File AaaaAa = new File(Aaaa);
		
		FrameGrab AaaAAaAaAa = FrameGrab.createFrameGrab(NIOUtils.readableChannel(AaaaAa));

		for (int AaAAAaAA = 0; AaAAAaAA < AaAA; AaAAAaAA++) {
		    Picture AaaAAaAaAaAAA = AaaAAaAaAa.getNativeFrame();
		    BufferedImage AaaaAaAA = AWTUtil.toBufferedImage(AaaAAaAaAaAAA);
		    AaAAAaAA(AaaaAaAA);
		    if(Main.AAAAA.size() % AaaaAaAA.getHeight() == 0) {
	    		StringBuilder aa = new StringBuilder();
		    	for(int a = 0; a < AaaaAaAA.getHeight(); a++) {
		    		aa.append("\r\n" + Main.AAAAA.get(0));
		    		Main.AAAAA.remove(0);
		    	}
	    		Main.packshitinhere.add(aa.toString());
	    		aa.setLength(0);
		    }
		}
		Main.AAAAA.clear();
		System.out.println("play in 5 secs");
		
		Thread.sleep(5000L);
		//create window
		FrameThatFuckMyLife fuckmylife = new FrameThatFuckMyLife(0, 0, 115*5, 144*5);
	}
	
	//Run through every pixel to say if that is an white or black and put in array
	private static void AaAAAaAA(BufferedImage aaa) {
		StringBuilder builder = new StringBuilder();
		for(int a = 0; a < aaa.getHeight(); ++a) {
			for(int aa = 0; aa < aaa.getWidth(); aa++) {
				int rgb = aaa.getRGB(aa, a);
				Color color = new Color(rgb);
				int red = color.getRed();
				int blue = color.getBlue();
				int green = color.getGreen();
				float luminance = (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;
				if (luminance >= 0.5f) {
					builder.append(black);
				} else {
					builder.append(white);
				}

				if(builder.length() == aaa.getWidth()) {
					Main.AAAAA.add(builder.toString());
					builder.setLength(0);
				}
			}
		}
		i++;
		System.out.println(i);
	}
}
