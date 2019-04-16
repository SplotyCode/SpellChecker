package io.github.splotycode.spellchecker.element;

public class SentencePart extends Element<Word, Sentence> {

    public SentencePart(int start, int end, Sentence root) {
        super(start, end, root);
    }

    public Sentence getSentence() {
        return root;
    }

}
