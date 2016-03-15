package mirror_mirror_1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class gameComponent extends JComponent{
	public static int TIME_SLICE1 = 15;
	public static int TIME_SLICE2 = 10;
	public static int MAX_MI_COUNT=5;
	public static int MAX_LT_COUNT = MAX_MI_COUNT+1;
	public static int MAX_EW_COUNT = 3;
	public static int MAX_E_COUNT = 2;
	public static int PIXEL =30;
	public static int mi_num=0;
	public static int lt_num=0;
	public static int peak =0;
//	public static int sub_prob = 0; // 같은 장애물 재생성 방지 확률 카운트 _ 필요 없다

	public static int ST_TITLE = 0;
	public static int ST_GAME = 1;
	public static int ST_END = 2;
	public static int ST_CLEAR = 3;
	
	static int state=0;

	public static int pos_count;
	public static int[][] room = new int[map.FRAME_W][map.FRAME_H];
	public static int MAX_WALL_COUNT=40;/////////////////////////
	private Wall[] wall;//////////////////////////
	int mcount = 0; // loop문에서 거울 증가시킬지 말지 결정하는
	int lcount = 0; // 빛이 벽에 부딪혀서 사라지게 하기 위한 count

	private Timer t1;
	private Timer t2;
	private light[] lt;
	private Mirror[] mirror;
	private MirrorBackground bgi;
	private EnemyWall[] enemy_wall;
	private Enemy[] enemy;

	gameComponent(){
		init();
		t1.start();
//		t2.start();
	}
	void init(){
		for(int i=0;i<map.FRAME_W;i++)
			for(int j=0;j<map.FRAME_H;j++)
				room[i][j] = 0;

		t1 = new Timer(TIME_SLICE1,new TimerHandler1());
//		t2 = new Timer(TIME_SLICE2,new TimerHandler2());
		bgi = new MirrorBackground();
		
		this.addKeyListener(new KeyHandler());	
		this.setFocusable(true);
		
		mirror = new Mirror[MAX_MI_COUNT];
		for(int i=0;i<MAX_MI_COUNT;i++){
//			mirror[i].setPoint(0,0);
			mirror[i] = new Mirror();
		}
		addMouseListener(new MouseEventHdl());
		
		enemy_wall = new EnemyWall[MAX_EW_COUNT];
		for(int i=0;i<MAX_EW_COUNT;i++){
			enemy_wall[i] = new EnemyWall();
		}
		
		enemy = new Enemy[MAX_E_COUNT];
		for(int i=0;i<MAX_E_COUNT;i++){
			enemy[i] = new Enemy();
		}
		
		wall = new Wall[MAX_WALL_COUNT];
		for(int i=0; i<MAX_WALL_COUNT; i++){
			wall[i] = new Wall();
		}
		for(int i=0; i<MAX_WALL_COUNT; i++){
			for (pos_count = 0; pos_count < 1; pos_count++) {
				wall[i].setEMX(enemy_wall[pos_count].getX());
				wall[i].setEMY(enemy_wall[pos_count].getY());
				wall[i].setEMState(enemy_wall[pos_count].em_state);
			}
			wall[i].makewall();
		}
		
		lt = new light[MAX_LT_COUNT];
		for(int i=0;i<MAX_LT_COUNT;i++){
			lt[i] = new light();
		}
	}
	class TimerHandler2 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
//			for(EnemyWall ew : enemy_wall){
//				if(ew.getState() == EnemyWall.EM_ST_ALIVE){
//					Rectangle ewbb = ew.getBBox();
//					if(lt[lt_num].getState() == lt[lt_num].LIGHT_ST_ALIVE){
//						if(ewbb.intersects(lt[lt_num].getBBox())){
//							lt[lt_num].wall_impact = 1;
//							lt[lt_num].blast();
//							lcount = 1;
//							state = ST_END;
//						}
//					}
//				}
//			}
//			if (peak == 2) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		
	}
	class TimerHandler1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(state == ST_GAME){
				lt[lt_num].startlight();
				lt[lt_num].move();
				bgi.move();
				for(int i=0;i<MAX_EW_COUNT;i++)
					enemy_wall[i].move();
				
				for(int i=0;i<MAX_E_COUNT;i++)
					enemy[i].move();

				for (Mirror mi : mirror) {
					if (mi.getState() == Mirror.MI_ST_NREFLECT) {
						Rectangle msbb = mi.getBBox();

						if (lt[lt_num].getState() == lt[lt_num].LIGHT_ST_ALIVE) {
							if (msbb.intersects(lt[lt_num].getBBox())) {
								mi.reflect();
								lt_num++;
								lt[lt_num].mirror_impact =1;
								lt[lt_num].setmovestate(mi.set_flag);
								lt[lt_num].setXY(mi.getX(), mi.getY());
								lt[lt_num].pos = 1;
							}
						}
					}
				}
				for (Wall wl : wall) {////////////////////////////////
					if(wl.getState() == Wall.WALL_ST_ALIVE){ // 벽에 부딪히면 충돌반응
						Rectangle wsbb = wl.getBBox();
						if (lt[lt_num].getState() == lt[lt_num].LIGHT_ST_ALIVE) {
							if (wsbb.intersects(lt[lt_num].getBBox())) {
								lt[lt_num].wall_impact = 1;
								lt[lt_num].blast();
								wl.blast();
								lcount = 1;
							}
							if (Wall.endbox.intersects(lt[lt_num].getBBox())) {
								state = ST_CLEAR;
							}
						}
					}
				}
			}
			else if(state == ST_END){
				for (light l : lt){
					l.stop();
				}
				lt_num=0;				
			}
			
			for(EnemyWall em : enemy_wall){
				if(em.getState() == EnemyWall.EW_ST_ALIVE){
					Rectangle embb = em.getBBox();
					if(lt[lt_num].getState() == lt[lt_num].LIGHT_ST_ALIVE){
						if(embb.intersects(lt[lt_num].getBBox())){
							lt[lt_num].wall_impact = 1;
							lt[lt_num].blast();
							lcount = 1;
							state = ST_END;
						}
					}
				}
			}
			
			for(Enemy enemy : enemy){
				if(enemy.getState() == EnemyWall.EW_ST_ALIVE){
					Rectangle ebb = enemy.getBBox();
					if(lt[lt_num].getState() == lt[lt_num].LIGHT_ST_ALIVE){
						if(ebb.intersects(lt[lt_num].getBBox())){
							lt[lt_num].wall_impact = 1;
							lt[lt_num].blast();
							lcount = 1;
							state = ST_END;
						}
					}
				}
			}
//			System.out.println(lt[lt_num].by);
			if(lt[lt_num].bx >900 || lt[lt_num].by >600)
				state = ST_END;
			repaint();
		}
	}
	public void paintComponent (Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, map.FRAME_W,map.FRAME_H);
//		for(int i=1;i<map.FRAME_W/PIXEL;i++)
//			for(int j=1;j<map.FRAME_H/PIXEL;j++){
//				int x=PIXEL*i;
//				int y=PIXEL*j;
//				g.setColor(Util.randColor(10,200));
//				g.fillOval(x-1,y-1,2,2);
//			}
		bgi.draw(g);
	
		//if(lcount == 0)
		for(light l : lt)
			l.draw(g);
		for (Wall wl : wall)//////////////////////
			wl.draw(g);
		
		for(EnemyWall ew : enemy_wall)
			ew.draw(g);
		
		for(Enemy enemy : enemy)
			enemy.draw(g);

		if(state==ST_TITLE){
			Font fo = new Font(Font.SANS_SERIF,Font.BOLD, 100);  //제목화면
			g.setColor(Color.white);
			g.setFont(fo);
			g.drawString("MIRROR_MIRROR", 20, 250);

			fo = new Font(Font.SANS_SERIF,Font.BOLD, 50);
			g.setColor(Color.white);
			g.setFont(fo);
			g.drawString("PRESS SPACE BAR",200,350);
			
			fo = new Font("궁서체",Font.ITALIC, 30);	
			g.setFont(fo);
			g.setColor(Color.WHITE);
			g.drawString("<<시작",0,PIXEL*4);
			g.drawString("종료>>",800,500);

		}
		if(state==ST_GAME){
			Font fo = new Font("궁서체",Font.ITALIC, 30);		//게임화면
			g.setFont(fo);
			g.setColor(Color.WHITE);
			g.drawString("<<시작",0,PIXEL*4);
			g.drawString("종료>>",800,500);
		}
		if(state==ST_END){
			Font fo = new Font(Font.SANS_SERIF,Font.BOLD, 130); //종료화면
			g.setColor(Color.white);
			g.setFont(fo);
			g.drawString("GAME OVER",20,250);

			fo = new Font(Font.SANS_SERIF,Font.BOLD, 50);
			g.setColor(Color.white);
			g.setFont(fo);
			g.drawString("PRESS ENTER KEY",200,350);
		}
		
		if(state==ST_CLEAR){
			Font fo = new Font(Font.SANS_SERIF,Font.BOLD, 130); //종료화면
			g.setColor(Color.white);
			g.setFont(fo);
			g.drawString("GAME CLEAR",20,250);

			fo = new Font(Font.SANS_SERIF,Font.BOLD, 50);
			g.setColor(Color.white);
			g.setFont(fo);
			g.drawString("PRESS ENTER KEY",200,350);
		}

		for(Mirror mi : mirror)
			mi.draw(g);

	}
	class KeyHandler extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int code = e.getKeyCode();
			if(state ==ST_TITLE){
				if(code == KeyEvent.VK_SPACE){
					state = ST_GAME;
					t1.start();
				}
			}
			else if (state==ST_END){
				if (code ==KeyEvent.VK_ENTER){
					state = ST_TITLE;
					t1.stop();
					mi_num = lt_num = 0;
					for(int i=0;i<map.FRAME_W;i++){
						for(int j=0;j<map.FRAME_H;j++){
							room[i][j] = 0;
						}
					}
					init();
					t1.start();
				}
			}
			else if (state==ST_CLEAR){
				if (code ==KeyEvent.VK_ENTER){
					state = ST_TITLE;
					t1.stop();
					mi_num = lt_num = 0;
					for(int i=0;i<map.FRAME_W;i++){
						for(int j=0;j<map.FRAME_H;j++){
							room[i][j] = 0;
						}
					}
					init();
					t1.start();
				}
			}
			repaint();
		}		
	}

	class MouseEventHdl extends MouseAdapter {
		private Graphics g;

		public void mousePressed(MouseEvent e) { // 이벤트 처리기
			int i = 0;
			if (mi_num == 0 && room[e.getX() - e.getX() % 30][e.getY() - e.getY()%30] == 0) {
				mirror[mi_num].setPoint(e.getX(), e.getY());
				mirror[mi_num].makeMirror();
				mi_num++;
			}
			else {
				while(i <mi_num){
					if (room[e.getX() - e.getX() % 30][e.getY() - e.getY()%30] == 1) {
						// e.getx,y를 통해 칸 안에 입력된 좌표들이 있으면 거울을 돌릴 수 있도록 하는 조건문
						if(mirror[i].x - mirror[i].x% 30 <= e.getX()
								&& e.getX() < mirror[i].x - mirror[i].x % 30 + 30
								&& mirror[i].y - mirror[i].y % 30 <= e.getY()
								&& e.getY() < mirror[i].y - mirror[i].y % 30 + 30){
							mirror[i].Rotate(i);
						}
					}
					else {
						if (mi_num < MAX_MI_COUNT) {
							System.out.println("make");
							mirror[mi_num].setPoint(e.getX(), e.getY());
							mirror[mi_num].makeMirror();
							mcount =1;
						}
					} i++;
				}
				if(mi_num < MAX_MI_COUNT && mcount == 1){
					mi_num++;
					mcount = 0;
				}
			}
		}
	}
}