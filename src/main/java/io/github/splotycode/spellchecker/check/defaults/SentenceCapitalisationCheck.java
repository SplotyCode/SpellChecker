package io.github.splotycode.spellchecker.check.defaults;

import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.ElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.element.Sentence;

public class SentenceCapitalisationCheck extends Check {

    @Override
    public Visitor visitor() {
        return new ElementVisitor() {
            @Override
            public void visitSentence(ProblemCollector collector, Sentence sentence) {
                if (!sentence.firstWord().isCapitalized()) {
                    collector.addProblem(sentence.firstWord(), "First word in a Sentence should be Capitalized");
                }
            }
        };
    }

}
