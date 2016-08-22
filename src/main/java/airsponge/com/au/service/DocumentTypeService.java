package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.DocumentType;
import airsponge.com.au.repository.DocumentTypeRepository;

@Service
@Transactional
public class DocumentTypeService  {

	
	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	 
	public List<DocumentType> findAll(){
		
		return documentTypeRepository.findAll();
	}


	public DocumentType findbyid(int id) {
		return documentTypeRepository.findOne(id);
	}


	public void save(DocumentType documentType) {
		documentTypeRepository.save(documentType);
		
	}
}
