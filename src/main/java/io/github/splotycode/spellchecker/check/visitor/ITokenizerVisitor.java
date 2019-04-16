package io.github.splotycode.spellchecker.check.visitor;

import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.token.Token;

public interface ITokenizerVisitor extends Visitor {

    void visitChar(char lastChar, char character, ProblemCollector collector);

    void visitToken(Token token, ProblemCollector collector);

}
