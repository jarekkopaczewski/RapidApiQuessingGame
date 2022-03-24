package bundles;

import java.text.MessageFormat;
import java.util.ListResourceBundle;

public abstract class IBundle extends ListResourceBundle {

    public String resolveMessage(String key, Object... args) {
        return MessageFormat.format(this.getString(key), args);
    }

    public abstract String getRegionMessage(int numberOfStates, String country);

    public abstract String getQuestion(String country);

    public abstract String getResponse(String country, boolean correct, int numberOfStates);

}
