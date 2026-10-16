// ListMain.java
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ListMain extends JFrame implements ActionListener {
	JButton btn;
	List listNengo;
	JLabel lSeireki;
	JTextField tNengo, tSeireki;

	public static void main(String[] args) {
		ListMain w = new ListMain();
		w.setVisible(true); //表示する
	}
	
	public ListMain() {
		setSize(250, 240); //Window のサイズをセット
		setTitle("年号西暦変換"); // Windowのタイトルをセット

		setLayout(new GridLayout(3,2));
		listNengo = new List(4); // リスト生成
		listNengo.add("明治");
		listNengo.add("大正");
		listNengo.add("昭和");
		listNengo.add("平成");
		listNengo.select(3); // 初期値として"平成"を選択
		add(listNengo);
		tNengo = new JTextField("30");
		add(tNengo); //　年号の年を表示するテキストフィールドを配置
		add(new JLabel("西暦")); // 固定ラベルを配置
		tSeireki = new JTextField("2018");
		add(tSeireki); //　西暦の年を表示するテキストフィールドを配置
		btn = new JButton("年号→西暦");
		btn.addActionListener(this);
		add(btn);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// 年号の年数を文字列で読み込んで，整数に変換
		int seireki = Integer.parseInt(tNengo.getText());
		switch (listNengo.getSelectedIndex()) {
		case 0: // 明治
			seireki += 1867;
			break;
		case 1: // 大正
			seireki += 1911;
			break;
		case 2: // 昭和
			seireki += 1925;
			break;
		case 3: // 平成
			seireki += 1988;
			break;
		}
		tSeireki.setText(Integer.toString(seireki));
	}
}