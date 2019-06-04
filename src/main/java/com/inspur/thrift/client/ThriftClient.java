package com.inspur.thrift.client;

import com.inspur.thrift.Person;
import com.inspur.thrift.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * User: YANG
 * Date: 2019/6/4-11:54
 * Description: No Description
 */
public class ThriftClient {

    public static void main(String[] args){
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();

            Person person = client.getPersonByUserName("Yang");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            Person person2 = new Person();
            person2.setUsername("YangJianWei0001");
            person2.setAge(18);
            person2.setMarried(true);
            client.savePerson(person2);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transport.close();
        }


    }
}
