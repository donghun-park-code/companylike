package site.metacoding.miniproject.service.company;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject.domain.like.companylike.CompanyLike;
import site.metacoding.miniproject.domain.like.companylike.CompanyLikesDao;
import site.metacoding.miniproject.domain.like.personalike.PersonalLike;
import site.metacoding.miniproject.domain.like.personalike.PersonalLikesDao;
import site.metacoding.miniproject.web.dto.request.InsertPersonalLikeDto;

@RequiredArgsConstructor
@Service
public class CompanyLikeService {
	private final CompanyLikesDao companyLikesDao;

	public void 좋아요(Integer personalId,Integer companyId) {
		CompanyLike companyLike = new CompanyLike(personalId, companyId);
		companyLikesDao.insert(companyLike);
	}

	public void 좋아요취소(Integer personalId,Integer companyId) {
		CompanyLike companyLike = new CompanyLike(personalId, companyId);
		companyLikesDao.deleteById(companyLike);

	}
	public List<CompanyLike> 구인계획서좋아요(){
		return companyLikesDao.findAll();
	}
	
	
}
