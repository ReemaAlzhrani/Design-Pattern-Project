package com.zetcode.sprite;

import javax.swing.ImageIcon; //عشان ننسخ الصوره بدون يرجع للملف  

import java.awt.Image;

public class Alien extends Sprite implements Cloneable {

    private Bomb bomb;

    public Alien(int x, int y) {

        initAlien(x, y);
    }

    @Override  // يسوي سوبر كلون للالين ويعيد النسخه بكل الخصائص بعدها يسوي بمب لكل الين 
    public Alien clone() {

        try {
            Alien copy = (Alien) super.clone(); // ينسخ خصائص الفضائي 

            copy.bomb = copy.new Bomb( // ينسخ قنبله لكل فضائي 
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

        var alienImg = "images/alien.png";
        var ii = new ImageIcon(alienImg);

        setImage(ii.getImage());
    }

    public void act(int direction) {

        this.x += direction;
    }

    public Bomb getBomb() {

        return bomb;
    }

    public class Bomb extends Sprite { //انر كلاس 

        private boolean destroyed;

        public Bomb(int x, int y) { //كونستكتر 

            initBomb(x, y);
        }
     // الكونستكتر يستقبل ايمج لانه يستقبل نفس الصوره 

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

            var bombImg = "images/bomb.png";
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
