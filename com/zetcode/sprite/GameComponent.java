package com.zetcode.sprite;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public interface GameComponent {

    void move(int direction);

    void moveDown(int distance);

    void draw(Graphics g, ImageObserver observer);
}