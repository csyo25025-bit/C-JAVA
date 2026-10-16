// ProgressMain.java
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressMain extends JFrame implements ActionListener {
	int count=10;
	private int moreHit = count;
	JButton btn;
	JProgressBar pb;
	JLabel lb;

	public static void main(String[] args) {
		ProgressMain w = new ProgressMain();
		w.setVisible(true); //表示する
	}
	
	public ProgressMain() {
		setSize(250, 150); //Window のサイズをセット
		setTitle(+count+"たたき"); // Windowのタイトルをセット

		setLayout(new GridLayout(3,1));
		lb = new JLabel(+count+"回たたこう");
		add(lb);
		pb = new JProgressBar();
		add(pb);
		btn = new JButton("Hit me!");
		btn.addActionListener(this);
		add(btn);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (--moreHit > 0) {
			pb.setValue(count - moreHit);
			lb.setText("あと " + moreHit + " 回");
		} else {
			pb.setValue(count);
			lb.setText("終了♪");
		}
	}
}