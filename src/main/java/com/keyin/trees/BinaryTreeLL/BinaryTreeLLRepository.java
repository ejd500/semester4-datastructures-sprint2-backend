package com.keyin.trees.BinaryTreeLL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BinaryTreeLLRepository extends JpaRepository<BinaryTreeLL, Long> {

    public BinaryTreeLL findById(int id);

}
