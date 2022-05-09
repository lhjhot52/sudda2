package sudda2;

import java.lang.reflect.Member;

public interface MemberServiceImpl {
	
	int memberInsert(MemberVO vo);
	MemberVO login(MemberVO vo);
	
}
