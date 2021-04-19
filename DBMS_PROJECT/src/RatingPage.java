import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RatingPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RatingPage window = new RatingPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RatingPage() {
		initialize("Avengers");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String movieName) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseRateYour = new JLabel("Please rate your experience with us!");
		lblPleaseRateYour.setBounds(94, 25, 279, 35);
		frame.getContentPane().add(lblPleaseRateYour);
		
		JLabel lblMovieRating = new JLabel("Movie rating");
		lblMovieRating.setBounds(41, 72, 107, 35);
		frame.getContentPane().add(lblMovieRating);
		
		JLabel lblCinemaStationRating = new JLabel("Cinema Station rating");
		lblCinemaStationRating.setBounds(41, 146, 169, 35);
		frame.getContentPane().add(lblCinemaStationRating);
		
		JSlider MovieSlider = new JSlider();
		MovieSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
			}
		});
		MovieSlider.setToolTipText("");
		MovieSlider.setValue(1);
		MovieSlider.setPaintTicks(true);
		MovieSlider.setMajorTickSpacing(1);
		MovieSlider.setPaintTrack(true);
		MovieSlider.setPaintLabels(true);
		MovieSlider.setMaximum(5);
		MovieSlider.setBounds(212, 72, 200, 48);
		frame.getContentPane().add(MovieSlider);
		
		JSlider CinemaSlider = new JSlider();
		CinemaSlider.setValue(1);
		CinemaSlider.setMaximum(5);
		CinemaSlider.setPaintTicks(true);
		CinemaSlider.setMajorTickSpacing(1);
		CinemaSlider.setPaintTrack(true);
		CinemaSlider.setPaintLabels(true);
		CinemaSlider.setBounds(212, 146, 200, 42);
		frame.getContentPane().add(CinemaSlider);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int movie_rating= MovieSlider.getValue();
				int cinema_rating=CinemaSlider.getValue();
				System.out.println("Movie: "+movieName+" MovieRating: "+movie_rating+" CinemaRating: "+cinema_rating);
			}
		});
		btnSubmit.setBounds(163, 218, 117, 25);
		frame.getContentPane().add(btnSubmit);
		
	}
}
