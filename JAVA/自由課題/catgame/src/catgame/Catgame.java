package catgame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Catgame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btn[]=new JButton[2];
	JTextField TF;
	JTextArea TA;
	
	int q=5;
	
	Ques ques[]=new Ques[q];
	
	int currentQues=0;
	int score=0;
	float reslt=0;
	
	public static void main(String[] args) {
		
		Catgame w=new Catgame();
		w.setVisible(true);
		
	}
	
	public Catgame() {
		
		setSize(360,200);
		setTitle("猫好き診断");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TA=new JTextArea();
		TA.setFocusable(false);
		TA.setLineWrap(true);
		TF = new JTextField();
		TF.setFocusable(false);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(1,2));
		
		for(int i=0;i<2;++i) {
			
			btn[i]=new JButton("ボタン"+i);
			btn[i].addActionListener(this);
			p.add(btn[i]);
			
		}
		
		add(TF,BorderLayout.NORTH);
		add(TA,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		
		initQues();
		showQues();
		
	}
	
	private void initQues() {
		
		ques[0]=new Ques(0,"はい","いいえ","外出した時に猫がいると立ち止まってしまう");
		ques[1]=new Ques(0,"はい","いいえ","猫がテーマのテレビ番組や動画をよく見る");
		ques[2]=new Ques(0,"はい","いいえ","猫の特徴を5個以上言える");
		ques[3]=new Ques(0,"はい","いいえ","保護猫活動（地域猫活動）に興味がある");
		ques[4]=new Ques(0,"はい","いいえ","猫を飼っている、あるいは猫を飼いたいと思っている");
		
	}
	
	private void showQues() {
		
		TA.setText(ques[currentQues].toString());
		ques[currentQues].setButton(btn);
		
	}
	
	private void nextQues() {
		
		if(++currentQues<ques.length) {
			
			showQues();
			
		}else {
			
			reslt=((float)score/q)*100;
			
			TA.setText("終了\n"+ques.length+"問中"+score+"問でした。\n"+String.format("%.2f",reslt)+"%でした。");
			btn[0].setEnabled(false);
			btn[1].setEnabled(false);
			
		}
		
	}
		
	@Override
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==btn[ques[currentQues].getSeikai()]) {
			
			TF.setText("猫好き度上昇");
			++score;
			
		}else {
			
			TF.setText("変化なし");
			
		}
		
		nextQues();
		
	}
	
	public class Ques{
		
		private int correctAnswer;
		private String a0,a1;
		private String quesText;
		
		public Ques() {}
		
		public Ques(int seikai,String ans0,String ans1,String quesText) {
			
			this.correctAnswer=seikai;
			a0=ans0;
			a1=ans1;
			this.quesText=quesText;
			
		}
		
		public int getSeikai() {
			
			return correctAnswer;
			
		}
		
		public void setButton(JButton[]btn) {
			
			btn[0].setText(a0);
			btn[1].setText(a1);
			
		}
		
		public String toString() {
			
			return quesText;
			
		}
		
	}
	
}
	