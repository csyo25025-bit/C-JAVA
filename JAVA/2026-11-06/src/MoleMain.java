// MoleMain.java
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MoleMain extends JFrame {
    static final int N_DIV = 3; // 縦と横の分割数(定数)
    MoleButton b[] = new MoleButton[N_DIV * N_DIV];
    public static void main(String[] args) {
        MoleMain w = new MoleMain();
        w.setTitle("もぐら叩きっぽい");
        w.setSize(400, 400); //Window のサイズをセット
        w.setVisible(true); //表示する
    }
    public MoleMain () {
        setLayout(new GridLayout(N_DIV, N_DIV));
        for (int i = 0; i < N_DIV * N_DIV; i++) {
            b[i] = new MoleButton("穴"+i); // ボタンi生成
            add(b[i]); // 配置
        }        
    }
    public class MoleButton extends JButton implements ActionListener {
        public MoleButton(String string) {
            super(string);
            addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae) {
            setText("叩いた");
        }
    }
}