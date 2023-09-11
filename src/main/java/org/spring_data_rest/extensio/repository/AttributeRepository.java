package org.spring_data_rest.extensio.repository;

import org.spring_data_rest.extensio.domain.Attribute;
import org.spring_data_rest.extensio.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
