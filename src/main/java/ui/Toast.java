package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Toast extends Thread {
    JWindow window;

    public Toast(String s, int x, int y, boolean correct) {
        window = new JWindow();
        window.setBackground(new Color(0, 0, 0, 0));

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawString(s, 35, 27);
                try {
                    if (correct)
                        g.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("correct.png"))), 8, 13, this);
                    else
                        g.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("incorrect.png"))), 8, 13, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        window.add(panel);
        window.setLocation(x, y);
        window.setSize(500, 200);
    }

    public void run() {
        window.setOpacity(1.0f);
        window.setVisible(true);
        try {
            Thread.sleep(2000);
            for (float opacity = 1.0f; opacity > 0.2f; opacity -= 0.1f, Thread.sleep(100))
                window.setOpacity(opacity);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        window.setVisible(false);
    }
}
