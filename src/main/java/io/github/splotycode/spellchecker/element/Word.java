package io.github.splotycode.spellchecker.element;

import io.github.splotycode.mosaik.util.AlmostBoolean;
import io.github.splotycode.spellchecker.token.Token;
import io.github.splotycode.spellchecker.token.types.SingleCharTokenType;
import lombok.Getter;

import java.util.Deque;
import java.util.LinkedList;

public class Word extends Element<DummyElement, SentencePart> {

    private AlmostBoolean capitalized = AlmostBoolean.MAYBE;
    @Getter private Deque<Token> tokens = new LinkedList<>();

    public Word(int start, int end, SentencePart root) {
        super(start, end, root);
    }

    public SentencePart getSentencePart() {
        return root;
    }

    public boolean isCapitalized() {
        if (capitalized == AlmostBoolean.MAYBE) {
            capitalized = AlmostBoolean.fromBoolean(Character.isUpperCase(tokens.getFirst().getText().charAt(0)));
        }
        return capitalized.decide(true);
    }
}
