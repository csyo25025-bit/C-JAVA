// CheckBoxMain.java
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxMainrajio extends JFrame implements ItemListener {
	JLabel lb;
	Checkbox cb0, cb1, cb2;

	public static void main(String[] args) {
		CheckBoxMainrajio w = new CheckBoxMainrajio();
		w.setVisible(true); //表示する
	}
	
	public CheckBoxMainrajio() {
		setSize(250, 150); //Window のサイズをセット
		setTitle("チェックボックス"); // Windowのタイトルをセット

		lb = new JLabel("Please check"); // ラベル生成
		setLayout(new GridLayout(4,1));
		add(lb); //　ラベルを配置
		CheckboxGroup cbg = new CheckboxGroup();
		cb0 = new Checkbox("ご飯", cbg, false);
		cb0.addItemListener(this); // 変化したときはこのクラスで処理
		add(cb0);
		cb1 = new Checkbox("肉", cbg, false);
		cb1.addItemListener(this); // 変化したときはこのクラスで処理
		add(cb1);
		cb2 = new Checkbox("野菜", cbg, false);
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