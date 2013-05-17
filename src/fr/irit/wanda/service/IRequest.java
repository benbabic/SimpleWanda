package fr.irit.wanda.service;

import java.util.Collection;

import org.apache.commons.fileupload.FileItem;

import fr.irit.wanda.entities.A3;
import fr.irit.wanda.entities.LinkedEntity;
import fr.irit.wanda.entities.LinkedEntity.PRIVACY;
import fr.irit.wanda.entities.Entity;
import fr.irit.wanda.entities.Metadata;
import fr.irit.wanda.entities.MetadataContent;
import fr.irit.wanda.entities.Montage;
import fr.irit.wanda.entities.NamedEntity;
import fr.irit.wanda.entities.User;
import fr.irit.wanda.exception.AlreadyRegistredException;
import fr.irit.wanda.exception.NotAllowedToProceedException;
import fr.irit.wanda.exception.NotFoundInDatabaseException;

public interface IRequest {

	int addA3(A3 a3) throws NotAllowedToProceedException;

	boolean createSite(NamedEntity site) throws NotAllowedToProceedException,
			AlreadyRegistredException, NotFoundInDatabaseException;

	boolean addSiteManager(NamedEntity site, User manager)
			throws NotAllowedToProceedException;

	boolean addMetadata(MetadataContent metadata)
			throws AlreadyRegistredException, NotAllowedToProceedException;

	int createUser(User user) throws AlreadyRegistredException,
			NotAllowedToProceedException;

	boolean createSession(NamedEntity session, NamedEntity father)
			throws AlreadyRegistredException, NotFoundInDatabaseException,
			NotAllowedToProceedException;

	boolean createView(NamedEntity view, NamedEntity father)
			throws AlreadyRegistredException, NotFoundInDatabaseException,
			NotAllowedToProceedException;

	boolean createMontage(Montage montage) throws NotAllowedToProceedException;

	boolean validate(NamedEntity entity) throws NotAllowedToProceedException;

	boolean submitAnnotation(LinkedEntity annotation, FileItem annotationFile)
			throws NotAllowedToProceedException;

	FileItem getAnnotation(String annotationName)
			throws NotAllowedToProceedException;

	Collection<MetadataContent> getMetadata(NamedEntity concerned)
			throws NotFoundInDatabaseException;

	FileItem getVideo(String videoName);

	boolean createCorpus(NamedEntity corpus, NamedEntity father)
			throws AlreadyRegistredException, NotAllowedToProceedException,
			NotFoundInDatabaseException;

	boolean editPrivacy(NamedEntity entity, PRIVACY privacy)
			throws NotFoundInDatabaseException, NotAllowedToProceedException;

	boolean addCorpusManager(NamedEntity corpus, User manager)
			throws NotAllowedToProceedException;

	String printHierarchy();

	int createVideo(NamedEntity video, NamedEntity father, PRIVACY privacy)
			throws AlreadyRegistredException, NotAllowedToProceedException,
			NotFoundInDatabaseException;

	int createAnnotation(NamedEntity annotation, NamedEntity father,
			PRIVACY privacy) throws AlreadyRegistredException,
			NotAllowedToProceedException, NotFoundInDatabaseException;
	
	int createMetadata(Metadata m);
	
	String getMetadataForm(Entity e);
	
	Collection<Metadata> getMetadata(Entity e);

	boolean createMetaContent (MetadataContent mc) throws AlreadyRegistredException;
}
