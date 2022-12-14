package site.metacoding.miniproject.domain.like.personalike;

import java.util.List;


public interface PersonalLikesDao {
	public void insert(PersonalLike personalLike);
	public List<PersonalLike> findAll();
	public PersonalLike findById(Integer personalLikeId);
	public void update(PersonalLike personalLike);
	public void deleteById(PersonalLike personalLike);
	public void check(PersonalLike personalLike);
}
