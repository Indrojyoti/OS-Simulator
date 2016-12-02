package simulator;

import java.util.concurrent.Semaphore;


public class dining_philosphers_problem {
	//public enum State {THINKING, HUNGRY, EATING};
	final  int n = 5;

	  final Philosopher[] philosophers = new Philosopher[n];

	  final Semaphore mutex = new Semaphore(1);










	}
	public class Philosopher extends Thread {

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
	      return philosophers[id == 0 ? n - 1 : id - 1];
	    }

	    private Philosopher right() {
	      return philosophers[(id + 1) % n];
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

	    

	public void dining_philosphers_problem() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 955);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		textArea_0.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
		textArea_0.setBackground(new Color(245, 255, 250));

		textArea_0.setBounds(10, 203, 83, 38);
		frame.getContentPane().add(textArea_0);
		textArea_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
		textArea_1.setBackground(new Color(230, 230, 250));

		textArea_1.setBounds(10, 481, 83, 38);
		frame.getContentPane().add(textArea_1);
		textArea_2.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
		textArea_2.setBackground(new Color(230, 230, 250));

		textArea_2.setBounds(683, 481, 83, 38);
		frame.getContentPane().add(textArea_2);
		textArea_3.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
		textArea_3.setBackground(new Color(240, 248, 255));

		textArea_3.setBounds(683, 239, 83, 38);
		frame.getContentPane().add(textArea_3);
		textArea_4.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
		textArea_4.setBackground(new Color(240, 255, 240));

		textArea_4.setBounds(345, 24, 89, 31);
		frame.getContentPane().add(textArea_4);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				philosophers[0] = new Philosopher(0);
			    for (int i = 1; i < n; i++) {
			      philosophers[i] = new Philosopher(i);
			    }


			    for (Thread t : philosophers) {
			      t.start();
			    }

			}
		});
		btnStart.setBounds(345, 673, 89, 23);
		frame.getContentPane().add(btnStart);

		JLabel lblNewLabel = new JLabel("");
		Image img=new  ImageIcon(this.getClass().getResource("/d.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(93, 73, 590, 588);
		frame.getContentPane().add(lblNewLabel);



	}
}
