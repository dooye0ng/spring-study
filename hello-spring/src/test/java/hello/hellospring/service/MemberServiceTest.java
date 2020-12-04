package hello.hellospring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

class MemberServiceTest {
	
	MemberService service;
	MemoryMemberRepository repository;
	
	@BeforeEach
	void beforeEach() {
		repository = new MemoryMemberRepository();
		service = new MemberService(repository);
	}
	
	@AfterEach
	void afterEach() {
		repository.clearStore();
	}
	
	@Test
	void join() {
		// given
		Member member = new Member();
		member.setName("spring");
		
		// when
		long saveId = service.join(member);
		
		// then
		Member findMember = service.findOne(saveId).get();
		assertThat(findMember.getName()).isEqualTo(member.getName());
	}
	
	@Test
	void validDuplication() {
		// given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		Member member3 = new Member();
		member3.setName("winter");
		// when
		service.join(member1);
		service.join(member3);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
		
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}

}
