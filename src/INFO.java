import javax.swing.*;
import java.awt.*;

public class INFO extends JFrame{
	public INFO(){
    Font font = new Font ("Century Gothic",Font.PLAIN,15);
    Color c1 = new Color(178,36,107);
    setLayout(new GridLayout(7,1));
	JLabel l1 = new JLabel ("  Done By: ");
	l1.setFont(font);
	l1.setForeground(c1);
	JLabel l2 = new JLabel ("  - Reem AlWadaey");
	l2.setFont(font);
	l2.setForeground(c1);
	JLabel l3 = new JLabel ("  - Muntaha AlShahrani");
	l3.setFont(font);
	l3.setForeground(c1);
	JLabel l4 = new JLabel ("  - Atheer AlHawaidi");
	l4.setFont(font);
	l4.setForeground(c1);
	
	JLabel l5 = new JLabel ("      ");
	
	JLabel l6 = new JLabel ("  Contact us:");
	l6.setFont(font);
	l6.setForeground(c1);

	JLabel l7 = new JLabel ("  SSP@gmail.com");
	l7.setFont(font);
	l7.setForeground(c1);
	
    add(l1);
    add(l2);
    add(l3);
    add(l4);
    add(l5);
    add(l6);
    add(l7);


}}
