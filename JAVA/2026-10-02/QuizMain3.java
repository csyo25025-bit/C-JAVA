// QuizMain3.java 
// 完全なコードではないので注意
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuizMain3 extends JFrame implements ActionListener{
    
	JButton btn1, btn2;
	JTextField tf;
	JTextArea ta;

	
	Quiz quiz[] = new Quiz[2];
    int currentQuiz = 0; // 現在のクイズの問題
    int score = 0; // 点数(正解数)
    
    public static void main(String[] args) {
		QuizMain3 w = new QuizMain3();
		w.setVisible(true); //表示する
	}

    public QuizMain3() {
    	setTitle("シンプルすぎるクイズゲーム3"); // Windowのタイトルをセット

    	
    	add(tf, BorderLayout.NORTH); //　テキストフィールドを上に配置
    	add(ta, BorderLayout.CENTER); //　テキストエリアを中央に配置
    	JPanel p = new JPanel(); // パネルを生成
    	p.add(btn1); // ボタン1をパネルに配置
    	p.add(btn2); // ボタン2をパネルに配置
    	add(p, BorderLayout.SOUTH); // パネルを下に配置
     
    	initQuiz();
    	ta.setText(quiz[currentQuiz].toString());
    }
    
    private void initQuiz() {
    	quiz[0] = new Quiz(true, "問　インドや中東で多く食べられており，平たいパンのような食べ物で，カレーとよく合う食品の名前はなんですか?");
    	quiz[1] = new Quiz(false, "問　メキシコなどで多く食べられており，平たいパンのような食べ物で，すり潰したとうもろこしから作る食品の名前はなんですか?");
    }
 
    private void nextQuiz() {
    	if (++currentQuiz < quiz.length) { // quiz.length は quiz配列の要素数，つまり問題数
    		ta.setText(quiz[currentQuiz].toString());
    	} else { // 全問回答終了
    		ta.setText("クイズ終了\n"+quiz.length+" 問中 "+score+" 問正解です");
    	}
    }

    public void actionPerformed1(ActionEvent ae) {
    	if ((ae.getSource() == btn1) && quiz[currentQuiz].isTrue() ||
    		(ae.getSource() == btn2) && !quiz[currentQuiz].isTrue())
    	{ // ボタンとクイズのはい，いいえが一致したら正解
    		tf.setText("おめでとう，正解です!");
    		score++; // 正解数を1増やす
    		currentQuiz++;
    	} else {
    		tf.setText("残念，不正解です!");
    		currentQuiz++;
    	}
    	nextQuiz(); // 次の問題へ
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Quiz.java
	// このコードは変更しなくてよい
	public class Quiz {
		private boolean isTrue; // 正しいかどうかのフラグ
		private String quizText; // 問題文

		public Quiz() {}
		
		public Quiz(boolean isTrue, String quizText) {
			this.isTrue = isTrue;
			this.quizText = quizText;
		}
		
		public boolean isTrue() {
			return isTrue;
		}
		
		public String toString() {
			return quizText;
		}
	}
	
}