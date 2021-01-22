package com.company;

import org.xml.sax.SAXException;

import javax.swing.*;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.Security;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private DefaultListModel jListModel1;
    private DefaultListModel jListModel2;
    private DefaultListModel jListModel3;
    private List<Employee> employeeList;

    public GUI() {

        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        JMenu jFileMenu = new JMenu("File");
        jMenuBar.add(jFileMenu);
        JMenuItem openFile = new JMenuItem("Open File");
        jFileMenu.add(openFile);

        JTabbedPane jTabbedPane = new JTabbedPane();

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();

        jTabbedPane.add("Sorted Data", jPanel1);
        jTabbedPane.add("Positions ", jPanel2);
        jTabbedPane.add("Minimal Salary", jPanel3);
        jPanel1.setLayout(new BorderLayout());
        jPanel2.setLayout(new BorderLayout());
        jPanel3.setLayout(new BorderLayout());
        jListModel1 = new DefaultListModel();
        jListModel2 = new DefaultListModel();
        jListModel3 = new DefaultListModel();

        JList jList1 = new JList(jListModel1);
        JList jList2 = new JList(jListModel2);
        JList jList3 = new JList(jListModel3);

        JScrollPane jScrollPane1 = new JScrollPane(jList1);
        JScrollPane jScrollPane2 = new JScrollPane(jList2);
        JScrollPane jScrollPane3 = new JScrollPane(jList3);

        Dimension jScrollPaneDimension = new Dimension(1000,500);
        Dimension jListDimension = new Dimension(1200,1000);

        jScrollPane1.setPreferredSize(jScrollPaneDimension);
        jScrollPane2.setPreferredSize(jScrollPaneDimension);
        jScrollPane3.setPreferredSize(jScrollPaneDimension);

        jList1.setPreferredSize(jListDimension);
        jList2.setPreferredSize(jListDimension);
        jList3.setPreferredSize(jListDimension);

        jPanel1.add(jScrollPane1, BorderLayout.CENTER);
        jPanel2.add(jScrollPane2, BorderLayout.CENTER);
        jPanel3.add(jScrollPane3, BorderLayout.CENTER);
        JButton jButton1 = new JButton("Sort Employees");
        JButton jButton2 = new JButton("Show unique positions ");
        JButton jButton3 = new JButton("Show minimal salary for every position");
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jPanel1.add(jButton1, BorderLayout.SOUTH);
        jPanel2.add(jButton2, BorderLayout.SOUTH);
        jPanel3.add(jButton3, BorderLayout.SOUTH);
        add(jTabbedPane);

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                jListModel1.clear();
                jListModel2.clear();
                jListModel3.clear();
                employeeList = new ArrayList<>();
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Choose file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    try {
                        ReaderUtils.parser(employeeList, fileChooser.getSelectedFile().getPath());
                    } catch (IOException | SAXException | ParserConfigurationException ex) {
                        JOptionPane.showMessageDialog(GUI.this, ex, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    }
                }
                jButton1.setEnabled(true);
                jButton2.setEnabled(true);
                jButton3.setEnabled(true);
            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                jListModel1.clear();
                List<Employee> newList = new ArrayList(employeeList);
                Collections.sort(newList);
                for (Employee temp : newList) {
                    jListModel1.addElement(temp.toString());
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                jListModel2.clear();
                Set<String> uniquePositions = new TreeSet<>();
                for (Employee item :employeeList ) {
                    uniquePositions.add(item.getPosition().toString());
                }
                for (String temp : uniquePositions) {
                    jListModel2.addElement(temp);
                }
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                jListModel3.clear();
                Map<Positions, Integer> salaries  = new  HashMap<>();
                for (Employee item : employeeList) {
                    if (salaries.containsKey(item.getPosition())) {
                        salaries.put(item.getPosition(), ( item.getSalary() < salaries.get(item.getPosition()) ) ? item.getSalary() : salaries.get(item.getPosition()));
                    } else {
                        salaries.put(item.getPosition(), item.getSalary());
                    }
                }
                jListModel3.addElement(salaries.toString());
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
    }
}
