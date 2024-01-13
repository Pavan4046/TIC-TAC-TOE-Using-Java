import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class XO implements ActionListener
{
	JFrame f;//this is for the score frame.
	JFrame F,F1;//for frame
	JTextField tf,tf1,tf2;//for Textfield tf1 is to show the turns of players
	JButton nb[]=new JButton[9];//for xo buttons
	JButton rst,h,t,score,ok;//rst is for restart the game,h is for head t is for tail.
	JPanel p,q;//this is to declare the variables
	boolean turn,count,count1;//set turn
	//Random r=new Random();
	Font f1=new Font("arial",Font.BOLD,33);//this is used to print the texts of buttons
	Font f2=new Font("arial",Font.BOLD,15);//this is to set the winner text
	Font f3=new Font("arial",Font.BOLD,7);//this is to set the players
	int scr=0,scr1=0;
	XO()
	{
		//Main frame
		F=new JFrame("TIC TAC TOE");
		F.setBounds(450,150,350,300);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setLayout(null);
		
		
		//for heads and tails
		h=new JButton("HEAD");
		h.setBounds(80,10,70,30);
		h.setFocusable(false);
		h.addActionListener(this);
		h.setBackground(Color.darkGray);
		h.setForeground(Color.white);
		F.add(h);
		
		
		t=new JButton("TAIL");
		t.setBounds(190,10,70,30);
		t.setFocusable(false);
		t.addActionListener(this);
		t.setBackground(Color.darkGray);
		t.setForeground(Color.white);
		F.add(t);
		//upto here for the first frame.

		
		//this set is used to set the second frame
		F1=new JFrame("                                                       TIC TAC TOE");
		F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F1.setSize(700,600);
		F1.setLayout(null);
		
		
		
		score=new JButton("SCORE");
		score.setBounds(560,15,70, 30);
		score.addActionListener(this);
		score.setBackground(Color.black);
		score.setFont(f3);;
		score.setFocusable(false);
		score.setForeground(Color.WHITE);
		F1.add(score);//in the second frame added score button.
		
		//this is used to set the turns
		tf1=new JTextField();
		tf1.setBounds(50,40,100,30);
		tf1.setEditable(false);
		tf1.setFont(f2);//this is used to set the fonts 
		tf1.setForeground(Color.ORANGE);
		
		
		//this is to show the winner
		tf2=new JTextField();
		tf2.setBounds(200,450,200,50);
		tf2.setEditable(false);
		tf2.setFont(f2);//this is used to set the fonts 
		tf2.setForeground(Color.ORANGE);
		
		
		//these are used to set the buttons
		p=new JPanel();
		p.setBounds(50, 100, 450, 450);
		p.setLayout(new GridLayout(4,4,10,10));
		
		//this is for the buttons
		for(int i2=0;i2<9;i2++)
		{
			 nb[i2]=new JButton();
			 p.add(nb[i2]);
			 nb[i2].addActionListener(this);
			 nb[i2].setFocusable(false);
			 nb[i2].setFont(f1);	
		}
		
		//this is for the turns
		/*if(r.nextInt(2)==0)
		{
			turn=true;
			tf.setText("X TURN");
		}
		else
		{
			turn=false;
			tf.setText("O TURN");	
		}*/
		
		
		
		//this is to restart the game
		q=new JPanel();
		q.setBounds(260,510,80,80);//first one is to shift right&left, second one is to shift up&down
		q.setLayout(new GridLayout(3,3,8,8));
		rst=new JButton("play again");
		rst.setFont(f3);
		rst.setFocusable(false);
		rst.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        for(int i=0;i<9;i++)
		        {
		        	nb[i].setText("");
		        	tf2.setText(null);//the winner text will be erased
		        }
		        F.setVisible(true);//this is for agian 
		        F1.setVisible(false);
		        tf1.setText(null);//the turn texts will be erased.
		    }
		});
		
		
		
		F1.add(p);//this add panel to frame
		F1.add(tf1);//this will add the textfield to frame
		F1.add(tf2);//this will add the second textfield to frame
		F.setVisible(true);
		//F1.setVisible(true);
	}
	
	public void check()
	{
		
			if((nb[0].getText()=="X"&&nb[1].getText()=="X"&&nb[2].getText()=="X")||
			   (nb[6].getText()=="X"&&nb[7].getText()=="X"&&nb[8].getText()=="X")||
			   (nb[3].getText()=="X"&&nb[4].getText()=="X"&&nb[5].getText()=="X")||
			   (nb[0].getText()=="X"&&nb[3].getText()=="X"&&nb[6].getText()=="X")||
			   (nb[1].getText()=="X"&&nb[4].getText()=="X"&&nb[7].getText()=="X")||
			   (nb[2].getText()=="X"&&nb[5].getText()=="X"&&nb[8].getText()=="X")||
			   (nb[0].getText()=="X"&&nb[4].getText()=="X"&&nb[8].getText()=="X")||
			   (nb[2].getText()=="X"&&nb[4].getText()=="X"&&nb[6].getText()=="X"))
				{
					count=true;
					tf2.setText("X IS WINNER");
					q.add(rst);
					F1.add(q);
				}
			if((nb[0].getText()=="O"&&nb[1].getText()=="O"&&nb[2].getText()=="O")||
			   (nb[6].getText()=="O"&&nb[7].getText()=="O"&&nb[8].getText()=="O")||
			   (nb[3].getText()=="O"&&nb[4].getText()=="O"&&nb[5].getText()=="O")||
			   (nb[0].getText()=="O"&&nb[3].getText()=="O"&&nb[6].getText()=="O")||
			   (nb[1].getText()=="O"&&nb[4].getText()=="O"&&nb[7].getText()=="O")||
			   (nb[2].getText()=="O"&&nb[5].getText()=="O"&&nb[8].getText()=="O")||
			   (nb[0].getText()=="O"&&nb[4].getText()=="O"&&nb[8].getText()=="O")||
			   (nb[2].getText()=="O"&&nb[4].getText()=="O"&&nb[6].getText()=="O"))
				{
					count1=true;
					tf2.setText("O IS WINNER");
					q.add(rst);
					F1.add(q);
				}
	}
	public void score()
	{
		f=new JFrame();
		f.setSize(300,200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		
		JTextField Tf=new JTextField();
		Tf.setBounds(50,30,180,30);
		Tf.setEditable(false);
		if(count)
		{
			scr++;
		}
		Tf.setText("X SCORE IS "+scr);
		Tf.setFont(f2);
		
		JTextField Tf1=new JTextField();
		Tf1.setBounds(50,60,180,30);
		Tf1.setEditable(false);
		if(count1)
		{
			scr1++;
		}
		Tf1.setText("O SCORE IS "+scr1);
		Tf1.setFont(f2);
		
		ok=new JButton("BACK");
		ok.setBounds(110,130,60,20);
		ok.addActionListener(this);
		ok.setBackground(Color.black);
		ok.setFont(f3);;
		ok.setFocusable(false);
		ok.setForeground(Color.WHITE);
		
		f.add(Tf);
		f.add(Tf1);
		f.add(ok);
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		XO c=new XO();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()==h)
		{
			turn=true;
			F1.setVisible(true);
			tf1.setText("X TURN");
			F.setVisible(false);
		}
		if(e.getSource()==t)
		{
			turn=false;
			F1.setVisible(true);
			tf1.setText("O TURN");
			F.setVisible(false);
		}
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==nb[i])
			{
				if(turn)
				{
					if(nb[i].getText()=="")
					{
						nb[i].setText("X");
						turn=false;
						tf1.setText("O TURN");
					}
				}
				else
				{
					if(nb[i].getText()=="")
					{
						nb[i].setText("O");
						turn=true;
						tf1.setText("X TURN");
					}
				}
			}
			check();
		}
		if(e.getSource()==score)
		{
			score();
		}
		if(e.getSource()==ok)
		{
			f.setVisible(false);
		}
	}
}