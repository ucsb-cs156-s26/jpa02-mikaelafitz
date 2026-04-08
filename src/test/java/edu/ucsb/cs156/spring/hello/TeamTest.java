package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;
    Team team4;

    class Cat {}
    Cat team2;
    
    class Person extends Team {}
    Person team3;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
        team2 = new Cat();
        team3 = new Person();
        team4 = new Team("team4");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_case_1() {
        assertEquals(team.equals(team), true);
    }

    @Test
    public void equals_case_2() {
        assertEquals(team.equals(team2), false);
    }

    @Test
    public void equals_case_3() {
        team.setName("t");
        team3.setName("t");

        ArrayList<String> players1 = new ArrayList<String>();
        players1.add("Joy");
        ArrayList<String> players2 = new ArrayList<String>();
        players2.add("Joy");
        team.setMembers(players1);
        team3.setMembers(players2);
        assertEquals(team.equals(team3), true);

        team3.setName("s");
        assertEquals(team.equals(team3), false);

        team3.setName("t");
        players2.add("Kris");
        team3.setMembers(players2);
        assertEquals(team.equals(team3), false);
    }

    @Test
    public void hash_function_test () {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
