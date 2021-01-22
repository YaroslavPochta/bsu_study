package com.company;
import org.xml.sax.SAXException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private DefaultListModel jListModel1;
    private DefaultListModel jListModel2;
    private DefaultListModel jListModel3;
    private DefaultListModel jListModel4;
    private DefaultListModel jListModel5;
    private List<Beast> beastList;

    public GUI() {

        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        JMenu jFileMenu = new JMenu("File");
        jMenuBar.add(jFileMenu);
        JMenuItem openFile = new JMenuItem("Open File");
        jFileMenu.add(openFile);
        JMenu jDataMenu = new JMenu("Data");
        jMenuBar.add(jDataMenu);
        JMenuItem jMenuItem1 = new JMenuItem("By habitat");
        JMenuItem jMenuItem2 = new JMenuItem("By mass");
        JMenuItem jMenuItem3 = new JMenuItem("Opportunists");
        JMenuItem jMenuItem4 = new JMenuItem("Places");
        JMenuItem jMenuItem5 = new JMenuItem("Search");
        JMenuItem jMenuItem6 = new JMenuItem("Quantity");
        jDataMenu.add(jMenuItem1);
        jDataMenu.add(jMenuItem2);
        jDataMenu.add(jMenuItem3);
        jDataMenu.add(jMenuItem4);
        jDataMenu.add(jMenuItem5);
        jDataMenu.add(jMenuItem6);

        jMenuItem1.setEnabled(false);
        jMenuItem2.setEnabled(false);
        jMenuItem3.setEnabled(false);
        jMenuItem4.setEnabled(false);
        jMenuItem5.setEnabled(false);
        jMenuItem6.setEnabled(false);
        JTabbedPane jTabbedPane = new JTabbedPane();

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();

        jTabbedPane.add("Initial data", jPanel1);
        jTabbedPane.add("Sorted by habitat", jPanel2);
        jTabbedPane.add("Sorted by mass", jPanel3);
        jTabbedPane.add("Opportunists", jPanel4);
        jTabbedPane.add("Places ", jPanel5);
        jListModel1 = new DefaultListModel();
        jListModel2 = new DefaultListModel();
        jListModel3 = new DefaultListModel();
        jListModel4 = new DefaultListModel();
        jListModel5 = new DefaultListModel();

        JList jList1 = new JList(jListModel1);
        JList jList2 = new JList(jListModel2);
        JList jList3 = new JList(jListModel3);
        JList jList4 = new JList(jListModel4);
        JList jList5 = new JList(jListModel5);

        JScrollPane jScrollPane1 = new JScrollPane(jList1);
        JScrollPane jScrollPane2 = new JScrollPane(jList2);
        JScrollPane jScrollPane3 = new JScrollPane(jList3);
        JScrollPane jScrollPane4 = new JScrollPane(jList4);
        JScrollPane jScrollPane5 = new JScrollPane(jList5);

        Dimension jScrollPaneDimension = new Dimension(1000,500);
        Dimension jListDimension = new Dimension(1200,1000);

        jScrollPane1.setPreferredSize(jScrollPaneDimension);
        jScrollPane2.setPreferredSize(jScrollPaneDimension);
        jScrollPane3.setPreferredSize(jScrollPaneDimension);
        jScrollPane4.setPreferredSize(jScrollPaneDimension);
        jScrollPane5.setPreferredSize(jScrollPaneDimension);

        jList1.setPreferredSize(jListDimension);
        jList2.setPreferredSize(jListDimension);
        jList3.setPreferredSize(jListDimension);
        jList4.setPreferredSize(jListDimension);
        jList5.setPreferredSize(jListDimension);

        jPanel1.add(jScrollPane1);
        jPanel2.add(jScrollPane2);
        jPanel3.add(jScrollPane3);
        jPanel4.add(jScrollPane4);
        jPanel5.add(jScrollPane5);
        add(jTabbedPane);

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                jListModel1.clear();
                jListModel2.clear();
                jListModel3.clear();
                beastList = new ArrayList<>();
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Choose file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    try {
                        ReaderUtils.parser(beastList, fileChooser.getSelectedFile().getPath());
                    } catch (IOException | SAXException | ParserConfigurationException ex) {
                        JOptionPane.showMessageDialog(GUI.this, ex, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    }
                    for (Beast temp : beastList) {
                        jListModel1.addElement(temp.toString());
                    }
                    jMenuItem1.setEnabled(true);
                    jMenuItem2.setEnabled(true);
                    jMenuItem3.setEnabled(true);
                    jMenuItem4.setEnabled(true);
                    jMenuItem5.setEnabled(true);
                    jMenuItem6.setEnabled(true);
                }
            }
        });

        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                jListModel2.clear();
                List<Beast> sortedByHabitatList = beastList;
                Collections.sort(sortedByHabitatList);
                for (Beast temp : sortedByHabitatList) {
                    jListModel2.addElement(temp.toString());
                }
            }
        });

        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                jListModel3.clear();
                List<Beast> sortedByMass = beastList;
                Collections.sort(sortedByMass, new CompareByMass());
                for (Beast temp : sortedByMass) {
                    jListModel3.addElement(temp.toString());
                }
            }
        });

        jMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        });

        jMenuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                jListModel5.clear();
                Set<String> habitatSet = new TreeSet<String>();
                for (Beast temp : beastList) {
                    habitatSet.add(temp.getHabitat());
                }
                for (String str: habitatSet) {
                    jListModel5.addElement(str);
                }

            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
    }
}