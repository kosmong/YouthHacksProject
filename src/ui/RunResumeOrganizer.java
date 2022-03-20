package ui;
import java.awt.event.*;

import javax.swing.*;

import model.ResumeOrganizer;

public class RunResumeOrganizer extends JFrame implements ActionListener{
    protected final static int WIDTH = 1200;
    protected final static int HEIGHT = 800;

    protected JFrame frame;
    protected JTextField searchBar;
    protected JButton codingLanguages;
    protected JButton experiences;
    protected JButton Projects;
    protected ResumeOrganizer organizer;

    public RunResumeOrganizer() {
        super("My Organizer");
        organizer = new ResumeOrganizer();

        initComponents();
        searchBar = new JTextField();
        searchBar.setBounds(300, 300, 50, 50);
        codingLanguages = new JButton("Coding Languages");
        codingLanguages.setBounds(WIDTH / 2 - 100, HEIGHT / 2 - 50, 200, 100);
        codingLanguages.addActionListener(this);

        add(codingLanguages);
        add(searchBar);

        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    protected void initComponents() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //textField.setText("Test");
        if (e.getSource().equals(codingLanguages)) {
            //this.dispose();
            CodingLanguagesFrame frame = new CodingLanguagesFrame(organizer);
            //frame.setVisible(true);
        }
    }

    private class OpenWindow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    //EFFECTS: runs the GUI of the farm
    public static void main(String[] args) {
        new RunResumeOrganizer();
    }
}
