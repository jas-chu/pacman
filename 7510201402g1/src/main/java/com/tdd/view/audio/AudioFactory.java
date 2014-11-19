package com.tdd.view.audio;

/**
 *
 * @author agu
 */
public class AudioFactory {
    
    private AudioFactory() {
    }
    
    public static AudioFactory getInstance() {
        return AudioFactoryHolder.INSTANCE;
    }
    
    private static class AudioFactoryHolder {

        private static final AudioFactory INSTANCE = new AudioFactory();
    }
    
    public Sound getPacmanBeginning(){
        return new Sound(AudioConstants.BEGINNING);
    }
    
    public Sound getPacmanChomp(){
        return new Sound(AudioConstants.PACMAN_CHOMP);
    }
}
