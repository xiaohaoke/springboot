package com.example.springboot.dao;


import com.example.springboot.model.TxPerson;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;




public interface TxPersonMapper {

    @Select("select * from tx_person")
    public List<TxPerson> selectPersons();

    @Select("select * from tx_person where pid = #{pid}")
    public TxPerson getPersonById(int pid);


    @Options(useGeneratedKeys = true, keyProperty = "pid")
    @Insert("insert into tx_person(pid, username ,password,pname, p_addr, gender, birth)" +
            "values(#{pid},#{username},#{password},#{pname},#{pAddr},#{gender},#{birth})")
    public void insert(TxPerson p);


    @Update("update  tx_person set  username = #{username} " +
            ",password = #{password}" +
            ",pname = #{pname}, " +
            "p_addr = #{pAddr}, " +
            "gender = #{gender}, " +
            "birth = #{birth}" +
            "where pid = #{pid}")
    public void updatePerosn(TxPerson p);

    @Delete("delete from tx_person where pid = #{pid}")
    public void delete(int pid);

    @Select("select * from tx_person where username = #{username} and password=#{password}")
    public TxPerson getPersonByUserPass(Map<String, String> map);


}
