package bundles;

import java.util.List;

public class Bundle_pl_PL extends IBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"FileButton", "Wybierz plik"},
                {"StartButton", "Rozpocznij"},
                {"QuestionLabel", "Ilość pytań"},
                {"ChooseDirError", "Musisz wybrać ścieżke!"},
                {"Question", "Pytanie:"},
                {"Progress", "Postęp"},
                {"Check", "Sprawdź"},
                {"Response", "{0}! {1} "},
                {"regions.one", "{0} jest jeden region."},
                {"regions.multiple", "{0} są {1} regiony."},
                {"regions.multiple2", "{0} jest {1} regionów."},
                {"ContentOfQuestion", "Ile regionów jest {0} {1}?"},
                {"EndGame", "Ukończyłeś grę!"},
                {"Ireland", "Irlandii"},
                {"Denmark", "Dani"},
                {"Germany", "Niemczech"},
                {"Poland", "Polsce"},
                {"Netherlands", "Holandii"},
                {"Austria", "Austrii"},
                {"France", "Francji"},
                {"Belgium", "Belgii"},
                {"Italy", "Włoszech"},
                {"Czech Republic", "Czechach"}};
    }

    @Override
    public String getRegionMessage(int numberOfStates, String country) {
        if (this.containsKey(country)) country = getString(country);
        String number = String.valueOf(numberOfStates);
        int last = Character.getNumericValue(number.charAt(number.length() - 1));
        if (numberOfStates == 1) return resolveMessage("regions.one", country, numberOfStates);
        else if (last > 1 && last <= 4) return resolveMessage("regions.multiple", country, numberOfStates);
        else return resolveMessage("regions.multiple2", country, numberOfStates);
    }

    @Override
    public String getQuestion(String country) {
        if (!this.containsKey(country)) return resolveMessage("ContentOfQuestion", "w", country);
        String connect = List.of("Italy", "France").contains(country) ? "we" : "w";
        return resolveMessage("ContentOfQuestion", connect, getString(country));
    }

    @Override
    public String getResponse(String country, boolean correct, int numberOfStates) {
        String begin = correct ? "Świetnie" : "Ups";
        String connect = List.of("Italy", "France").contains(country) ? "We" : "W";
        return resolveMessage("Response", begin, connect) + getRegionMessage(numberOfStates, country);
    }
}
