package tn.esprit.Constant;

public class SecurityConstant { 
	public static final long EXPIRATION_TIME = 432_000_000; // 5jours en millisecondes el expiration ta3 token
	public static final String TOKEN_PREFIX = "Bearer "; // eli 33tani el tokken manverifich ba3dou 
    public static final String JWT_TOKEN_HEADER = "Jwt-Token"; // header bech natachy el tokken lil requeete http
    public static final String TOKEN_CANNOT_BE_VERIFIER = "Token cannot be verified";
    public static final String GET_ARRAYS_LLC = "Get Arrays, LLC"; // sender ta3 tokken
    public static final String Get_ARRAYS_ADMINISTRATION = "User Management Portal"; //el recepteru ta3 tokken
    public static final String AUTHORITIES = "Authorities"; // les autorités ta3 el tokken mawjoudin hna 
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page"; 
    public static final String ACCESS_DENIED_MESSAGE = "You do not have the permission to acces this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS"; 
    //hedhom eli louta les url el ma7loulin bech ay user yaksedi 5ater moch ma39oul lezem tkoun 3amel login bech ta3mel login 
    public static final String[] PUBLIC_URLS = { "/user/login", "/user/register", "/user/resetpassword/**", "/user/image/**"};

    
    
    
    
}