import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoleMain3 extends JFrame {
    static final int N_DIV = 8; // 縦と横の分割数(定数)
    MoleButton b[] = new MoleButton[N_DIV * N_DIV];

    int tarn = 1;
    int countB = 0;
    int countW = 0;

    public static void main(String[] args) {
        MoleMain3 w = new MoleMain3();
        w.setSize(400, 400); // Window のサイズをセット
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 閉じるボタンで終了
        w.setVisible(true); // 表示する
    }

    public MoleMain3() {
        setLayout(new GridLayout(N_DIV, N_DIV));
        for (int i = 0; i < N_DIV * N_DIV; i++) {
            b[i] = new MoleButton(); // ボタンi生成
            add(b[i]); // 配置
        }
        updateTitle(); // 初期タイトルの表示
    }

    // 【追加】現在のカウントをタイトルバーに反映させるメソッド
    public void updateTitle() {
        setTitle("リバーシ (白: " + countW + ", 黒: " + countB + ")");
    }

    public class MoleButton extends JButton implements ActionListener {
        int state = 0;

        public MoleButton() {
            addActionListener(this);
            setOpaque(true);
            setBorderPainted(true);
            setBackground(Color.green);
            state = 0;
        }

        public void actionPerformed(ActionEvent ae) {
            if (state == 0) {
                if (tarn == 1) {
                    setBackground(Color.white);
                    state = 1;
                    tarn = 2;
                    countW = countW + 1;
                } else if (tarn == 2) {
                    setBackground(Color.black);
                    state = 2;
                    tarn = 1;
                    countB = countB + 1;
                }
            } else {
                // 白または黒から緑（未配置）に戻すときのカウント減算
                if (state == 1) {
                    countW = countW - 1;
                } else if (state == 2) {
                    countB = countB - 1;
                }

                setBackground(Color.green);
                state = 0;
                if (tarn == 1) {
                    tarn = 2;
                } else if (tarn == 2) {
                    tarn = 1;
                }
            }
            
            // 【追加】ボタンを押すたびにタイトルバーの表示を更新
            updateTitle();
        }
    }
}