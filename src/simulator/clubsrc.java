package simulator;

import java.util.concurrent.Semaphore;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import simulator.dining_philosphers_problem;
import simulator.Graph;
import simulator.fcfs;
import simulator.pageconvert;
import simulator.optimal;
//import simulator.pageconvert;
import simulator.secondchance;
import simulator.sjf;
import simulator.sjfnonpreempt;
import simulator.roundrobin;
import simulator.priority;
import simulator.random;
//import simulator.pageconvert;
import simulator.lru;
import simulator.fifo;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
public class clubsrc extends JFrame {

	private JPanel contentPane;
	JPanel panelmenu;
	JPanel panelpagerep;
	JPanel paneldisc;
	JPanel panelcpusched;
    JPanel paneldin;

	public JTextField textField;
	public JTextField inputarray;
	public JTextField textField_2;
	String val,h;
	int n;
	int[] h1;
	String arr,burst,prio;
	public double ans;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_fcfs_time;
	private JTextField textField_pagehit;
	final static JTextField textField_p1=new JTextField();
	final static JTextField textField_p2=new JTextField();
	final static JTextField textField_p3=new JTextField();
	final static JTextField textField_p4=new JTextField();
	final static JTextField textField_p5=new JTextField();
	final static int n1 = 5;

	  final static Philosopher[] philosophers = new Philosopher[n1];

	  final static Semaphore mutex = new Semaphore(1);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clubsrc frame = new clubsrc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public static class Philosopher extends Thread {

	    private enum State {
	    	THINKING
	    	{
	    		public String toString() {
	    		      return "THINK";
	    		    }
	    	}
	    	, HUNGRY
	    	{
	    		public String toString() {
	    		      return "HUNGRY";
	    		    }
	    	}
	    	, EATING
	    	{
	    		public String toString() {
	    		      return "EATING";
	    		    }
	    	}

	    };


	    private final int id;
	    private State state;
	    private final Semaphore self;

	    Philosopher(int id) {
	      this.id = id;
	      self = new Semaphore(0);
	      state = State.THINKING;
	    }

	    private Philosopher left() {
	      return philosophers[id == 0 ? n1 - 1 : id - 1];
	    }

	    private Philosopher right() {
	      return philosophers[(id + 1) % n1];
	    }

	    public void run() {
	      try {
	        while (true) {
	          printState();
	          switch(state) {
	          case THINKING:
	            thinkOrEat();
	            mutex.acquire();
	            state = State.HUNGRY;
	            break;
	          case HUNGRY:

	            test(this);
	            mutex.release();
	            self.acquire();
	            state = State.EATING;
	            break;
	          case EATING:
	            thinkOrEat();
	            mutex.acquire();
	            state = State.THINKING;
	            test(left());
	            test(right());
	            mutex.release();
	            break;
	          }
	        }
	      } catch(InterruptedException e) {}
	    }

	    static private void test(Philosopher p) {
	      if (p.left().state != State.EATING && p.state == State.HUNGRY &&
	          p.right().state != State.EATING) {
	        p.state = State.EATING;
	        p.self.release();
	      }
	    }

	    private void thinkOrEat() {
	      try {
	        Thread.sleep((long) Math.round(Math.random() * 5000));
	      } catch (InterruptedException e) {}
	    }

	    private void printState() {
	    	//String p = Integer.toString(id);


	    	//a=a.concat(Integer.toString(id));
	      System.out.println("Philosopher " + id + " is " + state);
	      if(id==0)
	      {
	    	  if(state==State.THINKING)
	    	  {
	    		  textField_p1.setText("THINKING");

	    	  }
	    	  else if(state==State.HUNGRY)
	    	  {
	    		  textField_p1.setText("HUNGRY");
	    	  }
	    	  else
	    	  {
	    		  textField_p1.setText("EATING");
	    	  }
	      }
	      if(id==1)
	      {
	    	  if(state==State.THINKING)
	    	  {
	    		  textField_p2.setText("THINKING");

	    	  }
	    	  else if(state==State.HUNGRY)
	    	  {
	    		  textField_p2.setText("HUNGRY");
	    	  }
	    	  else
	    	  {
	    		  textField_p2.setText("EATING");
	    	  }
	      }
	      if(id==2)
	      {
	    	  if(state==State.THINKING)
	    	  {
	    		  textField_p3.setText("THINKING");

	    	  }
	    	  else if(state==State.HUNGRY)
	    	  {
	    		  textField_p3.setText("HUNGRY");
	    	  }
	    	  else
	    	  {
	    		  textField_p3.setText("EATING");
	    	  }
	      }
	      if(id==3)
	      {
	    	  if(state==State.THINKING)
	    	  {
	    		  textField_p4.setText("THINKING");

	    	  }
	    	  else if(state==State.HUNGRY)
	    	  {
	    		  textField_p4.setText("HUNGRY");
	    	  }
	    	  else
	    	  {
	    		  textField_p4.setText("EATING");
	    	  }
	      }
	      if(id==4)
	      {
	    	  if(state==State.THINKING)
	    	  {
	    		  textField_p5.setText("THINKING");

	    	  }
	    	  else if(state==State.HUNGRY)
	    	  {
	    		  textField_p5.setText("HUNGRY");
	    	  }
	    	  else
	    	  {
	    		  textField_p5.setText("EATING");
	    	  }
	      }

	    }
	  }
	public clubsrc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		final JPanel panelpagerep = new JPanel();
		panelpagerep.setBackground(new Color(100, 149, 237));
		contentPane.add(panelpagerep, "name_777864128493815");
		panelpagerep.setLayout(null);
		panelpagerep.setVisible(false);

