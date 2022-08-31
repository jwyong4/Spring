package com.codestates.member.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * V2
 * - 메서드 구현
 * - DI 적용
 */
@Service
public class MemberService {
    private MemberRepository memberRepository;

    // MemberRepository DI
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /** 이미 존재하는 회원인지 검증하는 메서드 */
    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    /** 이미 등록된 이메일인지 검증 */
    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent()) // email이 존재하면 해당 값 반환, 없으면 예외 던지기
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

    public Member createMember(Member member) {
        verifyExistsEmail(member.getEmail()); // 이미 등록된 이메일인지 검증

        return memberRepository.save(member); // 회원 정보 저장
    }

    public Member updateMember(Member member) {
        Member findMember = findVerifiedMember(member.getMemberId()); // 존재하는 회원인지 검증
        /**
         * member 객체의 정보를 선택적으로 수정할 수 있기 때문에 .ofNullable 사용
         * 멤버 변수가 null 이더라도, 다음 메서드인 ifPresent() 메서드 호출
         */
        Optional.ofNullable(member.getName()) // 이름 정보 업데이트
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPhone()) // 폰 번호 정보 업데이트
                .ifPresent(phone -> findMember.setPhone(phone));

        return memberRepository.save(findMember); // 회원 정보 업데이트
    }

    public Member findMember(long memberId) {
        return findVerifiedMember(memberId); // 특정 회원 정보 조회
    }

    public List<Member> findMembers() {
        /** findAll() 의 리턴값이 Interable<T> 이기 때문에 List<> 로 캐스팅 */
        return (List<Member>) memberRepository.findAll(); // 모든 회원 정보 조회
    }

    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);

        memberRepository.delete(findMember); // 특정 회원 정보 삭제
    }
}
