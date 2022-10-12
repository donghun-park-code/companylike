package site.metacoding.miniproject.web.dto.request;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject.domain.like.companylike.CompanyLike;
import site.metacoding.miniproject.domain.like.personalike.PersonalLike;

@Getter
@Setter
public class InsertCompanyLikeDto {
	private Integer companyLikeId;
	private Integer personalId;
	private Integer companyId;
	private Integer alarmId;
	private Timestamp createdAt;
	
	public CompanyLike toEntity() {
		CompanyLike companyLike = new CompanyLike();
		companyLike.setCompanyId(this.companyId);
		companyLike.setPersonalId(this.personalId);
		return companyLike;
	}
}
