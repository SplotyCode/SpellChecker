package io.github.splotycode.spellchecker.check.defaults;

import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.TokenVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.token.Token;
import io.github.splotycode.spellchecker.token.types.TokenTypes;

public class WhitespaceAfterNewLineCheck extends Check {

    @Override
    public Visitor visitor() {
        return new TokenVisitor() {
            @Override
            public void visitToken(Token lastToken, Token token, ProblemCollector collector) {
                if (lastToken != null &&
                        lastToken.getType() == TokenTypes.NEW_LINE &&
                        (token.getType() == TokenTypes.TAB || token.getType() == TokenTypes.SPACE)) {
                    collector.addProblem(lastToken, token, "Whitespace after New Line");
                }
            }
        };
    }

}
