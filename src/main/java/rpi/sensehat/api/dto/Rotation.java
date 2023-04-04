package rpi.sensehat.api.dto;

/**
 * Created by jcincera on 04/07/2017.
 */
public enum Rotation {

    R_0("0"),
    R_90("90"),
    R_180("180"),
    R_270("270");

    private final String rot;

    Rotation(String rotation) {
        this.rot = rotation;
    }

    public String getRot() {
        return rot;
    }
}
