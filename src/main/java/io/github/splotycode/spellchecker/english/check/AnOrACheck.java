package io.github.splotycode.spellchecker.english.check;

import io.github.splotycode.mosaik.util.AlmostBoolean;
import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.ElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.dictfile.CaseDictFile;
import io.github.splotycode.spellchecker.dictfile.LineSeparator;
import io.github.splotycode.spellchecker.element.Word;

import static io.github.splotycode.mosaik.util.AlmostBoolean.*;

public class AnOrACheck extends Check {

    private CaseDictFile aDict = new CaseDictFile("en/a.txt", LineSeparator.UNIX);
    private CaseDictFile anDict = new CaseDictFile("en/an.txt", LineSeparator.UNIX);

    @Override
    public Visitor visitor() {
        return new ElementVisitor() {
            @Override
            public void visitWord(ProblemCollector collector, Word word) {
                if (word.match(NO, "an", "a")) {
                    Word next = word.nextWord();
                    if (next == null) {
                        collector.addProblem(word, "Unusually end");
                    } else {
                        AlmostBoolean shouldBeA = aDict.exists(next) ? YES : MAYBE;
                        if (anDict.exists(next)) {
                            if (shouldBeA == YES) {
                                /* This word allows both determiner */
                                return;
                            }
                            shouldBeA =  NO;
                        }
                        if (shouldBeA == MAYBE) {
                            shouldBeA = fromBoolean(!next.firstLetter().isVocal());
                        }
                        String correct = shouldBeA.decide(true) ? "a" : "an";
                        if (!word.asString().equalsIgnoreCase(correct)) {
                            collector.addProblem(word, "Should be " + correct);
                        }
                    }
                }
            }
        };
    }
}
