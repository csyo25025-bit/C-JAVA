import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextFieldMain2 extends JFrame implements ActionListener {
    JLabel lbl;
    JTextField textField;

    int r;
    int min = 0;
    int max = 99;
    int count=0;

    public static void main(String[] args) {
        TextFieldMain2 w = new TextFieldMain2();
        w.setVisible(true); // 表示する
    }
    
    public TextFieldMain2() {
       
        Random rand = new Random();
        r = rand.nextInt(max+1); 

        setSize(400, 100); // Window のサイズをセット
        setTitle("数当てゲーム"); // Window のタイトルをセット
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ×ボタンで終了する設定

        textField = new JTextField(); // テキストフィールド生成
        textField.addActionListener(this); // Enterキー押下時のイベントを設定
        add(textField, BorderLayout.NORTH); // テキストフィールドを北(上)に配置
        
     
        lbl = new JLabel(min + "以上, " + max + "以下の整数を入力してください"); 
        add(lbl, BorderLayout.CENTER); // ラベルを中央に配置 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if (textField.getText().equals("")) return;

        try {
            int i = Integer.parseInt(textField.getText());
            ++count;
            if(i<min||max<i) {
            	lbl.setText("範囲外です！ (" + count + "回目) " + min + "以上, " + max + "以下の整数を入力してください");
            }else if (i == r) {
            	lbl.setText("正解！ " + count + " 回目で答えの " + r + " を当てました！");
                textField.setEnabled(false); 
            } else if (i < r) {
                min = i + 1;
                if(min==max) {
                	lbl.setText("違います。(" + count + "回目)正解は"+ r +"です");
                	textField.setEnabled(false);
                }else {
                	lbl.setText("違います。(" + count + "回目) " + min + "以上, " + max + "以下の整数を入力してください");
                }
            } else {
                max = i - 1;
                if(max==min) {
                	lbl.setText("違います。(" + count + "回目)正解は"+ r +"です");
                	textField.setEnabled(false); 
                }else {
                	lbl.setText("違います。(" + count + "回目) " + min + "以上, " + max + "以下の整数を入力してください");
                }
            }
        } catch (NumberFormatException ex) {
            lbl.setText("整数を入力してください");
        }
        textField.setText("");
    }
}