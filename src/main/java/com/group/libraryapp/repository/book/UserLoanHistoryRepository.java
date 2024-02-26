package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.user.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    // select * from user_loan_history where book_name = ? and is_return = ? (대출 중인지 확인)
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

    // select * from user_loan_history where user_id = ? and book_name = ? and is_return = ? (반납을 위한 대출정보 확인)
    Optional<UserLoanHistory> findByUserIdAndBookNameAndIsReturn(long id, String name, boolean isReturn);
}
