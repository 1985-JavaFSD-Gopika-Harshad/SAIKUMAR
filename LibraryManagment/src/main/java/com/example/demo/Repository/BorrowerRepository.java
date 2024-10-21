package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
