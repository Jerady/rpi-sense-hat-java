package rpi.sensehat.utils;

public class OS {

    public static final String ARCH = "os.arch";
    public static final String ARCH_ARM = "arm";
    public static final String ARCH_AARCH64 = "aarch64";

    private OS() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isArmArchitecure() {
        String osArch = System.getProperty(OS.ARCH).toLowerCase();
        return (osArch.contains(OS.ARCH_ARM) || osArch.contains(OS.ARCH_AARCH64));
    }


}
