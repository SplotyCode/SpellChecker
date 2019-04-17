package io.github.splotycode.spellchecker.element;

public class Text extends Element<Sentence, DummyElement> {

    public Text(int start, int end, DummyElement root) {
        super(start, end, root);
    }

    public Sentence firstSentence() {
        return elements.get(0);
    }

    public SentencePart firstPart() {
        return firstSentence().elements.get(0);
    }

    public Word firstWord() {
        return firstPart().elements.get(0);
    }

}
