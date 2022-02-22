package com.chandler;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chandler.domain.Contents;
import com.chandler.repository.ContentsRepository;
import com.chandler.service.ContentsService;


@SpringBootTest()
public class ContentsServiceTest {
	@Autowired
    private ContentsRepository contentsRepository;
	
	@Autowired
    private ContentsService contentsService;
	
	@BeforeEach
    public void create() throws InterruptedException {
		Contents contents = Contents.builder().title("2월 11일 오전 오늘의 타이틀")
					.subTitle("2월 11일 오늘의 서브타이틀 하하호호 이순신 홍길동 강감찬")
					.contentHaha("황금 열차로 불리는 신분당선 연장선이 오는 5월 개통을 앞두면서 부동산 업계 관심이 뜨겁다.")
					.startDt( LocalDateTime.now() )
					.build();
		
		contentsRepository.save(contents);
 
		Contents contents2 = Contents.builder().title("2월 12일 오후 오늘의 타이틀")
				.subTitle("2월 12일 오늘의 서브타이틀 하하호호 이순신 김태희 전지현")
				.contentHaha("신분당선은 서울 강남역과 경기 수원시 광교역을 잇는 31㎞ 노선으로 2011년 개통했다 runs")
				.startDt( LocalDateTime.now() )
				.build();

		contentsRepository.save(contents2);
 
		Contents contents3 = Contents.builder().title("2월 14일 오후 오늘의 타이틀")
				.subTitle("2월 13일 오늘의 서브타이틀 하하호호 이순신 ")
				.contentHaha("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라만세 runs")
				.startDt( LocalDateTime.now() )
				.build();

		contentsRepository.save(contents3);

		contentsService.buildSearchIndex();
    }
	
	@Test
    public void searchContentsTest() {
//        String keyword = "황금";
		String keyword = "이순신";
//		String keyword = "runs";
		
        List<Contents> contentsList = contentsService.searchContents(keyword);
        for(Contents contents : contentsList) {
            
        	System.out.println("제목 : " + contents.getTitle() + ", 서브타이틀 : "+contents.getSubTitle()+", 내용 : "+contents.getContentHaha());
        }
    }
}