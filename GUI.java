import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JComboBox<String> teamsDropdown;

    //Home Page
    public GUI(){

        //Button Creation
        JButton TeamOption= new JButton("Team Gambling");
        TeamOption.setBackground(Color.BLUE);
        TeamOption.setForeground(Color.RED);
        TeamOption.setOpaque(true);
        TeamOption.setActionCommand("TeamOption");
        TeamOption.addActionListener(this);



        //Frame and panel creation
        JFrame frame= new JFrame("Odds Calculator");
        JPanel panel=new JPanel();
        panel.add(TeamOption);
        panel.setBackground(Color.LIGHT_GRAY);

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }

    //When Team Button Is Pressed
    public void teamOption(){
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        JButton button=new JButton("Check Odds");
       button.setActionCommand("Check_Odds");
        button.addActionListener(this);
        String[] teams = {
                "Arizona Cardinals", "Atlanta Falcons", "Baltimore Ravens", "Buffalo Bills",
                "Carolina Panthers", "Chicago Bears", "Cincinnati Bengals", "Cleveland Browns",
                "Dallas Cowboys", "Denver Broncos", "Detroit Lions", "Green Bay Packers",
                "Houston Texans", "Indianapolis Colts", "Jacksonville Jaguars", "Kansas City Chiefs",
                "Las Vegas Raiders", "Los Angeles Chargers", "Los Angeles Rams", "Miami Dolphins",
                "Minnesota Vikings", "New England Patriots", "New Orleans Saints", "New York Giants",
                "New York Jets", "Philadelphia Eagles", "Pittsburgh Steelers", "San Francisco 49ers",
                "Seattle Seahawks", "Tampa Bay Buccaneers", "Tennessee Titans", "Washington Commanders"
        };

                teamsDropdown=new JComboBox<>(teams);

        panel.add(teamsDropdown);
        panel.add(button);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this frame
        frame.setVisible(true);


    }


    public void displayResults(String[][] lol){


        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        JTextArea text=new JTextArea();
        int max= Integer.MIN_VALUE;
        String name="";
        for(int i=0;i<lol.length;i++){
            text.append(lol[i][0]+": "+ lol[i][1]+"\n");
            if(Integer.parseInt(lol[i][1])>max){
                max=Integer.parseInt(lol[i][1]);
                name=lol[i][0];

            }
        }
        text.append("The one that will give you the best odds is "+name+" at: "+ max);

        panel.add(text);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this frame
        frame.setVisible(true);

    }


    //Button Clicking Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("TeamOption")){
           teamOption();

        }

        if(e.getActionCommand().equals("Check_Odds")){
            String selectedTeam = (String) teamsDropdown.getSelectedItem();
            bettingOnTeam a=new bettingOnTeam();
            String up=a.findingGame(selectedTeam);
            String[][] lol=a.neat(up,selectedTeam);
            displayResults(lol);



        }


    }


    //Main Method
    public static void main(String[] args){
        new GUI();

    }
}
