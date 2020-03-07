package edu.bsu.cs222;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class StatsInterface extends JFrame {
    private JLabel logo;
    private Icon icon;
    private JLabel winNumber;
    private JLabel lossNumber;
    private JLabel teamsName;
    private JLabel title;
    private JButton seeStatistics;
    private JTextArea statistics;

    public StatsInterface() {
        logo = new JLabel();
        winNumber = new JLabel();
        lossNumber = new JLabel();
        teamsName = new JLabel();
        title = new JLabel("2019 NBA regular season");
        seeStatistics = new JButton("See more");
        statistics = new JTextArea();
        Font scoreFont = new Font("Arial", Font.PLAIN, 30);
        Font nameFont = new Font("Arial", Font.PLAIN, 20);
        Font titleFont = new Font("Arial", Font.PLAIN, 20);
        setLayout(null);
        Container container= getContentPane();
        container.setBackground(Color.gray);
        container.add(title).setBounds(300,0,300,50);
        container.add(logo).setBounds(0,30,200,200);
        container.add(teamsName).setBounds(10,200,300,100);
        container.add(winNumber).setBounds(300,50,300,100);
        container.add(lossNumber).setBounds(300,100,300,100);
        container.add(seeStatistics).setBounds(600,10,120,40);
        container.add(statistics).setBounds(550,70,220,280);
        statistics.setFont(new Font("Microsoft Uighur",Font.ITALIC,20));
        statistics.setBackground(Color.gray);
        title.setFont(titleFont);
        teamsName.setFont(nameFont);
        winNumber.setFont(scoreFont);
        winNumber.setForeground(Color.red);
        lossNumber.setFont(scoreFont);
        lossNumber.setForeground(Color.green);
        this.setSize(800, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void getStats(String teamName,int teamOrder,int teamId){
        HttpRequest httpRequest =new HttpRequest();
        try {
            teamsName.setText(teamName);
            winNumber.setText("Wins: "+ String.valueOf(httpRequest.getTeamsData(teamOrder,"wins")));
            lossNumber.setText("Losses: "+ String.valueOf(httpRequest.getTeamsData(teamOrder,"losses")));
            icon = new ImageIcon(new URL("http://mat1.gtimg.com/sports/nba/logo/1602/"+teamId+".png"));
            logo.setIcon(icon);
            seeStatistics.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    statistics.setText("Total Games: "+ httpRequest.getTeamsData(teamOrder, "games") +"\n"+
                                        "Total Points: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"points"))+"\n"+
                                        "Points Per Games: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"pointsPG"))+"\n"+
                                        "Threes Attempted: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"threesAttempted"))+"\n"+
                                        "Threes Attempted Per Games: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"threesAttemptedPG"))+"\n"+
                                        "Threes Made: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"threesMade"))+"\n"+
                                        "Threes Made Per Games: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"threesMadePG"))+"\n"+
                                        "Free Throw Attempted: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"fgAttempted"))+"\n"+
                                        "Free Throw Attempted Per Games: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"fgAttemptedPG"))+"\n"+
                                        "Free Throw Made: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"fgMade"))+"\n"+
                                        "Free Throw Made Per Games: "+String.valueOf(httpRequest.getTeamsData(teamOrder,"fgMadePG"))
                            );
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }





