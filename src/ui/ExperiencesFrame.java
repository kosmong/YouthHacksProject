package ui;

import exceptions.ExperienceAlreadyRecordedException;
import exceptions.ExperienceNotRecordedException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExperiencesFrame extends JFrame implements ActionListener{
    protected final static int WIDTH = 600;
    protected final static int HEIGHT = 600;

    protected ResumeOrganizer organizer;
    protected JButton addWorkExperience;
    protected JButton findWorkExperience;
    protected JButton addVolunteering;
    protected JButton findVolunteering;
    protected JButton addExtracurricular;
    protected JButton findExtracurricular;
    protected DefaultListModel<String> experienceModel;
    protected JList<String> experienceJList;

    public ExperiencesFrame(ResumeOrganizer organizer) {
        super("Experiences");
        this.organizer = organizer;
        experienceModel = new DefaultListModel<>();
        putExperienceInList();


        initComponents();

        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    protected void initComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        //JPanel display = new JPanel();
        setLayout(new FlowLayout(FlowLayout.CENTER));

        addWorkExperience = new JButton("Add Work Experience");
        addWorkExperience.addActionListener(this);
        add(addWorkExperience);

        findWorkExperience = new JButton("Find Work Experience");
        findWorkExperience.addActionListener(this);
        add(findWorkExperience);

        addVolunteering = new JButton("Add Volunteering Experience");
        addVolunteering.addActionListener(this);
        add(addVolunteering);

        findVolunteering = new JButton("Find Volunteering Experience");
        findVolunteering.addActionListener(this);
        add(findVolunteering);

        addExtracurricular = new JButton("Add Extracurricular");
        addExtracurricular.addActionListener(this);
        add(addExtracurricular);

        findExtracurricular = new JButton("Find Extracurricular");
        findExtracurricular.addActionListener(this);
        add(findExtracurricular);

        //add(display);

        experienceJList = new JList<>(experienceModel);
        experienceJList.setPreferredSize(new Dimension(400, 460));
        add(experienceJList);
    }

    protected void putExperienceInList() {
        // put work experience
        for (WorkExperience work: organizer.getExperiences().getWorkExperience().values()) {
            String name = work.getDescription().getName();
            experienceModel.addElement(name);
        }

        // put volunteering
        for (VolunteerExperience v: organizer.getExperiences().getVolunteerExperience().values()) {
            String name = v.getDescription().getName();
            experienceModel.addElement(name);
        }

        // put extracurriculars
        for (Extracurricular ex: organizer.getExperiences().getExtracurriculars().values()) {
            String name = ex.getDescription().getName();
            experienceModel.addElement(name);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addWorkExperience)) {
            addWork();
        } else if (e.getSource().equals(findWorkExperience)) {
            findWork();
        } else if (e.getSource().equals(addVolunteering)) {
            addVolunteering();
        } else if (e.getSource().equals(findVolunteering)) {
            findVolunteering();
        } else if (e.getSource().equals(addExtracurricular)) {
            addExtracurricular();
        } else if (e.getSource().equals(findExtracurricular)) {
            findExtracurricular();
        }
    }

    protected void addWork() {
        String companyName = JOptionPane.showInputDialog(this, "Enter company name");
        String position = JOptionPane.showInputDialog(this, "Enter position");
        try {
            organizer.addExperience(HardSkillTags.WORKEXPERIENCE, companyName, position);
            experienceModel.addElement(organizer.findExperience(HardSkillTags.WORKEXPERIENCE, companyName, position).getDescription().getName());
        } catch (ExperienceAlreadyRecordedException e) {
            JOptionPane.showMessageDialog(this, "Experience already recorded");
        } catch (ExperienceNotRecordedException e) {
            e.printStackTrace();
        }
    }

    protected void findWork() {
        String companyName = JOptionPane.showInputDialog(this, "Enter company name");
        String position = JOptionPane.showInputDialog(this, "Enter position");
        try {
            displayDescription(organizer.findExperience(HardSkillTags.WORKEXPERIENCE, companyName, position).getDescription());
        } catch (ExperienceNotRecordedException e) {
            JOptionPane.showMessageDialog(this, "Experience not recorded");
        }
    }

    protected void addVolunteering() {
        String organization = JOptionPane.showInputDialog(this, "Enter volunteering organization");
        String position = JOptionPane.showInputDialog(this, "Enter position");
        try {
            organizer.addExperience(HardSkillTags.VOLUNTEEREXPERIENCE, organization, position);
            experienceModel.addElement(organizer.findExperience(HardSkillTags.VOLUNTEEREXPERIENCE, organization, position).getDescription().getName());
        } catch (ExperienceAlreadyRecordedException e) {
            JOptionPane.showMessageDialog(this, "Experience already recorded");
        } catch (ExperienceNotRecordedException e) {
            e.printStackTrace();
        }
    }

    protected void findVolunteering() {
        String organization = JOptionPane.showInputDialog(this, "Enter volunteering organization");
        String position = JOptionPane.showInputDialog(this, "Enter position");
        try {
            displayDescription(organizer.findExperience(HardSkillTags.VOLUNTEEREXPERIENCE, organization, position).getDescription());
        } catch (ExperienceNotRecordedException e) {
            JOptionPane.showMessageDialog(this, "Experience not recorded");
        }
    }

    protected void addExtracurricular() {
        String extracurricular = JOptionPane.showInputDialog(this, "Enter extracurricular");
        String position = JOptionPane.showInputDialog(this, "Enter position");
        try {
            organizer.addExperience(HardSkillTags.EXTRACURRICULARS, extracurricular, position);
            experienceModel.addElement(organizer.findExperience(HardSkillTags.EXTRACURRICULARS, extracurricular, position).getDescription().getName());
        } catch (ExperienceAlreadyRecordedException e) {
            JOptionPane.showMessageDialog(this, "Experience already recorded");
        } catch (ExperienceNotRecordedException e) {
            e.printStackTrace();
        }
    }

    protected void findExtracurricular() {
        String extracurricular = JOptionPane.showInputDialog(this, "Enter extracurricular");
        String position = JOptionPane.showInputDialog(this, "Enter position");
        try {
            displayDescription(organizer.findExperience(HardSkillTags.EXTRACURRICULARS, extracurricular, position).getDescription());
        } catch (ExperienceNotRecordedException e) {
            JOptionPane.showMessageDialog(this, "Experience not recorded");
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



    private class EditTime implements ActionListener {
        private Description d;
        private JFrame p;

        public EditTime(Description description, JFrame parent) {
            d = description;
            p = parent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String year = JOptionPane.showInputDialog("Length of involvement in years");
            String month = JOptionPane.showInputDialog("Length of involvement in months");

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
