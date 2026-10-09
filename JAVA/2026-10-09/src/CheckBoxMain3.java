// CheckBoxMain.java
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxMain3 extends JFrame implements ActionListener,ItemListener {
	JButton btn;
	JLabel lb;
	CheckPrice cb0, cb1, cb2,cb3;
	int sum;

	public static void main(String[] args) {
		CheckBoxMain3 w = new CheckBoxMain3();
		w.setVisible(true); //表示する
	}
	
	public CheckBoxMain3() {
		setSize(250, 150); //Window のサイズをセット
		setTitle("チェックボックス"); // Windowのタイトルをセット

		lb = new JLabel("Please check"); // ラベル生成
		setLayout(new GridLayout(5,1));
		add(lb); //　ラベルを配置
		cb0 = new CheckPrice("ご飯 100円", 100);
		cb0.addItemListener(this); // 変化したときはこのクラスで処理
		add(cb0);
		cb1 = new CheckPrice("肉 250円",250);
		cb1.addItemListener(this); // 変化したときはこのクラスで処理
		add(cb1);
		cb2 = new CheckPrice("野菜 150円",150);
		cb2.addItemListener(this); // 変化したときはこのクラスで処理
		add(cb2);
		btn = new JButton("計算");
		btn.addActionListener((ActionListener) this);
		add(btn, BorderLayout.SOUTH);
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		String str;
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			str = " のチェックが 入り ました";
		} else {
			str = " のチェックが 外れ ました";
		}
		lb.setText(arg0.getItem()+str);
	}
	public class CheckPrice extends Checkbox {
		private int price; // 価格
		
		public CheckPrice(String string, int i) {
			super(string); // 親クラスのコンストラクタを呼ぶ
			price = i; // 価格をセット
		}

		public int getPrice() {
			if (getState()) 
				return price; // チェックされていれば価格を返す
			else
				return 0; // チェックされていなければ0を返す
		}
	}
	public void actionPerformed(ActionEvent ae) {
		sum=0;
		sum=sum+cb0.getPrice();
		sum=sum+cb1.getPrice();
		sum=sum+cb2.getPrice();
		lb.setText("合計:"+sum +"円です");
	}
}