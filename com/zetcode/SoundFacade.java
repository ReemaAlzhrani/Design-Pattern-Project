package com.zetcode;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

// Facade: يخفي تفاصيل مكتبة الصوت (AudioSystem, AudioInputStream, Clip)
// البورد يكلم هالكلاس بس ويقول playShot / playWin / playGameOver
public class SoundFacade {

    private Map<String, Clip> clips = new HashMap<>();

    public SoundFacade() {

        clips.put("shot", loadClip("sounds/shot.wav"));
        clips.put("win", loadClip("sounds/win.wav"));
        clips.put("gameover", loadClip("sounds/gameover.wav"));
        clips.put("explosion", loadClip("sounds/explosion.wav"));
    }

    public void playShot() {

        play("shot");
    }

    public void playExplosion() {

        play("explosion");
    }

    public void playWin() {

        play("win");
    }

    public void playGameOver() {

        play("gameover");
    }

    // يحمل الصوت مره وحده من الملف
    private Clip loadClip(String path) {

        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            return clip;

        } catch (Exception e) {
            System.out.println("Could not load sound: " + path);
            return null; // لو الصوت ما اشتغل، اللعبه تكمل عادي
        }
    }

    // يشغل الصوت من البدايه
    private void play(String name) {

        Clip clip = clips.get(name);

        if (clip == null) {
            return;
        }

        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }
}
