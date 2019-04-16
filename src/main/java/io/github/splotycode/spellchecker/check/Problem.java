package io.github.splotycode.spellchecker.check;

import io.github.splotycode.spellchecker.element.Element;
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

}
