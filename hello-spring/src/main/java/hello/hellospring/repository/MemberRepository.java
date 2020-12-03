package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
	Member save(Member member);
	// Optional : Java8 기능. null 감싸주는 것(?)
	Optional<Member> findById(long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
