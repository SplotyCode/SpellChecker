package io.github.splotycode.spellchecker.element;

public class Sentence extends Element<SentencePart, Text> {

    public Sentence(int start, int end, Text root) {
        super(start, end, root);
    }

    public Text getText() {
        return root;
    }

}
