package io.github.splotycode.spellchecker.english;

import io.github.splotycode.spellchecker.element.SentencePart;
import io.github.splotycode.spellchecker.element.Word;
import io.github.splotycode.spellchecker.element.WordFactory;

public class EnglishWordFactory implements WordFactory {
    @Override
    public Word createWord(int start, int end, SentencePart part) {
        return new EnglishWord(start, end, part);
    }
}
