import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GameMainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static int Width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int Height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	public static boolean isStop;
	JButton jbt_start, jbt_stop, jbt_over;
	MyPanel mypanel = new MyPanel();
	Thread thread = new Thread(mypanel);
	Music music = new Music();

	public GameMainFrame() {
		super();
		jbt_start = new JButton("¿ªÊ¼");
		jbt_start.addActionListener(this);
		jbt_stop = new JButton("ÔÝÍ£");
		jbt_stop.addActionListener(this);
		jbt_over = new JButton("½áÊø");
		jbt_over.addActionListener(this);
		JPanel jpn = new JPanel();
		jpn.add(jbt_start);
		jpn.add(jbt_stop);
		jpn.add(jbt_over);
		BorderLayout bLayout = new BorderLayout();
		setLayout(bLayout);
		add(jpn, BorderLayout.SOUTH);
		add(mypanel, BorderLayout.CENTER);
		music.playBgMusic();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		mypanel.requestFocus();
		if (arg0.getSource() == jbt_start) {
			isStop = false;
			thread.start();
		} else if (arg0.getSource() == jbt_stop) {
			isStop = true;
		} else if (arg0.getSource() == jbt_over) {
			System.exit(0);
		}
	}
}
