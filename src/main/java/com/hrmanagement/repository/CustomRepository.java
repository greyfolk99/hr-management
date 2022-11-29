package com.hrmanagement.repository;

import com.hrmanagement.domain.department.Department;
import com.hrmanagement.domain.department.QDepartment;
import com.hrmanagement.domain.training.QTraining;
import com.hrmanagement.domain.training.Training;
import com.hrmanagement.domain.user.QUser;
import com.hrmanagement.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomRepository {
    private final JPAQueryFactory queryFactory;

    public HashMap<String, List<?>> searchAll(String keyword){
        String[] keywords = keyword.split(" ");
        HashMap<String, List<?>> searchResults = new HashMap<>();
        searchResults.put("user", searchUsers(keywords));
        searchResults.put("department", searchDepartment(keywords));
        searchResults.put("training", searchTraining(keywords));
        return searchResults;
    }

    private List<Training> searchTraining(String[] keywords) {
        List<Training> departments = new ArrayList<>();
        QTraining training = QTraining.training;

        for(String keyword : keywords) {
            departments.addAll(queryFactory
                    .selectFrom(training)
                    .where(training.type.like(keyword),
                            training.detail.like(keyword))
                    .fetch());
        }
        return departments;
    }

    private List<Department> searchDepartment(String[] keywords) {
        List<Department> departments = new ArrayList<>();
        QDepartment department = QDepartment.department;

        for(String keyword : keywords) {
            departments.addAll(queryFactory
                    .selectFrom(department)
                    .where(department.name.like(keyword)).fetch());
        }
        return departments;
    }

    private List<User> searchUsers(String[] keywords){
        List<User> users = new ArrayList<>();
        QUser user = QUser.user;

        for(String keyword : keywords) {
            users.addAll(queryFactory.selectFrom(user)
                    .where(user.fullName.lastName.like(keyword),
                            user.fullName.middleName.like(keyword),
                            user.fullName.firstName.like(keyword),
                            user.contactInfo.email.like(keyword))
                    .from()
                    .fetch());
        }
        return users;
    }
}
