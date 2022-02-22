# hibernateSearch
루씬기반엔진을 탑재한 하이버네이트서치 샘플

( gradle설명 )
------------------------------------------------------------------------------------------
1    implementation 'org.hibernate.search:hibernate-search-mapper-orm:6.1.1.Final'
2    implementation 'org.hibernate.search:hibernate-search-backend-lucene:6.1.1.Final'
3    
4    implementation 'org.apache.lucene:lucene-analyzers-nori:8.11.1'
5    implementation 'org.apache.lucene:lucene-analyzers-common:8.11.1'
6    implementation 'org.apache.lucene:lucene-core:8.11.1'
------------------------------------------------------------------------------------------

spring boot version 2.6.3
1, 2 Line : Hibernate Search version 6.1.1.Final
default : Hibernate ORM core version 5.6.4.Final
4~6 Line Apache Lucene : 8.11.1
lucene-analyzers-nori : 한국어 토크나이저, 분석기포함 (KoreanTokenizerFactory, KoreanAnalyzer, Dictionary)
