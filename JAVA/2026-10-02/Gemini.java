import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gemini extends JFrame implements ActionListener {
    
    JButton btn1, btn2;
    JTextField tf;
    JTextArea ta;

    Quiz quiz[] = new Quiz[2];
    int currentQuiz = 0; // 現在のクイズの問題
    int score = 0; // 点数(正解数)
    
    public static void main(String[] args) {
        Gemini w = new Gemini();
        w.setVisible(true); // 表示する
    }

    public Gemini() {
        setTitle("シンプルすぎるクイズゲーム3"); // Windowのタイトルをセット
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ×ボタンでアプリ終了
        setSize(400, 300); // ウィンドウサイズの設定

        // 1. 各GUIパーツのインスタンス化
        tf = new JTextField();
        ta = new JTextArea();
        btn1 = new JButton("はい（○）");
        btn2 = new JButton("いいえ（×）");

        // 2. ボタンにイベントリスナーを登録
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        // レイアウトへの配置
        add(tf, BorderLayout.NORTH); // テキストフィールドを上に配置
        add(ta, BorderLayout.CENTER); // テキストエリアを中央に配置
        JPanel p = new JPanel(); // パネルを生成
        p.add(btn1); // ボタン1をパネルに配置
        p.add(btn2); // ボタン2をパネルに配置
        add(p, BorderLayout.SOUTH); // パネルを下に配置
     
        initQuiz();
        ta.setText(quiz[currentQuiz].toString());
    }
    
    private void initQuiz() {
        quiz[0] = new Quiz(true, "問 インドや中東で多く食べられており，平たいパンのような食べ物で，カレーとよく合う食品の名前はなんですか?");
        quiz[1] = new Quiz(false, "問 メキシコなどで多く食べられており，平たいパンのような食べ物で，すり潰したとうもろこしから作る食品の名前はなんですか?");
    }
 
    private void nextQuiz() {
        if (++currentQuiz < quiz.length) { // 問題が進む
            ta.setText(quiz[currentQuiz].toString());
        } else { // 全問回答終了
            ta.setText("クイズ終了\n" + quiz.length + " 問中 " + score + " 問正解です");
            btn1.setEnabled(false); // ボタンを無効化
            btn2.setEnabled(false);
        }
    }

    // 3. 正しいイベントハンドラメソッドに処理をまとめる
    @Override
    public void actionPerformed(ActionEvent ae) {
        // 配列の範囲外アクセスを防ぐチェック
        if (currentQuiz >= quiz.length) return;

        if ((ae.getSource() == btn1 && quiz[currentQuiz].isTrue()) ||
            (ae.getSource() == btn2 && !quiz[currentQuiz].isTrue())) {
            tf.setText("おめでとう，正解です!");
            score++; // 正解数を1増やす
        } else {
            tf.setText("残念，不正解です!");
        }
        
        // 4. カウントアップは nextQuiz() 内で行うため、ここでは currentQuiz++ は書かない
        nextQuiz(); // 次の問題へ
    }
    
    // Quizクラス
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
