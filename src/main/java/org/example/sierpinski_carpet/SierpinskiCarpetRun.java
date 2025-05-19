package org.example.sierpinski_carpet;

import javax.swing.*;

public class SierpinskiCarpetRun {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SierpinskiCarpet carpet = new SierpinskiCarpet(4);
            carpet.setVisible(true);
            carpet.startAnimation();
        });
    }
}
