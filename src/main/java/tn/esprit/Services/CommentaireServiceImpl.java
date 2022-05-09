package tn.esprit.Services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entities.Badwords;
import tn.esprit.Entities.Commentaire;
import tn.esprit.Entities.Publication;
import tn.esprit.Entities.User;
import tn.esprit.Repository.BadwordsRepository;
import tn.esprit.Repository.CommentaireRepository;
import tn.esprit.Repository.PublicationRepository;
import tn.esprit.Repository.UserRepository;

@Service
@Slf4j
public class CommentaireServiceImpl implements CommentaireService{
	
	@Autowired
	CommentaireRepository commentaireRepository;	
	
	@Autowired
	PublicationRepository publicationRepository;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	BadwordsRepository badwordsRepository;
	
	@Override
	public List<Commentaire> retrieveAllCommentaires(Long publicationId) {
		Publication publication = publicationRepository.findById(publicationId).orElse(null);
		List<Commentaire> comments =  commentaireRepository.findByPublication(publication);
		List<Commentaire> censoredComments = new ArrayList<Commentaire>();
		for(int i = 0 ; i<comments.size();i++) {
			comments.get(i).setContent(CensoredWords(comments.get(i).getContent()));
		}
		return comments;
	}
	
	@Override
	public void deleteCommentaire(Long id) {
		Commentaire c = commentaireRepository.findById(id).orElse(null);
		commentaireRepository.delete(c);		
	}

	@Override
	public Commentaire updateCommentaire(Commentaire c) {
		Commentaire commentaire = commentaireRepository.findById(c.getIdCommentaire()).get();	
		
		commentaire.setContent(c.getContent());
		return commentaireRepository.save(c);
	}

	@Override
	public Commentaire addCommentaire(Long id, Long idPublication, Commentaire comment) {
		Publication publication = publicationRepository.findById(idPublication).orElse(null);
		User user = userRepository.findById(id).orElse(null);
		comment.setUser(user);
		comment.setPublication(publication);
		return commentaireRepository.save(comment);
	}

	@Override
	public Commentaire findOne(Long idCommentaire) {
		return commentaireRepository.findById(idCommentaire).get();
	}

	
	@Override
	public String CensoredWords(String commentaire) {
		List<Badwords> wordsList = badwordsRepository.findAll();
		List<String> words = new ArrayList<String>();
		
		log.info("wordsList size : "+wordsList.size());
		for(int i=0 ; i< wordsList.size();i++) {
			words.add(wordsList.get(i).getWord());
		}
		
		log.info("words size : "+words.size());
		
		for (String word : words) {
            Pattern rx = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);
            commentaire = rx.matcher(commentaire).replaceAll(new String(new char[word.length()]).replace('\0', '*'));
           
		}
		log.info("New comment  "+commentaire);
		
		
		return commentaire;
	}

	

	
	
	

}
