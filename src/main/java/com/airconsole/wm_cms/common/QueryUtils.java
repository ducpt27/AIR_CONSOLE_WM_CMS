package com.airconsole.wm_cms.common;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class QueryUtils {

    public interface IExpressionBuilder<Domain, SubQueryDomain> {
        Expression<Boolean> build(Root<Domain> root, Subquery<SubQueryDomain> subQuery, Root<SubQueryDomain> subRoot);
    }

    public static Predicate and(CriteriaBuilder cb, Predicate... var1) {
        List<Predicate> all = H.findAll(Arrays.asList(var1), (index, item) -> item != null);
        return !H.isTrue(all) ? null : cb.and(all.toArray(new Predicate[]{}));
    }

    public static Predicate or(CriteriaBuilder cb, Predicate... var1) {
        List<Predicate> all = H.findAll(Arrays.asList(var1), (index, item) -> item != null);
        return !H.isTrue(all) ? null : cb.or(all.toArray(new Predicate[]{}));
    }

    public static String buildLikeExp(String query) {
        if (query == null || !H.isTrue(query.trim())) return null;
        return "%" + query.trim().replaceAll("\\s+", "%") + "%";
    }

    public static <T> Predicate buildLikeFilter(Root<T> root, CriteriaBuilder cb, String keyword, String... fieldNames) {
        String likeExp = QueryUtils.buildLikeExp(keyword);
        if (!H.isTrue(likeExp) || !H.isTrue(fieldNames)) return null;
        return cb.or(H.collect(Arrays.asList(fieldNames), (index, fieldName) -> cb.like(cb.upper(root.get(fieldName)), likeExp.toUpperCase())).toArray(new Predicate[]{}));
    }

    public static <T> Predicate buildSimpleLikeFilter(Root<T> root, CriteriaBuilder cb, String keyword, String... fieldNames) {
        if (!H.isTrue(keyword) || !H.isTrue(fieldNames)) return null;
        return cb.or(H.collect(Arrays.asList(fieldNames), (index, fieldName) -> cb.like(cb.upper(root.get(fieldName)), ("%" + keyword + "%").toUpperCase())).toArray(new Predicate[]{}));
    }

    public static <T> Predicate buildDateRangeFilter(Root<T> root, CriteriaBuilder cb, String fieldName, Long fromTime, Long toTime) {
        if (!H.isTrue(fromTime) && !H.isTrue(toTime)) return null;
        return and(cb,
                H.isTrue(fromTime) ? cb.greaterThanOrEqualTo(root.get(fieldName), new Date(fromTime)) : null,
                H.isTrue(toTime) ? cb.lessThan(root.get(fieldName), DateUtils.of(toTime).addDate(1).toDate()) : null
        );
    }

    public static <T, P> Predicate buildEqFilter(Root<T> root, CriteriaBuilder cb, String fieldName, P value) {
        return (!H.isTrue(value)) ? null : cb.equal(root.get(fieldName), value);
    }


    public static <T, P> Predicate buildInFilter(Root<T> root, String fieldName, Collection<P> values) {
        return (!H.isTrue(values)) ? null : root.get(fieldName).in(values);
    }

    public static <Domain, SubQueryDomain> Subquery<SubQueryDomain> buildSubQuery(
            Class<SubQueryDomain> subQueryDomainClass, Root<Domain> root, CriteriaQuery<?> criteriaQuery,
            IExpressionBuilder<Domain, SubQueryDomain> expressionBuilder) {
        Subquery<SubQueryDomain> subQuery = criteriaQuery.subquery(subQueryDomainClass);
        Root<SubQueryDomain> subRoot = subQuery.from(subQueryDomainClass);
        return subQuery.select(subRoot).where(expressionBuilder.build(root, subQuery, subRoot));
    }

}
