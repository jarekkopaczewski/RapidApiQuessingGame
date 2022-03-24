package bundles;

public class Bundle extends IBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"FileButton", "Choose file"},
                {"StartButton", "Start"},
                {"QuestionLabel", "Number of questions"},
                {"ChooseDirError", "You need to choose directory!"},
                {"Question", "Question:"},
                {"Progress", "Progress"},
                {"Check", "Check"},
                {"Response", "{0}! In "},
                {"regions.one", "{0} is one region."},
                {"regions.multiple", "{0} are {1} regions."},
                {"ContentOfQuestion", "How many regions are {0} {1}?"},
                {"EndGame", "You finished the game!"},
                {"Ireland", "Ireland"},
                {"Denmark", "Denmark"},
                {"Germany", "Germany"},
                {"Poland", "Poland"},
                {"Netherlands", "Netherlands"},
                {"Austria", "Austria"},
                {"France", "France"},
                {"Belgium", "Belgium"},
                {"Italy", "Italy"},
                {"Czech Republic", "Czech Republic"}};
    }

    @Override
    public String getRegionMessage(int numberOfStates, String country) {
        if(this.containsKey(country)) country = getString(country);
        if (numberOfStates == 1) return resolveMessage("regions.one", country, numberOfStates);
        else return resolveMessage("regions.multiple", country, numberOfStates);
    }

    @Override
    public String getQuestion(String country) {
        if(!this.containsKey(country)) return resolveMessage("ContentOfQuestion", "in", country);
        else return resolveMessage("ContentOfQuestion", "in", getString(country));
    }

    @Override
    public String getResponse(String country, boolean correct, int numberOfStates) {
        if( correct ) return resolveMessage("Response", "Nice") + getRegionMessage(numberOfStates, country);
        else return resolveMessage("Response", "Ops") + getRegionMessage(numberOfStates, country);
    }
}
