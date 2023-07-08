package com.sahil.dictionaryapp.Models;

import java.util.List;

public class Meaning {
    String partOfSpeech = "";
    List<Definication> definition =null;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Definication> getDefinition() {
        return definition;
    }

    public void setDefinition(List<Definication> definition) {
        this.definition = definition;
    }
}
