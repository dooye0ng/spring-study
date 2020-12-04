package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	/**
	 * ȸ�� ����
	 * @param member
	 * @return
	 */
	public long join(Member member) {
		// ���� �̸��� �ִ� �ߺ� ȸ�� X ����
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
				.ifPresent(m->{
					throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
				});
	}
	/**
	 * ��ü ȸ�� ��ȸ
	 * @return
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(long memberId){
		return memberRepository.findById(memberId);
	}
	
	
	
}
