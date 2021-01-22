package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class App extends JFrame {

    private JPanel mainPanel;
    private JPanel settingPanel;
    private JPanel openSavePanel;
    private JPanel paintPanelContainer;
    private JScrollPane scrollPane;
    private JComboBox colorsComboBox;
    private JButton clearButton;
    private JButton openButton;
    private JButton saveButton;

    private PaintPanel paintPanel;
    private Map<String, Color> colorMap;
    private BufferedImage img;
    private Point mousePointPrev;

    private App() {
        createPaintPanel();
        createColorMapAndSetComboBox();
        addListeners();
        setWindowParams();
    }

    private void createPaintPanel() {
        paintPanel = new PaintPanel();
        paintPanelContainer.add(paintPanel);
    }

    private void createColorMapAndSetComboBox() {

        colorMap = new HashMap<>();

        colorMap.put("Red", Color.RED);
        colorMap.put("Green", Color.GREEN);
        colorMap.put("Blue", Color.BLUE);

        colorMap.forEach((colorName, color) -> colorsComboBox.addItem(colorName));
    }

    private void addListeners() {

        paintPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                mousePointPrev = event.getPoint();
            }
            @Override
            public void mouseReleased(MouseEvent event) {
                mousePointPrev = null;
            }
        });

        paintPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                var g2d = img.getGraphics();
                g2d.setColor(getSelectedColor());
                var currentPoint = event.getPoint();
                g2d.drawLine(mousePointPrev.x, mousePointPrev.y, currentPoint.x, currentPoint.y);
                mousePointPrev = currentPoint;

                paintPanel.repaint();
            }
        });

        clearButton.addActionListener(event -> clearImage());
        saveButton.addActionListener(event -> saveImage());
        openButton.addActionListener(event -> openImage());
    }

    private void setWindowParams() {
        setContentPane(mainPanel);
        setTitle("Draw");
        setSize(600, 600);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private Color getSelectedColor() {
        var colorString = (String)colorsComboBox.getSelectedItem();
        return colorMap.get(colorString);
    }

    private void clearImage() {
        var graphics = (Graphics2D) img.getGraphics();
        graphics.setBackground(Color.WHITE);
        graphics.clearRect(0, 0, img.getWidth(), img.getHeight());
        paintPanel.repaint();
    }

    private void openImage() {
        var fileChooser = new JFileChooser();
        addImageFiltersToFileChooser(fileChooser);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            var file = fileChooser.getSelectedFile();
            openImage(file);
        }
    }

    private void openImage(File file) {
        try {
            img = ImageIO.read(file);
            paintPanelContainer.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
            paintPanel.repaint();
            scrollPane.getViewport().revalidate();
        } catch (IOException e) {
            e.printStackTrace();
            showMessageDialog(null, "Couldn't read file.");
        }
    }

    private void saveImage() {
        var fileChooser = new JFileChooser();
        addImageFiltersToFileChooser(fileChooser);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            var file = fileChooser.getSelectedFile();
            saveImage(file);
        }
    }

    private void saveImage(File file) {
        try {
            var formatName = getFormatName(file);
            if (!isImageFormat(formatName)) {
                throw new IOException();
            }
            ImageIO.write(img, formatName, file);
            showMessageDialog(null, "Saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            showMessageDialog(null, "Couldn't write to file.");
        }
    }

    private static void addImageFiltersToFileChooser(JFileChooser fileChooser) {
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.bmp", "bmp"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.gif", "gif"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.png", "png"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.jpeg", "jpeg"));
        fileChooser.setAcceptAllFileFilterUsed(false);
    }

    private static String getFormatName(File file) {
        var fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    private static boolean isImageFormat(String formatName) {
        var formats = ImageIO.getWriterFormatNames();
        var formatsList = Arrays.asList(formats);
        return formatsList.contains(formatName);
    }

    class PaintPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            var g2d = (Graphics2D)g;

            if (img == null) {
                img = (BufferedImage) createImage(this.getWidth(), this.getHeight());
                clearImage();
            }

            g2d.drawImage(img, 0, 0, null);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(App::new);
    }
}