		final JPanel paneldisc = new JPanel();
		paneldisc.setBackground(new Color(245, 222, 179));
		contentPane.add(paneldisc, "name_777868681237060");
		paneldisc.setLayout(null);
		paneldisc.setVisible(false);

		final JPanel panelcpusched = new JPanel();
		panelcpusched.setBackground(new Color(244, 164, 96));
		contentPane.add(panelcpusched, "name_777888057353116");
		panelcpusched.setLayout(null);
		panelcpusched.setVisible(false);

		/////////////////////////////////////////////................,,,,,,,,,,////////////////////////
		final JPanel panelmenu = new JPanel();
		panelmenu.setBackground(new Color(0, 0, 0));
		contentPane.add(panelmenu, "name_777858054128357");
		panelmenu.setLayout(null);
		panelmenu.setVisible(true);

		final JPanel paneldin = new JPanel();
		paneldin.setBackground(new Color(210, 180, 140));
		contentPane.add(paneldin, "name_65427412124377");
		paneldin.setLayout(null);
		paneldin.setVisible(false);

		JButton btnPagereplacement = new JButton("Page replacement");
		btnPagereplacement.setBackground(new Color(192, 192, 192));
		btnPagereplacement.setForeground(new Color(255, 0, 0));
		btnPagereplacement.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnPagereplacement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelpagerep.setVisible(true);
				panelmenu.setVisible(false);
			}
		});
		btnPagereplacement.setBounds(180, 158, 246, 61);
		panelmenu.add(btnPagereplacement);

		JButton btnDiscscheduling = new JButton("Disc Scheduling");
		btnDiscscheduling.setForeground(new Color(255, 0, 0));
		btnDiscscheduling.setBackground(new Color(192, 192, 192));
		btnDiscscheduling.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnDiscscheduling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paneldisc.setVisible(true);
				panelmenu.setVisible(false);
			}
		});
		btnDiscscheduling.setBounds(180, 262, 246, 61);
		panelmenu.add(btnDiscscheduling);

		JButton btnNewButton = new JButton("CPU Scheduling");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelmenu.setVisible(false);
				panelcpusched.setVisible(true);
			}
		});
		btnNewButton.setBounds(180, 69, 246, 56);
		panelmenu.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("SIMULATOR");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setBounds(239, 11, 163, 35);
		panelmenu.add(lblNewLabel_3);

		JButton btnDining = new JButton("Dining Philosopher");
		btnDining.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnDining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmenu.setVisible(false);
				paneldin.setVisible(true);
				 textField_p1.setText("THINKING");
				 textField_p2.setText("THINKING");
				 textField_p3.setText("THINKING");
				 textField_p4.setText("THINKING");
				 textField_p5.setText("THINKING");



			}
		});
		btnDining.setForeground(new Color(255, 0, 0));
		btnDining.setBackground(new Color(192, 192, 192));
		btnDining.setBounds(180, 368, 246, 61);
		panelmenu.add(btnDining);



		JButton btnTest = new JButton("Back");
		btnTest.setBackground(new Color(50, 205, 50));
		btnTest.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_3.setText("");
				textField_4.setText("");
				panelpagerep.setVisible(false);
				panelmenu.setVisible(true);
			}
		});
		btnTest.setBounds(266, 464, 89, 23);
		panelpagerep.add(btnTest);

		JLabel lblPageReplacement = new JLabel("Page Replacement");
		lblPageReplacement.setBackground(new Color(0, 0, 0));
		lblPageReplacement.setForeground(Color.ORANGE);
		lblPageReplacement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblPageReplacement.setBounds(203, 21, 255, 36);
		panelpagerep.add(lblPageReplacement);

		JButton btnFifo = new JButton("F.I.F.O.");
		btnFifo.setBackground(Color.YELLOW);
		btnFifo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnFifo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Val,v="";
					Val = textField_1.getText();
					pageconvert z = new pageconvert(Val);
					int[] L= z.method1();
					int h = Integer.parseInt(textField_3.getText());
					 fifo a1= new fifo(h,L);
					 int r = a1.method();
					 int y=a1.method1();
					 v=v+""+r;
					//a1.Get(L,L.length);

					textField_4.setText(v);
					textField_pagehit.setText(Integer.toString(y));
			}
		});
		btnFifo.setBounds(104, 68, 153, 41);
		panelpagerep.add(btnFifo);

		JButton btnLru = new JButton("L.R.U.");
		btnLru.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnLru.setBackground(Color.YELLOW);
		btnLru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String Val,v="";
				  Val = textField_1.getText();
				  pageconvert z = new pageconvert(Val);
				  int[] L= z.method1();
				  int h = Integer.parseInt(textField_3.getText());
				  lru a1= new lru(h,L);
				  int r = a1.method();
				  int y=a1.method1();
				  v=v+""+r;
				  //a1.Get(L,L.length);

				  textField_4.setText(v);
				  textField_pagehit.setText(Integer.toString(y));
			}
		});
		btnLru.setBounds(374, 68, 156, 41);
		panelpagerep.add(btnLru);

		JButton btnOptimal = new JButton("Optimal");
		btnOptimal.setBackground(Color.YELLOW);
		btnOptimal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnOptimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Val,v="";
				Val = textField_1.getText();
				pageconvert z = new pageconvert(Val);
				int[] L= z.method1();
				int h = Integer.parseInt(textField_3.getText());
				 optimal a1= new optimal(h,L);
				 int r = a1.method();
				 int y=a1.method1();
				 v=v+""+r;
				//a1.Get(L,L.length);

				textField_4.setText(v);
				textField_pagehit.setText(Integer.toString(y));
			}
		});
		btnOptimal.setBounds(104, 142, 153, 41);
		panelpagerep.add(btnOptimal);

		JButton btnSecondChance = new JButton("Second Chance");
		btnSecondChance.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnSecondChance.setBackground(Color.YELLOW);
		btnSecondChance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Val,v="";
				Val = textField_1.getText();
				pageconvert z = new pageconvert(Val);
				int[] L= z.method1();
				int h = Integer.parseInt(textField_3.getText());
				 secondchance a1= new secondchance(h,L);
				 int r = a1.method();
				 v=v+""+r;
				 int y=a1.method1();
				//a1.Get(L,L.length);

				textField_4.setText(v);
				textField_pagehit.setText(Integer.toString(y));
			}
		});
		btnSecondChance.setBounds(374, 142, 156, 41);
		panelpagerep.add(btnSecondChance);

		textField_1 = new JTextField();
		textField_1.setBounds(337, 258, 194, 20);
		panelpagerep.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblInput_1 = new JLabel("Input");
		lblInput_1.setForeground(Color.YELLOW);
		lblInput_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblInput_1.setBounds(180, 251, 52, 33);
		panelpagerep.add(lblInput_1);

		textField_3 = new JTextField();
		textField_3.setBounds(338, 311, 46, 20);
		panelpagerep.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel = new JLabel("No.of Frames");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(162, 311, 93, 18);
		panelpagerep.add(lblNewLabel);

		textField_4 = new JTextField();
		textField_4.setBounds(337, 354, 89, 20);
		panelpagerep.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("PageFaults");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(180, 356, 76, 14);
		panelpagerep.add(lblNewLabel_1);

		textField_pagehit = new JTextField();
		textField_pagehit.setBounds(340, 400, 86, 20);
		panelpagerep.add(textField_pagehit);
		textField_pagehit.setColumns(10);

		JLabel lblN = new JLabel("Page Hits");
		lblN.setForeground(Color.YELLOW);
		lblN.setBackground(Color.YELLOW);
		lblN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblN.setBounds(180, 398, 76, 23);
		panelpagerep.add(lblN);
		panelpagerep.setVisible(false);



		JButton btnFcfs_1 = new JButton("FCFS");
		btnFcfs_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnFcfs_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String S="",v="";
				val = inputarray.getText();
				String[] ele = val.split("\\s+");
				n = ele.length;
				h1 = new int[n];
				for(int i=0;i<n;i++){
					 h1[i]= Integer.parseInt(ele[i].trim());
				}
				int h = Integer.parseInt(textField.getText());
				fcfs a1= new fcfs(h,h1);
				 int[] r = a1.method();
				 int y= a1.method3();
				 v=v+""+y;
				//a1.Get(L,L.length);
				 Graph G = new Graph(r,r.length);
				  G.test(r,r.length);
				   for(int i=0;i<r.length;i++)
			    	{
			    	S = S + " " + r[i];
			    	//System.out.println(r[i]);
			    	}
			 // txtAs.setText("");
			 // textField.setText("");
			  textField_2.setText(S);
			  textField_fcfs_time.setText(Integer.toString(y));

			}
		});
		btnFcfs_1.setBounds(176, 56, 104, 43);
		paneldisc.add(btnFcfs_1);

		JButton button_1 = new JButton("SSTF");
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String S="",v="";
				val = inputarray.getText();
				String[] ele = val.split("\\s+");
				n = ele.length;
				h1 = new int[n];
				for(int i=0;i<n;i++){
					 h1[i]= Integer.parseInt(ele[i].trim());
				}
				int h = Integer.parseInt(textField.getText());
				sstf a1= new sstf(h,h1);
				 int[] r = a1.method();
				 int y= a1.method3();
				 v=v+""+y;
				//a1.Get(L,L.length);
				 Graph G = new Graph(r,r.length);
				  G.test(r,r.length);
				   for(int i=0;i<r.length;i++)
			    	{
			    	S = S + " " + r[i];
			    	//System.out.println(r[i]);
			    	}
			 // txtAs.setText("");
			 // textField.setText("");
			  textField_2.setText(S);
			  textField_fcfs_time.setText(Integer.toString(y));
			}
		});
		button_1.setBounds(392, 56, 104, 43);
		paneldisc.add(button_1);

		JButton btnScan = new JButton("SCAN");
		btnScan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				String S="",v="";
				val = inputarray.getText();
				String[] ele = val.split("\\s+");
				n = ele.length;
				h1 = new int[n];
				for(int i=0;i<n;i++){
					 h1[i]= Integer.parseInt(ele[i].trim());
				}
				int h = Integer.parseInt(textField.getText());
				scan a1= new scan(h,h1);
				 int[] r = a1.method();
				 int y= a1.method3();
				 v=v+""+y;
				//a1.Get(L,L.length);
				 Graph G = new Graph(r,r.length);
				  G.test(r,r.length);
				   for(int i=0;i<r.length;i++)
			    	{
			    	S = S + " " + r[i];
			    	//System.out.println(r[i]);
			    	}
			 // txtAs.setText("");
			 // textField.setText("");
			  textField_2.setText(S);
			  textField_fcfs_time.setText(Integer.toString(y));
			}
		});
		btnScan.setBounds(176, 125, 104, 39);
		paneldisc.add(btnScan);

		JButton btnCscan = new JButton("C-SCAN");
		btnCscan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCscan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String S="",v="";
				val = inputarray.getText();
				String[] ele = val.split("\\s+");
				n = ele.length;
				h1 = new int[n];
				for(int i=0;i<n;i++){
					 h1[i]= Integer.parseInt(ele[i].trim());
				}
				int h = Integer.parseInt(textField.getText());
				cscan a1= new cscan(h,h1);
				 int[] r = a1.method();
				 int y= a1.method3();
				 v=v+""+y;
				//a1.Get(L,L.length);
				 Graph G = new Graph(r,r.length);
				  G.test(r,r.length);
				   for(int i=0;i<r.length;i++)
			    	{
			    	S = S + " " + r[i];
			    	//System.out.println(r[i]);
			    	}
			 // txtAs.setText("");
			 // textField.setText("");
			  textField_2.setText(S);
			  textField_fcfs_time.setText(Integer.toString(y));
			}
		});
		btnCscan.setBounds(392, 125, 104, 39);
		paneldisc.add(btnCscan);

		JButton btnClook = new JButton("C-LOOK");
		btnClook.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnClook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String S="",v="";
				val = inputarray.getText();
				String[] ele = val.split("\\s+");
				n = ele.length;
				h1 = new int[n];
				for(int i=0;i<n;i++){
					 h1[i]= Integer.parseInt(ele[i].trim());
				}
				int h = Integer.parseInt(textField.getText());
				clook a1= new clook(h,h1);
				 int[] r = a1.method();
				 int y= a1.method3();
				 v=v+""+y;
				//a1.Get(L,L.length);
				 Graph G = new Graph(r,r.length);
				  G.test(r,r.length);
				   for(int i=0;i<r.length;i++)
			    	{
			    	S = S + " " + r[i];
			    	//System.out.println(r[i]);
			    	}
			 // txtAs.setText("");
			 // textField.setText("");
			  textField_2.setText(S);
			  textField_fcfs_time.setText(Integer.toString(y));
			}
		});
		btnClook.setBounds(392, 195, 104, 39);
		paneldisc.add(btnClook);

		textField = new JTextField();
		textField.setBounds(328, 257, 86, 20);
		paneldisc.add(textField);
		textField.setColumns(10);

		JLabel lblHead = new JLabel("Head");
		lblHead.setForeground(new Color(255, 165, 0));
		lblHead.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblHead.setBounds(216, 259, 46, 14);
		paneldisc.add(lblHead);

		inputarray = new JTextField();
		inputarray.setBounds(328, 300, 154, 20);
		paneldisc.add(inputarray);
		inputarray.setColumns(10);

		JLabel lblInput = new JLabel("Input");
		lblInput.setForeground(new Color(218, 165, 32));
		lblInput.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblInput.setBounds(216, 300, 46, 16);
		paneldisc.add(lblInput);

		textField_2 = new JTextField();
		textField_2.setBounds(328, 346, 154, 20);
		paneldisc.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblOutput = new JLabel("Output");
		lblOutput.setForeground(new Color(218, 165, 32));
		lblOutput.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblOutput.setBounds(216, 346, 46, 18);
		paneldisc.add(lblOutput);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				inputarray.setText("");
				textField_2.setText("");
				paneldisc.setVisible(false);
				panelmenu.setVisible(true);
			}
		});
		btnBack.setBounds(266, 471, 89, 23);
		paneldisc.add(btnBack);

		JButton btnLook = new JButton("LOOK");
		btnLook.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String S="",v="";
				val = inputarray.getText();
				String[] ele = val.split("\\s+");
				n = ele.length;
				h1 = new int[n];
				for(int i=0;i<n;i++){
					 h1[i]= Integer.parseInt(ele[i].trim());
				}
				int h = Integer.parseInt(textField.getText());
				look a1= new look(h,h1);
				 int[] r = a1.method();
				 int y= a1.method3();
				 v=v+""+y;
				//a1.Get(L,L.length);
				 Graph G = new Graph(r,r.length);
				  G.test(r,r.length);
				   for(int i=0;i<r.length;i++)
			    	{
			    	S = S + " " + r[i];
			    	//System.out.println(r[i]);
			    	}
			 // txtAs.setText("");
			 // textField.setText("");
			  textField_2.setText(S);
			  textField_fcfs_time.setText(Integer.toString(y));
			}
		});
		btnLook.setBounds(176, 195, 104, 39);
		paneldisc.add(btnLook);

		JLabel lblDiskScheduler = new JLabel("Disk Scheduler");
		lblDiskScheduler.setForeground(Color.RED);
		lblDiskScheduler.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblDiskScheduler.setBounds(234, -13, 209, 65);
		paneldisc.add(lblDiskScheduler);

		JLabel lblNewLabel_4 = new JLabel("Seek Time");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setForeground(new Color(218, 165, 32));
		lblNewLabel_4.setBounds(216, 391, 66, 30);
		paneldisc.add(lblNewLabel_4);

		textField_fcfs_time = new JTextField();
		textField_fcfs_time.setBounds(328, 397, 86, 20);
		paneldisc.add(textField_fcfs_time);
		textField_fcfs_time.setColumns(10);
		paneldisc.setVisible(false);



		JButton btnTestcpu = new JButton("Back");
		btnTestcpu.setForeground(new Color(255, 255, 255));
		btnTestcpu.setBackground(new Color(0, 0, 255));
		btnTestcpu.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnTestcpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelcpusched.setVisible(false);
				panelmenu.setVisible(true);
			}
		});
		btnTestcpu.setBounds(272, 461, 78, 23);
		panelcpusched.add(btnTestcpu);

		JButton btnFcfs = new JButton("Fcfs");
		btnFcfs.setBackground(new Color(218, 165, 32));
		btnFcfs.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				random x = new random();
				x.generate();
				//System.out.println("arrival time");
				arr = "";
				for(int i=0;i<x.n;i++)
					arr = arr + x.a[i] + " ";
					//System.out.print(x.a[i]+" ");
				//System.out.println("");
				textField_5.setText(arr);

				burst = "";
				//System.out.println("burst time");
				for(int i=0;i<x.n;i++)
					burst = burst + x.b[i] + " ";
					//System.out.print(x.b[i]+" ");
				//System.out.println("");
				textField_6.setText(burst);

				textField_7.setText("");
				//System.out.println("priority");
				//for(int i=0;i<x.n;i++)
					//System.out.print(x.p[i]+" ");
				//System.out.println("");

				cpufcfs y = new cpufcfs(x.n, x.b);
				ans = y.averageWaitingTimeCalc();
				textField_8.setText(Double.toString(ans));
			}
		});
		btnFcfs.setBounds(47, 80, 165, 23);
		panelcpusched.add(btnFcfs);

		JButton btnSjfpreemptive = new JButton("SJF Preemptive");
		btnSjfpreemptive.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnSjfpreemptive.setBackground(new Color(218, 165, 32));
		btnSjfpreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				random x = new random();
				x.generate();
				arr = "";
				//System.out.println("arrival time");
				for(int i=0;i<x.n;i++)
					arr = arr + x.a[i] + " ";
					//System.out.print(x.a[i]);
				textField_5.setText(arr);
				burst = "";
				//System.out.println("burst time");
				for(int i=0;i<x.n;i++)
					burst = burst + x.b[i] + " ";
					//System.out.print(x.b[i]);
				textField_6.setText(burst);
				textField_7.setText("");
				//System.out.println("priority");
				//for(int i=0;i<x.n;i++)
					//System.out.print(x.p[i]);

				sjf y = new sjf(x.n, x.a, x.b);
				y.averageWaitingTimeCalc();
				double ans2 = y.printWaitingTime();
				textField_8.setText(Double.toString(ans2));
			}
		});
		btnSjfpreemptive.setBounds(47, 189, 165, 23);
		panelcpusched.add(btnSjfpreemptive);

		JButton btnPriority = new JButton("Priority");
		btnPriority.setBackground(new Color(218, 165, 32));
		btnPriority.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				random xx = new random();
				xx.generate();
				arr = "";
				//System.out.println("arrival time");
				for(int i=0;i<xx.n;i++)
					arr = arr + xx.a[i] + " ";
					//System.out.print(xx.a[i]);
				textField_5.setText(arr);
				burst = "";
				//System.out.println("burst time");
				for(int i=0;i<xx.n;i++)
					burst = burst + xx.b[i] + " ";
					//System.out.print(xx.b[i]);
				textField_6.setText(burst);
				//System.out.println("priority");
				prio = "";
				for(int i=0;i<xx.n;i++)
					prio = prio + xx.p[i] + " ";
					//System.out.print(xx.p[i]);
				textField_7.setText(prio);
				priority y = new priority(xx.n, xx.p, xx.b);
				double ans3 = y.calcAverageWaitingTime();
				textField_8.setText(Double.toString(ans3));
			}
		});
		btnPriority.setBounds(47, 141, 165, 23);
		panelcpusched.add(btnPriority);

		JButton btnSjfnonpreemptive = new JButton("SJF Non Preemptive");
		btnSjfnonpreemptive.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnSjfnonpreemptive.setBackground(new Color(218, 165, 32));
		btnSjfnonpreemptive.setForeground(new Color(0, 0, 0));
		btnSjfnonpreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				random xx = new random();
				xx.generate();

				arr = "";
				//System.out.println("arrival time");
				for(int i=0;i<xx.n;i++)
					arr = arr + xx.a[i] + " ";
					//System.out.print(xx.a[i]);
				textField_5.setText(arr);
				burst = "";
				//System.out.println("burst time");
				for(int i=0;i<xx.n;i++)
					burst = burst + xx.b[i] + " ";
					//System.out.print(xx.b[i]);
				textField_6.setText(burst);
				//System.out.println("priority");
				textField_7.setText("");
				//for(int i=0;i<xx.n;i++)
					//System.out.print(xx.p[i]);

				sjfnonpreempt y = new sjfnonpreempt(xx.n, xx.a, xx.b);
				y.averageWaitingTimeCalc();
				double ans2 = y.printWaitingTime();
				textField_8.setText(Double.toString(ans2));
			}
		});
		btnSjfnonpreemptive.setBounds(380, 189, 166, 23);
		panelcpusched.add(btnSjfnonpreemptive);

		JButton btnRoundrobin = new JButton("Round Robin");
		btnRoundrobin.setBackground(new Color(218, 165, 32));
		btnRoundrobin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnRoundrobin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				random xx = new random();
				xx.generate();
				textField_5.setText("");
				burst = "";
				for(int i=0;i<xx.n;i++)
					burst = burst + xx.b[i] + " ";
					//System.out.println("burst = "+xx.b[i]);
				//System.out.println("time = "+xx.t);
				textField_6.setText(burst);
				textField_7.setText("");
				roundrobin y = new roundrobin(xx.n, xx.t, xx.b);
				double ans4 = y.calcAverageWaitingTime();
				textField_8.setText(Double.toString(ans4));
			}
		});
		btnRoundrobin.setBounds(380, 80, 165, 23);
		panelcpusched.add(btnRoundrobin);

		JLabel lblNewLabel_2 = new JLabel("Avg. Wait Time");
		lblNewLabel_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(357, 421, 98, 14);
		panelcpusched.add(lblNewLabel_2);

		textField_5 = new JTextField();
		textField_5.setBounds(196, 354, 258, 20);
		panelcpusched.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(196, 251, 258, 20);
		panelcpusched.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(196, 298, 258, 20);
		panelcpusched.add(textField_7);

		JLabel lblArrivalTime = new JLabel("Arrival Times");
		lblArrivalTime.setForeground(new Color(128, 0, 128));
		lblArrivalTime.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblArrivalTime.setBounds(86, 356, 89, 14);
		panelcpusched.add(lblArrivalTime);

		JLabel lblBurstTimes = new JLabel("Burst Times");
		lblBurstTimes.setForeground(new Color(128, 0, 128));
		lblBurstTimes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblBurstTimes.setBounds(86, 253, 91, 14);
		panelcpusched.add(lblBurstTimes);

		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setForeground(new Color(128, 0, 128));
		lblPriority.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblPriority.setBounds(97, 304, 44, 14);
		panelcpusched.add(lblPriority);

		textField_8 = new JTextField();
		textField_8.setBounds(473, 415, 101, 20);
		panelcpusched.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblTimequantum = new JLabel("Time Quantum  =  4");
		lblTimequantum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblTimequantum.setBounds(45, 427, 132, 20);
		panelcpusched.add(lblTimequantum);

		JLabel lblCpuscheduling = new JLabel("CPU Scheduling");
		lblCpuscheduling.setForeground(new Color(0, 0, 255));
		lblCpuscheduling.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblCpuscheduling.setBounds(233, 11, 215, 30);
		panelcpusched.add(lblCpuscheduling);

		JButton btnPriority_pre = new JButton("Priority Preemptive");
		btnPriority_pre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 {
					random xx = new random();
					xx.generate();
					arr = "";
					//System.out.println("arrival time");
					for(int i=0;i<xx.n;i++)
						arr = arr + xx.a[i] + " ";
						//System.out.print(xx.a[i]);
					textField_5.setText(arr);
					burst = "";
					//System.out.println("burst time");
					for(int i=0;i<xx.n;i++)
						burst = burst + xx.b[i] + " ";
						//System.out.print(xx.b[i]);
					textField_6.setText(burst);
					//System.out.println("priority");
					prio = "";
					for(int i=0;i<xx.n;i++)
						prio = prio + xx.p[i] + " ";
						//System.out.print(xx.p[i]);
					textField_7.setText(prio);
					priority y = new priority(xx.n, xx.p, xx.b);
					double ans3 = y.calcAverageWaitingTime();
					textField_8.setText(Double.toString(ans3));
				}

			}
		});
		btnPriority_pre.setBackground(new Color(218, 165, 32));
		btnPriority_pre.setForeground(new Color(0, 0, 0));
		btnPriority_pre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnPriority_pre.setBounds(380, 141, 165, 23);
		panelcpusched.add(btnPriority_pre);

		JButton btnDin_back = new JButton("Back");
		btnDin_back.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDin_back.setBackground(new Color(255, 250, 240));
		btnDin_back.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				textField_p1.setText("THINKING");
				textField_p2.setText("THINKING");
				textField_p3.setText("THINKING");
				textField_p1.setText("THINKING");
				textField_p1.setText("THINKING");

			    for (Thread t : philosophers) {
			      t.stop();
			    }
				paneldin.setVisible(false);
				panelmenu.setVisible(true);
			}
		});
		btnDin_back.setBounds(256, 469, 89, 23);
		paneldin.add(btnDin_back);

		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnStart.setBackground(new Color(255, 250, 240));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				philosophers[0] = new Philosopher(0);
			    for (int i = 1; i < n1; i++) {
			      philosophers[i] = new Philosopher(i);
			    }


			    for (Thread t : philosophers) {
			      t.start();
			    }


			}
		});
		btnStart.setBounds(256, 401, 89, 23);
		paneldin.add(btnStart);
		textField_p1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));

	//	textField_p1 = new JTextField();
		textField_p1.setBounds(90, 135, 97, 23);
		paneldin.add(textField_p1);
		textField_p1.setColumns(10);
		textField_p4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));

	//	textField_p4 = new JTextField();
		textField_p4.setBounds(250, 302, 106, 20);
		paneldin.add(textField_p4);
		textField_p4.setColumns(10);
		textField_p5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));

	//	textField_p5 = new JTextField();
		textField_p5.setBounds(90, 230, 97, 20);
		paneldin.add(textField_p5);
		textField_p5.setColumns(10);
		textField_p2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));

	//	textField_p2 = new JTextField();
		textField_p2.setBounds(395, 135, 106, 23);
		paneldin.add(textField_p2);
		textField_p2.setColumns(10);
		textField_p3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));

	//	textField_p3 = new JTextField();
		textField_p3.setBounds(395, 230, 106, 20);
		paneldin.add(textField_p3);
		textField_p3.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Philosopher 1");
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(86, 96, 120, 28);
		paneldin.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Philosopher 2");
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_6.setBounds(399, 99, 102, 23);
		paneldin.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Philosopher 5");
		lblNewLabel_7.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setBounds(86, 196, 129, 23);
		paneldin.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Philosopher 3");
		lblNewLabel_8.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_8.setBounds(393, 196, 120, 23);
		paneldin.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Philosopher 4");
		lblNewLabel_9.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_9.setBounds(250, 252, 113, 23);
		paneldin.add(lblNewLabel_9);

		JLabel lblDiningPhilosopher = new JLabel("Dining Philosopher");
		lblDiningPhilosopher.setForeground(new Color(255, 0, 0));
		lblDiningPhilosopher.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblDiningPhilosopher.setBounds(203, 29, 253, 45);
		paneldin.add(lblDiningPhilosopher);
		panelcpusched.setVisible(false);
	}
}
