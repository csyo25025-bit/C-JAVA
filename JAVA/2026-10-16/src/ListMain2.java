import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class ListMain2 extends JFrame implements ActionListener {
    JButton btn, btn2;
    List listNengo;
    JSpinner sNengo, sSeireki;

    public static void main(String[] args) {
        ListMain2 w = new ListMain2();
        w.setVisible(true);
    }
    
    public ListMain2() {
        setSize(250, 240);
        setTitle("年号西暦変換");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ウィンドウを閉じたら終了する設定

        setLayout(new GridLayout(3, 2));
        
        listNengo = new List(5);
        listNengo.add("明治");
        listNengo.add("大正");
        listNengo.add("昭和");
        listNengo.add("平成");
        listNengo.add("令和");
        listNengo.select(3); 
        add(listNengo);
        
        sNengo = new JSpinner();
        sNengo.setValue(26);
        add(sNengo);
        
        add(new JLabel("西暦"));
        
        sSeireki = new JSpinner();
        sSeireki.setValue(2014);
        add(sSeireki);
        
        btn = new JButton("年号→西暦");
        btn.addActionListener(this);
        add(btn);
        
        btn2 = new JButton("西暦→年号");
        btn2.addActionListener(this);
        add(btn2); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if (ae.getSource() == btn) {
            int seireki = (int) sNengo.getValue();
            switch (listNengo.getSelectedIndex()) {
            case 0: // 明治
                seireki += 1867;
                break;
            case 1: // 大正
                seireki += 1911;
                break;
            case 2: // 昭和
                seireki += 1925;
                break;
            case 3: // 平成
                seireki += 1988;
                break;
            case 4: // 令和
                seireki += 2018;
                break;
            }
            sSeireki.setValue(seireki);
        }
        
        if (ae.getSource() == btn2) {
            int seireki = (int) sSeireki.getValue();
            int nengo = 0;
            
            if (seireki >= 2019) { // 令和 
                nengo = seireki - 2018;
                listNengo.select(4);
            } else if (seireki >= 1989) { // 平成
                nengo = seireki - 1988;
                listNengo.select(3);
            } else if (seireki >= 1926) { // 昭和
                nengo = seireki - 1925;
                listNengo.select(2);
            } else if (seireki >= 1912) { // 大正 
                nengo = seireki - 1911;
                listNengo.select(1);
            } else if (seireki >= 1868) { // 明治 
                nengo = seireki - 1867;
                listNengo.select(0);
            }
            
            sNengo.setValue(nengo);
        } 
    } 
}