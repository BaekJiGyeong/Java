// 장애물이 왔다갔다 거리는 공간에 자꾸 벽이 생김. 대각선은 하지도 못함

package mirror_mirror_1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class EnemyWall {
	public static int EW_ST_DEATH = 0;
	public static int EW_ST_ALIVE = 1;
	public static int EW_WIDTH = 30;
	public static int EW_HEIGHT = 30;
	public static int EW_MOVE = 90;
	
	private static int ew_row = 1; // 가로
	private static int ew_col = 2; // 세로
	private static int ew_cl = 3; // 대각선 왼쪽
	private static int ew_cr = 4; // 대각선 오른쪽
	
	public static int em_state=0;
	private Rectangle bb;
	private int state;
	private light light;
	private int x, y,dx,dy;
	private int move =1;
	private Image img1;
	private int start_count=0;
	private int prob = 0;
	
//	public static Rectangle endbox = new Rectangle(end_x-end_x%30, end_y-end_y%30, INT_WIDTH, INT_HEIGHT);
	
	EnemyWall(){
		state = EW_ST_ALIVE;
		img1 = Toolkit.getDefaultToolkit().getImage("wall.png");
		x=Util.rand(900-EW_WIDTH-EW_MOVE);   //랜덤으로 x,y값 받고
		y=Util.rand(600-EW_HEIGHT-EW_MOVE);  // 벽이 외부에 생겨서 벽크기만큼 뻇어요
		prob = Util.rand(49);
		if((y-y%30) < 90)
			y=y+120;
		if((x-x%30) < 90)
			x=x+120;
//		gameComponent.room[x-x%30][y-y%30] = 1;  // 추가함 _ 벽에 거울이 안그려지도록
		dx=x-x%30;
		dy=y-y%30;
		bb = new Rectangle(x-x%30, y-y%30, EW_WIDTH, EW_HEIGHT); //충돌 box 만들고		
	}
	void init(){
	}
	Rectangle getBBox() {
		return bb;
	}
	int getX(){
		return x-x%30;
	}
	int getY(){
//		System.out.println("asdf: "+ (y-y%30));
		return y-y%30;
	}
	
	void move(){
		start_count = 1;
		if (dy == (y-y%30) -EW_MOVE) { //down|| 
			move = 1; 
		}
		else if (dy == (y-y%30)+EW_MOVE){ // up ||
			move = -1;
		}
		else if(dx ==(x-x%30) -EW_MOVE){
			move = 1; 
		}
		else if(dx ==(x-x%30)+EW_MOVE){
			move = -1;
		}
		
		if(0<=prob&& prob<25){ // 가로
			em_state = ew_row;
			dx += move;
		}
		else if(25<=prob&& prob<50){ // 세로
			em_state = ew_col;
			dy += move;
		}
//		else if(50<=prob&& prob<75){ // 대각선 왼쪽
//			em_state = em_cl;
//			dx += move;
//			dy += move;
//		}
//		else if(75<=prob&& prob<=100){ // 대각선 아래
//			em_state = em_cr;
//			dx -= move;
//			dy += move;
//		}
		bb = new Rectangle(dx, dy, EW_WIDTH, EW_HEIGHT);
	}
	
	int getState() {
		return state;
	}
	void draw(Graphics g) {
		if(start_count == 0)
			g.drawImage(img1,x-x%30,y-y%30,EW_WIDTH,EW_HEIGHT,null);
		else
			g.drawImage(img1,dx,dy,EW_WIDTH,EW_HEIGHT,null);
	}
}
