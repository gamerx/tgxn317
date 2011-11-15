package client.instance;

import client.custom.cSettings;
import java.awt.*;
import client.sign.Signlink;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class GameFrame extends Frame {

    public static TrayIcon trayIcon;
    private final GameApplet gameShell;

    public GameFrame(GameApplet gameShell, int i, int j) {
        this.gameShell = gameShell;
        setTitle("Client");
        setResizable(false);
        Image image1 = Toolkit.getDefaultToolkit().getImage(Signlink.findCacheDIR() + cSettings.mainIconLocation);
        setIconImage(image1);
        setFocusTraversalKeysEnabled(false);
        setVisible(true);
        toFront();
        setSize(i + 8, j + 28);

        // Position window.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screenSize.width / 2 - (i + 8) / 2, screenSize.height / 2 - (j + 28) / 2, i + 8, j + 28);

        setUpSystemTray();
    }

    @Override
    public Graphics getGraphics() {
        Graphics g = super.getGraphics();
        g.translate(4, 24);
        return g;
    }

    @Override
    public final void update(Graphics g) {
        gameShell.update(g);
    }

    @Override
    public final void paint(Graphics g) {
        gameShell.paint(g);
    }

    /**
     * Setup the tray icon, and menu's.
     */
    private void setUpSystemTray() {
        if (SystemTray.isSupported()) {

            Image icon = Toolkit.getDefaultToolkit().getImage(Signlink.findCacheDIR() + cSettings.mainIconLocation);
            trayIcon = new TrayIcon(icon, "-GaMeR X-'s Client is Running.");
            trayIcon.setImageAutoSize(true);

            try {
                SystemTray tray = SystemTray.getSystemTray();
                tray.add(trayIcon);
                trayIcon.displayMessage("-GaMeR X-'s Client", "Client Loading Started!", TrayIcon.MessageType.INFO);

                PopupMenu popup = new PopupMenu();

                final MenuItem minimiseItem = new MenuItem("Minimise to Tray");
                MenuItem aboutItem = new MenuItem("About");
                MenuItem exitItem = new MenuItem("Exit");

                popup.add(minimiseItem);
                popup.addSeparator();
                popup.add(aboutItem);
                popup.add(exitItem);

                trayIcon.setPopupMenu(popup);

                ActionListener minimiseListener = new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (GameApplet.gameFrame.isVisible()) {
                            GameApplet.gameFrame.setVisible(false);
                            minimiseItem.setLabel("Restore");
                        } else {
                            GameApplet.gameFrame.setVisible(true);
                            minimiseItem.setLabel("Minimise to Tray");
                        }
                    }
                };
                minimiseItem.addActionListener(minimiseListener);


                ActionListener aboutListener = new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane pane = new JOptionPane("-GaMeR X-'s 317 Client\nCopyright 2009-2012 tgxn.net,\nVisit [ http://www.tgxn.net/projects/rsps ] for more information.", JOptionPane.INFORMATION_MESSAGE);
                        Object[] options = new String[]{"Okay"};
                        pane.setOptions(options);
                        JDialog dialog = pane.createDialog(new JFrame(), "About Dialog");
                        Image image1 = Toolkit.getDefaultToolkit().getImage(Signlink.findCacheDIR() + cSettings.mainIconLocation); //icon
                        dialog.setIconImage(image1);
                        dialog.setVisible(true); //show it
                    }
                };
                aboutItem.addActionListener(aboutListener);

                ActionListener exitListener = new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cSettings.showExitWarningDialog();
                    }
                };
                exitItem.addActionListener(exitListener);



                /* 		klj		
                jl			
                kl		kljkl	
                
                jkl	l	gjkljkl	 */



                //use this in other files:
                //Frame_Sub1.trayIcon.displayMessage("-GaMeR X-'s Client", "Client Loaded Sucessfully!", TrayIcon.MessageType.INFO);

            } catch (AWTException e) {//catches error
                System.err.println(e);//prints error
            }
        }
    }
}