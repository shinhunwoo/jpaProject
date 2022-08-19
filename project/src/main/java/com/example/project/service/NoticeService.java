package com.example.project.service;

import com.example.project.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getQueryDslTest();

    List<String> getQueryDslContext();

    boolean noticeInsert();
}
