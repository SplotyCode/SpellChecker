package io.github.splotycode.spellchecker.check.defaults;

import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.TokenVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.token.Token;
import io.github.splotycode.spellchecker.token.types.SentenceTokenType;
import io.github.splotycode.spellchecker.token.types.WhitespaceTokenType;

public class WhitespacingCheck extends Check {

    @Override
    public Visitor visitor() {
        return new TokenVisitor(){
            @Override
            public void visitToken(Token lastToken, Token token, ProblemCollector collector) {
                if (lastToken != null) {
                    if (lastToken.getType() instanceof SentenceTokenType &&
                            !(token.getType() instanceof WhitespaceTokenType)) {
                        collector.addProblem(token, "Need Whitespace after '" + lastToken.getText() + "'");
                    } else if (token.getType() instanceof SentenceTokenType &&
                            !(lastToken.getType() instanceof WhitespaceTokenType)) {
                        collector.addProblem(lastToken, "Need Whitespace before '" + lastToken.getText() + "'");
                    }
                }
            }
        };
    }

}
