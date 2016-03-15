package mirror_mirror_1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Enemy {
	public static int E_ST_DEATH = 0;
	public static int E_ST_ALIVE = 1;
	public static int E_ST_BLAST = 1;
	public static int E_WIDTH = 30;
	public static int E_HEIGHT = 30;
	public static int E_MOVE = 90;
	
	private static int e_row = 1; // 가로
	private static int e_col = 2; // 세로
	private static int e_cl = 3; // 대각선 왼쪽
	private static int e_cr = 4; // 대각선 오른쪽
	
	public static int e_state=0;
	private Rectangle bb;
	private int state;
	private light light;
	private int x, y,dx,dy;
	private int move =1;
	private Image img1;
	private int start_count=0;
	private int count;
	private int prob = 0;
		
	Enemy(){
		state = E_ST_ALIVE;
		img1 = Toolkit.getDefaultToolkit().getImage("ENEMY.png");
		x=Util.rand(900-E_WIDTH-E_MOVE);   //랜덤으로 x,y값 받고
		y=Util.rand(600-E_HEIGHT-E_MOVE);  // 벽이 외부에 생겨서 벽크기만큼 뻇어요
		prob = Util.rand(100);
		if((y-y%30) < 90)
			y=y+120;
		if((x-x%30) < 90)
			x=x+120;
		dx=x-x%30;
		dy=y-y%30;
		bb = new Rectangle(x-x%30, y-y%30, E_WIDTH, E_HEIGHT); //충돌 box 만들고		
	}
	void birth(){
		
	}
	void blast(){
		state = E_ST_BLAST;
		count = 15;
	}
	Rectangle getBBox() {
		return bb;
	}
	int getX(){
		return x-x%30;
	}
	int getY(){
		return y-y%30;
	}
	
	void move(){
		if (state == E_ST_ALIVE) {
			start_count = 1;
			if (dy == (y - y % 30) - E_MOVE) { // down||
				move = 1;
				prob = Util.rand(100);
				blast();
			} else if (dy == (y - y % 30) + E_MOVE) { // up ||
				move = -1;
				prob = Util.rand(100);
				blast();
			} else if (dx == (x - x % 30) - E_MOVE) {
				move = 1;
				prob = Util.rand(100);
				blast();
			} else if (dx == (x - x % 30) + E_MOVE) {
				move = -1;
				prob = Util.rand(100);
				blast();
			}

			if (0 <= prob && prob < 25) { // 가로
				e_state = e_row;
				dx += move;
			} else if (25 <= prob && prob < 50) { // 세로
				e_state = e_col;
				dy += move;
			} else if (50 <= prob && prob < 75) { // 대각선 왼쪽
				e_state = e_cl;
				dx += move;
				dy += move;
			} else if (75 <= prob && prob <= 100) { // 대각선 아래
				e_state = e_cr;
				dx -= move;
				dy += move;
			}
			bb = new Rectangle(dx, dy, E_WIDTH, E_HEIGHT);
			if(dy >600 || dy<0 || dx >900 || dx<0)
				blast();
		}
	}
	
	int getState() {
		return state;
	}
	void draw(Graphics g) {
		if (state == E_ST_ALIVE) {
			if (start_count == 0)
				g.drawImage(img1, x - x % 30, y - y % 30, E_WIDTH, E_HEIGHT,null);
			else
				g.drawImage(img1, dx, dy, E_WIDTH, E_HEIGHT, null);
		}
		else if(state == E_ST_BLAST){
			for(int i=1;i<count;i++){
				g.setColor(Util.randColor(128,255));
				int x0 = Util.rand(-30,30);
				int y0 = Util.rand(-30,30);
				int r0 = Util.rand(5,30);
				g.fillOval(300, 300, r0, r0);
//				g.fillOval(dx, dy, E_WIDTH, E_HEIGHT);
			}
			count --;
			if(count == 0){
				state = E_ST_DEATH;
			}
		}
	}
}

