package io.github.splotycode.spellchecker.english;

import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.ElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.dictfile.ReplaceingDirctFile;
import io.github.splotycode.spellchecker.element.Word;

public class ContractionsCheck extends Check {

    private ReplaceingDirctFile contractions = new ReplaceingDirctFile("en/contractions.txt");

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
