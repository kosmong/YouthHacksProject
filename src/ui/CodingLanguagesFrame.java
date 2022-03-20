package ui;

import exceptions.LanguageAlreadyRecordedException;
import exceptions.LanguageNotRecordedException;
import model.ResumeOrganizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            organizer.findLanguage(language);
        } catch (LanguageNotRecordedException e) {
            JOptionPane.showMessageDialog(this, "Language not recorded");
        }
    }
}
