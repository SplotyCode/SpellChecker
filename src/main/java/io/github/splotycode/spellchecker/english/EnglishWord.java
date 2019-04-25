package io.github.splotycode.spellchecker.english;

import io.github.splotycode.spellchecker.dictfile.LineSeparator;
import io.github.splotycode.spellchecker.dictfile.MappedDict;
import io.github.splotycode.spellchecker.dictfile.SimpleSetDictFile;
import io.github.splotycode.spellchecker.element.SentencePart;
import io.github.splotycode.spellchecker.element.Word;

import static io.github.splotycode.mosaik.util.AlmostBoolean.MAYBE;
import static io.github.splotycode.mosaik.util.AlmostBoolean.NO;

public class EnglishWord extends Word {

    private static SimpleSetDictFile dict = new SimpleSetDictFile(MAYBE, "en/dict.dict", LineSeparator.WINDOWS);
    private static SimpleSetDictFile allWords = new SimpleSetDictFile(MAYBE, "en/enwords.dict", LineSeparator.UNIX);

    private static MappedDict misspelledWords = new MappedDict(NO) {
        @Override
        protected String map(String word) {
            return word.toLowerCase().replace('d', 't').replace("ss", "s");
        }
    };

    static {
        misspelledWords.loadDict("en/dict.dict", LineSeparator.WINDOWS);
    }

    public EnglishWord(int start, int end, SentencePart root) {
        super(start, end, root);
    }

    public boolean guessCostomName() {
        /* If words is not in the striped dict and is in the normal dict it is a name */
        if (isInDict(true) != isInDict(false)) return true;
        return !isInDict(false) && isCapitalized();
    }

    public String correctlySpelled() {
        if (isInDict(false)) return asString();
        return misspelledWords.transform(this);
    }

    public boolean isInDict(boolean noNames) {
        return noNames ? allWords.exists(asString(NO)) : dict.exists(asString(NO));
    }

}
