package com.supinfo.supfitness.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Track.class)
public abstract class Track_ {

	public static volatile SingularAttribute<Track, Date> date;
	public static volatile SingularAttribute<Track, Double> latitude;
	public static volatile SingularAttribute<Track, Long> id;
	public static volatile SingularAttribute<Track, Long> footRaceId;
	public static volatile SingularAttribute<Track, Double> speed;
	public static volatile SingularAttribute<Track, Double> longitude;

}

