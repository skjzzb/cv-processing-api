package com.gslab.talent.constant;

public class Constant {
	
	public static final String ACCEPT_JSON = "Accept=application/json";

	public static final String CANDIDATE_ID = "id";
	public static final String VACANCY_ID = "id";
	public static final String GET_LIST_OF_CANDIDATES = "/candidiate";
	public static final String GET_CANDIDATE_BY_ID = "/candidiate/{id}";
	public static final String GET_CANDIDATE_BY_VACANCY_ID = "/candidiate/vacancy/{id}";
	public static final String ADD_CANDIDATE = "/candidiate/{id}";
	public static final String DELETE_CANDIDATE_BY_ID = "/candidiate/{id}";

	public static final String UPDATE_CANDIDATE ="/candidate/update/{id}";
	
	public static final String DOCUMENT_ID = "id";
	public static final String GET_LIST_OF_DOCUMENTS = "/doc";
	public static final String GET_DOCUMENT_BY_ID = "/doc/{id}";
	public static final String ADD_DOCUMENT = "/doc";
	public static final String DELETE_DOCUMENT_BY_ID = "/doc/{id}";

	public static final String UPDATE_DOCUMENT ="/doc/update";

	
	

	public static final String GET_LIST_OF_USERS = "/user";
	public static final String ADD_USER = "/user";
	public static final String GET_USER_BY_ID = "/user/{userId}";
	public static final String UPDATE_USER =  "/user/{userId}";

	public static final String DELETE_USER = "/user/{userId}";

	public static final String TECHNOLOGY_ID = "technologyId";
	public static final String GET_LIST_OF_TECHNOLOGY = "/technology";
	public static final String ADD_TECHNOLOGY = "/technology";
	public static final String GET_TECHNOLOGY_BY_ID = "/technology/{technologyId}";
	public static final String UPDATE_TECHNOLOGY =  "/technology/{technologyId}";

	public static final String DELETE_TECHNOLOGY = "/technology/{technologyId}";
	
	public static final String SUBTECHNOLOGY_ID = "subTechnologyId";
	public static final String GET_LIST_OF_SUBTECHNOLOGY = "/subtechnology";
	public static final String ADD_SUBTECHNOLOGY = "/subtechnology";
	public static final String GET_SUBTECHNOLOGY_BY_ID = "/subtechnology/{subTechnologyId}";
	public static final String UPDATE_SUBTECHNOLOGY =  "/subtechnology/{subTechnologyId}";
	public static final String GET_SUBTECHNOLOGY_BY_TECHNOLOGY_ID =  "/subtechnology/technology/{technologyId}";
	
	public static final String DELETE_SUBTECHNOLOGY = "/subtechnology/{subTechnologyId}";

	public static final String GET_LIST_OF_VACANCY= "/vacancy";

	public static final String GET_VACANCY_BY_ID = "/vacancy/{vacancyId}";
}
