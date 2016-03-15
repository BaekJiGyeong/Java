package mirror_mirror_1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


class MirrorBackground {

	private int x1 = map.FRAME_W,x = map.FRAME_W; // 배경 처음 위치
	private int dx = 2;
	private Image img1,img2;
	
	MirrorBackground(){
			img1 = Toolkit.getDefaultToolkit().getImage("img1.jpg");		
			img2 = Toolkit.getDefaultToolkit().getImage("img2.jpg");
	}
	
	public void move() {
		x = x1 -= dx;
	}

	public void draw(Graphics g) {
	
		if(x1 <0){
			x1 = map.FRAME_W;
		}
		g.drawImage(this.img1, x1, 0,900,600,null);		
		if(x <0){
			x1 = map.FRAME_W;
		}
		g.drawImage(this.img2,x - map.FRAME_W,0,900,600,null);
		
	}
}