package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.user.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    // select * from user_loan_history where book_name = ? and is_return = ? (대출 중인지 확인)
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

}
