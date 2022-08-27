package com.codestates.member;

import org.mapstruct.Mapper;

// MapStruct가 자동으로 인터페이스 구현 클래스를 생성해준다.
@Mapper(componentModel = "spring") // 애트리뷰트로 spring을 지정해주면 Spring Bean으로 등록된다.
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDtoDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
