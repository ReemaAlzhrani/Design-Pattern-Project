package com.zetcode.sprite;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

// Composite Pattern - Composite
// Manages individual aliens and groups of aliens as one unit.
public class AlienGroup implements GameComponent {

    private final List<GameComponent> children = new ArrayList<>();

    // Add an alien or another group
    public void add(GameComponent component) {
        children.add(component);
    }

    // Remove an alien or another group
    public void remove(GameComponent component) {
        children.remove(component);
    }

    // Return the components inside this group
    public List<GameComponent> getChildren() {
        return children;
    }

    // Move all components horizontally
    @Override
    public void move(int direction) {
        for (GameComponent component : children) {
            component.move(direction);
        }
    }

    // Move all components downward
    @Override
    public void moveDown(int distance) {
        for (GameComponent component : children) {
            component.moveDown(distance);
        }
    }

    // Draw all components
    @Override
    public void draw(Graphics g, ImageObserver observer) {
        for (GameComponent component : children) {
            component.draw(g, observer);
        }
    }
}