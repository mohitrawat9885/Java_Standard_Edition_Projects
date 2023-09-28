package clock;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame{
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Java Digital Clock");
        this.setLayout(new FlowLayout());
        this.setSize(430, 260);
        this.setResizable(false);
        
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
        
        
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 65));
        timeLabel.setForeground(Color.BLUE);
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);
        
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 40));
        dayLabel.setForeground(Color.ORANGE);
        dayLabel.setBackground(Color.black);
        
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 40));
        dateLabel.setForeground(Color.MAGENTA);
        dateLabel.setBackground(Color.black);
        
        
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        
        getContentPane().setBackground(Color.BLACK);
        
        
        this.setVisible(true);
        
        setTime();
    }
    
    public void setTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
}


public class Clock {
    public static void main(String[] args) {
        new MyFrame();        
    }
}
