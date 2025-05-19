package org.example.sierpinski_carpet;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SierpinskiCarpet extends JFrame {

    private final Map<Integer, Long> timeMetrics = new HashMap<>();
    private int currentDepth = 0;
    private final Timer animationTimer;

    public SierpinskiCarpet(int maxDepth) {
        setTitle("Салфетка Серпинского");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        animationTimer = new Timer(1000, e -> {
            if (currentDepth <= maxDepth) {
                repaint();
                currentDepth++;
            } else {
                ((Timer) e.getSource()).stop();
                printTimeMetrics();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);

        long startTime = System.nanoTime();
        drawCarpet(g, currentDepth, 50, 50, 700);
        long endTime = System.nanoTime();

        timeMetrics.put(currentDepth, (endTime - startTime) / 1_000_000);

        g.setColor(Color.RED);
        g.drawString("Глубина: " + currentDepth, 20, 20);
    }

    private void drawCarpet(Graphics g, int depth, int x, int y, int size) {
        if (depth == 0) {
            g.fillRect(x, y, size, size);
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                drawCarpet(g, depth - 1, x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    private void printTimeMetrics() {
        System.out.println("\nЗависимость времени от глубины:");
        System.out.println("Глубина | Время (мс)");
        System.out.println("--------|----------");
        timeMetrics.forEach((d, t) -> System.out.printf("%7d | %8d\n", d, t));
    }

    public void startAnimation() {
        animationTimer.start();
    }
}