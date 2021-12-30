package hello.springshop.service;

import hello.springshop.domain.Member;
import hello.springshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    @Autowired MemberRepository memberRepository;
    /*
    회원 가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    //사실 멤버 수를 세서 0보다 큰지 판단하는 로직이 더  최적화된다.
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName()); //이렇게 핻 문제다.
        if (!findMembers.isEmpty()) { //멤버 A라는 이름으로 동시에 호출하면 정상처리되므로 ,--> 멀티 쓰레드를 고려한 유니크제약조건을 걸어야 한다.
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    //회원 단건 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    //회원 수정
    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        validateDuplicateMember(member);
        member.setName(name);
    }
}
