package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.book.UserLoanHistoryRepository;
import com.group.libraryapp.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        // 책 대출 여부 확인
        Book findBook = bookRepository.findByName(request.getBookName())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 책입니다."));

        // 대출 중인지 확인
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(findBook.getName(), false)) {
            throw new IllegalArgumentException("이미 대출 중인 책은 대여할 수 없습니다.");
        }

        // 대출 중인 책이 아니라면 유저 정보를 가져와 새로운 대출정보를 생성
        User findUser = userRepository.findByName(request.getUserName())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원 정보입니다."));

        findUser.loanBook(findBook.getName());
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        // 존재하는 책, 회원인지 확인 필요
        User findUser = userRepository.findByName(request.getUserName())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원 정보입니다."));

        // findBook, findUser가 모두 히스토리에 존재해야 반납 가능
        findUser.returnBook(request.getBookName());
    }
}
