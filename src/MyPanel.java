import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	static final int NUM = 5;
	char str[] = new char[NUM];
	int x[] = new int[NUM];
	int y[] = new int[NUM];
	int dead[] = new int[NUM];
	ImageIcon img_bg, img_apple, img_deadapple, img_xin;
	int count;

	public MyPanel() {
		initGame();
	}

	public void initGame() {
		img_bg = new ImageIcon("res/bg1.jpg");
		img_apple = new ImageIcon("res/apple1.png");
		img_deadapple = new ImageIcon("res/apple2.png");
		img_xin = new ImageIcon("res/xin.png");
		for (int i = 0; i < NUM; i++) {
			x[i] = (int) (Math.random() * (GameMainFrame.Width - 100));
			y[i] = -80;
			str[i] = (char) (Math.random() * 26 + 97);
		}
		count = 0;
		User.setHPNum(3);
		User.setScore(1000);
		addKeyListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img_bg.getImage(), 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Î¢ÈíÑÅºÚ", 1, 50));
		for (int i = 0; i < NUM; i++) {
			g.drawImage(img_apple.getImage(), x[i] - 20, y[i] - 60, this);
			g.drawString(String.valueOf(str[i]), x[i], y[i]);
			if (dead[i] > 0) {
				g.drawImage(img_deadapple.getImage(), dead[i] - 25, GameMainFrame.Height - 150, this);
			}
		}
		g.setColor(Color.RED);
		g.setFont(new Font("Î¢ÈíÑÅºÚ", 1, 35));
		g.drawString("·ÖÊý", 600, 70);
		g.drawString(String.valueOf(User.getScore()), 700, 70);
		g.drawImage(img_xin.getImage(), 820, 10, this);
		g.drawString(String.valueOf(User.getHPNum()), 920, 70);
		g.drawImage(img_deadapple.getImage(), 1000, 10, this);
		g.drawString(String.valueOf(count), 1100, 70);

	}

	public void keyPressed(KeyEvent arg0) {

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {
		int nowY = -1;
		int nowIndex = -1;
		for (int i = 0; i < NUM; i++) {
			if (str[i] == arg0.getKeyChar()) {
				if (nowY < y[i]) {
					nowY = y[i];
					nowIndex = i;
				}

			}

		}

		if (nowY != -1) {
			y[nowIndex] = 0;
			x[nowIndex] = (int) (Math.random() * (GameMainFrame.Width - 100));
			str[nowIndex] = (char) (Math.random() * 26 + 97);
			User.setScore(User.getScore() + 100);
		} else {
			User.setScore(User.getScore() - 100);
		}

	}

	public void run() {
		while (true) {
			if (GameMainFrame.isStop == false) {

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}

				for (int i = 0; i < NUM; i++) {
					y[i] += 1;
					if (y[i] > GameMainFrame.Height - 160) {
						dead[i] = x[i];
						if (y[i] > GameMainFrame.Height - 150) {
							y[i] = 0;
							dead[i] = 0;
							User.setScore(User.getScore() - 100);
							count++;
						}
					}
				}

				repaint();

				if (count == 10) {
					User.setHPNum(User.getHPNum() - 1);
					count -= 10;
					if (User.getHPNum() == 0 || User.getScore() == 0) {
						new OverJFrame().getMyPanel(this);
						GameMainFrame.isStop = true;
					}
				}

			}
		}

	}

}
