/*
 * ICS4U Final Project - GymSim
 * Minato Sato, Malin Meyer, Xavier Kitching
 * December 2024 - January 2025
 * 
 * (Class Description)
 */
package gymsim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    //Avoid code repetition for checking if player hovering over equipment
    boolean equipmentInteract = false;

    //Exercise descriptions
    String descriptions[] = new String[9];

    //ArrayList to hold all the exercises
    ArrayList<Exercise> exercisesList = new ArrayList();

    // Creating gameThread
    private Thread gameThread;
    // Running set to false
    private boolean running = false;
    // Declaring gameState variable 
    // There will be 4 game states 0-menu 1-game 2-interacting with exBenchPress 3 - credits
    private int gameState = 0;

    private boolean displayPlayerStats = false;
    private boolean moreInfo = false;
    private boolean displayShop = false;

    // Declaring player object
    private Player player;

    // Declaring Exercise object 
    private Exercise exLatPulldown;
    private Exercise exPreacherCurl;
    private Exercise exCalfRaise;
    private Exercise exBenchPress;
    private Exercise exCrunch;
    private Exercise exTreadmill;
    private Exercise exSquat;
    private Exercise exShoulderPress;
    private Exercise exTricepPushdown;
    private Shop shop;

    private Item banana;
    private Item proteinBar;
    private Item creatine;
    private Item preWorkout;

    // Instantiating new exercise objects
    Image latPulldownImg = ImageIO.read(getClass().getResource("/gymsim/sprites/latPulldown.png"));
    //Image mapImage = ImageIO.read(getClass().getResource("/gymsim/sprites/gym_map.gif"));
    Image playerImg = ImageIO.read(getClass().getResource("/gymsim/sprites/Character.png"));
    Image preacherCurlImg = ImageIO.read(getClass().getResource("/gymsim/sprites/preacherCurl.png"));
    Image calfRaiseImg = ImageIO.read(getClass().getResource("/gymsim/sprites/calfRaise.png"));
    Image benchPressImg = ImageIO.read(getClass().getResource("/gymsim/sprites/benchPressImg.png"));
    Image crunchImg = ImageIO.read(getClass().getResource("/gymSim/sprites/crunch.png"));
    Image treadmillImg = ImageIO.read(getClass().getResource("/gymSim/sprites/treadmill.png"));
    Image squatRackImg = ImageIO.read(getClass().getResource("/gymsim/sprites/squatRackImg.png"));
    Image shoulderPressImg = ImageIO.read(getClass().getResource("/gymSim/sprites/shoulderPress.png"));
    Image tricepPushdownImg = ImageIO.read(getClass().getResource("/gymSim/sprites/tricepPushdown.png"));
    Image floorImage = ImageIO.read(getClass().getResource("/gymSim/sprites/gymFloor.png"));
    Image shopImage = ImageIO.read(getClass().getResource("/gymSim/sprites/shop.png"));
    Image shopInteriorImage = ImageIO.read(getClass().getResource("/gymSim/sprites/insideShop.png"));
    Image bananaImage = ImageIO.read(getClass().getResource("/gymSim/sprites/banana.png"));
    Image proteinBarImage = ImageIO.read(getClass().getResource("/gymSim/sprites/proteinBar.png"));
    Image creatineImage = ImageIO.read(getClass().getResource("/gymSim/sprites/creatine.png"));
    Image preWorkoutImage = ImageIO.read(getClass().getResource("/gymSim/sprites/preWorkout.png"));

    /**
     * Constructor for GamePanel throws IOException for reading file
     */
    public GamePanel() throws IOException {
        // Setting the preferred panel size for the program 
        this.setPreferredSize(new Dimension(900, 600));
        // Sets the focus state to true on the panel 
        this.setFocusable(true);
        // Adding input listeners to recieve events
        this.addKeyListener(new KeyHandler());
        this.addMouseListener(new MouseHandler());

        readFile();

        // Instantiating player object at (100, 100) 
        player = new Player(playerImg, 400, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        //Instantiate new exercises
        exercisesList.add(exLatPulldown = new Exercise(latPulldownImg, "Lat Pulldown", 100, 100, descriptions[0]));
        exercisesList.add(exPreacherCurl = new Exercise(preacherCurlImg, "Preacher Curl", 250, 100, descriptions[1]));
        exercisesList.add(exCalfRaise = new Exercise(calfRaiseImg, "Calf Raise", 400, 100, descriptions[2]));
        exercisesList.add(exBenchPress = new Exercise(benchPressImg, "Bench Press", 550, 100, descriptions[3]));
        exercisesList.add(exCrunch = new Exercise(crunchImg, "Crunch", 100, 250, descriptions[4]));
        exercisesList.add(exTreadmill = new Exercise(treadmillImg, "Treadmill", 250, 250, descriptions[5]));
        exercisesList.add(exSquat = new Exercise(squatRackImg, "Squat", 400, 250, descriptions[6]));
        exercisesList.add(exShoulderPress = new Exercise(shoulderPressImg, "Shoulder Press", 550, 250, descriptions[7]));
        exercisesList.add(exTricepPushdown = new Exercise(tricepPushdownImg, "Tricep Pushdown", 700, 250, descriptions[8]));
        banana = new Item(bananaImage, 70, 25, "Banana", 1.5);
        proteinBar = new Item(proteinBarImage, 240, 25, "Protein Bar", 2);
        preWorkout = new Item(preWorkoutImage, 520, 25, "Pre Workout", 2.5);
        creatine = new Item(creatineImage, 730, 25, "Creatine", 3);
        shop = new Shop(shopImage, 700, 400, banana, proteinBar, preWorkout, creatine, null, null);
    }

    /**
     *
     */
    public void readFile() {

        int i = 0;
        try {
            File f = new File("src/gymsim/exercisedescriptions.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                descriptions[i] = s.nextLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    /**
     * Start game method
     */
    public void startGame() {
        running = true;
        // Starting thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while (running) {

            update();
            repaint();
            try {
                Thread.sleep(16); // For 60 fps 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * GamePanel update method Updates all objects within the game
     */
    private void update() {

        if (gameState == 0) { // In main menu 

        } else if (gameState == 1) { // In game

            if (!displayPlayerStats && !moreInfo && !displayShop) {
                player.update();
            }

            //Check if player is hovering over each equipment
            for (int i = 0; i < exercisesList.size(); i++) {

            }

        } else if (gameState == 2) { // Interacting with exBenchPress

        }
        // Win status
        if (player.getPlayerLvl() == 100) {
            gameState = 4;
            player.setPlayerLvl(0);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Cast Graphics to Graphics2D for advanced rendering features
        Graphics2D g2d = (Graphics2D) g;

        Font title = new Font("Arial", Font.BOLD, 50);
        Font subtitle1 = new Font("Arial", Font.BOLD, 25);
        Font subtitle2 = new Font("Arial", Font.BOLD, 20);
        Font normalText1 = new Font("Arial", Font.PLAIN, 15);
        Font normalText2 = new Font("Arial", Font.PLAIN, 12);

        if (gameState == 0) { // In main menu 

            // Draw main menu
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, 900, 600);  // Background
            g2d.setColor(Color.WHITE);
            g2d.setFont(title);
            g2d.drawString("Main Menu", 250, 150);
            g2d.setFont(subtitle1);
            g2d.drawString("Press Enter to Start", 230, 250);

        } else if (gameState == 1) { // In game

            //Draw map and equipments
            g2d.drawImage(floorImage, 0, 0, 900, 600, null);
            for (int i = 0; i < 9; i++) {
                //draw all the equipment on the map
                g2d.drawImage(exercisesList.get(i).getImage(), exercisesList.get(i).getXPos(), exercisesList.get(i).getYPos(), 100, 100, null);
            }
            g2d.drawImage(shop.getImage(), shop.getXPos(), shop.getYPos(), 200, 200, null);

            //Draw player on screen
            player.draw(g);

            g2d.setFont(subtitle2);
            g2d.drawString("Press I for player stats", 310, 520);

            for (int i = 0; i < 9; i++) {
                if (exercisesList.get(i).isPlayerInteracting(player)) {
                    g2d.drawString("Press E for exercise information", 300, 550);
                }
            }

            //Transparency
            g2d.setColor(Color.darkGray);
            float alpha = 0.9f;
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(alcom);

            //Displayer player's stats when they press I in the game
            if (displayPlayerStats) {
                g2d.fillRoundRect(300, 80, 300, 400, 20, 20);
                g2d.setColor(Color.white);
                g2d.drawString("Player Stats", 400, 110);
                g2d.setFont(normalText1);
                g2d.drawString("Player Level: " + player.getPlayerLvl(), 315, 150);
                g2d.drawString("Back Level: " + player.getBackLvl(), 315, 175);
                g2d.drawString("Biceps Level: " + player.getBicepLvl(), 315, 200);
                g2d.drawString("Calves Level: " + player.getCalvesLvl(), 315, 225);
                g2d.drawString("Chest Level: " + player.getChestLvl(), 315, 250);
                g2d.drawString("Core Level: " + player.getCoreLvl(), 315, 275);
                g2d.drawString("Endurance Level: " + player.getEnduranceLvl(), 315, 300);
                g2d.drawString("Forearms Level: " + player.getForearmLvl(), 315, 325);
                g2d.drawString("Legs Level: " + player.getLegsLvl(), 315, 350);
                g2d.drawString("Shoulders Level: " + player.getShoulderLvl(), 315, 375);
                g2d.drawString("Triceps Level: " + player.getTricepLvl(), 315, 400);
                g2d.drawString("Press ESC to exit", 465, 460);
            }

            //Following code to display information about eache exercise when player enters E when isPlayerInteracting
            if (moreInfo) {
                for (int i = 0; i < 9; i++) {
                    if (exercisesList.get(i).isPlayerInteracting(player)) {
                        g2d.fillRoundRect(20, 20, 860, 560, 20, 20);
                        g2d.setFont(subtitle1);
                        g2d.setColor(Color.white);
                        g2d.drawString(exercisesList.get(i).getName(), 350, 50);
                        g2d.setFont(subtitle2);
                        g2d.drawString("Description", 50, 120);
                        g2d.setFont(normalText2);
                        g2d.drawString(descriptions[i], 50, 150);
                    }
                }
                g2d.setFont(normalText1);
                g2d.drawString("Press ESC to exit", 740, 560);
            }

            //code to draw shop
            if (displayShop) {
                if (shop.isPlayerInteracting(player)) {
                    g2d.drawImage(shopInteriorImage, 0, 0, 490, 600, null);
                }
            }

        } else if (gameState == 2) {

            //Images
            g2d.drawImage(floorImage, 0, 0, 900, 600, null);

            //add image of close up of equipment when player is interacting
            for (int i = 0; i < 9; i++) {
                if (exercisesList.get(i).isPlayerInteracting(player)) {
                    g2d.drawImage(exercisesList.get(i).getImage(), 30, 90, 500, 400, null);
                    g2d.drawString(exercisesList.get(i).getName(), 200, 100);
                }
            }

            //Titles
            g2d.setFont(subtitle1);
            g2d.drawString("Click your mouse to gain xp", 100, 70);
            g2d.setFont(subtitle2);

            //Meter
            g2d.drawString("Meter", 245, 550);
            g2d.setColor(Color.red);
            g2d.fillRoundRect(120, 510, 300, 20, 10, 10);

            //Transparency
            g2d.setColor(Color.darkGray);
            float alpha = 0.7f;
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(alcom);
            g2d.fillRoundRect(570, 70, 270, 470, 20, 20);

            //Stats text
            g2d.setColor(Color.white);
            g2d.drawString("Equipment Stats", 630, 100);
            g2d.setFont(normalText1);
            g2d.drawString("Muscles Worked: ", 585, 130);
            g2d.drawString("Rep Counter: ", 585, 155);
            g2d.drawString("Description: ", 585, 180);
            g2d.setFont(subtitle2);
            g2d.drawString("Player Stats", 650, 225);
            g2d.setFont(normalText1);
            g2d.drawString("Player Level: " + player.getPlayerLvl(), 585, 255);
            g2d.drawString("Back Level: " + player.getBackLvl(), 585, 280);
            g2d.drawString("Biceps Level: " + player.getBicepLvl(), 585, 305);
            g2d.drawString("Calves Level: " + player.getCalvesLvl(), 585, 330);
            g2d.drawString("Chest Level: " + player.getChestLvl(), 585, 355);
            g2d.drawString("Core Level: " + player.getCoreLvl(), 585, 380);
            g2d.drawString("Endurance Level: " + player.getEnduranceLvl(), 585, 405);
            g2d.drawString("Forearms Level: " + player.getForearmLvl(), 585, 430);
            g2d.drawString("Legs Level: " + player.getLegsLvl(), 585, 455);
            g2d.drawString("Shoulders Level: " + player.getShoulderLvl(), 585, 480);
            g2d.drawString("Triceps Level: " + player.getTricepLvl(), 585, 505);

            //Exit text
            g2d.setColor(Color.black);
            g2d.drawString("Right click to return to map", 640, 560);

            //Shop
        } else if (gameState == 3) {

            g2d.drawImage(shopInteriorImage, 0, 0, 450, 600, null);
            g2d.drawImage(shopInteriorImage, 450, 0, 450, 600, null);
            g2d.drawImage(shop.getItem1().getImage(), shop.getItem1().getXPos(), shop.getItem1().getYPos(), 100, 100, null);
            g2d.drawImage(shop.getItem2().getImage(), shop.getItem2().getXPos(), shop.getItem2().getYPos(), 150, 120, null);
            g2d.drawImage(shop.getItem3().getImage(), shop.getItem3().getXPos(), shop.getItem1().getYPos(), 90, 90, null);
            g2d.drawImage(shop.getItem4().getImage(), shop.getItem4().getXPos(), shop.getItem4().getYPos(), 100, 90, null);

        } else { // In credits

            // Draw credits
            // Draw credits background
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, 900, 600);

            g2d.setColor(Color.WHITE);
            g2d.setFont(title);
            g2d.drawString("Credits", 330, 50);

            g2d.setFont(subtitle1); 
            g2d.drawString("Developed by: Malin Meyer", 250, 100);
            g2d.drawString("Artwork by: Xavier Kitching", 250, 100 + 40);
            g2d.drawString("Sound by: Minato Sato", 250, 100 + 80);
            g2d.drawString("Special Thanks: Danny Jang", 250, 100 + 120);

            g2d.drawString("Press ESC to Return", 250, 100 + 200);

        }

    }

    // Key and Mouse Handlers
    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            // Key variable 
            int key = e.getKeyCode();
            // If the game is in the main menu and the key pressed is ENTER  
            if (gameState == 0 && key == KeyEvent.VK_ENTER) {
                gameState++; // Change to game state
            } else if (gameState == 1) {
                if (key == KeyEvent.VK_E && !displayPlayerStats) {
                    moreInfo = true;
                }
                if (key == KeyEvent.VK_E && !displayShop) {
                    displayShop = true;
                }
                if (key == KeyEvent.VK_I && !moreInfo) {
                    displayPlayerStats = true;
                }
                if (key == KeyEvent.VK_ESCAPE) {
                    moreInfo = false;
                    displayPlayerStats = false;
                    displayShop = false;
                }
            } else if (gameState == 4 && key == KeyEvent.VK_ESCAPE) {
                gameState = 0;  // Return to main menu when ESC is pressed

            }
            // Handling player keys
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {

            //if user clicks mouse while on top of exBenchPress switch to gamemode 2 to interact with exBenchPress
            if (gameState == 1 && e.getButton() == MouseEvent.BUTTON1) {
                if (exLatPulldown.isPlayerInteracting(player)
                        || exPreacherCurl.isPlayerInteracting(player)
                        || exCalfRaise.isPlayerInteracting(player)
                        || exBenchPress.isPlayerInteracting(player)
                        || exCrunch.isPlayerInteracting(player)
                        || exTreadmill.isPlayerInteracting(player)
                        || exSquat.isPlayerInteracting(player)
                        || exShoulderPress.isPlayerInteracting(player)
                        || exTricepPushdown.isPlayerInteracting(player)) {
                    gameState = 2;
                } else if (shop.isPlayerInteracting(player)) {
                    gameState = 3;
                }
            }
            //Mouse clicks to gain xp in gamemode 2 interacting with equipment
            if (gameState == 2) {

                if (e.getButton() == MouseEvent.BUTTON1) {

                    player.setPlayerLvl(player.getPlayerLvl() + 1);
                    if (exLatPulldown.isPlayerInteracting(player)) {
                        player.setBackLvl(player.getBackLvl() + 1);
                    } else if (exPreacherCurl.isPlayerInteracting(player)) {
                        player.setBicepLvl(player.getBicepLvl() + 1);
                    } else if (exCalfRaise.isPlayerInteracting(player)) {
                        player.setCalvesLvl(player.getCalvesLvl() + 1);
                    } else if (exBenchPress.isPlayerInteracting(player)) {
                        player.setChestLvl(player.getChestLvl() + 1);
                    } else if (exCrunch.isPlayerInteracting(player)) {
                        player.setCoreLvl(player.getCoreLvl() + 1);
                    } else if (exTreadmill.isPlayerInteracting(player)) {
                        player.setEnduranceLvl(player.getEnduranceLvl() + 1);
                    } else if (exSquat.isPlayerInteracting(player)) {
                        player.setLegsLvl(player.getLegsLvl() + 1);
                    } else if (exShoulderPress.isPlayerInteracting(player)) {
                        player.setShoulderLvl(player.getShoulderLvl() + 1);
                    } else if (exTricepPushdown.isPlayerInteracting(player)) {
                        player.setTricepLvl(player.getTricepLvl() + 1);
                    }

                }

                if (e.getButton() == MouseEvent.BUTTON3) {
                    gameState = 1;
                }

            }

            if (gameState == 3) {

                if (e.getButton() == MouseEvent.BUTTON3) {
                    gameState = 1;
                }

            }

        }

    }

}
