package com.shtukary.ita.dao;

import com.shtukary.ita.model.User;
import com.shtukary.ita.model.VerificationToken;

import java.util.Optional;

public interface VerificationTokenDao extends BaseDao<VerificationToken, Long> {

    Optional<VerificationToken> findVerificationToken(String token);

    Optional<VerificationToken> findByUser(User user);

    void deleteAllExpiredSince();

}
