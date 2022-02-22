package com.chandler.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chandler.domain.Contents;

@Service
public class ContentsService {
	@PersistenceContext //(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
    /**
     * 인덱스 재생성
     * @throws InterruptedException
     */
	@Transactional
    public void buildSearchIndex() throws InterruptedException {
    	// old
//        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//        fullTextEntityManager.createIndexer().startAndWait();
        // New
        SearchSession searchSession = Search.session( entityManager );
        MassIndexer indexer = searchSession.massIndexer().threadsToLoadObjects( 7 );
        indexer.startAndWait();
    }
	@Transactional
	public List<Contents> searchContents(String keyword) {
		// old
//		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//	    QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
//	        .forEntity(Contents.class)
//	        .get();
//	    Query query = queryBuilder.keyword()
//	        .onFields("title", "subTitle", "contentHaha")
//	        .matching(keyword)
//	        .createQuery();
//	    FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Contents.class);
//	    @SuppressWarnings("unchecked")
//		List<Contents> contents = (List<Contents>) fullTextQuery.getResultList();
	    
		SearchSession searchSession = Search.session( entityManager );
        SearchResult<Contents> contents = searchSession.search( Contents.class )
						                .where( f -> f.match()
						                        .fields( "title", "subTitle", "contentHaha" )
						                        .matching( keyword ) )
						                .fetch( 1000 );
        long totalHitCount = contents.total().hitCount();
        System.out.println("totalHitCount : " + totalHitCount);
        
        List<Contents> hits = contents.hits();
	    return hits;
	}
}