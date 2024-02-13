package com.cybertek.Pojos;

import java.util.List;

public class SearchForSpartan {
    private List<Spartan> content;
    private int totalElement;

    public List<Spartan> getContent() {
        return content;
    }

    public void setContent(List<Spartan> content) {
        this.content = content;
    }

    public int getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(int totalElement) {
        this.totalElement = totalElement;
    }

    @Override
    public String toString() {
        return "SearchForSpartan{" +
                "content=" + content +
                ", totalElement=" + totalElement +
                '}';
    }
}
