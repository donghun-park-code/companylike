package site.metacoding.miniproject.service.personal;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject.domain.like.personalike.PersonalLike;
import site.metacoding.miniproject.domain.like.personalike.PersonalLikesDao;
import site.metacoding.miniproject.web.dto.request.InsertPersonalLikeDto;

@RequiredArgsConstructor
@Service
public class PersonalLikeService {
	private final PersonalLikesDao personalLikesDao;

	public void 좋아요(Integer resumesId,Integer companyId) {
		PersonalLike personalLike = new PersonalLike(resumesId, companyId);
		personalLikesDao.insert(personalLike);
	}

	public void 좋아요취소(Integer resumesId,Integer companyId) {
		PersonalLike personalLike = new PersonalLike(resumesId, companyId);
		personalLikesDao.deleteById(personalLike);

	}
	
	public List<PersonalLike> 좋아요이력서(){
		return personalLikesDao.findAll();
	}
	
	
}
