package io.github.splotycode.spellchecker.english.check;

import io.github.splotycode.mosaik.util.AlmostBoolean;
import io.github.splotycode.mosaik.util.StringUtil;
import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.ElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.english.EnglishWord;

public class EnglishCapitalisationCheck extends Check {
    @Override
    public Visitor visitor() {
        return new ElementVisitor<EnglishWord>() {
            @Override
            public void visitWord(ProblemCollector collector, EnglishWord word) {
                /* First word in Sentence */
                if (word.getSentence().firstWord() == word) return;
                if (word.isNumber()) return;

                System.out.println(word.asString() + " " + word.isInDict(true) + " " + word.isInDict(false));

                boolean current = word.isCapitalized();
                boolean should = word.guessCostomName();

                if (current != should) {
                    String fixed = should ? StringUtil.camelCase(word.asString()) : word.asString(AlmostBoolean.NO);
                    collector.addProblem(word, "Capitalisation mistake word should be " + fixed);
                }
            }
        };
    }
}
