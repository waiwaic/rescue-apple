import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OverJFrame extends JFrame implements ActionListener {
	JLabel jlb = new JLabel(User.getName() + "��̫���ˣ���" + User.getScore() + "�֣��ؼ������");
	JButton restart = new JButton("��������");
	JButton over = new JButton("�ؼ�����");
	JPanel jpn = new JPanel();
	MyPanel mypanel;

	private static final long serialVersionUID = 1L;

	public OverJFrame() {
		super();
		setBounds(GameMainFrame.Width / 2, GameMainFrame.Height / 2, 250, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		jpn.add(jlb);
		jpn.add(restart);
		jpn.add(over);
		add(jpn);
		restart.addActionListener(this);
		over.addActionListener(this);
	}

	public void getMyPanel(MyPanel mypanel) {
		this.mypanel = mypanel;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == restart) {
			mypanel.initGame();
			setVisible(false);
		} else if (arg0.getSource() == over) {
			System.exit(0);
		}
	}
}
