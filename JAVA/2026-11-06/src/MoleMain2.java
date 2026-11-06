// MoleMain2.java
// ボタンを押したら色が変わる
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoleMain2 extends JFrame {
	static final int N_DIV = 3; // 縦と横の分割数(定数)
	MoleButton b[] = new MoleButton[N_DIV * N_DIV];

	public static void main(String[] args) {
		MoleMain2 w = new MoleMain2();
		w.setTitle("〇×かっ!");
		w.setSize(400, 400); //Window のサイズをセット
		w.setVisible(true); //表示する
	}

	public MoleMain2() {
		setLayout(new GridLayout(N_DIV, N_DIV));
		for (int i = 0; i < N_DIV * N_DIV; i++) {
			b[i] = new MoleButton(); // ボタンi生成
			add(b[i]); // 配置
		}
	}

	public class MoleButton extends JButton implements ActionListener {
		public MoleButton() {
			addActionListener(this);
			setBackground(Color.green);
		}

		public void actionPerformed(ActionEvent ae) {
			setBackground(Color.white);
		}
	}
}