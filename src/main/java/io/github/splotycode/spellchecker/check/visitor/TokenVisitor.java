package io.github.splotycode.spellchecker.check.visitor;

import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.token.Token;

public class TokenVisitor implements ITokenizerVisitor {

    @Override
    public void visitChar(char lastChar, char character, ProblemCollector collector) {

    }

    @Override
    public void visitToken(Token lastToken, Token token, ProblemCollector collector) {

    }
}
