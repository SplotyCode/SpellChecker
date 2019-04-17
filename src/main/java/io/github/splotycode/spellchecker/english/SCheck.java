package io.github.splotycode.spellchecker.english;

import io.github.splotycode.mosaik.util.AlmostBoolean;
import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.ElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.element.SentencePart;

import static io.github.splotycode.mosaik.util.AlmostBoolean.*;

//TODO ????
public class SCheck extends Check {
    @Override
    public Visitor visitor() {
        return new ElementVisitor() {
            @Override
            public void visitSentencePart(ProblemCollector collector, SentencePart text) {
                if (text.firstWord().match(NO, "what", "where")) return;
                if (!text.firstWord().match(NO, "do", "does", "did")) return;
                //if (!text.getWord(1).match())
            }
        };
    }
}
