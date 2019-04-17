package io.github.splotycode.spellchecker.dictfile;

import io.github.splotycode.spellchecker.element.Word;

public interface TransformableDict extends DictFile {

    String transform(String original);

    default String transform(Word original) {
        return transform(original.asString());
    }

}
