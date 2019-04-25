package io.github.splotycode.spellchecker.dictfile;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LineSeparator {

    UNIX("\n"),
    WINDOWS("\r\n"),
    CLASSIC_MAC("\r");

    private String separatorString;

}
