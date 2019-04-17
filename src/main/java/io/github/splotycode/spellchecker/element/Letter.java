package io.github.splotycode.spellchecker.element;

import io.github.splotycode.spellchecker.Language;

public class Letter extends Element<DummyElement, Word> {

    private String str;

    public Letter(String str, int start, int end, Word root) {
        super(start, end, root);
        this.str = str;
    }

    public boolean isVocal() {
        char lc = asLowerChar();
        return lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u';
    }

    public boolean isVocal(Language language) {
        return language.isVocal(asChar());
    }

    public boolean isCapitalized() {
        return Character.isUpperCase(asChar());
    }

    public char asLowerChar() {
        return Character.toLowerCase(asChar());
    }

    public char asChar() {
        return str.charAt(0);
    }

    @Override
    public String toString() {
        return str;
    }

}
