package site.metacoding.miniproject.web.dto.request;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject.domain.like.personalike.PersonalLike;

@Getter
@Setter
public class InsertPersonalLikeDto {
	private Integer personalLikeId;
	private Integer resumesId;
	private Integer companyId;
	private Integer alarmId;
	private Timestamp createdAt;
	
	public PersonalLike toEntity() {
		PersonalLike personalLike = new PersonalLike();
		personalLike.setCompanyId(this.companyId);
		personalLike.setResumesId(this.resumesId);
		return personalLike;
	}
}
