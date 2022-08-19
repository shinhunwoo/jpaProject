package com.example.project.service;

import com.example.project.entity.Notice;
import com.example.project.entity.QNotice;
import com.example.project.repository.NoticeRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public List<Notice> getQueryDslTest() {

        JPAQuery<Notice> noticeQuery = new JPAQuery(entityManager);
        QNotice qNotice = QNotice.notice;

        List<Notice> notice = (List<Notice>) noticeQuery
                                            .from(qNotice)
                                            .orderBy(qNotice.wrDateTime.desc())
                                            .fetch();

        /*Notice notice1 = (Notice) noticeQuery.from(qNotice).where(qNotice.id.eq(1L)).fetchOne();

        entityManager.clear();

        Long count = noticeQuery.from(qNotice).fetchCount();

        System.out.println(notice1);
        System.out.println(count);*/

        List<String> contextList = jpaQueryFactory.select(qNotice.wrContnet)
                                        .orderBy(qNotice.wrDateTime.desc())
                                        .fetch();


        return notice;
    }

    @Override
    public List<String> getQueryDslContext() {

        QNotice qNotice = QNotice.notice;

        List<String> contextList = jpaQueryFactory.select(qNotice.wrContnet)
                .from(qNotice)
                .orderBy(qNotice.wrDateTime.desc())
                .fetch();

        return contextList;
    }

    @Override
    public boolean noticeInsert() {

        Notice notice = new Notice();
        notice.setWrContnet("JPA-INSERT-TEST1");
        notice.setWrSubject("JPA_INSERT1");

        noticeRepository.save(notice);

        System.out.println(notice.getId());
        System.out.println(notice.getWrDateTime());

        return true;
    }
}
