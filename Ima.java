import java.awt.*;
import javax.swing.*;
public class Ima extends JFrame
{
	JFrame f;
	ImageIcon i;
	JLabel l;
	Ima()
	{
		i=new ImageIcon(this.getClass().getResource("/Ima2.png"));
		l=new JLabel(i);
		l.setSize(650,450);
		f=new JFrame();
		f.setSize(650,450);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(l);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new Ima();
	}
}
