package mirror_mirror_1;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JComponent;

public class Mirror extends JComponent {
	public static int MI_ST_NREFLECT = 1;
	public static int MI_ST_REFLECT = 2;
	public static int MI_WIDTH = 30;
	public static int MI_HEIGHT = 30;

	public int set_flag;
	public int x,y;
	private Image img1;	
	private Image img2;	
	private Image img3;	
	private Image img4;	
	private Rectangle bb;
	private int state;
//	private int forward_w = 0; // 거울 앞부분 
//	private int forward_h = 0; // 거울 앞부분
//	private int back_w = 0; // 거울 뒷부분
//	private int back_h = 0; // 거울 뒷부분
//	private int px1,px2,px3, py1,py2,py3, bpx1,bpx2,bpx3, bpy1,bpy2,bpy3;
	// 삼각형 포인트


	public int getX(){
		return x-x%30+15;
	}
	public int getY(){
		return y-y%30+10;
	}

	void makeMirror(){
		state = MI_ST_NREFLECT;
		set_flag = 1;
		gameComponent.room[x-x%30][y-y%30] = 1;
		Rotate(gameComponent.mi_num);
		img1 = Toolkit.getDefaultToolkit().getImage("mirror1.png");
		img2 = Toolkit.getDefaultToolkit().getImage("mirror2.png");
		img3 = Toolkit.getDefaultToolkit().getImage("mirror3.png");
		img4 = Toolkit.getDefaultToolkit().getImage("mirror4.png");
	}
	Rectangle getBBox() {
		return bb;
	}

	int getState() {
		return state;
	}
	void reflect() {
		state = MI_ST_REFLECT;
	}

	public void setPoint(int x, int y) {
		this.x=x;
		this.y=y;
	}

