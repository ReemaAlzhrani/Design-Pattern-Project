package com.zetcode.sprite;

import javax.swing.ImageIcon;

import java.awt.Image;

public class Alien extends Sprite implements Cloneable {

    private Bomb bomb;

    public Alien(int x, int y) {

        initAlien(x, y);
    }

    @Override
    public Alien clone() {

        try {
            Alien copy = (Alien) super.clone();

            copy.bomb = copy.new Bomb(
                    bomb.getX(),
                    bomb.getY(),
                    bomb.getImage()
            );

            copy.bomb.setDestroyed(bomb.isDestroyed());

            return copy;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    private void initAlien(int x, int y) {

        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);

        var alienImg = "src/images/alien.png";
        var ii = new ImageIcon(alienImg);

        setImage(ii.getImage());
    }

    public void act(int direction) {

        this.x += direction;
    }

    public Bomb getBomb() {

        return bomb;
    }

    public class Bomb extends Sprite {

        private boolean destroyed;

        public Bomb(int x, int y) {

            initBomb(x, y);
        }

        private Bomb(int x, int y, Image image) {

            setDestroyed(true);

            this.x = x;
            this.y = y;

            setImage(image);
        }

        private void initBomb(int x, int y) {

            setDestroyed(true);

            this.x = x;
            this.y = y;

            var bombImg = "src/images/bomb.png";
            var ii = new ImageIcon(bombImg);
            setImage(ii.getImage());
        }

        public void setDestroyed(boolean destroyed) {

            this.destroyed = destroyed;
        }

        public boolean isDestroyed() {

            return destroyed;
        }
    }
}
