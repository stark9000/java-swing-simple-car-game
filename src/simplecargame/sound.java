/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecargame;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author saliya
 */
public class sound {

    Clip clip;
    URL SURL[] = new URL[1];

    public sound() {
        SURL[0] = getClass().getResource("../res/1.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream A = AudioSystem.getAudioInputStream(SURL[0]);
            clip = AudioSystem.getClip();
            clip.open(A);
        } catch (Exception e) {
        }
    }

    public void play() {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(6.0f);
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
