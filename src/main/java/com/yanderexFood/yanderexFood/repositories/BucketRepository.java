package com.yanderexFood.yanderexFood.repositories;

import com.yanderexFood.yanderexFood.models.AppUser;
import com.yanderexFood.yanderexFood.models.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//ЭТО БАЗА
public interface BucketRepository extends JpaRepository<Bucket, Long> {
    List<Bucket> findAll();
    Bucket getBucketByUser(AppUser user);
    void deleteBucketById(long id);
}
