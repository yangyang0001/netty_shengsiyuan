package com.inspur.thrift.provider;

import com.inspur.thrift.DataException;
import com.inspur.thrift.Person;
import com.inspur.thrift.PersonService;
import org.apache.thrift.TException;

/**
 * User: YANG
 * Date: 2019/6/4-11:40
 * Description: No Description
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUserName(String username) throws DataException, TException {
        System.out.println("getPersonByUserName invoked ...");
        Person person = new Person();

        person.setUsername("YangJianWei");
        person.setAge(22);
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("savePerson invoked ...");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
