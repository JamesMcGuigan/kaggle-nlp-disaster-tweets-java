package com.jamesmcguigan.nlp.data;

import org.elasticsearch.client.core.TermVectorsResponse;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Wrapper class around TermVectorsResponse to provide easy access to tokenization
 * Tokens generated here are unique per field / document
 * <p/>
 * For duplicated tokens in accordance with {@code getTermFreq()}, use {@link TermVectorTokens}
 */
public class TermVectorDocTokens extends TermVectorTokens {
    public TermVectorDocTokens(TermVectorsResponse response) {
        super(response);
    }

    @Override
    public List<String> tokenize() {
        List<String> tokens = super.tokenize();
        tokens = tokens.stream().distinct().collect(Collectors.toList());
        return tokens;
    }

    @Override
    public List<String> tokenize(String fieldName) {
        List<String> tokens = super.tokenize(fieldName);
        tokens = tokens.stream().distinct().collect(Collectors.toList());
        return tokens;
    }
}
