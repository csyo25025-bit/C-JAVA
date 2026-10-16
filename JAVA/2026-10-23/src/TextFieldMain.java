import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextFieldMain extends JFrame implements ActionListener {
    JLabel lbl;
    JTextField textField;

    public static void main(String[] args) {
        TextFieldMain w = new TextFieldMain();
        w.setVisible(true); // 表示する
    }
    
    public TextFieldMain() {
        setSize(400, 100); // Window のサイズをセット
        setTitle("倍返しだ!"); // Window のタイトルをセット
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ×ボタンで終了する設定

        textField = new JTextField(); // テキストフィールド生成
        textField.addActionListener(this); // Enterキー押下時のイベントを設定
        add(textField, BorderLayout.NORTH); // テキストフィールドを北(上)に配置
        
        lbl = new JLabel("数値を入力して，Enterを押してください"); // ラベルの生成 
        add(lbl, BorderLayout.CENTER); // ラベルを中央に配置
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            int i = Integer.parseInt(textField.getText());
            i = i * 2; // 入力値を2倍にする
            textField.setText(Integer.toString(i)); // 2倍した値をテキストフィールドに戻す
            lbl.setText("倍返しだ!");
        } catch (NumberFormatException ex) {
            lbl.setText("整数値ではありません");
        }
        // 末尾にあった不要な textField.setText(Integer.toString(i)); は削除
    }
}