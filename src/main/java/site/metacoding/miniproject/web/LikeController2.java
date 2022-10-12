package site.metacoding.miniproject.web;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject.service.company.CompanyLikeService;
import site.metacoding.miniproject.web.dto.response.ResponseDto;
import site.metacoding.miniproject.web.dto.response.SignedDto;

@RequiredArgsConstructor
@Controller
public class LikeController2 {
	private final HttpSession session;
	private final CompanyLikeService companyLikeService;

	@PostMapping("/companyLike/{companyId}/likes")
	public @ResponseBody ResponseDto<?> insertLike(@PathVariable Integer companyId) {
		//Company company = (Company) session.getAttribute("principal");
	
		SignedDto<?> signedDto = (SignedDto) session.getAttribute("principal");
		
		companyLikeService.좋아요(companyId, signedDto.getPersonalId());
		return new ResponseDto<>(1, "좋아요성공", null);
		
	}

	@DeleteMapping("/companyLike/{companyId}/likes")
	public @ResponseBody ResponseDto<?> deleteLike(@PathVariable Integer companyId){
		
		SignedDto<?> signedDto = (SignedDto) session.getAttribute("principal");
		
		companyLikeService.좋아요취소(companyId, signedDto.getPersonalId());
		return new ResponseDto<>(1, "좋아요취소", null);
	}
	@GetMapping("/companyInsert")
	public String companyInsert() {
		return "/company/companyInsert";
	}
}
