package com.spring.framework.util;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;

/**
 *
 * @author devesh.bharathan
 */
public class Validator {

//    protected static final String validNameRegex = "[A-Za-z'. ]{1,80}";
    protected static final String validPasswordRegex = "((?=.*\\d)(?=.*[a-zA-Z]).{7,})";
    protected static final String validPhoneRegex = "^[6789]\\d{9}$";
    protected static final String validUserAgentForMobile="(?i)(android|bb\\d+|meego).+mobile|avantgo|bada\\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino";
    
    public static boolean register(String name, String password, String email, String phone) {
        if(!Character.isLetterOrDigit(email.charAt(email.length()-1))) {
            return false;
        }
        if(!Character.isDigit(phone.charAt(phone.length()-1))) {
            return false;
        }
        if (!GenericValidator.matchRegexp(password, validPasswordRegex)) {
            return false;
        }
        // commented because name is allowed on the basis of userType
//        if (!GenericValidator.isBlankOrNull(name)) {
//            return false;
//        }
        if (!GenericValidator.isEmail(email)) {
            return false;
        }
        if (!GenericValidator.isBlankOrNull(phone) && !GenericValidator.matchRegexp(phone, validPhoneRegex)) {
            return false;
        }
        return true;
    }
    
    public static boolean checkForUserAgentMobile(String userAgent){
        if(userAgent != null){
            Pattern p = Pattern.compile(validUserAgentForMobile);
            Matcher m = p.matcher(userAgent);
            return m.find();
        }

        return false;
    }

    public static boolean userInfo(String email, String phone) {
        if(!Character.isLetterOrDigit(email.charAt(email.length()-1))) {
            return false;
        }
        if(!Character.isDigit(phone.charAt(phone.length()-1))) {
            return false;
        }
        if (!GenericValidator.isEmail(email)) {
            return false;
        }
        if (!GenericValidator.matchRegexp(phone, validPhoneRegex)) {
            return false;
        }
        return true;
    }

    public static boolean login(String email, String password) {
        if(!Character.isLetterOrDigit(email.charAt(email.length()-1))) {
            return false;
        }
        if (!GenericValidator.isEmail(email)) {
            return false;
        }
        if (!GenericValidator.matchRegexp(password, validPasswordRegex)) {
            return false;
        }
        return true;
    }

    public static boolean email(String email) {
        if(!Character.isLetterOrDigit(email.charAt(email.length()-1))) {
            return false;
        }
        if (!GenericValidator.isEmail(email)) {
            return false;
        }
        return true;
    }

    public static boolean password(String password) {
        if (!GenericValidator.matchRegexp(password, validPasswordRegex)) {
            return false;
        }
        return true;
    }
    
    public static boolean mobile(String phone){
        
        if(StringUtils.isBlank(phone)){
            return false;
        }
        if(!Character.isDigit(phone.charAt(phone.length()-1))) {
            return false;
        }
         if (!GenericValidator.matchRegexp(phone, validPhoneRegex)) {
            return false;
        }
        return true;
    }
}
