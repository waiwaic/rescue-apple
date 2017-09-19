import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginJFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JPanel jpn = new JPanel();
	TextField txf = new TextField(10);
	JButton jbt = new JButton("进入游戏");
	JLabel jlb = new JLabel("请输入用户名");
	
	public LoginJFrame() {
		super();
		jpn.add(jlb);
		jpn.add(txf);
		jpn.add(jbt);
		add(jpn);
		jbt.addActionListener(this);
		setBounds(GameMainFrame.Width / 2, GameMainFrame.Height / 2, 200, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LoginJFrame();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jbt) {
			User.setName(txf.getText());
			new GameMainFrame();
			setVisible(false);
		}
	}
}
