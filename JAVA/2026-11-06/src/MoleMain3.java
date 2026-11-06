// MoleMain3.java
// ボタンを押したら色が変わる
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoleMain3 extends JFrame {
	static final int N_DIV = 8; // 縦と横の分割数(定数)
	MoleButton b[] = new MoleButton[N_DIV * N_DIV];

	int tarn=1;
	
	public static void main(String[] args) {
		MoleMain3 w = new MoleMain3();
		w.setTitle("リバーシ");
		w.setSize(400, 400); //Window のサイズをセット
		w.setVisible(true); //表示する
	}

	public MoleMain3() {
		setLayout(new GridLayout(N_DIV, N_DIV));
		for (int i = 0; i < N_DIV * N_DIV; i++) {
			b[i] = new MoleButton(); // ボタンi生成
			add(b[i]); // 配置
		}
	}

	public class MoleButton extends JButton implements ActionListener {
		int state=0;
		
		public MoleButton() {
			addActionListener(this);
			setBackground(Color.green);
			state=0;
		}
		
			public void actionPerformed(ActionEvent ae) {
			if(state==0) {
				if(tarn==1) {
						setBackground(Color.white);
						state=1;
						tarn=2;
					}
				else if(tarn==2) {
					setBackground(Color.black);
					state=2;
					tarn=1;
				}
			}
			else{
					setBackground(Color.green);
					state=0;
					if(tarn==1) {
						tarn=2;
					}
					else if(tarn==2) {
						tarn=1;
					}
				}
			}
		
		}
}