package mirror_mirror_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

class light {
	public static int LIGHT_ST_DEATH = 0;
	public static int LIGHT_ST_ALIVE = 1;
	public static int LIGHT_ST_BLAST = 2;
	public int wall_impact = 0;
	public int mirror_impact = 0;
	public int pos = 0;
	public int mstate;

	private int state;
	//	private int bound=0;
	private Color cr1,cr2;
	private int x0;
	private int y0;
	private int x, y;
	private int count;
	private Rectangle bb;
	private Mirror mirror;
	int bx,by,dx,dy;

	int getState()	{ return state;}
	int getX()		{ return x;}
	int getY()		{ return y;};
	Rectangle getBBox(){return bb;}


	void startlight(){
		state=LIGHT_ST_ALIVE;
		mirror = new Mirror();
		if (gameComponent.lt_num == 0) {
			y0 = gameComponent.PIXEL * 4 - 18; //빛 시작
			x0 = 0;
		}
		//		→←↑↓
		else {
//			System.out.println(mstate);
			if (pos == 1) {
				x0 = getX();
				y0 = getY();
				if (mstate == 1) { // →(위)
					dx = 0;
					dy = y0;
					
					bx = x0;
					by = y0;
				} 
				else if (mstate == 2) { // ↓
					dx = x0;
					dy = 0;
					
					bx = x0;
					by = y0;
				} 
				else if (mstate == 3) { // ↑
					dx = x0;
					dy = 0;
					
					bx = x0;
					by = y0;
				} 
				else if (mstate == 4) { // →(아래)
					dx = 0;
					dy = y0;
					
					bx = x0;
					by = y0;
				}
				pos = 0;
			}
		}
	}
	void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setmovestate(int x){
		mstate=x;
	}

	void move(){
		if(state == LIGHT_ST_ALIVE){
			if (mirror_impact == 1 && mstate ==1) { // →(위) 완
//				System.out.println("1");
				bx +=1;
				by = y0;
				dx += 1;
				dy = y0;
//				bb = new Rectangle(x0, y0, bx, 6);
				bb = new Rectangle(bx, by, 5, 5);
			}
			else if (mirror_impact == 1 && mstate ==2) { // ↓ 완
//				System.out.println("2");
				bx = bx;
				by += 1;
				dx = dx;
				dy += 1;
//				bb = new Rectangle(x0, y0, 6, by);
				bb = new Rectangle(bx, by, 5, 5);
			}
			else if (mirror_impact == 1 && mstate ==3) { // ↑
//				System.out.println("3");
				bx = bx;
				y0 -= 1;          ///////////////////////////////////////// 여기 문제 발생인거 같음
				by = y0;
				
				dx = dx;
				dy += 1;
//				bb = new Rectangle(x0, y0, 6, by);
				bb = new Rectangle(bx, by+11, 5, 5);
			}
			else if (mirror_impact == 1 && mstate == 4) { // →(아래) 완 
//				System.out.println("4");
				bx +=1;
				by = y0;
				dx += 1;
				dy = y0;
//				bb = new Rectangle(x0, y0, bx, 6);
				bb = new Rectangle(bx, by, 5, 5);
			}
			else{ 
				bx+=1;
				by=y0;
				dx += 1;
				dy = y0;
//				bb = new Rectangle(x0,y0,bx,6);
				bb = new Rectangle(bx, by, 5, 5);
			}
//			bb = new Rectangle(bx,by,6,6);
			if(map.FRAME_W<bx){
				state=LIGHT_ST_DEATH;
			}
		}
	}
	void stop(){
		dx = dy = bx = by = x0 = y0 = 0;
		bb = new Rectangle(0,0,0,0);
		
	}

	void blast(){
		if(state==LIGHT_ST_ALIVE) //앞으로 가는중이었으면 뒤로
			state = LIGHT_ST_DEATH; 
	}

	void draw(Graphics g){
		if(state == LIGHT_ST_ALIVE){
			g.setColor(Util.randColor());
			if (mstate == 0) { // 초기값 _ 완
				g.fillRect(x0, y0, dx, 7);
				for (int i = 0; i < 1; i++)
					g.fillOval(dx - 2, dy - 1, 8, 8);
			}

			else if(mstate == 1) { // → (위)  완
				g.fillRect(x0, y0, dx, 7);
				for (int i = 0; i < 1; i++)
					g.fillOval(dx+x0 - 2, dy - 1, 8, 8);
			}

			else if(mstate == 2){  // ↓ 완
				g.fillRect(x0, y0, 7, dy);
				for (int i = 0; i < 1; i++)
					g.fillOval(dx - 1, y0 +dy-2, 8, 7);
			}

			else if(mstate == 3){  // ↑ 완
				g.fillRect(x0, y0, 7, dy);
				for (int i = 0; i < 1; i++)
					g.fillOval(dx - 1, y0-2, 8, 7);
			}

			else if(mstate == 4){   //→ (아래) 완
				g.fillRect(x0, y0, dx, 7);
				for (int i = 0; i < 1; i++)
					g.fillOval(dx+x0-2, dy - 1, 8, 8);
			}
		}		
	}
}
