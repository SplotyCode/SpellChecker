package io.github.splotycode.spellchecker.dictfile;

import io.github.splotycode.spellchecker.element.Word;

public interface DictFile {

    Iterable<String> getAll();

    boolean exists(String word);

    default boolean exists(Word word) {
        return exists(word.asString());
    }

}
