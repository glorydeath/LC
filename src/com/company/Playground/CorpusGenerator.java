package com.company.Playground;

import java.util.ArrayList;
import java.util.List;

public class CorpusGenerator {

    String corpus;

    String[] words;

    int numWords;

    public CorpusGenerator(String corpus, int numWords) {
        this.corpus = corpus;
        this.numWords = numWords;
    }


    public List<String> generate() {
        List<String> results = new ArrayList<String>();
        this.words = corpus.split("[ |.|,]");
        int n = this.words.length;
        int curWordIndex = 0;
        for(int i=0; i<this.numWords; i++) {
            curWordIndex = getNextWord(curWordIndex);
            results.add(words[curWordIndex]);
        }
        return results;
    }


    public int getNextWord(int curWordIndex) {
        int n = words.length;
        if (curWordIndex == n-1) {
            return 0;
        } else {
            // todo: check the random here
            int newIndex = (int)(Math.random() * (n - 1 - curWordIndex)) + curWordIndex + 1;
            return newIndex;
        }
    }
}
