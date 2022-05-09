package tn.esprit.Services;

import java.util.List;


import tn.esprit.Entities.Commentaire;

public interface CommentaireService {
	
	Commentaire addCommentaire(Long id, Long idPublication, Commentaire comment);

	void deleteCommentaire(Long id);

	Commentaire updateCommentaire(Commentaire commentaire);
	
	List<Commentaire> retrieveAllCommentaires(Long publicationId);
	
	Commentaire findOne(Long idCommentaire);
	
	String CensoredWords(String commentaire);



}
