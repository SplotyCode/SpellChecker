package io.github.splotycode.spellchecker.element;

public interface WordFactory {

    Word createWord(int start, int end, SentencePart part);

}
