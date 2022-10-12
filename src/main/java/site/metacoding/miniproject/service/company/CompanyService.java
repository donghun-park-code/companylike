package site.metacoding.miniproject.service.company;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject.domain.company.CompanyDao;
import site.metacoding.miniproject.domain.personal.Personal;
import site.metacoding.miniproject.domain.personal.PersonalDao;
import site.metacoding.miniproject.domain.personal.detail.PersonalDetail;
import site.metacoding.miniproject.web.dto.request.CompanyJoinDto;
import site.metacoding.miniproject.web.dto.request.PersonalJoinDto;

@Service
@RequiredArgsConstructor
public class CompanyService {
	
	private final CompanyDao companyDao;
	
	public void companyjoin(CompanyJoinDto joinDto){
		

	}
	
}
