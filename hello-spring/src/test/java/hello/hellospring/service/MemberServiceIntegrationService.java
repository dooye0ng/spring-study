package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationService {
	@Autowired MemberService service;
	@Autowired MemberRepository repository;
	
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
		assertThat(e.getMessage()).isEqualTo("error.");
		
		
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
}
