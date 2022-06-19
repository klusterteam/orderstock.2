package repository;

import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /* 초기화 */
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setMember_name("spring");

        repository.save(member);

        Member result = repository.findByIdx(member.getIdx()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setMember_name("spring1");
        repository.save(member1);

        Member member2 = new Member(); // 전체 바꾸기 복사후 부분 클릭후 shift + f6
        member2.setMember_name("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setMember_name("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setMember_name("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
