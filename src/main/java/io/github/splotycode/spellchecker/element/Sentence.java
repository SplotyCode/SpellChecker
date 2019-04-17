package io.github.splotycode.spellchecker.element;

public class Sentence extends Element<SentencePart, Text> {

    public Sentence(int start, int end, Text root) {
        super(start, end, root);
    }

    public SentencePart firstPart() {
        return elements.get(0);
    }

    public Word firstWord() {
        return firstPart().elements.get(0);
    }

    public Text getText() {
        return root;
    }

}
