
//QuizMain.java
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuizMain extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btn1, btn2;
	JTextField tf;
	JTextArea ta;

	public static void main(String[] args) {
		QuizMain w = new QuizMain();
		w.setVisible(true); //表示する
	}
	
	public QuizMain() {
		setSize(360, 200); //Window のサイズをセット
		setTitle("シンプルすぎるクイズゲーム"); // Windowのタイトルをセット

		 // テキストエリア生成
		ta = new JTextArea("問　インドや中東で多く食べられており，平たいパンのような食べ物で，カレーとよく合う食品の名前はなんですか?");
		ta.setFocusable(false); // テキストエリアを手動で変更できなくする
		ta.setLineWrap(true); // 1行に収まらなければ改行する
		tf = new JTextField("ボタンを押して回答してください"); // テキストフィールド生成
		tf.setFocusable(false); // テキストフィールドを手動で変更できなくする
		btn1 = new JButton("はい，そうです"); // ボタン1生成
		btn1.addActionListener(this); // ボタン1を押した時はこのクラスで処理
		btn2 = new JButton("いいえ，ちがいます"); // ボタン2生成
		btn2.addActionListener(this); // ボタン2を押した時はこのクラスで処理
		
		setLayout(new GridLayout(4,1)); // 4行1列のレイアウト，すなわち垂直レイアウトを指定
		add(tf); //　テキストフィールドを配置
		add(ta); //　テキストエリアを配置
		add(btn1); // ボタン1を配置
		add(btn2); // ボタン2を配置
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn1) { // ボタンが複数あるなど，複数のイベントがあるときの区別
			tf.setText("おめでとう，正解です!");
		} else {
			tf.setText("残念，不正解です!");
		}
	}
}