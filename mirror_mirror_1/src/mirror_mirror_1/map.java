package mirror_mirror_1;

import javax.swing.JFrame;


public class map{
	public static int FRAME_W = 900;
	public static int FRAME_H = 600;
	
	public static void main(String[] arg){
		JFrame f = new JFrame("Mirror_Mirror");
		f.setSize(FRAME_W + 8,FRAME_H+34);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameComponent gc = new gameComponent();
		f.add(gc);
		f.setVisible(true);
	}
}
