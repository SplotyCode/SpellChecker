package io.github.splotycode.spellchecker.english.check;

import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.ElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.english.EnglishWord;

public class EnglishTypoCheck extends Check {
    @Override
    public Visitor visitor() {
        return new ElementVisitor<EnglishWord>() {
            @Override
            public void visitWord(ProblemCollector collector, EnglishWord word) {
                if (!word.isInDict(false) && !word.guessCostomName() && !word.isNumber()) {
                    String correction = word.correctlySpelled();
                    collector.addProblem(word, "Might contain a spelling mistake!" +
                            (correction != null ? " Did you mean: " + correction : ""));
                }
            }
        };
    }
}
