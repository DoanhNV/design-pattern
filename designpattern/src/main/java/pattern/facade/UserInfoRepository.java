package pattern.facade;

import pattern.facade.storage.UserCache;
import pattern.facade.storage.ReaderUserDAO;
import pattern.facade.model.User;
import pattern.facade.storage.WriterUserDAO;

public class UserInfoRepository {

    private ReaderUserDAO readerUserDAO = new ReaderUserDAO();
    private WriterUserDAO writerUserDAO = new WriterUserDAO();
    private UserCache userCache = new UserCache();

    public void addUser(User user) {
        if (user == null) {
            throw new RuntimeException("UserInfoManager ::: addUser: user must be not null!");
        }
        writerUserDAO.add(user);
        userCache.add(user);
    }

    public User getUser(String userId) {
        User user = userCache.getUser(userId);

        final boolean isCacheFail = user == null;
        if (isCacheFail) {
            user = readerUserDAO.get(userId);
            userCache.add(user);
        }
        return user;
    }

    public void update(String userId, User updateUser) {
        if (updateUser == null) {
            throw new RuntimeException("UserInfoManager ::: update: updateUser must be not null!");
        }
        writerUserDAO.update(userId, updateUser);
        userCache.update(userId, updateUser);
    }

    public void delete(String userId) {
        if (userId == null) {
            throw new RuntimeException("UserInfoManager ::: delete: userId must be not null!");
        }
        writerUserDAO.delete(userId);
        userCache.delete(userId);
    }
}
