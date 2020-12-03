package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
	Member save(Member member);
	// Optional : Java8 ���. null �����ִ� ��(?)
	Optional<Member> findById(long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
