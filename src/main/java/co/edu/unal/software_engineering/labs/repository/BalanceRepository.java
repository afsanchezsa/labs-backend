package co.edu.unal.software_engineering.labs.repository;


import co.edu.unal.software_engineering.labs.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Integer> {

}
