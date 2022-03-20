package ui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.ResumeOrganizer;

public class RunResumeOrganizer extends JFrame implements ActionListener{
    protected final static int WIDTH = 600;
    protected final static int HEIGHT = 100;

    protected JButton codingLanguages;
    protected JButton experiences;
    protected JButton projects;
    protected ResumeOrganizer organizer;

    public RunResumeOrganizer() {
        super("My Organizer");
        organizer = new ResumeOrganizer();
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        initComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    protected void initComponents() {
        codingLanguages = new JButton("Coding Languages");
        codingLanguages.addActionListener(this);

        experiences = new JButton("Experiences");
        experiences.addActionListener(this);

        projects = new JButton("Projects");
        projects.addActionListener(this);

        add(codingLanguages);
        add(experiences);
        add(projects);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(codingLanguages)) {
            new CodingLanguagesFrame(organizer);
        } else if (e.getSource().equals(experiences)) {
            new ExperiencesFrame(organizer);
        } else if (e.getSource().equals(projects)) {
            new ProjectsFrame(organizer);
        }
    }


    //EFFECTS: runs the GUI of the farm
    public static void main(String[] args) {
        new RunResumeOrganizer();
    }
}
