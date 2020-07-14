package springdiy;

public class UserDAOImpl implements UserDAO {
    @Override
    public void save(User u) {
        System.out.println("User:" + u.toString());
    }

    @Override
    public void delete() {
        System.out.println("delete User");

    }
}