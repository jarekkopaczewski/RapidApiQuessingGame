package preferences;

import java.util.prefs.Preferences;

public class LanguagePreferences {
    public static Preferences preferences = Preferences.userNodeForPackage(LanguagePreferences.class);
    private static final String ID1 = "lang";

    public static String getPreferences() {
        return preferences.get(ID1, "EN");
    }

    public static void setPreferences(String local) {
        preferences.put(ID1, local);
    }
}
