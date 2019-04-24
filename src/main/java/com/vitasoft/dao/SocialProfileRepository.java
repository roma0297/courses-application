package com.vitasoft.dao;

import com.vitasoft.model.SocialProfileModel;
import com.vitasoft.model.keys.SocialProfileKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialProfileRepository extends JpaRepository<SocialProfileModel, SocialProfileKey> {

}
