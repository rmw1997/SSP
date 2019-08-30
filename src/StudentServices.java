/* 

Student Services Program serves a student to predict semester and cumulative GPA,
as well as calculating remaining hours before getting a DN in a course. 
 
Developed By:
- Reem AlWadaey
- Muntaha AlShahrani
- Atheer AlHawaidi

 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class StudentServices extends JFrame implements ActionListener {
	
	/* ------ DECLARATION ------ */

	JPanel card,homePanel,buttonsPanel,gpaPanel,absencePanel,p4,p4_1,p4_2,p4_3,p5,p6,p6_1,p6_2,p6_3,p7_1,p7_2,p7_3,p7_4,p7_5,p7_6;
	JButton[] b = new JButton[10];
	JLabel mainLogo,gpaLogo,absenceLogo,message,message2,signs;
	JLabel[] l = new JLabel[13];
    JTextField currentGPA,noOfHours,semGPA,cumulativeGPA,courseName,courseHours,absenceHours;
	JRadioButton[] rb = new JRadioButton[7];
    ButtonGroup bg = new ButtonGroup();
    CardLayout cardLayout = new CardLayout();
    JComboBox[] g , creditHours;
    JTextField [] t = new JTextField [7];
    double totalPoints , sem_GPA , cumulative_GPA , current_GPA , points;
    int totalHours , no_Of_Hours ;
	Font font = new Font ("Century Gothic",Font.PLAIN,20);
	Color c1 = new Color(51,153,153); //Lochinvar
	Color c2 = new Color(178,36,107); //Hibiscus
	Color c3 = new Color(88,89,91); //Gray

	public StudentServices(){


		/* ------  MAIN FRAME  -------- */
		
		setLayout(new BorderLayout());
		mainLogo = new JLabel (new ImageIcon("./images/SSP.png")); //The Program Logo
		card= new JPanel ();
		homePanel=new JPanel(); 
		buttonsPanel= new JPanel();
		
		// The Main Buttons for moving across the options
		b[0] = new JButton("HOME");
		b[1] = new JButton("GPA CALCULATOR");
		b[2] = new JButton("ABSENCE CALCULATOR");
		b[3] = new JButton("EXIT");
		b[4] = new JButton("?");

		homePanel.add(mainLogo);

		for(int i=0 ; i < 5 ; i++){
			buttonsPanel.add(b[i]); //Loop for adding the buttons in the buttons panel
		}

		add(card,BorderLayout.CENTER);
		add(buttonsPanel,BorderLayout.SOUTH);
		card.setLayout(cardLayout);
		buttonsPanel.setBackground(c1);


		/* ------  GPA CALCULATOR FRAME  -------- */

		gpaPanel=new JPanel();
		p4 = new JPanel();
		p4_1 = new JPanel();
		p4_2 = new JPanel();
		p4_3 = new JPanel();

		p5 = new JPanel();

		p6 = new JPanel();
		p6_1 = new JPanel();
		p6_2= new JPanel();
		p6_3=new JPanel();
		
		l[0]= new JLabel("Your Current GPA:");
		l[1] = new JLabel("   	No. of Hours:");
		l[2] = new JLabel("  Courses:");
		l[3] = new JLabel("  Credit Hours:");
		l[4] = new JLabel("  Expected Grade:");
		l[5] = new JLabel("Semester GPA:");
		l[6] = new JLabel("         Cumulative GPA:");
		l[7] = new JLabel ("		No. of Courses:");

		l[1].setToolTipText("This means the No. of hrs of all the courses you've taken in all semesters");
		l[7].setToolTipText("This means the No. of courses you take this semester");

		message =  new JLabel("");
		gpaLogo = new JLabel(new ImageIcon("./images/GPA.png"));

		currentGPA = new JTextField(10);
		currentGPA.setFont(font);
		currentGPA.setForeground(c1);

		noOfHours = new JTextField(10);
		noOfHours.setFont(font);
		noOfHours.setForeground(c1);

		semGPA= new JTextField(10);
		semGPA.setFont(font);
		semGPA.setForeground(c1);

		cumulativeGPA= new JTextField(10);
		cumulativeGPA.setFont(font);
		cumulativeGPA.setForeground(c1);

		b[5] = new JButton ("CALCULATE");
		b[6] = new JButton ("CLEAR");
		b[7] = new JButton("ADD");

		String credit [] = {"0","1","2","3","4"};
		creditHours = new JComboBox[7];

		String grade [] = {"-","A+","A","B+","B","C+","C","D+","D","F"};
		g = new JComboBox[7];
		
		for(int i=0 ; i<=6 ; i++)
		{
			t[i] = new JTextField("Course "+(i+1));
			t[i].setFont(font);
			t[i].setForeground(c1);
			t[i].setVisible(false);
			
			rb[i] = new JRadioButton (" "+(i+1)+" ");
			rb[i].setFont(font);
			rb[i].setForeground(c1);
			bg.add(rb[i]); 

			creditHours[i] = new JComboBox<> (credit);
			creditHours[i].setFont(font);
			creditHours[i].setVisible(false);
			creditHours[i].setForeground(c1);
				
			g[i] = new JComboBox<> (grade);
			g[i].setFont(font);
			g[i].setVisible(false);
			g[i].setForeground(c1);

		}
		
		gpaPanel.setLayout(new BorderLayout());
		gpaPanel.add(p4,BorderLayout.NORTH);
		p4.setLayout(new GridLayout (3,1));
		p4.add(p4_1);
		p4_1.add(gpaLogo);
		p4.add(p4_2);

		p4_2.add(l[0]);
		p4_2.add(currentGPA);
		p4_2.add(l[1]);
		p4_2.add(noOfHours);

		p4.add(p4_3);
		p4_3.add(l[7]);

		for(int i=0 ; i < 7 ; i++){
			p4_3.add(rb[i]);
		}

		p4_3.add(b[7]);

		gpaPanel.add(p5,BorderLayout.CENTER);
		p5.setLayout(new GridLayout (8,3));

		p5.add(l[2]);
		p5.add(l[3]);
		p5.add(l[4]);

		for(int i=0 ; i < 7 ; i++){
			p5.add(t[i]);
			p5.add(creditHours[i]);
			p5.add(g[i]);
		}

		gpaPanel.add(p6,BorderLayout.SOUTH);
		p6.setLayout(new GridLayout (3,1));
		p6.add(p6_1);
		p6_1.add(b[5]);
		p6_1.add(b[6]);

		p6.add(p6_2);
		p6_2.add(l[5]);
		p6_2.add(semGPA);
		p6_2.add(l[6]);
		p6_2.add(cumulativeGPA);

		p6.add(p6_3);
		p6_3.add(message);

		/* ------  ABSENCE CALCULATOR FRAME  -------- */

		absencePanel=new JPanel();
		p7_1=new JPanel();
		p7_2=new JPanel();
		p7_3=new JPanel();
		p7_4=new JPanel();
		p7_5=new JPanel();
		p7_6=new JPanel();

		l[8] = new JLabel ("Course Name:");
		l[9] = new JLabel ("No. of Hours per Week:");
		l[10] = new JLabel ("Absence Hours:");
		l[11] = new JLabel ("Remaining Hours:");
		l[12] = new JLabel ("");
		absenceLogo = new JLabel(new ImageIcon("./images/ABS.png"));
		signs = new JLabel(new ImageIcon("./images/SIGN.png"));
		message2 =  new JLabel("");

		courseName = new JTextField(14);
		courseName.setFont(font);
		courseName.setForeground(c1);

		courseHours = new JTextField(10);
		courseHours.setFont(font);
		courseHours.setForeground(c1);

		absenceHours = new JTextField(15);
		absenceHours.setFont(font);
		absenceHours.setForeground(c1);

		b[8] = new JButton("RESULT");
		b[9] = new JButton("CLEAR");
		
		absencePanel.setLayout(new GridLayout (7,1));
		absencePanel.add(absenceLogo);

		absencePanel.add(p7_1);
		p7_1.add(l[8]);
		p7_1.add(courseName);

		absencePanel.add(p7_2);
		p7_2.add(l[9]);
		p7_2.add(courseHours);

		absencePanel.add(p7_3);
		p7_3.add(l[10]);
		p7_3.add(absenceHours);

		absencePanel.add(p7_4);
		p7_4.add(b[8]);
		p7_4.add(b[9]);

		absencePanel.add(p7_5);
		p7_5.add(l[11]);
		p7_5.add(l[12]);

		absencePanel.add(p7_6);
		p7_6.setLayout(new GridLayout (3,1));
		p7_6.add(signs);
		p7_6.add(message2);

		card.add(homePanel, "1");
		card.add(gpaPanel,"2");
		card.add(absencePanel, "3");

		for(int i=0;i<13;i++){
			l[i].setFont(font);
			l[i].setForeground(c3);
		}
		for(int i=0;i<10;i++){
			b[i].setFont(font);
			b[i].setForeground(c2);
			b[i].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent ae){

		String s=ae.getActionCommand();

		if(s.equals("HOME"))
            cardLayout.show(card,"1");
		else if(s.equals("GPA CALCULATOR"))
            cardLayout.show(card,"2");
		else if(s.equals("ABSENCE CALCULATOR"))
            cardLayout.show(card,"3");
		else if(s.equals("EXIT"))
			System.exit(0);
		else if(s.equals("?"))
		{
			INFO f1 = new INFO();
			f1.setVisible(true);
			f1.setBounds(470,300,400,200);
			f1.setTitle("ABOUT US");
		}
        else if (s.equals("ADD") )
		{	
			for(int i=0 ; i<7 ; i++){
				if(rb[i].isSelected()){
					for(int j=0;j<=i;j++){
						t[j].setVisible(true);
						creditHours[j].setVisible(true);
						g[j].setVisible(true);}
				}
			}
		}
		else if(s.equals("CALCULATE"))
		{
			double[] coursePoints= new double[7];
			double[] courseGrade = new double [7];
			int[] courseHours = new int [7];

			for(int i=0;i<=6;i++){
				courseHours[i]= Integer.parseInt((String) creditHours[i].getSelectedItem());
				if(g[i].getSelectedItem().equals("A+"))
                     courseGrade[i]=4.0;
	             else if (g[i].getSelectedItem().equals("A"))
                     courseGrade[i]=3.75;
	             else if (g[i].getSelectedItem().equals("B+"))
                     courseGrade[i]=3.5;
	             else if (g[i].getSelectedItem().equals("B"))
                     courseGrade[i]=3.0;
	             else if(g[i].getSelectedItem().equals("C+"))
                     courseGrade[i]=2.5;
	             else if (g[i].getSelectedItem().equals("C"))
                     courseGrade[i]=2.0;
	             else if (g[i].getSelectedItem().equals("D+"))
                     courseGrade[i]=1.5;
	             else if (g[i].getSelectedItem().equals("D"))
                     courseGrade[i]=1.0;
	             else if (g[i].getSelectedItem().equals("F"))
					 courseGrade[i]=0;
				coursePoints[i]= courseHours[i]*courseGrade[i];
				 }

			  totalPoints= coursePoints[0]+coursePoints[1]+coursePoints[2]+coursePoints[3]+coursePoints[4]+coursePoints[5]+coursePoints[6];
			  totalHours= courseHours[0]+courseHours[1]+courseHours[2]+courseHours[3]+courseHours[4]+courseHours[5]+courseHours[6];

			  DecimalFormat f = new DecimalFormat("##.##");
			  try{
				  current_GPA = Double.parseDouble(currentGPA.getText());
				  
	          	if (current_GPA>4.0)
					throw new ArithmeticException ("Dear Student, Your input is incorrect");
					
	          	no_Of_Hours =Integer.parseInt(noOfHours.getText());
				points = current_GPA * no_Of_Hours; //Formula for calculating the points 
				  
				sem_GPA = (totalPoints)/(totalHours); //Formula for calculating the semester GPA
				semGPA.setText(f.format(sem_GPA));
					 
				cumulative_GPA = (totalPoints+points)/(totalHours+no_Of_Hours);  //Formula for calculating the cumulative GPA
				cumulativeGPA.setText(f.format(cumulative_GPA));
				}
				  
		   	  catch(NumberFormatException e)
		   	  {
		   		message.setText("Dear Student, Your input is incorrect");
		   		message.setForeground(Color.RED);
                message.setFont(font);
		   	  }
			  catch(ArithmeticException e){
				  message.setText(e.getMessage());
			   	  message.setForeground(Color.RED);
	              message.setFont(font);
			  }
			 }

		else if(s.equals("CLEAR")) {

			bg.clearSelection();
			currentGPA.setText("");
			noOfHours.setText("");
			semGPA.setText("");
			cumulativeGPA.setText("");
			courseName.setText("");
			courseHours.setText("");
			absenceHours.setText("");
			l[12].setText("");
			message.setText("");
			message2.setText("");
			
			for(int i=0;i<=6;i++){
				t[i].setVisible(false);
				t[i].setText("Course "+(i+1));
				creditHours[i].setVisible(false);
				creditHours[i].setSelectedItem("0");
				g[i].setVisible(false);
				g[i].setSelectedItem("-");}
			}
		else if(s.equals("RESULT")){
			try{
				int hoursPerWeek, absentHours , remainingHours;

				hoursPerWeek = Integer.parseInt(courseHours.getText());
				absentHours = Integer.parseInt(absenceHours.getText());
				remainingHours = (hoursPerWeek*3)-absentHours; //This formula is applicable at Jubail University College

				l[12].setText(Integer.toString(remainingHours));

				//Changing the color of remaining hours depends on its value
				if (absentHours<=hoursPerWeek)
					l[12].setForeground(Color.GREEN); //Safe Sign
				else if (absentHours<=(2*hoursPerWeek))
					l[12].setForeground(Color.ORANGE); //Be Carefull
				else if (absentHours<(3*hoursPerWeek))
					l[12].setForeground(Color.RED); //Warning Sign
				else if (absentHours>=(3*hoursPerWeek))
				{
					l[12].setText("---"); //DN
					DN f = new DN ();
					f.setVisible(true);
					f.setBounds(470,300,300,100);
				}
			
			}catch(NumberFormatException e){
				message2.setText("\t\t\t\t\tDear Student, Your input is incorrect");
				message2.setForeground(Color.RED);
		        message2.setFont(font);
			}


		}
	}

	public static void main(String[] args){
		StudentServices frame = new StudentServices();
		frame.setTitle("Welcome to Student Services Program");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}



