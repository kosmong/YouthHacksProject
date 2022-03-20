package ui;

import exceptions.LanguageAlreadyRecordedException;
import exceptions.LanguageNotRecordedException;
import model.Description;
import model.ResumeOrganizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CodingLanguagesFrame extends JFrame {
    protected final static int WIDTH = 600;
    protected final static int HEIGHT = 480;

    protected ResumeOrganizer organizer;
    protected JButton addLanguage;
    protected JButton findLanguage;
    protected DefaultListModel<String> languageModel;
    protected JList<String> languageJList;

    public CodingLanguagesFrame(ResumeOrganizer organizer) {
        super("Coding Languages");
        this.organizer = organizer;
        languageModel = new DefaultListModel<>();
        putAllLangOnList();


        initComponents();

        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    protected void initComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel display = new JPanel();
        display.setLayout(new FlowLayout(FlowLayout.CENTER));

        addLanguage = new JButton("Add Language");
        addLanguage.addActionListener(new AddLanguage());
        display.add(addLanguage);

        findLanguage = new JButton("Find Language");
        findLanguage.addActionListener(new FindLanguage());
        display.add(findLanguage);

        add(display);

        languageJList = new JList<>(languageModel);
        languageJList.setPreferredSize(new Dimension(400, 360));
        add(languageJList);
    }

    protected void putAllLangOnList() {
        for (String language: organizer.getLanguages().getCodingLanguages().keySet()) {
            languageModel.addElement(language);
        }
    }

    private class AddLanguage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addLanguage();
        }
    }

    protected void addLanguage() {
        String language = JOptionPane.showInputDialog(this, "Enter language");
        try {
            organizer.addCodingLanguage(language);
            languageModel.addElement(organizer.findLanguage(language).getDescription().getName());
        } catch (LanguageAlreadyRecordedException e) {
            JOptionPane.showMessageDialog(this, "Language already recorded");
        } catch (LanguageNotRecordedException e) {
            e.printStackTrace();
        }
    }

    private class FindLanguage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            findLanguage();
        }
    }

    protected void findLanguage() {
        String language = JOptionPane.showInputDialog(this, "Enter language");

        try {
            displayDescription(organizer.findLanguage(language).getDescription());

        } catch (LanguageNotRecordedException e) {
            JOptionPane.showMessageDialog(this, "Language not recorded");
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
            String year = JOptionPane.showInputDialog("Amount of experience in years");
            String month = JOptionPane.showInputDialog("Amount experience in months");

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
