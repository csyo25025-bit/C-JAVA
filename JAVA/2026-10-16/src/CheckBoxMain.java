// CheckBoxMain.java
import java.awt.List;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxMain extends JFrame implements ItemListener {
	JLabel lb;
	List listMenu;

	public static void main(String[] args) {
		CheckBoxMain w = new CheckBoxMain();
		w.setVisible(true); //表示する
	}
	
	public CheckBoxMain() {
		setSize(250, 150); //Window のサイズをセット
		setTitle("チェックボックス"); // Windowのタイトルをセット

		lb = new JLabel("Please check"); // ラベル生成
		setLayout(new GridLayout(2,1));
		add(lb); //　ラベルを配置
		
		List listMenu = new List(3, true); // リスト生成 trueで複数選択可
		listMenu.add("ご飯");
		listMenu.add("肉");
		listMenu.add("野菜");
		listMenu.addItemListener(this); // 変化したときはこのクラスで処理
		add(listMenu);
		
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