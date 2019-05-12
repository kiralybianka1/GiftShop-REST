package hu.giftshop.util;

import hu.giftshop.dto.UserDTO;

public class Context {
    
    private UserDTO userDTO;

    public Context(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Context() {
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

}