	void Rotate(int i){
//		System.out.println(set_flag);
		if(set_flag == 1){
//			px1 = x - x % 30;
//			px2 = x - x % 30+30;
//			px3 = x - x % 30+30;
//
//			py1 = y - y % 30;
//			py2 = y - y % 30;
//			py3 = y - y % 30+30;
//
//			bpx1 = x - x % 30 + 16;
//			bpx2 = x - x % 30+30;
//			bpx3 = x - x % 30+30;
//
//			bpy1 = y - y % 30;
//			bpy2 = y - y % 30;
//			bpy3 = y - y % 30+15;
//
//			forward_w = MI_WIDTH/2;
//			forward_h = MI_HEIGHT;
//			back_w = MI_WIDTH/4;
//			back_h = MI_HEIGHT;
			bb = new Rectangle(x-x%30+15, y-y%30, MI_WIDTH/2, MI_HEIGHT);
			set_flag = 2;
		}
		else if(set_flag == 2){  // 90도 회전
//			px1 = x - x % 30+30;
//			px2 = x - x % 30;
//			px3 = x - x % 30+30;
//
//			py1 = y - y % 30;
//			py2 = y - y % 30+30;
//			py3 = y - y % 30+30;
//
//			bpx1 = x - x % 30+30;
//			bpx2 = x - x % 30+30;
//			bpx3 = x - x % 30+15;
//
//			bpy1 = y - y % 30+15;
//			bpy2 = y - y % 30+30;
//			bpy3 = y - y % 30+30;
//
//			forward_w = MI_WIDTH;
//			forward_h = MI_HEIGHT/2;
//			back_w = MI_WIDTH;
//			back_h = MI_HEIGHT/4;
			bb = new Rectangle(x-x%30+15, y-y%30, MI_WIDTH/2, MI_HEIGHT);
			set_flag = 3;
		}
		else if(set_flag == 3){ // 180도 회전
//			px1 = x - x % 30;
//			px2 = x - x % 30;
//			px3 = x - x % 30+30;
//
//			py1 = y - y % 30;
//			py2 = y - y % 30+30;
//			py3 = y - y % 30+30;
//
//			bpx1 = x - x % 30;
//			bpx2 = x - x % 30;
//			bpx3 = x - x % 30+15;
//
//			bpy1 = y - y % 30+15;
//			bpy2 = y - y % 30+30;
//			bpy3 = y - y % 30+30;
//
//			forward_w = MI_WIDTH/2;
//			forward_h = MI_HEIGHT;
//			back_w = MI_WIDTH/4;
//			back_h = MI_HEIGHT;
			bb = new Rectangle(x-x%30, y-y%30+15, MI_WIDTH, MI_HEIGHT/2);
			set_flag = 4;
		}
		else if(set_flag == 4){ // 270도 회전
//			px1 = x - x % 30;
//			px2 = x - x % 30+30;
//			px3 = x - x % 30;
//
//			py1 = y - y % 30;
//			py2 = y - y % 30;
//			py3 = y - y % 30+30;
//
//			bpx1 = x - x % 30;
//			bpx2 = x - x % 30+15;
//			bpx3 = x - x % 30;
//
//			bpy1 = y - y % 30;
//			bpy2 = y - y % 30;
//			bpy3 = y - y % 30+15;
//
//			forward_w = MI_WIDTH;
//			forward_h = MI_HEIGHT/2;
//			back_w = MI_WIDTH;
//			back_h = MI_HEIGHT/4;
			bb = new Rectangle(x-x%30, y-y%30, MI_WIDTH, MI_HEIGHT);
			set_flag = 1;
		}
	}
	void draw(Graphics g) {
		Font fo = new Font("궁서체",Font.BOLD, 30);
		g.setFont(fo);
		if (state == MI_ST_NREFLECT) {
			//				g.setColor(Color.white);
			//				int[] xPnts = {px1,px2,px3};
			//				int[] yPnts = {py1,py2,py3};
			//				int nPnts = xPnts.length;
			//				g.fillPolygon(xPnts, yPnts, nPnts);				
			//				
			//				g.setColor(Color.LIGHT_GRAY);
			//				int[] bxPnts = {bpx1,bpx2,bpx3};
			//				int[] byPnts = {bpy1,bpy2,bpy3};
			//				int bnPnts = bxPnts.length;
			//				g.fillPolygon(bxPnts, byPnts, bnPnts);

			//				←

			g.setColor(Color.red);
			if(set_flag == 1){					
				g.drawImage(img4,x-x%30,y-y%30,30,30,null);
				g.drawString("→",x-x%30,y-y%30+15);	}
			else if(set_flag== 2){				
				g.drawImage(img1,x-x%30,y-y%30,30,30,null);
				g.drawString("↓",x-x%30,y-y%30+15);}
			else if(set_flag== 3){				
				g.drawImage(img2,x-x%30,y-y%30,30,30,null);
				g.drawString("↑",x-x%30,y-y%30+15);}
			else{				
				g.drawImage(img3,x-x%30,y-y%30,30,30,null);
				g.drawString("→",x-x%30,y-y%30+15);}
		} 

		else if (state == MI_ST_REFLECT) { // 부딪히면 색바뀜
			//				g.setColor(Color.red);
			//				int[] xPnts = {px1,px2,px3};
			//				int[] yPnts = {py1,py2,py3};
			//				int nPnts = xPnts.length;
			//				g.fillPolygon(xPnts, yPnts, nPnts);
			//				
			//				g.setColor(Color.LIGHT_GRAY);
			//				int[] bxPnts = {bpx1,bpx2,bpx3};
			//				int[] byPnts = {bpy1,bpy2,bpy3};
			//				int bnPnts = bxPnts.length;
			//				g.fillPolygon(bxPnts, byPnts, bnPnts);

			//g.drawImage(img,x-x%30,y-y%30,30,30,null);

			g.setColor(Color.ORANGE);
			if(set_flag == 1){					
				g.drawImage(img4,x-x%30,y-y%30,30,30,null);
				g.drawString("→",x-x%30,y-y%30+15);	}
			else if(set_flag== 2){				
				g.drawImage(img1,x-x%30,y-y%30,30,30,null);
				g.drawString("↓",x-x%30,y-y%30+15);}
			else if(set_flag== 3){				
				g.drawImage(img2,x-x%30,y-y%30,30,30,null);
				g.drawString("↑",x-x%30,y-y%30+15);}
			else{				
				g.drawImage(img3,x-x%30,y-y%30,30,30,null);
				g.drawString("→",x-x%30,y-y%30+15);}
		} 
	}
}
