package io.github.splotycode.spellchecker.element;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Element<L extends Element, U extends Element> {

   @Getter protected int start;
   @Getter @Setter protected int end;

    public Element(int start, int end, U root) {
        this.start = start;
        this.end = end;
        this.root = root;
    }

    public int length() {
        return end - start;
    }

    protected U root;
    @Getter protected ArrayList<L> elements = new ArrayList<>();

    public void addElement(L element) {
        elements.add(element);
    }

}
