package com.shtukary.ita.dao.impl.profile;

import com.shtukary.ita.dao.PhotoDao;
import com.shtukary.ita.dao.impl.AbstractDao;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.profile.Photo;

@Repository
public class PhotoDaoImpl extends AbstractDao<Photo, Long> implements PhotoDao {
}
