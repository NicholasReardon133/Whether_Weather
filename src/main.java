import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class main {

    public static GridLayout gLayout = new GridLayout(0,2);
    public static GridLayout gLayout1 = new GridLayout(0,1);

    private static API api = new API();

    private static String originalLoc;
    private static String currentLoc;
    private static String gender;
    private static String originalClothes;
    private static String finalClothes;
    private static int upperChoice;
    private static int lowerChoice;
    private static int oldTemp;
    private static int newTemp;
    private static int humidity;
    private static int windSpeed;


    public static void setVars(String oLoc, String currLoc, String gen){
        originalLoc = oLoc;
        currentLoc = currLoc;                                   //sets up variables for use in other things
        gender = gen;
        System.out.println(originalLoc + " " + currentLoc + " " + gender);
    }


    public static void setVars(String outfit){
        originalClothes = outfit;
        System.out.println(originalClothes);                         //sets up the original outfit
    }


    private static void createWindow1(){

        JFrame f = new JFrame("Whether Weather");
        JPanel grid = new JPanel();
        grid.setLayout(gLayout);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //Setting up first frame
        f.setSize(600, 450);

        final JLabel Q1 = new JLabel("Where are you from?\n (City)", SwingConstants.CENTER);
        grid.add(Q1);
        final JTextField answerField1 = new JTextField();          //Text and text field for Q1
        grid.add(answerField1);

        final JLabel Q2 = new JLabel("Where do you live now?\n (City)", SwingConstants.CENTER);
        grid.add(Q2);
        final JTextField answerField2 = new JTextField();          //Text and text field for Q2
        grid.add(answerField2);

        final JLabel Q3 = new JLabel("What sex are you?\n (male/female)", SwingConstants.CENTER);
        grid.add(Q3);
        final JTextField answerField3 = new JTextField();          //Text and text field for Q3
        grid.add(answerField3);

        f.add(grid, BorderLayout.CENTER);

        final JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 200, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String originalLoc = answerField1.getText();       //Submit button and saves user input as variables
                String currentLoc = answerField2.getText();
                String gender = answerField3.getText();
                setVars(originalLoc, currentLoc, gender);
                oldTemp = (int)api.getTemp(originalLoc);
                newTemp = (int)api.getTemp(currentLoc);
                humidity = (int)api.getHumidity(currentLoc);
                windSpeed = (int)api.getWind(currentLoc);
                System.out.println(oldTemp);
                f.removeAll();
                f.setVisible(false);
                if(gender.equals("female")) {
                    createWindow2F();
                } else {
                    createWindow2M();
                }
            }
        });
        f.add(submitButton, BorderLayout.SOUTH);

        f.setLocationRelativeTo(null);                                 //final frame settings
        f.setVisible(true);
    }


    private static void createWindow2M(){

        JFrame f1 = new JFrame("Whether Weather");
        JPanel grid1 = new JPanel();
        grid1.setLayout(gLayout1);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //Setting up second frame
        f1.setSize(600, 450);

        final JLabel Q4 = new JLabel("If the weather was 50 F, What would you wear?", SwingConstants.CENTER);
        grid1.add(Q4);
        JComboBox<String> upperClothesBox = new JComboBox<String>(Predictor.upperClothesM);
        grid1.add(upperClothesBox);
        JComboBox<String> lowerClothesBox = new JComboBox<String>(Predictor.lowerClothesM);
        grid1.add(lowerClothesBox);                                                                  //Creates drop down boxes
        JComboBox<String> upperAccessoriesBox = new JComboBox<String>(Predictor.upperAccessoriesM);
        grid1.add(upperAccessoriesBox);
        JComboBox<String> lowerAccessoriesBox = new JComboBox<String>(Predictor.lowerAccessoriesM);
        grid1.add(lowerAccessoriesBox);

        f1.add(grid1, BorderLayout.CENTER);

        final JButton submitButton1 = new JButton("Submit");
        submitButton1.setBounds(50, 200, 100, 30);
        submitButton1.addActionListener(new ActionListener() {
            @Override                                                             //gets all of the choices and makes a string
            public void actionPerformed(ActionEvent e) {
                String outfitChoice = (String)upperClothesBox.getSelectedItem() + ", " + (String)lowerClothesBox.getSelectedItem();
                System.out.println(upperClothesBox.getSelectedIndex() + " " + lowerClothesBox.getSelectedIndex());
                upperChoice = upperClothesBox.getSelectedIndex() - 3;
                lowerChoice = lowerClothesBox.getSelectedIndex() - 3;
                setVars(outfitChoice);
                f1.removeAll();
                f1.setVisible(false);
                createWindow3();
            }
        });
        f1.add(submitButton1, BorderLayout.SOUTH);

        f1.setLocationRelativeTo(null);                      //final frame settings
        f1.setVisible(true);
    }


    private static void createWindow2F(){

        JFrame f1 = new JFrame("Whether Weather");
        JPanel grid1 = new JPanel();
        grid1.setLayout(gLayout1);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //Setting up second frame
        f1.setSize(600, 450);

        final JLabel Q4 = new JLabel("If the weather was 50 F, What would you wear?", SwingConstants.CENTER);
        grid1.add(Q4);
        JComboBox<String> upperClothesBox = new JComboBox<String>(Predictor.upperClothesF);
        grid1.add(upperClothesBox);
        JComboBox<String> lowerClothesBox = new JComboBox<String>(Predictor.lowerClothesF);
        grid1.add(lowerClothesBox);                                                                //Creates the drop downs
        JComboBox<String> upperAccessoriesBox = new JComboBox<String>(Predictor.upperAccessoriesF);
        grid1.add(upperAccessoriesBox);
        JComboBox<String> lowerAccessoriesBox = new JComboBox<String>(Predictor.lowerAccessoriesF);
        grid1.add(lowerAccessoriesBox);

        f1.add(grid1, BorderLayout.CENTER);

        final JButton submitButton1 = new JButton("Submit");
        submitButton1.setBounds(50, 200, 100, 30);
        submitButton1.addActionListener(new ActionListener() {
            @Override                                                        //gets all of the choices and makes a string
            public void actionPerformed(ActionEvent e) {
                String outfitChoice = (String)upperClothesBox.getSelectedItem() + ", " + (String)lowerClothesBox.getSelectedItem();
                System.out.println(upperClothesBox.getSelectedIndex() + " " + lowerClothesBox.getSelectedIndex());
                upperChoice = upperClothesBox.getSelectedIndex() - 3;
                lowerChoice = lowerClothesBox.getSelectedIndex() - 3;
                setVars(outfitChoice);
                f1.removeAll();
                f1.setVisible(false);
                createWindow3();
            }
        });
        f1.add(submitButton1, BorderLayout.SOUTH);

        f1.setLocationRelativeTo(null);                        //final frame settings
        f1.setVisible(true);
    }


    public static void createWindow3() {
        JFrame f2 = new JFrame("Whether Weather");
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //Setting up final frame
        f2.setSize(400, 400);
        f2.setBackground(Color.decode("#55a6d9"));

        JTextArea finalText = new JTextArea();
        finalClothes = Predictor.getFinalClothes(upperChoice, lowerChoice);
        finalText.setText("The weather today is " + newTemp + "\u00B0F in " + currentLoc + ". The " +
                "humidity is " + humidity + "% and the wind speed is " + windSpeed + " mph. Based on your habits, " +
                "you should wear " + finalClothes);
        finalText.setWrapStyleWord(true);
        finalText.setLineWrap(true);
        finalText.setOpaque(false);
        finalText.setFont(new Font("Serif", Font.PLAIN, 24));
        finalText.setAlignmentX(Component.CENTER_ALIGNMENT);
        finalText.setAlignmentY(Component.CENTER_ALIGNMENT);
        f2.add(finalText);

        f2.setLocationRelativeTo(null);                    //final frame settings
        f2.setVisible(true);
    }


    public static void main(String[] args) {

        createWindow1();

    }
}