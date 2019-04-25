package io.github.splotycode.spellchecker.element;

import io.github.splotycode.mosaik.util.AlmostBoolean;
import io.github.splotycode.spellchecker.util.CapitalisationUtil;

public class Word extends Element<Letter, SentencePart> {

    private AlmostBoolean capitalized = AlmostBoolean.MAYBE;

    public Word(int start, int end, SentencePart root) {
        super(start, end, root);
    }

    public SentencePart getSentencePart() {
        return root;
    }

    public boolean isNumber() {
        for (Letter letter : elements) {
            char ch = letter.asChar();
            if (!Character.isDigit(ch) && ch != '.' && ch != ',') {
                return false;
            }
        }
        return true;
    }

    public Sentence getSentence() {
        return root.root;
    }

    public String asString() {
        return asString(AlmostBoolean.MAYBE);
    }

    public String asString(AlmostBoolean capitalisation) {
        StringBuilder builder = new StringBuilder();
        for (Letter token : elements) {
            builder.append(token.toString());
        }
        return CapitalisationUtil.capitalize(builder.toString(), capitalisation);
    }

    public Letter firstLetter() {
        return elements.get(0);
    }

    public boolean match(String... matches) {
        return match(AlmostBoolean.MAYBE, matches);
    }

    public boolean match(AlmostBoolean capitalized, String... matches) {
        String string = asString(capitalized);
        for (String match : matches) {
            if (string.equals(match)) {
                return true;
            }
        }
        return false;
    }

    public int getIndex() {
        return getSentencePart().elements.indexOf(this);
    }

    public Word nextWord() {
        int index = getIndex();
        if (index == root.elements.size() - 1) return null;
        return root.elements.get(index + 1);
    }

    public Word previousWord() {
        int index = getIndex();
        if (index == 0) return null;
        return getSentencePart().elements.get(index - 1);
    }

    public boolean isCapitalized() {
        if (capitalized == AlmostBoolean.MAYBE) {
            capitalized = AlmostBoolean.fromBoolean(elements.get(0).isCapitalized());
        }
        return capitalized.decide(true);
    }
}
