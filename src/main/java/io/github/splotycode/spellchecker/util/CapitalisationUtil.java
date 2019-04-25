package io.github.splotycode.spellchecker.util;

import io.github.splotycode.mosaik.util.AlmostBoolean;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CapitalisationUtil {

    public static String capitalize(final String input, AlmostBoolean capitalisation) {
        switch (capitalisation) {
            case YES:
                return input.toUpperCase();
            case NO:
                return input.toLowerCase();
            default:
                return input;
        }
    }

}
