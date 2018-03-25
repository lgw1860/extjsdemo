package com.luter.extjs.util;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.sql.JoinType;

import java.util.*;

/**
 * @author Luter.INC
 * @ClassName: ConditionQuery
 * @Description: 查询语句构造辅助类
 * @date 2013-9-27 下午01:27:15
 */
public class ConditionQuery {

    private List<Criterion> criterions = new ArrayList<Criterion>();

    private Map<String, String> aliasMap = new HashMap<String, String>();

    public void add(Criterion criterion) {
        criterions.add(criterion);
    }

    public void createAlias(String key, String alias) {
        aliasMap.put(key, alias);
    }

    @SuppressWarnings("unchecked")
    public void build(Criteria criteria) {
        if (!aliasMap.isEmpty()) {
            for (Iterator iterator = aliasMap.keySet().iterator(); iterator.hasNext(); ) {
                String keyString = (String) iterator.next();
                String aliasString = aliasMap.get(keyString);
                criteria.createAlias(keyString, aliasString, JoinType.LEFT_OUTER_JOIN);
            }
        }
        for (Criterion criterion : criterions) {
            criteria.add(criterion);
        }
    }


}
