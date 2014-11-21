package com.tdd.view.audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class Sound {

    private AudioClip clip;

    public Sound(String path) {
        try {

            this.clip = Applet.newAudioClip(new URL("file:" + path));

        } catch (IOException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void playSound() {
        
        clip.play();
    }
}
