package edu.bsu.cs222;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class InitialInterface{

    public static void main(String[] args) {
        JPanel selectPanel = new JPanel();
        JPanel statsPanel = new JPanel();
        JTabbedPane tabbedPane = buildJTabbedPane(selectPanel, statsPanel);
        buildFrame(tabbedPane);
    }

    private static void buildFrame(JComponent component) {
        JFrame frame = new JFrame();
        frame.setTitle("NBA Teams Stats");
        frame.add(component);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(BorderLayout.CENTER, component);
        frame.setPreferredSize(new Dimension(1060, 560));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(true);
    }
    private static JTabbedPane buildJTabbedPane(JPanel statsPanel, JPanel comparePanel) {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tabbedPane.setSize(800,500);
        tabbedPane.add("Stats", statsPanel);
        tabbedPane.add("Compare", comparePanel);
        statsPanel.add(buildJLabel("Select your favorite team:", 10, 20, 80, 25));
        String teamsNames[] = {"Milwaukee Bucks", "Houston Rockets", "Dallas Mavericks","LA Clippers","New Orleans Pelicans","Washington Wizards",
                "LA Lakers","Portland Trailblazers","San Antonio Spurs","Memphis Grizzlies", "Boston Celtics","Toronto Raptors","Minnesota Timberwolves","Phoenix Suns","Miami Heat",
                "Utah Jazz","Oklahoma City Thunder","Atlanta Hawks", "Denver Nuggets","Brooklyn Nets","Indiana Pacers", "Philadelphia 76ers","Detroit Pistons","Golden State Warriors","Chicago Bulls",
                "Cleveland Cavaliers","New York Knicks","Orlando Magic","Charlotte Hornets"};
        statsPanel.add(buildJComboBox("Teams", "Golden State Warriors", teamsNames, 0, 100, 20, 165, 25));
        return tabbedPane;

    }

    private static JComboBox<String> buildJComboBox(Object selectedItem, String name, String[] elements, int selectedIndex, int x, int y, int width, int height) {
        DefaultComboBoxModel<String> nbaTeamsModel = new DefaultComboBoxModel<>();
        for (String element : elements) {
            nbaTeamsModel.addElement(element);
        }
        JComboBox<String> nbaTeamsBox = new JComboBox<>(nbaTeamsModel);
        nbaTeamsBox.setName(name);
        nbaTeamsBox.setSelectedItem(selectedItem);
        nbaTeamsBox.setBounds(x, y, width, height);
        nbaTeamsBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    TeamNumber teamNumber = new TeamNumber();
                    String teamName = (String)nbaTeamsModel.getSelectedItem();
                    int teamOrder = nbaTeamsModel.getIndexOf(teamName);
                    int teamId = teamNumber.findTeamsId(teamName);
                    new StatsInterface().getStats(teamName,teamOrder,teamId);
                }
            }
        });
        return nbaTeamsBox;
    }
    private static JLabel buildJLabel(String name, int x, int y, int width, int height) {
        JLabel label = new JLabel(name);
        label.setBounds(x, y, width, height);
        return label;
    }
}


