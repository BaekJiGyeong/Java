package mirror_mirror_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Wall {
	public static int WALL_ST_DEATH = 0;
	public static int WALL_ST_ALIVE = 1;
	public static int WALL_ST_BLAST = 2;
	public static int WALL_WIDTH = 30;
	public static int WALL_HEIGHT = 30;
	public static int WALL_NUMBER = 30;
	private static int end_x = 880;
	private static int end_y = 500;
	private int x, y;
	private int[] emx = new int[3];
	private int[] emy = new int[3];
	private int[] ems = new int[3];
	private Rectangle bb;
	private int state;
	private Image img;	
	private light light;
	public static Rectangle endbox = new Rectangle(end_x-end_x%30, end_y-end_y%30, WALL_WIDTH, WALL_HEIGHT);

	void makewall() { // ��ֹ� ������ ����
		state = WALL_ST_ALIVE;
		getXY();
		img = Toolkit.getDefaultToolkit().getImage("wall.png");
		bb = new Rectangle(x-x%30, y-y%30, WALL_WIDTH, WALL_HEIGHT); //�浹 box �����
	}
	void getXY(){
		x=Util.rand(900-WALL_WIDTH);   //�������� x,y�� �ް�
		y=Util.rand(600-WALL_HEIGHT);  // ���� �ܺο� ���ܼ� ��ũ�⸸ŭ �P���
		gameComponent.room[x-x%30][y-y%30] = 1;  // �߰��� _ ���� �ſ��� �ȱ׷�������
		if (y > 90 && y < 150 && x < 210){ // ���ⱸ�� ��ֹ� �Ȼ��⵵��
//			System.out.println("asdfasdfasdf");
			getXY();
		}
		if (x > 730 && y > 440 && y < 550)
			getXY();
//		System.out.println("print : "+emy[0]);
		for (int i = 0; i < 1; i++){ // ���θ� �����̴� ���
//			System.out.println("qwert");
			if( ems[i] == 1 && (x-x%30)== emx[i] && (y-y%30)< emy[i]+120 && (y-y%30)> emy[i]-120){
//				System.out.println(y-y%30);
//				System.out.println("lkjklj11111111");
				getXY();
			}
			else if( ems[i] == 2 && (y-y%30)== emy[i] && (x-x%30)< emx[i]+120 && (x-x%30)> emx[i]-120) // ���θ� �����̴� ���
				getXY();
//			else if(ems[i] == 3) // �밢�� ���ʸ� �����̴� ���
//				getXY();
//			else if(ems[i] == 4) // �밢�� �����ʸ� �����̴� ���
//				getXY();
		}		
	}
	
	void setEMX(int emx){
		this.emx[gameComponent.pos_count] = emx; 
	}
	void setEMY(int emy){
		this.emy[gameComponent.pos_count] = emy;
	}
	void setEMState(int ems){
		this.ems[gameComponent.pos_count] = ems;
	}

	Rectangle getBBox() {
		return bb;
	}

	int getState() {
		return state;
	}

	void blast() {
		state = WALL_ST_BLAST;
		gameComponent.state=gameComponent.ST_END;
	}

	void draw(Graphics g) {
		if (state == WALL_ST_ALIVE) {
			g.drawImage(img,x-x%30,y-y%30, WALL_WIDTH, WALL_HEIGHT,null);


		} else if (state == WALL_ST_BLAST) { // �ε����� �ѻ���
			g.drawImage(img,x-x%30,y-y%30, WALL_WIDTH, WALL_HEIGHT,null);

		}
	}
}