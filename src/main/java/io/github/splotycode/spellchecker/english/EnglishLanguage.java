package io.github.splotycode.spellchecker.english;

import io.github.splotycode.spellchecker.Language;
import io.github.splotycode.spellchecker.check.defaults.*;

public class EnglishLanguage extends Language {

    public EnglishLanguage() {
        checks.add(new DoubleWhitespaceCheck());
        checks.add(new DoubleWordCheck("will", "may", "tse", "sapiens", "blah", "had", "that", "can"));
        checks.add(new SentenceCapitalisationCheck());
        checks.add(new WhitespaceAfterNewLineCheck());
        checks.add(new WhitespacingCheck());

        checks.add(new AnOrACheck());
        checks.add(new ContractionsCheck());
    }

    @Override
    public boolean isVocal(char character) {
        char lc = Character.toLowerCase(character);
        return lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u';
    }

    @Override
    public String getDisplayName() {
        return "English";
    }
}
