package io.github.splotycode.spellchecker.english;

import io.github.splotycode.spellchecker.Language;
import io.github.splotycode.spellchecker.check.defaults.*;
import io.github.splotycode.spellchecker.element.WordFactory;
import io.github.splotycode.spellchecker.english.check.AnOrACheck;
import io.github.splotycode.spellchecker.english.check.ContractionsCheck;
import io.github.splotycode.spellchecker.english.check.EnglishCapitalisationCheck;
import io.github.splotycode.spellchecker.english.check.EnglishTypoCheck;

public class EnglishLanguage extends Language {

    private static final EnglishWordFactory WORD_FACTORY = new EnglishWordFactory();

    public EnglishLanguage() {
        checks.add(new DoubleWhitespaceCheck());
        checks.add(new DoubleWordCheck("will", "may", "tse", "sapiens", "blah", "had", "that", "can"));
        checks.add(new SentenceCapitalisationCheck());
        checks.add(new WhitespaceAfterNewLineCheck());
        checks.add(new WhitespacingCheck());

        checks.add(new AnOrACheck());
        checks.add(new ContractionsCheck());
        checks.add(new EnglishTypoCheck());
        checks.add(new EnglishCapitalisationCheck());
    }

    @Override
    public boolean isVocal(char character) {
        char lc = Character.toLowerCase(character);
        return lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u';
    }

    @Override
    public WordFactory wordFactory() {
        return WORD_FACTORY;
    }

    @Override
    public String getDisplayName() {
        return "English";
    }
}
