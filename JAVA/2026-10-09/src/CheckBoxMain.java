// CheckBoxMain.java
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxMain extends JFrame implements ItemListener {
	JLabel lb;
	Checkbox cb0, cb1, cb2;

	public static void main(String[] args) {
		CheckBoxMain w = new CheckBoxMain();
		w.setVisible(true); //表示する
	}
	
	public CheckBoxMain() {
		setSize(250, 150); //Window のサイズをセット
		setTitle("チェックボックス"); // Windowのタイトルをセット

		lb = new JLabel("Please check"); // ラベル生成
		setLayout(new GridLayout(4,1));
		add(lb); //　ラベルを配置
		cb0 = new Checkbox("ご飯");
		cb0.addItemListener(this); // 変化したときはこのクラスで処理
		add(cb0);
		cb1 = new Checkbox("肉");
		cb1.addItemListener(this); // 変化したときはこのクラスで処理
		add(cb1);
		cb2 = new Checkbox("野菜");
		cb2.addItemListener(this); // 変化したときはこのクラスで処理
		add(cb2);
		
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
}