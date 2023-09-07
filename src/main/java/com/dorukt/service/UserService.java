package com.dorukt.service;

import com.dorukt.exception.EerrorType;
import com.dorukt.exception.ResultIsEmptyException;
import com.dorukt.repository.IUserRepository;
import com.dorukt.repository.entity.Token;
import com.dorukt.repository.entity.User;
import com.dorukt.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User, Long> {

    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        List<User> users = super.findAll();
        if (users.isEmpty())
            throw new ResultIsEmptyException(EerrorType.SORGULAMA_YAPILAN_LISTE_BOS);
        return users;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        if (aLong == null) {
            throw new ResultIsEmptyException(EerrorType.GECERSIZ_PARAMETRE);
        }
        Optional<User> user = super.findById(aLong);
        if (user.isEmpty())
            throw new ResultIsEmptyException(EerrorType.USER_NOT_FOUND);
        return user;
    }

    @Override
    public void deleteById(Long aLong) {
        Optional<User> optUser = findById(aLong);
        super.delete(optUser.get());
    }

    @Override
    public User update(User user) {
        Optional<User> optUser = findById(user.getId());
        return super.update(user);
    }

    public Token login(String username, String password) {
        Optional<User> user = repository.findByUsernameAndPassword(username, password);
        if (user.isEmpty())
            throw new ResultIsEmptyException(EerrorType.HATALI_GIRIS);
        return new Token(""+username.charAt(0)+user.get().getFirstName().charAt(0)+"token"+user.get().getId());
    }
}
