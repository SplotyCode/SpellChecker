package io.github.splotycode.spellchecker.element;

public class Text extends Element<Sentence, DummyElement> {
    public Text(int start, int end, DummyElement root) {
        super(start, end, root);
    }
}
