// QuizMain4.java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuizMain4 extends JFrame implements ActionListener{
	JButton btn[] = new JButton[4];
	JTextField tf;
	JTextArea ta;
	Quiz4 quiz[] = new Quiz4[2];
	int currentQuiz = 0; // 現在のクイズの問題
	int score = 0; // 点数(正解数)

	public static void main(String[] args) {
		QuizMain4 w = new QuizMain4();
		w.setVisible(true); //表示する
	}

	public QuizMain4() {
		setSize(360, 200); //Window のサイズをセット
		setTitle("シンプルすぎるクイズゲーム4"); // Windowのタイトルをセット

		ta = new JTextArea(); // テキストエリア生成
		ta.setFocusable(false); // テキストエリアを手動で変更できなくする
		ta.setLineWrap(true);
		tf = new JTextField("ファイナルアンサー?"); // テキストフィールド生成
		tf.setFocusable(false); // テキストフィールドを手動で変更できなくする

		JPanel p = new JPanel(); // パネルを生成
		p.setLayout(new GridLayout(2,2)); // 2行2列のレイアウトにする
		for (int i = 0; i < 4; i++) {
			btn[i] = new JButton("ボタン"+i); // ボタンi生成
			btn[i].addActionListener(this); // ボタンiを押した時はこのクラスで処理
			p.add(btn[i]); // Panelに配置
		}

		add(tf, BorderLayout.NORTH); //　テキストフィールドを上に配置
		add(ta, BorderLayout.CENTER); //　テキストエリアを中央に配置
		add(p, BorderLayout.SOUTH); // パネルを下に配置

		initQuiz();
		showQuiz();
	}

	private void initQuiz() {
		quiz[0] = new Quiz4(1, "福山雅治", "吉川　浩", "嘉門達夫", "宮崎　駿", "応用情報工学科の教員は誰?");
		quiz[1] = new Quiz4(0, "最高", "微妙", "なんだかなぁ", "来年も受けたい", "Javaプログラミングの授業は?");
	}

	private void showQuiz() {
		ta.setText(quiz[currentQuiz].toString()); // 問題文を表示
		quiz[currentQuiz].setButton(btn); // 選択肢を表示
	}
	private void nextQuiz() {
		if (++currentQuiz < quiz.length) { // quiz.length は quiz配列の要素数，つまり問題数
			showQuiz();
		} else { // 全問回答終了
			
			ta.setText("クイズ終了\n"+quiz.length+" 問中 "+score +" 問正解です．");
			
			if(actionPerformed()==1) {
			currentQuiz=0;
			showQuiz();
			}
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()
				== btn[quiz[currentQuiz].getSeikai()]) { //押されたボタンは正解か?
			tf.setText("おめでとう，正解です!");
			score++; // 正解数を1増やす
		} else {
			tf.setText("残念，不正解です!");
		}
		nextQuiz(); // 次の問題へ
	}
	
	// 4択だからQuiz4っていう安易な命名
	public class Quiz4 {
		private int correctAnswer; // 正解の選択肢番号
		private String a0, a1, a2, a3; // 選択肢の文字列
		private String quizText; // 問題文

		public Quiz4() {}

		public Quiz4(int seikai, String ans0, String ans1, String ans2, String ans3, String quizText) {
			this.correctAnswer = seikai;
			a0 = ans0;
			a1 = ans1;
			a2 = ans2;
			a3 = ans3;
			this.quizText = quizText;
		}

		public int getSeikai() {
			return correctAnswer;
		}

		public void setButton(JButton[] btn) {
			btn[0].setText(a0);
			btn[1].setText(a1);
			btn[2].setText(a2);
			btn[3].setText(a3);
		}

		public String toString() {
			return quizText; // 問題文を返す
		}
	}
}