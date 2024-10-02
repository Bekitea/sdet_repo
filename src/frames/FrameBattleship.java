package frames;

import drawing_objects.DirectionType;
import drawing_objects.DrawingBattleship;
import drawing_objects.DrawingShip;
import movement_strategy.AbstractStrategy;
import movement_strategy.MoveToCenter;
import movement_strategy.MoveToBorder;
import movement_strategy.DrawingObjectShip;
import movement_strategy.Status;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FrameBattleship extends JFrame {
    private DrawingShip drawingShip;
    private AbstractStrategy abstractStrategy;
    private JComboBox<String> comboBoxStrategy;
    private JComponent pictureBoxBattleship;
    public FrameBattleship() throws IOException {
        super("Линкор");
        setSize(new Dimension(900,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //components initialisation
        pictureBoxBattleship = new JComponent(){
            public void paintComponent(Graphics graphics){
                super.paintComponent(graphics);
                Graphics2D graphics2D = (Graphics2D) graphics;
                if (drawingShip != null) drawingShip.drawTransport(graphics2D);
                super.repaint();
            }
        };
        pictureBoxBattleship.setBounds( 0, 0, getContentPane().getWidth(), getContentPane().getHeight());
        comboBoxStrategy = new JComboBox<>(new String[]{"к центру", "к границе"});
        JButton stepButton = new JButton("Шаг");
        JButton createShipButton = new JButton("Создать корабль");
        JButton createBattleshipButton = new JButton("Создать линкор");
        JButton rightButton = new JButton(new ImageIcon(ImageIO.read(new File("images/right.png"))));
        rightButton.setPreferredSize(new Dimension(30,30));
        JButton leftButton = new JButton(new ImageIcon(ImageIO.read(new File("images/left.png"))));
        leftButton.setPreferredSize(new Dimension(30,30));
        JButton upButton = new JButton(new ImageIcon(ImageIO.read(new File("images/up.png"))));
        upButton.setPreferredSize(new Dimension(30,30));
        JButton downButton = new JButton(new ImageIcon(ImageIO.read(new File("images/down.png"))));
        downButton.setPreferredSize(new Dimension(30,30));
        //ActionListeners and ActionCommand addition
        createShipButton.addActionListener(e -> buttonCreateShipClick());
        createBattleshipButton.addActionListener(e -> buttonCreateBattleshipClick());
        stepButton.addActionListener(e -> buttonStepClick());
        rightButton.setActionCommand("right");
        rightButton.addActionListener(this::buttonMoveClick);
        leftButton.setActionCommand("left");
        leftButton.addActionListener(this::buttonMoveClick);
        upButton.setActionCommand("up");
        upButton.addActionListener(this::buttonMoveClick);
        downButton.setActionCommand("down");
        downButton.addActionListener(this::buttonMoveClick);
        //panels and constraints initialisation
        JPanel panelBattleship = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel createPanel = new JPanel(new GridBagLayout());
        JPanel movementPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets.left = constraints.insets.top = constraints.insets.bottom = constraints.insets.right = 2;
        //addition to createPanel
        constraints.gridx = 0;
        constraints.gridy = 0;
        createPanel.add(createShipButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        createPanel.add(createBattleshipButton, constraints);
        //addition to movementPanel
        constraints.gridx = 2;
        constraints.gridy = 1;
        movementPanel.add(rightButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        movementPanel.add(leftButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        movementPanel.add(upButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        movementPanel.add(downButton, constraints);
        //addition to stepPanel
        JPanel stepPanel = new JPanel(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        stepPanel.add(comboBoxStrategy, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        stepPanel.add(stepButton, constraints);
        //addition to frame
        setLayout(new BorderLayout());
        add(pictureBoxBattleship);
        rightPanel.add(movementPanel, BorderLayout.SOUTH);
        rightPanel.add(stepPanel, BorderLayout.NORTH);
        leftPanel.add(createPanel, BorderLayout.SOUTH);
        panelBattleship.add(rightPanel, BorderLayout.EAST);
        panelBattleship.add(leftPanel, BorderLayout.WEST);
        add(panelBattleship,BorderLayout.CENTER);
        setVisible(true);
    }
    private void buttonCreateBattleshipClick() {
        Random random = new Random();
        pictureBoxBattleship.setBounds(0,0,getContentPane().getWidth(),getContentPane().getHeight());
        drawingShip = new DrawingBattleship(random.nextInt(200) + 100, random.nextInt(2000) + 1000, new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
                new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), random.nextBoolean(), random.nextBoolean(), pictureBoxBattleship.getWidth(), pictureBoxBattleship.getHeight(), random.nextInt(3),(random.nextInt(3)+1)*2);
        drawingShip.setPosition(random.nextInt(90) + 10, random.nextInt(90) + 10);
        draw();
    }
    private void buttonCreateShipClick(){
        Random random = new Random();
        pictureBoxBattleship.setBounds(0,0,getContentPane().getWidth(),getContentPane().getHeight());
        drawingShip = new DrawingShip(random.nextInt(200) + 100, random.nextInt(2000) + 1000, new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
                pictureBoxBattleship.getWidth(), pictureBoxBattleship.getHeight(), random.nextInt(3),(random.nextInt(3)+1)*2);
        drawingShip.setPosition(random.nextInt(90) + 10, random.nextInt(90) + 10);
        draw();
    }
    private void buttonStepClick(){
        if (drawingShip == null) {
            return;
        }
        if (comboBoxStrategy.isEnabled()) {
            switch (comboBoxStrategy.getSelectedIndex()) {
                case 0 -> abstractStrategy = new MoveToCenter();
                case 1 -> abstractStrategy = new MoveToBorder();
                default -> abstractStrategy = null;
            }
            if (abstractStrategy == null) {
                return;
            }
            abstractStrategy.setData(new DrawingObjectShip(drawingShip), pictureBoxBattleship.getWidth(), pictureBoxBattleship.getHeight());
            comboBoxStrategy.setEnabled(false);
        }
        if (abstractStrategy == null) {
            return;
        }
        abstractStrategy.makeStep();
        draw();
        if (abstractStrategy.getStatus() == Status.FINISH)
        {
            comboBoxStrategy.setEnabled(true);
            abstractStrategy = null;
        }
    }
    private void buttonMoveClick(ActionEvent event) {
        if(drawingShip == null || drawingShip.getEntityShip() == null)
            return;
        switch (event.getActionCommand()) {
            case "left" -> drawingShip.moveTransport(DirectionType.LEFT);
            case "right" -> drawingShip.moveTransport(DirectionType.RIGHT);
            case "up" -> drawingShip.moveTransport(DirectionType.UP);
            case "down" -> drawingShip.moveTransport(DirectionType.DOWN);
        }
        draw();
    }
    private void draw() {
        if (drawingShip == null)
        {
            return;
        }
        pictureBoxBattleship.repaint();
    }
}