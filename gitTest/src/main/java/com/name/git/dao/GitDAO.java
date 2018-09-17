package com.name.git.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.name.git.vo.FollowVO;
import com.name.git.vo.ItemVO;
import com.name.git.vo.LikedVO;
import com.name.git.vo.MemberVO;
import com.name.git.vo.ReviewVO;
import com.name.git.vo.SelectedVO;

@Repository
public class GitDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	//회원가입 처리
	public int memberJoin(MemberVO memberVO) {
		return sqlSession.insert("Git.memberJoin", memberVO);
	}
	
	//로그인 처리
	public MemberVO memberLogin(MemberVO memberVO) {
		return sqlSession.selectOne("Git.memberLogin", memberVO);
	}
	
	//개인정보 보기
	public MemberVO personalInfo(String id) {
		return sqlSession.selectOne("Git.personalInfo", id);
	}
	
	//개인정보 수정
	public int modifyPersonalInfo(MemberVO memberVO) {
		return sqlSession.update("Git.modifyPersonalInfo", memberVO);
	}
	
	//개인정보 보기 전 비밀번호입력 처리
	public MemberVO passwordChecking(MemberVO memberVO) {
		return sqlSession.selectOne("Git.passwordChecking", memberVO);
	}
	
	/*//검색시 따라오는 개인정보 처리
	public MemberVO whenSearchingFollowingInfo(String id) {
		return sqlSession.selectOne("Git.whenSearchingFollowingInfo", id);
	}*/
	
	//검색 결과 처리
	public List<ItemVO> searchedResults(ItemVO itemVO) {
		return sqlSession.selectList("Git.searchedResults", itemVO);
	}
	
	
	//검색 필터 처리(GENDER)
	public ItemVO searchFilter(ItemVO itemVO) {
		return sqlSession.selectOne("Git.searchFilter", itemVO);
	}
	
	//검색 필터 처리(AGE)
	public ItemVO searchFilter2(ItemVO itemVO) {
		return sqlSession.selectOne("Git.searchFilter2", itemVO);
	}
	
	
	//검색 필터 처리(SKINTYPE)
	public ItemVO searchFilter3(ItemVO itemVO) {
		return sqlSession.selectOne("Git.searchFilter3", itemVO);
	}
	
	//제품 상세 페이지 처리
	public ItemVO viewItem(ReviewVO reviewVO) {
		return sqlSession.selectOne("Git.viewItem", reviewVO);
	}
	
	//리뷰 작성 처리
	public int writeReview(ReviewVO reviewVO) {
		return sqlSession.insert("Git.writeReview", reviewVO);
	}
	
	//리뷰 목록 보기
	public List<ReviewVO> reviewLists(ReviewVO reviewVO) {
		return sqlSession.selectList("Git.reviewLists", reviewVO);
	}
	
	//내가 작성한 리뷰 보기
	public List<ReviewVO> reviewsIWrote(ReviewVO reviewVO) {
		return sqlSession.selectList("Git.reviewsIWrote", reviewVO);
	}
	
	//좋아요 올리기
	public int raiseLike(ReviewVO reviewVO) {
		return sqlSession.update("Git.raiseLike", reviewVO);
	}

	//좋아요 올릴시 liked테이블 insert
	public int raiseLike2(LikedVO likedVO) {
		return sqlSession.insert("Git.raiseLike2", likedVO);
	}

	//내가 좋아요한 리뷰 보기 (해당 아이디로 REVIEW_ID 값 구하기)
	public LikedVO reviewsILiked(String id) {
		return sqlSession.selectOne("Git.reviewsILiked", id);
	}

	//내가 좋아요한 리뷰보기 (REVIEW_ID 값으로 좋아요한 리뷰 리스트로 불러오기)
	public List<ReviewVO> reviewsILiked2(int review_ID) {
		return sqlSession.selectList("Git.reviewsILiked2", review_ID);
	}
	
	//찜하기
	public int markItem(SelectedVO selectedVO) {
		return sqlSession.insert("Git.markItem", selectedVO);
	}

	//내가 찜한 목록 보기 (해당 아이디로 ITEM_ID 값 구하기)
	public SelectedVO listsIMarked(String id) {
		return sqlSession.selectOne("Git.listsIMarked", id);
	}

	//내가 찜한 목록 보기 (ITEM_ID 값으로 리스트로 다 불러오기)
	public List<ItemVO> listsIMarked2(int item_ID) {
		return sqlSession.selectList("Git.listsIMarked2", item_ID);
	}

	//리뷰 상세보기
	public ReviewVO viewReview(int id) {
		return sqlSession.selectOne("Git.viewReview", id);
	}

	//리뷰 상세보기(작성자 개인정보)
	public MemberVO viewMemInfo(String mem_ID) {
		return sqlSession.selectOne("Git.memInfo", mem_ID);
	}

	//리뷰작성자 팔로잉시 리뷰 보여주기
	public List<ReviewVO> willFollow(String MEM_ID) {
		return sqlSession.selectList("Git.followReview", MEM_ID);
	}

	//팔로우 처리
	public int checkFollow(FollowVO followVO) {
		return sqlSession.insert("Git.checkFollow", followVO);
	}

}
