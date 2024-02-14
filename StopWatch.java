import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatch implements ActionListener {
    JFrame frame=new JFrame();
    JButton startButton= new JButton("Start");
    JButton resetButton=new JButton("Reset");
    JLabel timeLabel=new JLabel();
    int elapsedTime=0;
    int seconds=0;
    int minutes=0;
    int hours=0;
    boolean started=false;
    String seconds_String=String.format("%02d",seconds);
    String minutes_String=String.format("%02d",minutes);
    String hours_String=String.format("%02d",hours);
    Timer timer= new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime+=1000;
            hours=(elapsedTime/3600000);
            minutes=(elapsedTime/60000)%60;
            seconds=(elapsedTime/1000)%60;
            seconds_String=String.format("%02d",seconds);
            minutes_String=String.format("%02d",minutes);
            hours_String=String.format("%20d",hours);

            timeLabel.setText(hours_String+":"+minutes_String+":"+seconds_String);

        }
    });


    public StopWatch() {
        timeLabel.setText(hours_String+":"+minutes_String+":"+seconds_String);
        timeLabel.setBounds(50,50,250,100);
        timeLabel.setFont(new Font("New Time Romance",Font.PLAIN,25));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(50,150,125,50);
        startButton.setFont(new Font("Ink free",Font.PLAIN,15));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(175,150,125,50);
        resetButton.setFont(new Font("Ink free",Font.PLAIN,15));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(resetButton);
        frame.add(startButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton) {
            if (started==false){
                started=true;
                startButton.setText("Stop");
                start();
            }
            else {
                started=true;
                startButton.setText("Start");
                stop();
            }
        }
        if (e.getSource()==resetButton){
            started=false;
            startButton.setText("Start");
            reset();
        }

    }
    private void start(){
        timer.start();

    }
    private void stop(){
        timer.stop();

    }
    private void reset(){
        timer.stop();
        elapsedTime=0;
        seconds=0;
        minutes=0;
        hours=0;

        seconds_String=String.format("%02d",seconds);
        minutes_String=String.format("%02d",minutes);
        hours_String=String.format("%20d",hours);
        timeLabel.setText(hours_String+":"+minutes_String+":"+seconds_String);


    }
}
