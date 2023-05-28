import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class digital_clock extends JFrame{
    private JLabel timeLabel;
    private JLabel dateLabel;

    public digital_clock(){
        setTitle("Digital Clock");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //create a panel to hold the time and date labels
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BorderLayout());

        //create a label to display the time
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.RED);

        //create a label to display the date
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setVerticalAlignment(SwingConstants.CENTER);
        dateLabel.setForeground(Color.WHITE);

        //Add the time and date lables to the panel
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);

        //set the panel's background color
        panel.setBackground(Color.BLACK);

        //Add the panel to the frame
        add(panel);

        //Use a Timer to upadate the time and date labels every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                updateTimeAndDate();
            }
        });
        timer.start();
    }

    private void updateTimeAndDate(){
        //Get The current time and formatit
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormater = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormater.format(calendar.getTime());

        //Get the current date and format it
        SimpleDateFormat dateFormater = new SimpleDateFormat("EEE, MMM dd, yyyy");
        String date = dateFormater.format(calendar.getTime());

        //Update the time and date labels
        timeLabel.setText(time);
        dateLabel.setText(date);
    }

    public static void main(String[] args) {
        digital_clock clock = new digital_clock();
        clock.setVisible(true);
    }
}
