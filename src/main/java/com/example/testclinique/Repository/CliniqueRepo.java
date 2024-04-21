package com.example.testclinique.Repository;

import com.example.testclinique.entity.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CliniqueRepo  extends JpaRepository<Clinique, Long>  {
}
