package com.vitasoft.hibernatesearch;

import com.vitasoft.model.CourseModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class CoursesSearchDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<CourseModel> searchCourseNameByKeywordQuery(String query) {
		Query keywordQuery = getQueryBuilder()
			.keyword()
			.onField("name")
			.matching(query)
			.createQuery();
		
		return getJpaQuery(keywordQuery).getResultList();
	}
	
	@Transactional
	public List<CourseModel> searchCourseNameByFuzzyQuery(String query) {
		Query keywordQuery = getQueryBuilder()
			.keyword()
			.fuzzy()
			.withEditDistanceUpTo(2)
			.withPrefixLength(5)
			.onField("name")
			.matching(query)
			.createQuery();
		
		return getJpaQuery(keywordQuery).getResultList();
	}
	
	@Transactional
	public List<CourseModel> searchCourseNameByWildcardQuery(String query) {
		Query keywordQuery = getQueryBuilder()
			.keyword()
			.wildcard()
			.onField("name")
			.matching(query)
			.createQuery();
		
		return getJpaQuery(keywordQuery).getResultList();
	}
	
	@Transactional
	public List<CourseModel> searchCourseNameAndDescriptionBySimpleQuery(String query) {
		Query keywordQuery = getQueryBuilder()
			.simpleQueryString()
			.onFields("name", "description")
			.matching(query)
			.createQuery();
		
		return getJpaQuery(keywordQuery).getResultList();
	}
	
	
	private FullTextQuery getJpaQuery(Query luceneQuery) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		
		return fullTextEntityManager.createFullTextQuery(luceneQuery, CourseModel.class);
	}
	
	private QueryBuilder getQueryBuilder() {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		
		return fullTextEntityManager.getSearchFactory()
			.buildQueryBuilder()
			.forEntity(CourseModel.class)
			.get();
	}
}
