package fuckmylife;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static final ArrayList<String> AAAAA = new ArrayList<>();
	public static final ArrayList<String> packshitinhere = new ArrayList<>();
	public static void main(String[] args) throws InterruptedException, IOException {
		ThreadOne t2 = new ThreadOne();
		t2.setName("s");
		t2.start();
	    /*Timer timer = new Timer(10, new ActionListener() {
	    	@Override
	    	public void actionPerformed( ActionEvent e ) {
	    		try {
	    			//clear();
					
	    			System.out.println(packshitinhere.get(0));
	    			packshitinhere.remove(0);//delete things in here :?
	    		}catch(IndexOutOfBoundsException asdas) {}
	    	}
	    });
	    timer.setRepeats(true);
	    timer.start();*/
		System.out.println("bad?");
		Scanner www = new Scanner(System.in);
		String bad = www.nextLine();
		if(bad.equalsIgnoreCase("apple")) {
			System.out.println(":)");
			www.close();
			System.out.println("waiting for Ascii generating finish");
		}
		else {
			System.out.println("stoopid hooman do again");
			System.exit(-1);
		}
	}
	
	public static void clear() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
    }
	
}
