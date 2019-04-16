package io.github.splotycode.spellchecker.check;

import io.github.splotycode.spellchecker.element.Element;
import io.github.splotycode.spellchecker.token.Token;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Problem {

    private int start, end;
    private String displayMessage;

    public Problem(Element element, String displayMessage) {
        this(element.getStart(), element.getEnd(), displayMessage);
    }

    public Problem(Element first, Element second, String displayMessage) {
        this(Math.min(first.getStart(), second.getStart()), Math.max(first.getEnd(), second.getEnd()), displayMessage);
    }

    public Problem(Token token, String displayMessage) {
        this(token.getStart(), token.getEnd(), displayMessage);
    }

    public Problem(Token first, Token second, String displayMessage) {
        this(Math.min(first.getStart(), second.getStart()), Math.max(first.getEnd(), second.getEnd()), displayMessage);
    }

}
