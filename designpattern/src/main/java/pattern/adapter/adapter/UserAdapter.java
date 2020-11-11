package pattern.adapter.adapter;

import org.modelmapper.ModelMapper;
import pattern.adapter.model.User;
import pattern.adapter.model.UserJsonFile;
import pattern.adapter.model.UserRequest;

public class UserAdapter {

    private final ModelMapper modelMapper = new ModelMapper();

    public User adapt(UserRequest userRequest) {
        User user = new User();
        modelMapper.map(userRequest, user);
        return user;
    }

    public User adapt(UserJsonFile userJsonFile) {
        User user = new User();
        modelMapper.map(userJsonFile, user);
        return user;
    }

    public UserRequest toUserRequest(User source) {
        UserRequest destination = new UserRequest();
        modelMapper.map(source, destination);
        return destination;
    }

    public UserJsonFile toUserJsonFile(User source) {
        UserJsonFile destination = new UserJsonFile();
        modelMapper.map(source, destination);
        return destination;
    }
}

