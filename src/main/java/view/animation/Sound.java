package view.animation;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public enum Sound {
    MUSIC1(new Media(Sound.class.getResource("/sounds/ride of valkery.wav").toExternalForm())),
    MUSIC2(new Media(Sound.class.getResource("/sounds/dangerZone.wav").toExternalForm())),
    MUSIC3(new Media(Sound.class.getResource("/sounds/topGun.wav").toExternalForm())),
    EXPLOSION(new AudioClip(Sound.class.getResource("/sounds/explosion2.wav").toExternalForm())),
    DROP(new AudioClip(Sound.class.getResource("/sounds/drop.wav").toExternalForm())),
    ATOM(new AudioClip(Sound.class.getResource("/sounds/atom.wav").toExternalForm()));

    private final AudioClip audioClip;
    private final Media media;

    Sound(AudioClip audioClip) {
        this.audioClip = audioClip;
        this.media = null;
    }

    Sound(Media media) {
        this.audioClip = null;
        this.media = media;
    }

    public AudioClip getAudioClip() {
        return audioClip;
    }

    public Media getMedia() {
        return media;
    }
}
