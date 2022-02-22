package com.chandler.analyzer;

import org.apache.lucene.analysis.ko.KoreanTokenizerFactory;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

public class MyLuceneAnalysisConfigurer implements LuceneAnalysisConfigurer {
    @Override
    public void configure(LuceneAnalysisConfigurationContext context) {
        context.analyzer( "english" ).custom()
                .tokenizer( "standard" )
                .tokenFilter( "lowercase" )
                .tokenFilter( "snowballPorter" )
                .param( "language", "English" )
                .tokenFilter( "asciiFolding" );

        context.analyzer( "name" ).custom()
                .tokenizer( "standard" )
                .tokenFilter( "lowercase" )
                .tokenFilter( "asciiFolding" );

        context.analyzer( "korea" ).custom()
                .tokenizer(KoreanTokenizerFactory.class);
    }
}