package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		Member result = repository.findById(member.getId()).get();
//	1	System.out.println("result = " + (result == member));
//	2	Assertions.assertEquals(member, result);
		assertThat(result).isEqualTo(member);
	}
}
