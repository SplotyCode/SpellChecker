package io.github.splotycode.spellchecker.english.check;

import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.ElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.dictfile.LineSeparator;
import io.github.splotycode.spellchecker.dictfile.ReplacingDictFile;
import io.github.splotycode.spellchecker.element.Word;

public class ContractionsCheck extends Check {

    private ReplacingDictFile contractions = new ReplacingDictFile("en/contractions.txt", LineSeparator.UNIX);

    @Override
    public Visitor visitor() {
        return new ElementVisitor() {
            @Override
            public void visitWord(ProblemCollector collector, Word word) {
                String replacement = contractions.transform(word);
                if (replacement != null) {
                    collector.addProblem(word, "Should be " + replacement);
                }
            }
        };
    }
}
