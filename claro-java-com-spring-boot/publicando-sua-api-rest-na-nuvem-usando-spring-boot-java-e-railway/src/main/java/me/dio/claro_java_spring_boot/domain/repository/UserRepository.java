package me.dio.claro_java_spring_boot.domain.repository;

import jakarta.transaction.Transactional;
import me.dio.claro_java_spring_boot.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Checks if an account exists by number.
     *
     * @param number
     *      Account number.
     *
     * @return boolean
     *      True if exists.
     *
     * @author Daniel Silva Marcelino
     */
    boolean existsByAccountNumber(String number);

    /**
     * Check if there is a card with the number provided.
     *
     * @param number
     *      Card number.
     *
     * @return boolean
     *      True if exists.
     *
     * @author Daniel Silva Marcelino
     */
    boolean existsByCardNumber(String number);
}
