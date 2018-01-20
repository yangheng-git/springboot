package com.imooc.girl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GirlRepostory extends JpaRepository<Girl,Integer> {
    /*通过年龄进行查询
    * 方法名有讲究，要遵循jpa方法名设计的规则，否则无法查询出数据。
    * */
    public List<Girl> findByAge(Integer age);
}
