// ScrollMain.java
import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class ScrollMain extends JFrame implements AdjustmentListener{
	JScrollBar scrollBar;
	JLabel label;
	int scrollValue = 100;
	
	public static void main(String[] args) {
		ScrollMain w = new ScrollMain();
		w.setTitle("スクロールバーのテスト");
	    w.setSize(350, 150); //Window のサイズをセット
		w.setVisible(true); //表示する
	}

	ScrollMain() {
	    //scrollBar = new JScrollBar();
	    scrollBar = new JScrollBar(Adjustable.HORIZONTAL, 255, 10, 0, 265);
	    scrollBar.addAdjustmentListener(this);
	    add(scrollBar, BorderLayout.CENTER);

	    label = new JLabel("0");
	    add(label, BorderLayout.NORTH);

	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent ae) {
		scrollValue = ae.getValue();
		label.setText(Integer.toString(scrollValue));
		scrollBar.setBackground(new Color(scrollValue, scrollValue, scrollValue));
	}
}