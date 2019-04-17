package io.github.splotycode.spellchecker.element;

public class SentencePart extends Element<Word, Sentence> {

    public SentencePart(int start, int end, Sentence root) {
        super(start, end, root);
    }

    public Word getWord(int index) {
        return elements.get(index);
    }

    public Word firstWord() {
        return elements.get(0);
    }

    public Sentence getSentence() {
        return root;
    }

}
