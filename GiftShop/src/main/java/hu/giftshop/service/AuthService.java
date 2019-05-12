package hu.giftshop.service;

import hu.giftshop.dto.UserDTO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthService {

    public AuthService() {
        
    }
    
    public String passwordDigest(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            StringBuilder hashCodeBuffer = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                hashCodeBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return hashCodeBuffer.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public UserDTO login(String userName, String password){
        UserDTO userDto = new UserDTO();
        return null;
    }
    
}
