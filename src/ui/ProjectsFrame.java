package ui;

import exceptions.*;
import model.Description;
import model.HardSkillTags;
import model.Project;
import model.ResumeOrganizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectsFrame extends JFrame implements ActionListener {
    protected final static int WIDTH = 600;
    protected final static int HEIGHT = 480;

    protected ResumeOrganizer organizer;
    protected JButton addProject;
    protected JButton findProject;
    protected DefaultListModel<String> projectModel;
    protected JList<String> projectJList;

    public ProjectsFrame(ResumeOrganizer organizer) {
        super("Projects");
        this.organizer = organizer;
        projectModel = new DefaultListModel<>();
        putAllLangOnList();


        initComponents();

        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    protected void initComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel display = new JPanel();
        display.setLayout(new FlowLayout(FlowLayout.CENTER));

        addProject = new JButton("Add Project");
        addProject.addActionListener(this);
        display.add(addProject);

        findProject = new JButton("Find Project");
        findProject.addActionListener(this);
        display.add(findProject);

        add(display);

        projectJList = new JList<>(projectModel);
        projectJList.setPreferredSize(new Dimension(400, 360));
        add(projectJList);
    }

    protected void putAllLangOnList() {
        for (Project project: organizer.getProjects().getProjects().values()) {
            String name = project.getDescription().getName();
            projectModel.addElement(name);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addProject)){
            addProject();
        } else if (e.getSource().equals(findProject)) {
            findProject();
        }
    }

    protected void addProject() {
        String projectName = JOptionPane.showInputDialog(this, "Enter project name");
        String language = JOptionPane.showInputDialog(this, "Enter coding language");
        try {
            organizer.addProject(projectName, language);
            projectModel.addElement(organizer.findProject(projectName, language).getDescription().getName());
        } catch (ProjectAlreadyRecordedException e) {
            JOptionPane.showMessageDialog(this, "Project already recorded");
        } catch (LanguageAlreadyRecordedException | LanguageNotRecordedException | ProjectNotRecordedException e) {
            e.printStackTrace();
        }
    }

    protected void findProject() {
        String projectName = JOptionPane.showInputDialog(this, "Enter project name");
        String language = JOptionPane.showInputDialog(this, "Enter coding language");
        try {
            displayDescription(organizer.findProject(projectName, language).getDescription());
        } catch (ProjectNotRecordedException e) {
            JOptionPane.showMessageDialog(this, "Project not recorded");
        }
    }

    protected void displayDescription(Description description) {
        JFrame panel = new JFrame(description.getName());
        panel.setSize(400, 400);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel name = new JLabel(description.getName());
        panel.add(name);

        JLabel time = new JLabel(description.getTime().getYear() + " Years, " + description.getTime().getMonth() + " Months");
        panel.add(time);

        JLabel describe = new JLabel(description.getDescription());
        panel.add(describe);

        setEditMenu(panel, description);
        //setCodeMenu();

        panel.setVisible(true);
    }

    protected void setEditMenu(JFrame parent, Description description) {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Edit");
        JMenuItem editTime = new JMenuItem("Time");
        JMenuItem editDescription = new JMenuItem("Description");
        editTime.addActionListener(new EditTime(description, parent));
        editDescription.addActionListener(new EditDescription(description, parent));
        menu.add(editTime);
        menu.add(editDescription);
        bar.add(menu);
        parent.setJMenuBar(bar);
    }

//    protected void setCodeMenu() {
//
//    }



    private class EditTime implements ActionListener {
        private Description d;
        private JFrame p;

        public EditTime(Description description, JFrame parent) {
            d = description;
            p = parent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String year = JOptionPane.showInputDialog("Time spent on project in years");
            String month = JOptionPane.showInputDialog("Time spent on project in months");

            try {
                int y = Integer.parseInt(year);
                int m = Integer.parseInt(month);
                d.setTime(y, m);
                p.dispose();
                displayDescription(d);
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Please enter an integer!");
            }
        }
    }

    private class EditDescription implements ActionListener {
        private  Description d;
        private JFrame parent;

        public EditDescription(Description description, JFrame parent) {
            d = description;
            this.parent = parent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String newDescription = JOptionPane.showInputDialog("Put new description here");
            d.setDescription(newDescription);
            parent.dispose();
            displayDescription(d);
        }
    }


}
