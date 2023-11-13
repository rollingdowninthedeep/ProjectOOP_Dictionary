package DictionaryApp.Feature;

public class Word {
    private String origin;
    private String meaning;

    public Word(String origin, String meaning) {
        this.origin = origin;
        this.meaning = meaning;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
